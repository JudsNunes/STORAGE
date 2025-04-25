package com.almoxarifado.empetur.almoxarifado.sin.service;


import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {


    ItemRepository itemRepository;

    //injeção de dependência
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<Item> create (Item item) {
        itemRepository.save(item);
        return list();
    }

    public List<Item> list (){
        Sort sort = Sort.by("nome").ascending();
        return itemRepository.findAll(sort);

    }
    public List<Item> update(Item item){
        itemRepository.save(item);
        return list();
    }

    public List<Item> delete(Long id){
        itemRepository.deleteById(id);
        return list();
    }









}
