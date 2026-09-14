package cl.lema.models;

import cl.lema.interfaces.Asignable;
import cl.lema.interfaces.Cancelable;
import cl.lema.interfaces.Despachable;

/**
 * Representa un pedido express asociado a una tienda.
 * Este pedido se puede asignar, cancelar y despachar.
 */
public class PedidoExpress extends Pedido implements Asignable, Cancelable, Despachable {

    private String tienda;

    /**
     * Crea un pedido express asociado a una tienda.
     *
     * @param idPedido identificador único del pedido
     * @param cliente nombre del cliente que recibe el pedido
     * @param direccionEntrega dirección donde se realizará la entrega
     * @param distanciaKm distancia aproximada de entrega en kilómetros
     * @param tienda tienda asociada al pedido express
     */
    public PedidoExpress(int idPedido, String cliente, String direccionEntrega, double distanciaKm, String tienda) {
        super(idPedido, cliente, direccionEntrega, distanciaKm);
        this.tienda = tienda;
    }

    /**
     * Calcula el tiempo según la distancia del pedido.
     *
     * @return 15 minutos si la distancia es mayor a 5 km o 10 minutos en caso contrario
     */
    @Override
    public int calcularTiempoEntrega() {
        if (distanciaKm > 5) {
            return 15;
        }
        return 10;
    }

    /**
     * Informa que el pedido express está en preparación y se asigna un repartidor.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("Preparando rápidamente su pedido express y asignando repartidor...");
    }

    /**
     * Informa que el despacho express fue cancelado.
     */
    @Override
    public void cancelar() {
        System.out.println("Despacho express cancelado");
    }

    /**
     * Informa que el pedido express va en camino.
     */
    @Override
    public void despachar() {
        System.out.println("¡Su despacho va en camino a toda velocidad!");
    }
}
