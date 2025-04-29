package com.almoxarifado.empetur.almoxarifado.sin.service;

import com.almoxarifado.empetur.almoxarifado.sin.dto.ItemDTO;
import com.almoxarifado.empetur.almoxarifado.sin.dto.MovementsDTO;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.entity.Movements;
import com.almoxarifado.empetur.almoxarifado.sin.enums.TipoMovimentacao;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;
import com.almoxarifado.empetur.almoxarifado.sin.repository.MovementsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    private ItemDTO convertToDto(Item item) {
        return new ItemDTO(item.getId(), item.getCode(), item.getName(), item.getDescription(),item.getQuantidade());
    }


    private Item convertToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setCode(itemDTO.getCode());
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setQuantidade(itemDTO.getQuantidade());
        return item;
    }


    public List<ItemDTO> create(ItemDTO itemDTO) {
        Item itemCreateToDto = convertToEntity(itemDTO);
        itemRepository.save(itemCreateToDto);
        return list();
    }


    public List<ItemDTO> list() {
        Sort sort = Sort.by("name").ascending();
        List<Item> itens = itemRepository.findAll(sort);
        return itens.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<ItemDTO> update(ItemDTO itemDTO) {
        Item itemToUpdate = convertToEntity(itemDTO);
        itemRepository.save(itemToUpdate);
        return list();
    }


    public List<ItemDTO> delete(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            itemRepository.delete(itemOptional.get());
        }
        return list();
    }


    private void processarEntradaEstoque(Item item, MovementsDTO movementsDTO){
        double saldoAnterior = item.getQuantidade();
        double saldoAtual = item.getQuantidade() + movementsDTO.getQuantidade();

        item.setQuantidade(saldoAtual);
        registrarMovimentacao(item,movementsDTO,saldoAnterior);
    }



    public ItemDTO registrarMovimentacao(Item item, MovementsDTO dto, double saldoAnterior){
        Movements mov = new Movements();
        mov.setItem(item);
        mov.setTipo(dto.getTipo());
        mov.setQuantidade(dto.getQuantidade());
        mov.setSaldoAnterior(saldoAnterior);
        mov.setSaldoAtual(item.getQuantidade());
        mov.setData(LocalDateTime.now());

        MovementsRepository.save(mov);


    }

}