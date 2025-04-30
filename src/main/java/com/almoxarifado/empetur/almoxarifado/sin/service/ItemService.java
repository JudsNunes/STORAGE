package com.almoxarifado.empetur.almoxarifado.sin.service;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.mapper.ItemMapper;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    @Autowired
    private final ItemMapper itemMapper;


    public ItemDTO getProductDto(){
        Item item = this.itemRepository.findById(1L).get();
        return itemMapper.itemToDTO(item);
    }

    public ItemDTO create(ItemDTO itemDTO){
        Item item = itemMapper.dtoToItem(itemDTO);
        Item itemSave = itemRepository.save(item);
        return itemMapper.itemToDTO(itemSave);
    }

    public ItemDTO update(ItemDTO itemDTO){
        Item item = itemMapper.dtoToItem(itemDTO);
        Item itemUpdate = itemRepository.save(item);
        return itemMapper.itemToDTO(itemUpdate);
    }

    public List<ItemDTO> list(){
        Sort sort = Sort.by("name").ascending();
        return itemRepository.findAll(sort)
                .stream()
                .map(itemMapper::itemToDTO)
                .collect(Collectors.toList());

    }


    public ItemDTO delete(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item não encontrado com ID: " +id));

        ItemDTO deletedItem = itemMapper.itemToDTO(item);
        itemRepository.delete(item);

        return deletedItem;
    }





}
