# Sistema de Validación de Transacciones y Bonificaciones

## Descripción

Este proyecto implementa una API REST desarrollada en **Java 23**, utilizando **Spring Boot**, **Maven**, **JUnit 5** y **Cucumber**, para validar transacciones y calcular bonificaciones de acuerdo con las reglas de negocio definidas.

La aplicación permite:

- Validar montos de transacciones.
- Determinar si una transacción es aceptada o rechazada.
- Calcular el porcentaje de bonificación correspondiente.
- Aplicar bonificaciones adicionales para usuarios premium.
- Exponer la funcionalidad mediante una API REST.
- Realizar pruebas unitarias y pruebas BDD con Cucumber.

---

## Tecnologías Utilizadas

- Java 23 (Oracle OpenJDK 23.0.2)
- Spring Boot 3.x
- Maven
- JUnit 5
- Cucumber
- IntelliJ IDEA

---

## Reglas de Negocio

### Validación del Monto

Una transacción será considerada válida únicamente cuando el monto se encuentre dentro del rango permitido.

| Condición | Resultado |
|------------|------------|
| Monto < $1.000 | Rechazada |
| Monto > $50.000 | Rechazada |
| $1.000 ≤ Monto ≤ $50.000 | Aceptada |

---

### Bonificación por Monto

| Rango de Monto | Bonificación |
|----------------|--------------|
| $1.000 - $9.999 | 0% |
| $10.000 - $29.999 | 10% |
| ≥ $30.000 | 25% |

---

### Bonificación Premium

Si el usuario es premium, se adiciona un **5%** a la bonificación obtenida.

#### Fórmula

Bonificación Final = Bonificación Base + 5% (si es premium)

---

## Ejemplos

| Monto | Premium | Bonificación |
|---------|----------|--------------|
| $15.000 | No | 10% |
| $15.000 | Sí | 15% |
| $35.000 | No | 25% |
| $35.000 | Sí | 30% |

---

