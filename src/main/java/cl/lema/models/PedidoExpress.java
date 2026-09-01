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

    public PedidoExpress(int idPedido, String cliente, String direccionEntrega, double distanciaKm,  String repartidorAsignado, String tienda) {
        super(idPedido, cliente, direccionEntrega, distanciaKm, repartidorAsignado);
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
