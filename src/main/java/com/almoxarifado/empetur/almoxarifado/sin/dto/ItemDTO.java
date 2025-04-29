package com.almoxarifado.empetur.almoxarifado.sin.dto;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private long id;

    private String code;

    private String name;

    private String description;

    private int quantidade;

    public ItemDTO(){

    }




    public ItemDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemDTO(long id, String code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemDTO(long id, String code, String name, String description, int quantidade) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.quantidade = quantidade;
    }
}
