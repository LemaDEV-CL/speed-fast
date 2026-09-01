package cl.lema.app;

import cl.lema.interfaces.Asignable;
import cl.lema.interfaces.Cancelable;
import cl.lema.interfaces.Despachable;
import cl.lema.models.*;
import cl.lema.servicio.ControladorDeEnvios;

/**
 * Clase principal que ejecuta un ejemplo del sistema Speed Fast.
 * Crea distintos tipos de pedidos y usa el controlador para procesarlos.
 */
public class Main {

    /**
     * Inicia el programa y muestra en consola el proceso de los pedidos.
     *
     * @param args argumentos recibidos al ejecutar el programa
     */
    public static void main(String[] args) {

        ControladorDeEnvios controlador = new ControladorDeEnvios();
        int cancelarID = 328;

        Pedido[] pedidos = {
        new PedidoComida(
                232,
                "Juan",
                "Hugo Bravo 94",
                3,
                "Speedy",
                "Piccola",
                30
        ),

        new PedidoEncomienda(
                328,
                "Andres cliente",
                "Pajaritos 368",
                4,
                "Spiderman",
                3,
                9
        ),

        new PedidoExpress(
                475,
                "Diego Apurado",
                "Alameda 265",
                6,
                "Carlos Moto",
                "Needle"
        )};



        for (Pedido pedido : pedidos) {
            System.out.println("=== Resumen pedido #" + pedido.getIdPedido() + " ===");
            pedido.mostrarResumen();

            System.out.println("=== Estado del envío #" + pedido.getIdPedido() + " ===");

            if (pedido instanceof Asignable asignable) {
                controlador.asignarPedido(asignable);
            }

            if (pedido instanceof Despachable despachable) {
                controlador.despacharPedido(despachable);
            }

            if (pedido instanceof Cancelable cancelable) {
                if (pedido.getIdPedido() == cancelarID) {
                    System.out.println("Cancelando pedido...");
                    controlador.cancelarPedido(cancelable);
                    pedido.setCancelado(true);
                    System.out.println();
                }
            }

            if (pedido.isCancelado() == false) {
                controlador.registrarEntrega(pedido);
                System.out.println();
            }

        }
        controlador.verHistorial();
    }
}
