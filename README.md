# Speed Fast

Proyecto desarrollado en Java para practicar los contenidos de Programación Orientada a Objetos de la asignatura.

El programa representa un sistema simple de pedidos de la empresa ficticia **Speed Fast**, utilizando distintos tipos de pedidos como comida, encomienda y express.

## Avance por semana

- **Semana 1:** creación del proyecto y de las primeras clases para representar pedidos y repartidores.
- **Semana 2:** uso de herencia mediante la clase `Pedido` y sus clases hijas. También se incorpora el método abstracto `calcularTiempoEntrega()`, implementado de forma diferente según el tipo de pedido.
- **Semana 3:** incorporación de interfaces para representar las distintas acciones que puede realizar un pedido y uso de un controlador para ejecutar estas acciones.
- **Semana 4:** incorporación de concurrencia. Cada `Repartidor` implementa `Runnable` y procesa su propia lista de pedidos. Los repartidores se ejecutan de forma simultánea mediante `ExecutorService` y se utiliza `Thread.sleep()` para simular tiempos de entrega aleatorios.

## Conceptos aplicados

- Clases y objetos.
- Encapsulamiento mediante atributos y métodos de acceso.
- Herencia entre `Pedido` y sus clases hijas.
- Clase y método abstracto.
- Sobreescritura de métodos con `@Override`.
- Polimorfismo mediante la clase `Pedido`.
- Interfaces para definir comportamientos.
- Listas de objetos con `List`.
- Implementación de `Runnable`.
- Programación concurrente con múltiples hilos.
- Uso de `Thread.sleep()` para simular tiempos de ejecución.
- Administración de tareas concurrentes mediante `ExecutorService`.
- Manejo de `InterruptedException`.

## Clases principales

- `Main`: crea los pedidos y repartidores de ejemplo y administra la ejecución concurrente.
- `Pedido`: clase abstracta que contiene los datos y comportamientos comunes de los pedidos.
- `PedidoComida`: representa un pedido realizado a un restaurante.
- `PedidoEncomienda`: representa el envío de una encomienda.
- `PedidoExpress`: representa un pedido con entrega express.
- `Repartidor`: implementa `Runnable` y procesa secuencialmente los pedidos que tiene asignados.
- `ControladorDeEnvios`: contiene funcionalidades desarrolladas durante la Semana 3 para trabajar con las acciones de los pedidos.

## Interfaces

- `Asignable`: permite asignar un repartidor.
- `Despachable`: permite despachar un pedido.
- `Cancelable`: permite cancelar un pedido cuando corresponda.
- `Rastreable`: permite realizar las acciones de seguimiento definidas en el proyecto.

## Funcionamiento actual

Al ejecutar el programa se crean seis pedidos y se distribuyen entre tres repartidores: Camila, Luis y Pedro. Cada repartidor recibe dos pedidos y los procesa secuencialmente.

Los tres repartidores son enviados a un `ExecutorService` con tres hilos, permitiendo que trabajen de forma concurrente. Cada entrega utiliza una pausa aleatoria para simular su duración. Finalmente, el programa espera a que todos los repartidores terminen antes de cerrar la simulación.

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
