package cl.lema.app;

import cl.lema.hilos.Repartidor;
import cl.lema.models.*;
import cl.lema.servicio.ZonaDeCarga;


/**
 * Clase principal del sistema SpeedFast.
 * Crea pedidos de ejemplo, los agrega a una zona de carga compartida
 * y ejecuta varios repartidores de forma concurrente mediante hilos.
 */
public class Main {

    /**
     * Punto de entrada de la simulación.
     * Inicializa la zona de carga, crea los pedidos y coordina el inicio
     * y término de los hilos repartidores.
     *
     * @param args argumentos recibidos por consola; no se utilizan en esta simulación
     * @throws InterruptedException si se interrumpe la carga de pedidos o la espera de hilos
     */
    public static void main(String[] args) throws InterruptedException {
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        Pedido pedido1 = new PedidoComida(
                101,
                "Don Hambre Feroz",
                "Av. Pajaritos 2500",
                12,
                "La Cocoa",
                10
        );

        Pedido pedido2 = new PedidoEncomienda(
                102,
                "María Soto",
                "Las Parcelas 1800",
                6.2,
                5,
                20
        );

        Pedido pedido3 = new PedidoExpress(
                103,
                "Pedro González",
                "Av. Providencia 1200",
                8.5,
                "Falabella"
        );

        Pedido pedido4 = new PedidoComida(
                104,
                "Carolina Pérez",
                "Irarrázaval 2500",
                4.7,
                "McDonalds",
                15
        );

        Pedido pedido5 = new PedidoExpress(
                105,
                "Luis Martínez",
                "Alameda 3200",
                10.3,
                "Paris"
        );

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);

        Thread repartidor1 =
                new Thread(new Repartidor("Camila", zonaDeCarga));

        Thread repartidor2 =
                new Thread(new Repartidor("Luis", zonaDeCarga));

        Thread repartidor3 =
                new Thread(new Repartidor("Pedro", zonaDeCarga));

        repartidor1.start();
        repartidor2.start();
        repartidor3.start();

        repartidor1.join();
        repartidor2.join();
        repartidor3.join();

        System.out.println();
        System.out.println(
                "Todos los pedidos han sido entregados correctamente"
        );
    }
}
