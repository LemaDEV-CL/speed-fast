package cl.lema.models;

/**
 * Clase abstracta que contiene los datos comunes de todos los pedidos.
 * Cada tipo de pedido debe calcular su propio tiempo de entrega mediante
 * la implementación del método abstracto calcularTiempoEntrega().
 */
public abstract class Pedido {

    protected int idPedido;
    protected String cliente;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected EstadoPedido estado;

    /**
     * Crea un pedido con sus datos principales y lo deja en estado pendiente.
     *
     * @param idPedido identificador único del pedido
     * @param cliente nombre del cliente que recibe el pedido
     * @param direccionEntrega dirección donde se realizará la entrega
     * @param distanciaKm distancia aproximada de entrega en kilómetros
     */
    public Pedido(int idPedido, String cliente, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.estado = EstadoPedido.PENDIENTE;
    }


    /**
     * Obtiene el identificador del pedido.
     *
     * @return identificador del pedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Obtiene la dirección de entrega.
     *
     * @return dirección de entrega del pedido
     */
    public String getDireccion() {
        return direccionEntrega;
    }

    /**
     * Obtiene la distancia aproximada del pedido.
     *
     * @return distancia de entrega en kilómetros
     */
    public double getDistanciaKm() {
        return distanciaKm;
    }

    /**
     * Obtiene el estado actual del pedido.
     *
     * @return estado actual del pedido
     */
    public EstadoPedido getEstado() {
        return estado;
    }

    /**
     * Actualiza el estado del pedido.
     *
     * @param estado nuevo estado del pedido
     */
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    /**
     * Muestra en consola los datos principales y el tiempo estimado del pedido.
     */
    public void mostrarResumen() {
        System.out.println("ID: " + getIdPedido());
        System.out.println("Cliente: " + getCliente());
        System.out.println("Direccion: " + getDireccion());
        System.out.println("Distancia Km: " + getDistanciaKm());
        System.out.println("Tiempo de entrega: " + calcularTiempoEntrega() + " minutos aprox.");
        System.out.println("Estado: " + getEstado());
        System.out.println("");
    }

    /**
     * Calcula el tiempo de entrega según el tipo de pedido.
     *
     * @return tiempo aproximado de entrega en minutos
     */
    public abstract int calcularTiempoEntrega();

    /**
     * Devuelve una representación en texto del pedido con sus datos principales.
     *
     * @return texto con los datos del pedido
     */
    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", cliente='" + cliente + '\'' +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", distanciaKm=" + distanciaKm +
                ", estado='" + estado + '\'' +
                '}';
    }
}
