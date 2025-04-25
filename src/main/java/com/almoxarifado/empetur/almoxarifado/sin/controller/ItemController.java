package com.almoxarifado.empetur.almoxarifado.sin.controller;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    List<Item> create(@RequestBody Item item){
        return itemService.create(item);
    }


    @GetMapping
    List<Item> list(){
        return itemService.list();
    }

    @PutMapping
    List<Item> update(@RequestBody Item item){
        return  itemService.update(item);
    }

    @DeleteMapping("{id}")
    List<Item> delete(@PathVariable("id") Long id){
        return itemService.delete(id);
    }



}
