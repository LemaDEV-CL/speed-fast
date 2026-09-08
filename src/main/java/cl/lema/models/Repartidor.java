package cl.lema.models;

import java.util.List;
import java.util.Random;

/**
 * Representa a un repartidor encargado de procesar una lista de pedidos.
 * Implementa Runnable para permitir que varios repartidores realicen
 * sus entregas de forma concurrente.
 */

public class Repartidor implements Runnable {

    private String nombre;
    private List<Pedido> pedidosAsignados;
    private Random random = new Random();

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {

        for (Pedido pedido : pedidosAsignados) {

            System.out.println(
                    "[Repartidor: " + nombre + "] Entregando " +
                            pedido.getClass().getSimpleName() +
                            " #" + pedido.getIdPedido()
            );

            try {

                int tiempoEntrega = 1000 + random.nextInt(2000);

                Thread.sleep(tiempoEntrega);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "[Repartidor: " + nombre + "] Entrega interrumpida."
                );

                return;
            }

            System.out.println(
                    "[Repartidor: " + nombre + "] Pedido #" +
                            pedido.getIdPedido() +
                            " entregado."
            );
        }
    }
}
