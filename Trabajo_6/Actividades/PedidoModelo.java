package Trabajo_6.Actividades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private int nextId;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
        nextId = 1;
    }

    public Pedido agregarPedido(String nombrePlato) {
        Pedido nuevoPedido = new Pedido(nextId++, nombrePlato);
        pedidos.add(nuevoPedido);
        return nuevoPedido;
    }

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public List<Pedido> getPedidosPorEstado(Pedido.EstadoPedido estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado() == estado)
                .collect(Collectors.toList());
    }

    public boolean marcarComoCompletado(int id) {
        return cambiarEstadoPedido(id, Pedido.EstadoPedido.COMPLETADO);
    }

    public boolean eliminarPedido(int id) {
        return cambiarEstadoPedido(id, Pedido.EstadoPedido.ELIMINADO);
    }

    private boolean cambiarEstadoPedido(int id, Pedido.EstadoPedido nuevoEstado) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedido.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }

    public int contarPedidosPendientes() {
        return (int) pedidos.stream()
                .filter(p -> p.getEstado() == Pedido.EstadoPedido.PENDIENTE)
                .count();
    }

    public List<Pedido> getHistorial() {
        return pedidos.stream()
                .filter(p -> p.getEstado() == Pedido.EstadoPedido.COMPLETADO || p.getEstado() == Pedido.EstadoPedido.ELIMINADO)
                .collect(Collectors.toList());
    }
}