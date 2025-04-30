package com.almoxarifado.empetur.almoxarifado.sin.dto;

import org.springframework.beans.BeanUtils;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private int quantidade;

    public ItemDTO() {
    }
    public ItemDTO(Item item){
        BeanUtils.copyProperties(item,this);
    }
}
