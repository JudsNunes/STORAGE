package com.almoxarifado.empetur.almoxarifado.sin.dto;

import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Double quantidade;


}
