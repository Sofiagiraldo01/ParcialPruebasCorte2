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

## Técnicas de Diseño de Pruebas

### Partición de Equivalencias

La técnica de partición de equivalencias permite dividir los datos de entrada en grupos que se comportan de manera similar, reduciendo la cantidad de pruebas necesarias sin perder cobertura.

#### Clases Válidas

| Clase | Valor Ejemplo |
|---------|--------------|
| 1.000 - 9.999 | 5.000 |
| 10.000 - 29.999 | 15.000 |
| 30.000 - 50.000 | 40.000 |

#### Clases Inválidas

| Clase | Valor Ejemplo |
|---------|--------------|
| < 1.000 | 999 |
| > 50.000 | 50.001 |

---

### Análisis de Valores Límite

La técnica de valores límite se enfoca en probar los extremos de los rangos permitidos, ya que es donde suelen encontrarse la mayoría de los errores.

| Caso | Valor |
|--------|--------|
| Min - 1 | 999 |
| Min | 1.000 |
| Min + 1 | 1.001 |
| Max - 1 | 49.999 |
| Max | 50.000 |
| Max + 1 | 50.001 |

---

### Casos de Prueba

Los siguientes casos verifican el correcto funcionamiento de las reglas de negocio relacionadas con la validación de montos y el cálculo de bonificaciones.

| ID | Monto | Premium | Resultado Esperado |
|------|--------|----------|-------------------|
| CP01 | 999 | No | Error |
| CP02 | 1.000 | No | 0% |
| CP03 | 9.999 | No | 0% |
| CP04 | 10.000 | No | 10% |
| CP05 | 29.999 | No | 10% |
| CP06 | 30.000 | No | 25% |
| CP07 | 50.000 | No | 25% |
| CP08 | 50.001 | No | Error |
| CP09 | 15.000 | Sí | 15% |
| CP10 | 30.000 | Sí | 30% |

---

### Cobertura de Pruebas

Los casos definidos garantizan la validación de:

- Clases de equivalencia válidas.
- Clases de equivalencia inválidas.
- Valores límite inferiores.
- Valores límite superiores.
- Cálculo de bonificación base.
- Aplicación de bonificación adicional para usuarios premium.
- Rechazo de transacciones fuera del rango permitido.

Esto asegura una cobertura adecuada de las reglas de negocio establecidas para el sistema.