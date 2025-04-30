package com.almoxarifado.empetur.almoxarifado.sin.controller;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(value = "/itens")
    public class ItemController {

        private final ItemService itemService;

        public ItemController(ItemService itemService) {
            this.itemService = itemService;
        }

        @GetMapping
        public List<ItemDTO> list() {
            return itemService.list();
        }

        @PostMapping
        public  create(@RequestBody ItemDTO itemDTO){
            return itemService.create(itemDTO);
        }

        @PutMapping
        public  update(@RequestBody ItemDTO itemDTO){
            return itemService.update(itemDTO);
        }


        @DeleteMapping("/{id}")
       public ResponseEntity<Void> delete(@PathVariable("id") Long id){
            itemService.delete(id);
            return ResponseEntity.ok().build();
        }



}