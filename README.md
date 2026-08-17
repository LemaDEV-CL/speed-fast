# Speed Fast

Proyecto básico en Java para practicar conceptos de Programación Orientada a Objetos mediante un sistema de asignación de repartidores para distintos tipos de pedidos.

## Conceptos aplicados

- Herencia entre `Pedido` y sus clases derivadas.
- Polimorfismo al trabajar con distintos pedidos mediante el tipo `Pedido`.
- Sobreescritura del método `asignarRepartidor()`.
- Sobrecarga del método `asignarRepartidor()` con diferentes parámetros.
- Implementación de la interfaz `Asignable`.

## Estructura

- `Main`: crea los pedidos y muestra los ejemplos en consola.
- `Asignable`: define la asignación de un repartidor.
- `Pedido`: clase base de los pedidos.
- `PedidoComida`: representa pedidos de comida.
- `PedidoEncomienda`: representa pedidos de encomiendas.
- `PedidoExpress`: representa pedidos express.

## Ejecución

El proyecto utiliza Maven y requiere Java 23.

```bash
mvn compile
mvn exec:java -Dexec.mainClass="cl.lema.app.Main"
```
