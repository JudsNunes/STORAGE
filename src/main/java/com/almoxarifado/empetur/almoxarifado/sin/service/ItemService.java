package com.almoxarifado.empetur.almoxarifado.sin.service;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface ItemService {



    List<Item> findAll(String name);

    Item findById(Long id);

    Item save(Item item);

    Void delete(Long id);

    Item update(Item item);




}
