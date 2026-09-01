# Speed Fast

Proyecto básico en Java que simula la gestión de pedidos de la empresa Speed Fast. El programa crea pedidos de comida, encomienda y express, para luego asignarlos, despacharlos, cancelarlos o registrarlos como entregados.

## Avance por semana

- Semana 1: creación del proyecto para practicar conceptos de Programación Orientada a Objetos mediante un sistema de pedidos y repartidores.
- Semana 2: uso de la clase abstracta `Pedido` y del método `calcularTiempoEntrega()`, que se implementa de forma distinta en cada clase hija.
- Semana 3: actualización para la sumativa n°1. Se agregan interfaces y un controlador de envíos para separar las responsabilidades del programa.

## Conceptos aplicados

- Herencia entre `Pedido` y sus clases derivadas.
- Polimorfismo al trabajar con distintos pedidos mediante el tipo `Pedido`.
- Clase y método abstracto para calcular los tiempos de entrega.
- Sobreescritura de métodos según cada tipo de pedido.
- Uso de las interfaces `Asignable`, `Despachable`, `Cancelable` y `Rastreable`.
- Encapsulamiento de los datos del pedido mediante atributos y métodos de acceso.
- Uso de `instanceof` para comprobar qué acciones puede realizar cada pedido.

## Clases e interfaces

- `Main`: crea los pedidos y ejecuta el ejemplo en consola.
- `Pedido`: clase abstracta que guarda los datos comunes de todos los pedidos.
- `PedidoComida`: representa pedidos de comida.
- `PedidoEncomienda`: representa pedidos de encomiendas.
- `PedidoExpress`: representa pedidos express.
- `ControladorDeEnvios`: asigna, despacha, cancela y registra las entregas.
- `Asignable`: define la acción de asignar un repartidor.
- `Despachable`: define la acción de despachar un pedido.
- `Cancelable`: define la acción de cancelar un pedido.
- `Rastreable`: define la consulta del historial de entregas.

## Funcionamiento

Al ejecutar el programa se crean tres pedidos de ejemplo. Para cada uno se muestra su información y el tiempo aproximado de entrega. El controlador realiza las acciones permitidas por sus interfaces, cancela el pedido indicado en `Main` y finalmente muestra el historial de las entregas completadas.

## Ejecución

El proyecto utiliza Maven y requiere Java 23. Desde la carpeta principal se pueden usar los siguientes comandos:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="cl.lema.app.Main"
```
