# Sistema de Almoxarifado - API REST

Esta é uma API REST para gerenciamento de itens e usuários em um sistema de almoxarifado, desenvolvida com Spring Boot.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- MapStruct (para mapeamento DTO/Entity)
- Lombok (para redução de boilerplate code)
- H2 Database (embutida para desenvolvimento)
- Maven (gerenciamento de dependências)

## Padrão DTO com MapStruct

O projeto utiliza o padrão DTO (Data Transfer Object) com MapStruct para:

1. Separar a camada de apresentação (DTO) da camada de persistência (Entity)
2. Evitar expor a estrutura interna do banco de dados
3. Permitir customização dos dados trafegados na API
4. Facilitar a manutenção e evolução da API

Exemplo de mapeamento:

```java
@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDTO itemToDTO(Item item);
    Item dtoToItem(ItemDTO itemDTO);
}
