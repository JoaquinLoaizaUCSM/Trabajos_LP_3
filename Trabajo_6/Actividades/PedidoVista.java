package Trabajo_6.Actividades;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- Sistema de Gestión de Pedidos ---");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Marcar Pedido como Completado");
        System.out.println("4. Eliminar Pedido");
        System.out.println("5. Mostrar Pedidos Pendientes");
        System.out.println("6. Mostrar Historial");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public String solicitarNombrePlato() {
        System.out.print("Ingrese el nombre del plato: ");
        return scanner.nextLine();
    }

    public int solicitarIdPedido() {
        System.out.print("Ingrese el ID del pedido: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos para mostrar.");
        } else {
            System.out.println("\n--- Lista de Pedidos ---");
            for (Pedido pedido : pedidos) {
                System.out.printf("ID: %d, Plato: %s, Estado: %s%n",
                        pedido.getId(), pedido.getNombrePlato(), pedido.getEstado());
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}