package com.almoxarifado.empetur.almoxarifado.sin.factory;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemFactory {

    public Item mapDtoToItem(ItemDTO itemDTO){
        Item item = new Item();
        item.setCodigo(itemDTO.getCodigo());
        item.setNome(itemDTO.getNome());
        item.setDescricao(itemDTO.getDescricao());
        item.setQuantidade(itemDTO.getQuantidade());
        item.setCategoria(itemDTO.getCategoria());
        item.setUnidMedida(itemDTO.getUnidMedida());
        item.setUnidPreco(itemDTO.getUnidPreco());
        item.setFornecedor(itemDTO.getFornecedor());
        item.setLocalizacao(itemDTO.getLocalizacao());
        item.setEstoqueMinimo(itemDTO.getEstoqueMinimo());

        return item;
    }
}
