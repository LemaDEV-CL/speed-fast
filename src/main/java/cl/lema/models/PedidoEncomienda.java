package cl.lema.models;

/**
 * Representa un pedido de encomienda con peso y volumen.
 */
public class PedidoEncomienda extends Pedido{

    private int peso;
    private int volumen;

    public PedidoEncomienda(int idPedido, String cliente, String direccionEntrega, double distanciaKm, int volumen) {
        super(idPedido, cliente, direccionEntrega, distanciaKm);
        this.peso = peso;
        this.volumen = volumen;
    }

    @Override
    public int calcularTiempoEntrega() {
        double tiempoBase = 20;
        double tiempoExtra = 1.5 * distanciaKm;
        double resultado = tiempoExtra + tiempoBase;
        return (int) Math.round(resultado);
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
