package com.almoxarifado.empetur.almoxarifado.sin.controller;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Método para criar um novo item
    @PostMapping
    public List<ItemDTO> create(@RequestBody ItemDTO itemDTO) {
        return itemService.create(itemDTO);
    }
    // Método para listar todos os itens
    @GetMapping
    public List<ItemDTO> list() {
        return itemService.list(); // Retorna a lista de ItemDTOs
    }

    // Método para atualizar um item
    @PutMapping
    public List<ItemDTO> update(@RequestBody ItemDTO itemDTO) {
        return itemService.update(itemDTO); // Passa o DTO para o serviço
    }

    // Método para deletar um item
    @DeleteMapping("{id}")
    public List<ItemDTO> delete(@PathVariable("id") Long id) {
        return itemService.delete(id); // Passa o ID para o serviço
    }
}