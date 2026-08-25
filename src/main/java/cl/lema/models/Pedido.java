package cl.lema.models;

import cl.lema.interfaces.Asignable;

/**
 * Clase abstracta que representa un pedido general con los datos ID del cliente con dirección y distancia de su ubicación en kms.
 */
public abstract class Pedido implements Asignable {

    protected int idPedido;
    protected String cliente;
    protected String direccionEntrega;
    protected double distanciaKm;

    public Pedido(int idPedido, String cliente, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public abstract int calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("ID: " + getIdPedido());
        System.out.println("Cliente: " + getCliente());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Distancia Km: " + getDistanciaKm());
        System.out.println("Tiempo de entrega: " + calcularTiempoEntrega() + " minutos aprox.");
    }

    @Override
    public String asignarRepartidor() {
        return "Asignando pedido";
    }
    public String asignarRepartidor(String tipo) {
        return "Tipo de pedido asignado: " + tipo;
    }
}
