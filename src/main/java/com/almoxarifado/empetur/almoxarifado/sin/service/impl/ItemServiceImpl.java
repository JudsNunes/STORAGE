package com.almoxarifado.empetur.almoxarifado.sin.service.impl;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.exception.BusinessUncheckedException;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import org.springframework.transaction.annotation.Transactional;

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
    public Item findAll(Long id){
        if(id==null ){
            throw new BusinessUncheckedException(REGISTRO_NAO_ENCONTRADO);
        }
        return itemRepository.findAllById(id);

    }


    @Transactional(readOnly = true)
    @Override
    public Item findById(Long id){
        if(id==null){
            throw  new BusinessUncheckedException(REGISTRO_NAO_ENCONTRADO);
        }

        return itemRepository.findById(id);
    }


    @Transactional(readOnly = true)
    @Override
    public Item save(Item item){
        if(item.getId()!= null && !itemRepository.findById(item.getId()).isPresent()){
            throw new BusinessUncheckedException(REGISTRO_JA_EXISTE);
        }

        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    @Override
    public Item findByNameOrDescription(String name, String description){
        if(name == null){
            throw new BusinessUncheckedException(REGISTRO_NAO_ENCONTRADO);
        }

        return itemRepository.findByNameOrDescription(name,description);

    }

    @Transactional(readOnly = true)
    @Override
    public Void delete(Long id){
        if(id==null){
            throw new BusinessUncheckedException(REGISTRO_NAO_ENCONTRADO);
        }
        itemRepository.delete(id);
    }



}
