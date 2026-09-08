package cl.lema.app;

import cl.lema.models.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal del sistema SpeedFast.
 * Crea pedidos y repartidores de ejemplo y ejecuta sus entregas de forma concurrente
 * mediante un ExecutorService.
 */
public class Main {

    public static void main(String[] args) {

        Pedido pedido1 = new PedidoComida(
                101,
                "Juan Pérez",
                "Av. Pajaritos 2500",
                4.5,
                "Camila",
                "McDonalds",
                15
        );

        Pedido pedido2 = new PedidoExpress(
                102,
                "María Soto",
                "Las Parcelas 1800",
                6.2,
                "Camila",
                "Falabella"
        );

        Pedido pedido3 = new PedidoEncomienda(
                201,
                "Carlos Díaz",
                "Alameda 1500",
                5,
                "Luis",
                4,
                8
        );

        Pedido pedido4 = new PedidoComida(
                202,
                "Ana Torres",
                "Las Rejas 850",
                3.7,
                "Luis",
                "Domino",
                20
        );

        Pedido pedido5 = new PedidoExpress(
                301,
                "Felipe Rojas",
                "Providencia 2200",
                7,
                "Pedro",
                "Paris"
        );

        Pedido pedido6 = new PedidoEncomienda(
                302,
                "Laura González",
                "Irarrázaval 1350",
                5.5,
                "Pedro",
                2,
                6
        );

        List<Pedido> pedidosCamila = List.of(pedido1, pedido2);
        List<Pedido> pedidosLuis = List.of(pedido3, pedido4);
        List<Pedido> pedidosPedro = List.of(pedido5, pedido6);

        Repartidor camila = new Repartidor("Camila", pedidosCamila);
        Repartidor luis = new Repartidor("Luis", pedidosLuis);
        Repartidor pedro = new Repartidor("Pedro", pedidosPedro);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(camila);
        executor.execute(luis);
        executor.execute(pedro);
        executor.shutdown();

        try {

            boolean finalizado = executor.awaitTermination(1, TimeUnit.MINUTES);
            if (finalizado) {
                System.out.println("=== Todos los repartidores finalizaron ===");
            } else {
                System.out.println("=== La simulación no finalizó dentro del tiempo esperado ===");
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            System.out.println("=== La ejecución principal fue interrumpida ===");
        }
    }
}
