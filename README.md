# Speed Fast

Proyecto desarrollado en Java para practicar los contenidos de Programación Orientada a Objetos vistos durante las primeras semanas de la asignatura.

El programa representa un sistema simple de pedidos de la empresa ficticia **Speed Fast**, utilizando distintos tipos de pedidos como comida, encomienda y express. Cada pedido puede realizar distintas acciones, por ejemplo asignar un repartidor, despacharse, cancelarse o registrar su entrega, según corresponda.

## Avance por semana

- **Semana 1:** creación del proyecto y de las primeras clases para representar pedidos y repartidores.
- **Semana 2:** uso de herencia mediante la clase `Pedido` y sus clases hijas. También se incorpora el método abstracto `calcularTiempoEntrega()`, implementado de forma diferente según el tipo de pedido.
- **Semana 3:** incorporación de interfaces para representar las distintas acciones que puede realizar un pedido y uso de un controlador para ejecutar estas acciones.

## Conceptos aplicados

Durante el desarrollo se aplican los siguientes contenidos vistos en clases:

- Clases y objetos.
- Encapsulamiento mediante atributos y métodos de acceso.
- Herencia entre `Pedido` y sus clases hijas.
- Clase y método abstracto.
- Sobreescritura de métodos con `@Override`.
- Polimorfismo al trabajar con distintos tipos de pedidos mediante la clase `Pedido`.
- Interfaces para definir acciones que pueden realizar algunos pedidos.
- Uso de `instanceof` para comprobar si un pedido implementa una determinada interfaz antes de ejecutar una acción.
- Uso de arreglos para almacenar y recorrer distintos pedidos.

## Clases principales

- `Main`: crea los pedidos de ejemplo y ejecuta las distintas acciones del programa.
- `Pedido`: clase abstracta que contiene los datos y comportamientos comunes de los pedidos.
- `PedidoComida`: representa un pedido realizado a un restaurante.
- `PedidoEncomienda`: representa el envío de una encomienda.
- `PedidoExpress`: representa un pedido con entrega express.
- `ControladorDeEnvios`: contiene métodos para realizar acciones sobre los pedidos, como asignar, despachar, cancelar o registrar una entrega.

## Interfaces

- `Asignable`: permite asignar un repartidor.
- `Despachable`: permite despachar un pedido.
- `Cancelable`: permite cancelar un pedido cuando corresponda.
- `Rastreable`: permite realizar las acciones de seguimiento definidas en el proyecto.

No todos los tipos de pedido tienen necesariamente las mismas acciones. Por este motivo, antes de realizar algunas operaciones se utiliza `instanceof` para comprobar si el pedido implementa la interfaz correspondiente.

## Funcionamiento

Al ejecutar el programa se crean distintos pedidos de ejemplo y se recorren mediante un arreglo de tipo `Pedido`.

Para cada pedido se muestra su información y se realizan solamente las acciones que correspondan según las interfaces que implemente. Finalmente, el programa puede mostrar el historial registrado por el controlador.

## Requisitos

- Java 23.
- Maven.
- Un IDE para Java, por ejemplo IntelliJ IDEA.

## Cómo ejecutar el proyecto

### Opción 1: desde IntelliJ IDEA

1. Clonar o descargar este repositorio.
2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Esperar a que IntelliJ cargue el proyecto Maven.
4. Abrir la clase `Main.java`.
5. Ejecutar el método `main()`.

### Opción 2: desde PowerShell

Desde la carpeta principal del proyecto, donde se encuentra el archivo `pom.xml`:

```powershell
mvn compile
mvn exec:java "-Dexec.mainClass=cl.lema.app.Main"
```

## Clonar el repositorio

```bash
git clone https://github.com/LemaDEV-CL/speed-fast.git
cd speed-fast
```
