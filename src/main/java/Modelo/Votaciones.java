package Modelo;

public class Votaciones {
    private int id;
    private int circunscripcion;
    private int fechaVotaciones;
    private boolean estado;

    public Votaciones(int id, int circunscripcion, int fechaVotaciones, boolean estado) {
        this.id = id;
        this.circunscripcion = circunscripcion;
        this.fechaVotaciones = fechaVotaciones;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCircunscripcion() {
        return circunscripcion;
    }
    public void setCircunscripcion(int circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public int getFechaVotaciones() {
        return fechaVotaciones;
    }
    public void setFechaVotaciones(int fechaVotaciones) {
        this.fechaVotaciones = fechaVotaciones;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Votaciones{" +
                "id=" + id +
                ", circunscripcion=" + circunscripcion +
                ", fechaVotaciones=" + fechaVotaciones +
                ", estado=" + estado +
                '}';
    }
}
