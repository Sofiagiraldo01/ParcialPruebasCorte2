Feature: Calculo de recargas

  Scenario: Recarga valida sin bonificacion
    Given un monto de 5000
    And el usuario no es premium
    When calculo la recarga
    Then la bonificacion debe ser 0

  Scenario: Recarga con bonificacion del 10 por ciento
    Given un monto de 10000
    And el usuario no es premium
    When calculo la recarga
    Then la bonificacion debe ser 10

  Scenario: Recarga con bonificacion del 25 por ciento
    Given un monto de 30000
    And el usuario no es premium
    When calculo la recarga
    Then la bonificacion debe ser 25

  Scenario: Recarga premium con bonificacion del 10 por ciento
    Given un monto de 10000
    And el usuario es premium
    When calculo la recarga
    Then la bonificacion debe ser 15

  Scenario: Recarga premium con bonificacion del 25 por ciento
    Given un monto de 30000
    And el usuario es premium
    When calculo la recarga
    Then la bonificacion debe ser 30

  Scenario: Monto menor al permitido
    Given un monto invalido de 999
    When calculo la recarga invalida
    Then debe lanzarse una excepcion



