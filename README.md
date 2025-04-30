# Sistema de Almoxarifado - API REST

API para gerenciamento de itens e usuários em um sistema de almoxarifado, desenvolvida com Spring Boot e padrões modernos de desenvolvimento.

## 🔧 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MapStruct (mapeamento DTO/Entity)
- Lombok
- H2 Database (em desenvolvimento)
- Maven
## Utilizando a API 
Cria um novo item	{"code":"IT001","name":"Martelo","description":"...","quantidade":10}
Atualiza um item existente	{"id":1,"code":"IT001","name":"Martelo Atualizado",...}
## 📊 Diagrama UML da Arquitetura

```mermaid
classDiagram
    class ItemController {
        -ItemService itemService
        +list() List<ItemDTO>
        +create(ItemDTO) ResponseEntity<ItemDTO>
        +update(ItemDTO) ItemDTO
        +delete(Long) ResponseEntity<ItemDTO>
    }

    class UserController {
        -UserService userService
        +create(User) List<User>
        +list() List<User>
        +update(User) List<User>
        +delete(Long) List<User>
    }

    class ItemService {
        -ItemRepository itemRepository
        -ItemMapper itemMapper
        +create(ItemDTO) ItemDTO
        +update(ItemDTO) ItemDTO
        +list() List<ItemDTO>
        +delete(Long) ItemDTO
    }

    class UserService {
        -UserRepository userRepository
        +create(User) List<User>
        +list() List<User>
        +update(User) List<User>
        +delete(Long) List<User>
    }

    class Item {
        -Long id
        -String code
        -String name
        -String description
        -Double quantidade
    }

    class User {
        -Long id
        -String login
        -String password
    }

    class ItemDTO {
        -Long id
        -String code
        -String name
        -String description
        -Double quantidade
    }

    class ItemMapper {
        +itemToDTO(Item) ItemDTO
        +dtoToItem(ItemDTO) Item
    }

    ItemController --> ItemService
    UserController --> UserService
    ItemService --> ItemRepository
    ItemService --> ItemMapper
    UserService --> UserRepository
    ItemMapper --> Item
    ItemMapper --> ItemDTO
