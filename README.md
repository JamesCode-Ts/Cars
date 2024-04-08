
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
