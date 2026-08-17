package cl.lema.models;

import cl.lema.interfaces.Asignable;

/**
 * Representa un pedido general con los datos del cliente y su dirección.
 */
public class Pedido implements Asignable {

    private int idPedido;
    private String cliente;
    private String direccion;

    public Pedido(int idPedido, String cliente, String direccion) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.direccion = direccion;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String asignarRepartidor() {
        return "Asignando pedido";
    }
    public String asignarRepartidor(String tipo) {
        return "Tipo de pedido asignado: " + tipo;
    }
}
