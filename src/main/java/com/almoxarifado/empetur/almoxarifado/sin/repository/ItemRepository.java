package com.almoxarifado.empetur.almoxarifado.sin.repository;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
