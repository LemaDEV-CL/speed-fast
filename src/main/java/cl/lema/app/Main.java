package cl.lema.app;

import cl.lema.models.Pedido;
import cl.lema.models.PedidoComida;
import cl.lema.models.PedidoEncomienda;
import cl.lema.models.PedidoExpress;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejecuta ejemplos de herencia, polimorfismo, sobreescritura y sobrecarga
 * mediante distintos tipos de pedidos.
 */
public class Main {

    public static void main(String[] args) {

        boolean urgente = true;
        boolean prioritario = true;
        int horaLimite = 20;

        String tipoComida = "Comida";
        String tipoEncomienda = "Encomienda";
        String tipoExpress = "Express";

        PedidoComida pedidoComida = new PedidoComida(
                1,
                "Andres21",
                "Casablanca 1821, Maipu",
                "Piccola",
                "30 minutos"
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                2,
                "MartinaLema1",
                "Pedro Prado 123",
                2,
                4
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                3,
                "Carlos3921",
                "Hugo Bravo 94, Maipu",
                "H&M",
                2
        );

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedidoComida);
        pedidos.add(pedidoEncomienda);
        pedidos.add(pedidoExpress);

        System.out.println("=== SOBRESCRITURA Y POLIMORFISMO ===");

        for (Pedido pedido : pedidos) {
            System.out.println("\n" + pedido.getClass().getSimpleName());
            System.out.println(pedido.asignarRepartidor());
        }

        System.out.println("\n=== SOBRECARGA DE METODOS ===");

        System.out.println("\nPedidoComida");
        System.out.println(pedidoComida.asignarRepartidor(tipoComida));
        System.out.println(pedidoComida.asignarRepartidor(urgente));

        System.out.println("\nPedidoEncomienda");
        System.out.println(pedidoEncomienda.asignarRepartidor(tipoEncomienda));
        System.out.println(pedidoEncomienda.asignarRepartidor(prioritario));

        System.out.println("\nPedidoExpress");
        System.out.println(pedidoExpress.asignarRepartidor(tipoExpress));
        System.out.println(pedidoExpress.asignarRepartidor(horaLimite));
    }
}
