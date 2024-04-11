# Concessionária de Carros

Java RESTful API criada para o Desafio de projeto.

## Principais Tecnologias
 - **Java 17**: Utilizei a versão LTS do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalhei com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Foi utilizada para lidar e simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Foi criado uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
 - **Render**: Para o deploy da aplicação usando docker.


## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class Car {
    - private BigDecimal price
    - Brand brand
    - Model model
    - Number year
    - String codeFipe
  }

  class Model {
    - String name
  }

  class Brand {
    - String name
  }

  class Sale {
    - Date saleDate
    - String saleTime
    - Client client
  }
  
  class Client {
    - String name
    - String cpf
    - String address
    - String telefone
  }

  Car "1..* " *-- "1" Model
  Car "1..* " -- "0..*" Sale
  Car "1..*" *-- "1" Brand
  Sale "1..*" -- "1" Client

```
### Documentação Interativa

Para explorar e testar os endpoints da API, consulte a [Documentação interativa](https://car-dealership-relj.onrender.com/swagger-ui/index.html#/).
