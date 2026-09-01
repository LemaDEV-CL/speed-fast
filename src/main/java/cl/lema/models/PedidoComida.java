package cl.lema.models;

import cl.lema.interfaces.Asignable;
import cl.lema.interfaces.Cancelable;
import cl.lema.interfaces.Despachable;

/**
 * Representa un pedido de comida realizado a un restaurante.
 * Este pedido se puede asignar, cancelar y despachar.
 */
public class PedidoComida extends Pedido implements Asignable, Cancelable, Despachable{

    private String restaurante;
    private int tiempoPreparacion;


    public PedidoComida(int idPedido, String cliente, String direccionEntrega, double distanciaKm, String repartidorAsignado, String restaurante, int tiempoPreparacion) {
        super(idPedido, cliente, direccionEntrega, distanciaKm, repartidorAsignado);
        this.restaurante = restaurante;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    /**
     * Calcula el tiempo usando una base de 15 minutos más la distancia.
     *
     * @return tiempo aproximado de entrega en minutos
     */
    @Override
    public int calcularTiempoEntrega() {
        double tiempoBase = 15;
        double tiempoExtra = 2 * distanciaKm;
        double resultado = tiempoExtra + tiempoBase;
        return (int) Math.round(resultado);
    }

    /**
     * Informa que la comida está en preparación y se asigna un repartidor.
     */
    @Override
    public void asignarRepartidor() {
        System.out.println("Preparando su comida y asignando repartidor...");
    }

    /**
     * Informa que el despacho de comida fue cancelado.
     */
    @Override
    public void cancelar() {
        System.out.println("Despacho de comida cancelado");
    }

    /**
     * Informa que el pedido de comida va en camino.
     */
    @Override
    public void despachar() {
        System.out.println("¡Su comida va en camino!");
    }

}
