package cl.lema.models;

/**
 * Clase abstracta que contiene los datos comunes de todos los pedidos.
 * Cada tipo de pedido debe calcular su propio tiempo de entrega.
 */
public abstract class Pedido {

    protected int idPedido;
    protected String cliente;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidorAsignado;
    protected boolean cancelado = false;

    public Pedido(int idPedido, String cliente, String direccionEntrega, double distanciaKm, String repartidorAsignado) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidorAsignado = repartidorAsignado;
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

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public boolean isCancelado() { return cancelado; }

    public void setCancelado(boolean cancelado) { this.cancelado = cancelado; }

    /**
     * Muestra en consola los datos principales y el tiempo estimado del pedido.
     */
    public void mostrarResumen() {
        System.out.println("ID: " + getIdPedido());
        System.out.println("Cliente: " + getCliente());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Distancia Km: " + getDistanciaKm());
        System.out.println("Repartidor Asignado: " + getRepartidorAsignado());
        System.out.println("Tiempo de entrega: " + calcularTiempoEntrega() + " minutos aprox.");
        System.out.println("");
    }

    /**
     * Calcula el tiempo de entrega según el tipo de pedido.
     *
     * @return tiempo aproximado de entrega en minutos
     */
    public abstract int calcularTiempoEntrega();


}
