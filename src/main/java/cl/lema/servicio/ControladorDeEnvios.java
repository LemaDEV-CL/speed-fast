package cl.lema.servicio;

import cl.lema.interfaces.Asignable;
import cl.lema.interfaces.*;
import cl.lema.models.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 * Controla las acciones principales de los envíos.
 * También guarda un historial simple de los pedidos entregados.
 */
public class ControladorDeEnvios implements Rastreable {

    private List<String> historial = new ArrayList<>();

    /**
     * Solicita la asignación de un repartidor para un pedido.
     *
     * @param pedido pedido que puede recibir un repartidor
     */
    public void asignarPedido(Asignable pedido) {
        pedido.asignarRepartidor();
    }

    /**
     * Solicita la cancelación de un pedido.
     *
     * @param pedido pedido que puede ser cancelado
     */
    public void cancelarPedido(Cancelable pedido) { pedido.cancelar(); }

    /**
     * Solicita el despacho de un pedido.
     *
     * @param pedido pedido que puede ser despachado
     */
    public void despacharPedido(Despachable pedido) {
        pedido.despachar();
    }

    /**
     * Muestra en consola el historial de pedidos entregados.
     */
    @Override
    public void verHistorial() {
        System.out.println("=== HISTORIAL DE ENTREGAS COMPLETADAS ===");
        if (historial.isEmpty()) {
            System.out.println("No existen despachos registrados.");
        } else {
            for (String evento : historial) {
                System.out.println(evento);
            }
        }
    }

    /**
     * Agrega un pedido al historial de entregas completadas.
     *
     * @param pedido pedido que fue entregado
     */
    public void registrarEntrega(Pedido pedido) {
        historial.add("Pedido #" + pedido.getIdPedido() + " - entregado por " + pedido.getRepartidorAsignado()
        );
    }
}
