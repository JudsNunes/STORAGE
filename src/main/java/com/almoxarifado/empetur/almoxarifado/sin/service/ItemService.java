package com.almoxarifado.empetur.almoxarifado.sin.service;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.dto.MovementsDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Movements;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void create(ItemDTO itemDTO) {
        Item itemEntity = new Item(itemDTO);
        itemRepository.save(itemEntity)
    }


    public List<ItemDTO> list() {
        Sort sort = Sort.by("name").ascending();
        List<Item> itens = itemRepository.findAll(sort);
        //percorrendo a lista de usuários
        return itens.stream().map(ItemDTO::new).toList();
    }


    public update(ItemDTO itemDTO) {
        Item itemEntity = new Item(itemDTO);
        return new ItemDTO(itemRepository.save(itemEntity));

    }


    public void delete(Long id) {
        Item itemEntity = itemRepository.findById(id).get();
        if (id != null) itemRepository.delete(itemEntity);
        return list();

    }

    public ItemDTO find(Long id) {
        if(id != null) return ItemDTO(itemRepository.findById(id).get());
    }


}