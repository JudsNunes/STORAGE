package com.almoxarifado.empetur.almoxarifado.sin.mapper;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {


    ItemDTO itemToDTO(Item item);


    Item dtoToItem(ItemDTO itemDTO);


}
