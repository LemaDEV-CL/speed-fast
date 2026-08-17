package cl.lema.models;

/**
 * Representa un pedido express asociado a una tienda y una distancia.
 */
public class PedidoExpress extends Pedido{

    private String tienda;
    private int distancia;

    public PedidoExpress(int idPedido, String cliente, String direccion, String tienda, int distancia) {
        super(idPedido, cliente, direccion);
        this.tienda = tienda;
        this.distancia = distancia;
    }

    @Override
    public String asignarRepartidor() {
        return "Asignando su pedido express a un repartidor";
    }

    public String asignarRepartidor(int horaLimite){
        return "Repartidor asignado y en camino - Hora limite: " + horaLimite;
    }
}
