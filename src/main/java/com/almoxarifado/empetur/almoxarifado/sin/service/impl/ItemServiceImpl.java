package com.almoxarifado.empetur.almoxarifado.sin.service.impl;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.exception.BusinessUncheckedException;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private static final String REGISTRO_NAO_ENCONTRADO = "Registro não encontrado";
    private static final String GLOBAL_NOT_FOUND = "global.not_found";
    private static final String REGISTRO_JA_EXISTE = "Registro já existe";

    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Item> findAll(String name){
        return name == null ? itemRepository.findAll() : itemRepository.findByName(name);

    }

    @Transactional(readOnly = true)
    @Override
    public Item findById(Long id){
        return id == null ? itemRepository.findAll() : itemRepository.findById(id).orElseThrow(() -> new BusinessUncheckedException(REGISTRO_NAO_ENCONTRADO));
    }


    @Transactional
    @Override
    public Item save(Item item){
        if(item.getId()!= null && itemRepository.findById(item.getId()).isPresent()){
            throw new BusinessUncheckedException(REGISTRO_JA_EXISTE);
        }

        return itemRepository.save(item);
    }

    @Transactional
    @Override
    public Item update(Item item){
        if(item.getId() == null || !itemRepository.existsById(item.getId())){
            return throw new BusinessUncheckedException(REGISTRO_JA_EXISTE);
        }
        return itemRepository.save(item);
    }

    @Transactional
    @Override
    public void delete(Long id){
        if(id==null || itemRepository.existsById(id)){
            throw new BusinessUncheckedException(GLOBAL_NOT_FOUND);
        }
         itemRepository.deleteById(id);
    }



}
