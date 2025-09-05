package com.almoxarifado.empetur.almoxarifado.sin.controller;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.exception.BusinessUncheckedException;
import com.almoxarifado.empetur.almoxarifado.sin.factory.ItemFactory;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

    @RestController
    @RequestMapping(value = "/itens")
    public class ItemController implements ItemAPI{

        private final ItemService itemService;
        private final ItemFactory itemFactory;

        public ItemController(ItemService itemService, ItemFactory itemFactory) {
            this.itemService = itemService;
            this.itemFactory = itemFactory;
        }

        @Override
        public ResponseEntity<Item> findById(@PathVariable Long id) {
            final Item item = itemService.findById(id);
            if(item != null){
                return new ResponseEntity<>(item, HttpStatus.OK);
            } else {
                throw new BusinessUncheckedException("Item not found");
            }

        }

        @Override
        public  ResponseEntity<Item> createItem(@RequestBody ItemDTO body){
            if(body.getId() != null) {
                 throw new BusinessUncheckedException("New item cannot already have an ID");
            }
            Item item = itemFactory.mapDtoToItem(body);
            Item savedItem = itemService.save(item);
            return ResponseEntity.created(URI.create("/itens/" + savedItem.getId())).body(savedItem);

        }

        @Override
        public ResponseEntity<Item> updateItem(@RequestBody ItemDTO body){
            if(body.getId() == null){
                 throw new BusinessUncheckedException("New item cannot already have an ID");
            }

            Item item = itemFactory.mapDtoToItem(body);
            Item updatedItem = itemService.update(item);
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        }

        @Override
        public ResponseEntity<Void> deleteItem(@RequestBody Long id){
            if(id == null || itemService.findById(id) == null ){
                 throw new BusinessUncheckedException("Item not found");
            }

            itemService.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }

    }