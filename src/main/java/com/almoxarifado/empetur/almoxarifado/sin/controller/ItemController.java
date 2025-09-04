package com.almoxarifado.empetur.almoxarifado.sin.controller;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
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


    }