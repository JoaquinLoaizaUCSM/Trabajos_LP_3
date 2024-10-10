package Trabajo_6.Actividades;


public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            String opcion = vista.solicitarNombrePlato(); // Reutilizamos este método para leer la opción
            switch (opcion) {
                case "1":
                    agregarPedido();
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    marcarComoCompletado();
                    break;
                case "4":
                    eliminarPedido();
                    break;
                case "5":
                    mostrarPedidosPendientes();
                    break;
                case "6":
                    mostrarHistorial();
                    break;
                case "7":
                    salir = true;
                    vista.mostrarMensaje("Gracias por usar el Sistema de Gestión de Pedidos.");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
        vista.cerrar();
    }

    private void agregarPedido() {
        String nombrePlato = vista.solicitarNombrePlato();
        Pedido nuevoPedido = modelo.agregarPedido(nombrePlato);
        vista.mostrarMensaje("Pedido agregado con ID: " + nuevoPedido.getId());
    }

    private void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    private void marcarComoCompletado() {
        int id = vista.solicitarIdPedido();
        if (modelo.marcarComoCompletado(id)) {
            vista.mostrarMensaje("Pedido marcado como completado.");
        } else {
            vista.mostrarMensaje("No se encontró el pedido con ID: " + id);
        }
    }

    private void eliminarPedido() {
        int id = vista.solicitarIdPedido();
        if (modelo.eliminarPedido(id)) {
            vista.mostrarMensaje("Pedido eliminado.");
        } else {
            vista.mostrarMensaje("No se encontró el pedido con ID: " + id);
        }
    }

    private void mostrarPedidosPendientes() {
        vista.mostrarPedidos(modelo.getPedidosPorEstado(Pedido.EstadoPedido.PENDIENTE));
        vista.mostrarMensaje("Total de pedidos pendientes: " + modelo.contarPedidosPendientes());
    }

    private void mostrarHistorial() {
        vista.mostrarPedidos(modelo.getHistorial());
    }
}