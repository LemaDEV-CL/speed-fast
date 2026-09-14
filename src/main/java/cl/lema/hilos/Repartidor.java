package cl.lema.hilos;

import cl.lema.models.EstadoPedido;
import cl.lema.models.Pedido;
import cl.lema.servicio.ZonaDeCarga;

/**
 * Representa a un repartidor encargado de procesar pedidos desde la zona de carga.
 * Implementa Runnable para permitir que varios repartidores realicen
 * sus entregas de forma concurrente sobre una cola compartida.
 */

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    /**
     * Crea un repartidor asociado a una zona de carga.
     *
     * @param nombre nombre del repartidor que se mostrará en consola
     * @param zonaDeCarga zona compartida desde donde retirará pedidos
     */
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    /**
     * Retira pedidos desde la zona de carga mientras existan pedidos disponibles.
     * Cada pedido pasa a estado EN_REPARTO y luego a ENTREGADO después
     * de una pausa que simula el tiempo de entrega.
     */
    @Override
    public void run() {

        while (zonaDeCarga.cantidadPedidos() > 0){
            Pedido pedido = zonaDeCarga.retirarPedido();
            if (pedido != null) {
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                System.out.println("Repartidor " + nombre + " retirando pedido #" + pedido.getIdPedido());
                System.out.println("Estado: " + pedido.getEstado());
            }
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                System.out.println("Repartidor " + nombre + " fue interrumpido");
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);

            System.out.println("Repartidor " + nombre + " ha entregado satisfactoriamente el pedido #" + pedido.getIdPedido());
            System.out.println("Estado: " + pedido.getEstado());
        }
    }
}
