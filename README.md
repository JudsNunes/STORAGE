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
🚀 Endpoints da API
📦 Itens (/itens)
Método	Endpoint	Descrição	Corpo da Requisição (exemplo)
GET	/itens	Lista todos os itens ordenados por nome	-
POST	/itens	Cria um novo item	{"code":"IT001","name":"Martelo","description":"...","quantidade":10}
PUT	/itens	Atualiza um item existente	{"id":1,"code":"IT001","name":"Martelo Atualizado",...}
DELETE	/itens/{id}	Remove um item pelo ID	-
👥 Usuários (/users)
Método	Endpoint	Descrição	Corpo da Requisição (exemplo)
GET	/users	Lista todos os usuários	-
POST	/users	Cria um novo usuário	{"login":"admin","password":"12345"}
PUT	/users	Atualiza um usuário existente	{"id":1,"login":"admin","password":"newpass"}
DELETE	/users/{id}	Remove um usuário pelo ID	-
⚙️ Configuração e Execução
Pré-requisitos:

JDK 17

Maven 3.8+

Clonar e executar:

bash
git clone https://github.com/seu-usuario/almoxarifado-api.git
cd almoxarifado-api
mvn spring-boot:run
Acessar a API:

http://localhost:8080
🛠️ Padrão DTO com MapStruct
O projeto utiliza o padrão DTO com MapStruct para:

Isolar a camada de persistência da camada de apresentação

Controlar quais dados são expostos na API

Facilitar transformações de dados

Exemplo de mapeamento:

java
@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDTO itemToDTO(Item item);      // Converte Entity → DTO
    Item dtoToItem(ItemDTO itemDTO);   // Converte DTO → Entity
}
📋 Exemplos de Uso
Criar Item
bash
curl -X POST http://localhost:8080/itens \
  -H "Content-Type: application/json" \
  -d '{
    "code": "IT001",
    "name": "Furadeira",
    "description": "Furadeira 500W",
    "quantidade": 5
  }'
Listar Usuários
bash
curl -X GET http://localhost:8080/users
📄 Licença
MIT License


Este README inclui:
1. Diagrama UML completo do sistema
2. Explicação detalhada de todos os endpoints
3. Exemplos práticos de uso
4. Explicação sobre o uso do MapStruct
5. Instruções de configuração e execução
6. Formatação organizada e visualmente agradável

Você pode personalizar ainda mais adicionando:
- Seção de testes
- Configurações de ambiente
- Informações sobre deploy
- Badges de status do projeto
