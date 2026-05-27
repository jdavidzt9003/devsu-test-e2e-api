Feature: Comprar productos

  @TEST-01
  Scenario: Finalizar compra de productos exitosamente
    Given "Comprador" selecciona dos productos
    When completa el formulario de compra
      | name  | country  | city   | creditCard | month | year |
      | David | Colombia | Bogotá | 123456789  | 05    | 2026 |
    Then Debera ver la compra realizada exitosamente
