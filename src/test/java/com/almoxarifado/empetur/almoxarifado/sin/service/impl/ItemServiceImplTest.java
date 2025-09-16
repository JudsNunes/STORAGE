package com.almoxarifado.empetur.almoxarifado.sin.service.impl;

import com.almoxarifado.empetur.almoxarifado.sin.entity.Item;
import com.almoxarifado.empetur.almoxarifado.sin.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl service;

    @Mock
    private ItemRepository repository;

    @Mock
    private Item item;


    @BeforeEach
    void setUp() {


    }

    @Test
    void findAll_ReturnAllProducer_WhenArgumentIsNull() {

        when(repository.findAll()).thenReturn(Collections.singletonList(item));

        var producers = service.findAll(null);

        Assertions.assertThat(producers).isNotNull().hasSize(1);

    }

    @Test
    void findById_returnItem_WhenIdExists() {

        //definindo o id que sera usado na consulta
        Long id = 1L;
        //inicializando o estado do objeto
        item.setId(id);

        //simulando o comportamento do Repository
        when(repository.findById(id)).thenReturn(Optional.of(item));

        //executando o metodo do service
        var itemFound = service.findById(id);

        //verificando se o itemFound nao e nulo.
        Assertions.assertThat(itemFound).isNotNull();
        //verificando se o id do itemFound e igual ao id usado na consulta
        Assertions.assertThat(itemFound.get()).isEqualTo(id);
    }

    @Test
    void findById_returnNull_WhenIdNotExists() {

        Long id = 32L;
        item.setId(id);

        when(repository.findById(id)).thenReturn(Optional.empty());

        var itemNotFound = service.findById(id);

        Assertions.assertThat(itemNotFound).isNull();

    }


    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}