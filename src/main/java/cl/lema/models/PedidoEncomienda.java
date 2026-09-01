package cl.lema.models;
import cl.lema.interfaces.Asignable;
import cl.lema.interfaces.Cancelable;
import cl.lema.interfaces.Despachable;
/**
 * Representa un pedido de encomienda que tiene peso y volumen.
 * Este pedido se puede asignar, cancelar y despachar.
 */
public class PedidoEncomienda extends Pedido implements Asignable, Cancelable, Despachable {

    private int peso;
    private int volumen;

    public PedidoEncomienda(int idPedido, String cliente, String direccionEntrega, double distanciaKm, String repartidorAsignado, int peso, int volumen) {
        super(idPedido, cliente, direccionEntrega, distanciaKm, repartidorAsignado);
        this.peso = peso;
        this.volumen = volumen;
    }

    /**
     * Calcula el tiempo usando una base de 20 minutos más la distancia.
     *
     * @return tiempo aproximado de entrega en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempoBase = 20;
        double tiempoExtra = 1.5 * distanciaKm;
        double resultado = tiempoExtra + tiempoBase;
        return (int) Math.round(resultado);
    }

    /**
     * Informa que la encomienda está en preparación y se asigna un repartidor.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("Preparando su encomienda y asignando repartidor...");
    }

    /**
     * Informa que el despacho de la encomienda fue cancelado.
     */
    @Override
    public void cancelar() {
        System.out.println("Despacho de encomienda cancelado");
    }

    /**
     * Informa que la encomienda va en camino.
     */
    @Override
    public void despachar() {
        System.out.println("¡Su encomienda va en camino!");
    }
}
