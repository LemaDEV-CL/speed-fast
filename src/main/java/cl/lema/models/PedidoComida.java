package cl.lema.models;

/**
 * Representa un pedido de comida realizado a un restaurante.
 */
public class PedidoComida extends Pedido {

    private String restaurante;
    private String tiempoPreparacion;

    public PedidoComida(int idPedido, String cliente, String direccion, String restaurante, String tiempoPreparacion) {
        super(idPedido, cliente, direccion);
        this.restaurante = restaurante;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public String asignarRepartidor() {
        return "Preparando su comida y asignando repartidor";
    }

    public String asignarRepartidor(boolean urgente) {
        if (urgente) {
            return "Repartidor asignado para envío prioritario";
        }
        return "Repartidor asignado, considere que puede tener otros repartos antes del suyo";
    }
}
