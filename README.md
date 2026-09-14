# Speed Fast

Proyecto académico desarrollado en Java para la asignatura **Programación Orientada a Objetos II**, correspondiente al primer año de la carrera.

El programa representa un sistema simple de pedidos de la empresa ficticia **Speed Fast**. La idea principal es practicar los contenidos de POO mediante distintos tipos de pedidos, repartidores y una simulación básica de entregas concurrentes.

## Avance por semana

- **Semana 1:** creación del proyecto Maven y de las primeras clases del sistema. Se trabajó con objetos de pedido, tipos de pedido y una primera interfaz para asignar repartidores.
- **Semana 2:** aplicación de herencia usando `Pedido` como clase base abstracta. Las clases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` sobrescriben `calcularTiempoEntrega()` según su propia lógica.
- **Semana 3:** incorporación de interfaces para separar comportamientos: asignar, despachar, cancelar y rastrear pedidos. También se agregó `ControladorDeEnvios` para centralizar acciones y registrar entregas.
- **Semana 4:** incorporación de concurrencia. `Repartidor` implementa `Runnable`, se crean varios hilos y se usa `Thread.sleep()` para simular el tiempo que tarda una entrega.
- **Semana 5:** se agregó `ZonaDeCarga` como cola compartida de pedidos. Los repartidores retiran pedidos desde esa zona usando una `BlockingQueue` protegida con `ReentrantLock`, y cada pedido cambia de estado mediante el enum `EstadoPedido`.

## Conceptos aplicados

- Clases y objetos.
- Encapsulamiento mediante atributos y métodos de acceso.
- Herencia entre `Pedido` y sus clases hijas.
- Clase abstracta y método abstracto.
- Sobreescritura de métodos con `@Override`.
- Polimorfismo al trabajar con referencias de tipo `Pedido`.
- Interfaces para definir comportamientos comunes.
- Enumeraciones mediante `EstadoPedido`.
- Colecciones y colas de objetos.
- Implementación de `Runnable`.
- Programación concurrente con múltiples hilos.
- Uso de `Thread`, `start()` y `join()`.
- Uso de `Thread.sleep()` para simular tiempos de ejecución.
- Uso de `BlockingQueue`, `LinkedBlockingQueue` y `ReentrantLock`.
- Manejo de `InterruptedException`.

## Clases principales

- `Main`: crea pedidos de ejemplo, los agrega a la zona de carga y ejecuta tres repartidores en hilos separados.
- `Pedido`: clase abstracta que contiene los datos comunes de todos los pedidos.
- `PedidoComida`: representa un pedido de comida realizado a un restaurante.
- `PedidoEncomienda`: representa el envío de una encomienda con peso y volumen.
- `PedidoExpress`: representa un pedido express asociado a una tienda.
- `EstadoPedido`: enum que representa los estados `PENDIENTE`, `EN_REPARTO` y `ENTREGADO`.
- `ZonaDeCarga`: administra la cola compartida desde donde los repartidores retiran pedidos.
- `Repartidor`: implementa `Runnable` y procesa pedidos desde la zona de carga.
- `ControladorDeEnvios`: contiene funcionalidades trabajadas en Semana 3 para asignar, despachar, cancelar y registrar entregas.

## Interfaces

- `Asignable`: define que un pedido puede recibir un repartidor.
- `Despachable`: define que un pedido puede ser despachado.
- `Cancelable`: define que un pedido puede ser cancelado.
- `Rastreable`: define la consulta de historial de entregas.

## Funcionamiento actual

Al ejecutar el programa se crea una `ZonaDeCarga` y se agregan cinco pedidos de distintos tipos. Luego se crean tres repartidores: Camila, Luis y Pedro.

Cada repartidor se ejecuta en su propio `Thread` y comparte la misma zona de carga. Mientras existan pedidos disponibles, un repartidor retira un pedido, cambia su estado a `EN_REPARTO`, espera dos segundos para simular la entrega y finalmente cambia el estado a `ENTREGADO`.

El método `main()` inicia los tres hilos con `start()` y luego espera su término usando `join()`. Cuando todos los repartidores finalizan, se muestra un mensaje indicando que todos los pedidos fueron entregados correctamente.

## Estructura general

```text
src/main/java/cl/lema
+-- app
|   +-- Main.java
+-- hilos
|   +-- Repartidor.java
+-- interfaces
|   +-- Asignable.java
|   +-- Cancelable.java
|   +-- Despachable.java
|   +-- Rastreable.java
+-- models
|   +-- EstadoPedido.java
|   +-- Pedido.java
|   +-- PedidoComida.java
|   +-- PedidoEncomienda.java
|   +-- PedidoExpress.java
+-- servicio
    +-- ControladorDeEnvios.java
    +-- ZonaDeCarga.java
```

## Requisitos

- Java 23.
- Maven.
- IDE para Java

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
