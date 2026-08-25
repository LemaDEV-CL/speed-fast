package cl.lema.models;

/**
 * Representa un pedido express asociado a una tienda
 */
public class PedidoExpress extends Pedido{

    private String tienda;

    public PedidoExpress(int idPedido, String cliente, String direccionEntrega, double distanciaKm, String tienda) {
        super(idPedido, cliente, direccionEntrega, distanciaKm);
        this.tienda = tienda;
    }

    @Override
    public int calcularTiempoEntrega() {
        if (distanciaKm > 5) {
            return 15;
        }
        return 10;
    }

    @Override
    public String asignarRepartidor() {
        return "Asignando su pedido express a un repartidor";
    }

    public String asignarRepartidor(int calcularTiempoEntrega) {
        return "Repartidor asignado y en camino - Tiempo de entrega: " + calcularTiempoEntrega + " minutos aprox.";
    }
}
