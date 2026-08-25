package cl.lema.models;

/**
 * Representa un pedido de comida realizado a un restaurante que también tiene un tiempo de preparación.
 */
public class PedidoComida extends Pedido {

    private String restaurante;
    private String tiempoPreparacion;

    public PedidoComida(int idPedido, String cliente, String direccionEntrega, double distanciaKm, String restaurante, String tiempoPreparacion) {
        super(idPedido, cliente, direccionEntrega, distanciaKm);
        this.restaurante = restaurante;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public int calcularTiempoEntrega() {
        double tiempoBase = 15;
        double tiempoExtra = 2 * distanciaKm;
        double resultado = tiempoExtra + tiempoBase;
        return (int) Math.round(resultado);
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
