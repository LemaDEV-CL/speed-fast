package cl.lema.models;

/**
 * Representa un pedido de encomienda con peso y volumen.
 */
public class PedidoEncomienda extends Pedido{

    private int peso;
    private int volumen;

    public PedidoEncomienda(int idPedido, String cliente, String direccion, int peso, int volumen) {
        super(idPedido, cliente, direccion);
        this.peso = peso;
        this.volumen = volumen;
    }

    @Override
    public String asignarRepartidor() {
        return "Preparando su encomienda y asignando repartidor";
    }

    public String asignarRepartidor(boolean prioritario) {
        if (prioritario) {
            return "Encomienda prioritaria asignada... repartidor en camino a destino";
        }
        return "Encomienda asignada, te avisaremos cuando estemos en camino";
    }
}
