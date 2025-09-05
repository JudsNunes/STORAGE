package com.almoxarifado.empetur.almoxarifado.sin.repository;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {

    Item findAllById (Long id);
    
    Item findByName(String name);

    Item findByCode(String code);

    Item findByCodeOrDescriptionOrName(String code, String description, String name);

    Item findByDescription(String description);

    Item findAll(Long id);
}
