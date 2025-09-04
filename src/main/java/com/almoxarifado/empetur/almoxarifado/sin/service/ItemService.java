package com.almoxarifado.empetur.almoxarifado.sin.service;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    Item findAll(Long id);

    Item findById(Long id);

    Item save(Item item);

    Void delete(Long id);

    Item findByNameOrDescription(String name, String description);


}
