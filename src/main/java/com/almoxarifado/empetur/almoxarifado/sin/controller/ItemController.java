package com.almoxarifado.empetur.almoxarifado.sin.controller;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
            return list();
        }

        @PostMapping
        public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) {
            ItemDTO createdItem = itemService.create(itemDTO);
            return ResponseEntity
                    .created(URI.create("/api/itens/" + createdItem.getId()))
                    .body(createdItem);
        }
        @PutMapping
        public ItemDTO update(@RequestBody ItemDTO itemDTO){
            return itemService.update(itemDTO);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<ItemDTO> delete(@PathVariable("id") Long id){
            ItemDTO deleteItem = itemService.delete(id);
            return ResponseEntity.ok(deleteItem);
        }



    }