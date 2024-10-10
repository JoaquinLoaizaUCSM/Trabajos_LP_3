package Trabajo_6.Actividades;

public class Pedido {
    public enum EstadoPedido {
        PENDIENTE, COMPLETADO, ELIMINADO
    }

    private int id;
    private String nombrePlato;
    private EstadoPedido estado;

    public Pedido(int id, String nombrePlato) {
        this.id = id;
        this.nombrePlato = nombrePlato;
        this.estado = EstadoPedido.PENDIENTE;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}