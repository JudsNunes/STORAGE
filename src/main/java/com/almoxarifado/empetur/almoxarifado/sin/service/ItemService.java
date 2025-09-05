package com.almoxarifado.empetur.almoxarifado.sin.service;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {



    Item findById(Long id);

    Item save(Item item);

    Void delete(Long id);

    Item update(Item item);

    Item findByNameOrDescription(String name, String description);


}
