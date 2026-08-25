package cl.lema.app;

import cl.lema.models.*;

/**
 * Ejecuta ejemplo de clase padre abstracta
 * mediante distintos tipos de pedidos.
 */
public class Main {

    public static void main(String[] args) {

        Pedido[] pedidos = {
        new PedidoComida (
                1521,
                "Juan Cliente",
                "Hugo Bravo 94, Maipú",
                3,
                "Piccola",
                "30"
        ),
        new PedidoEncomienda (
                2213,
                "Huguito Lema",
                "Lasagna 2134, Pudahuel",
                3.5,
                23
        ),
        new PedidoExpress (5543,
                "Renato Apurado",
                "Pajaritos 2251, Maipú",
                3.4,
                "La comida mas rápida"
        )};

        System.out.println("...::: Listado de pedidos :::... \n");
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("\n");
        }
    }
}
