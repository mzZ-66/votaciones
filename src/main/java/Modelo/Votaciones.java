package Modelo;

public class Votaciones {
    private int id;
    private int circunscripcion;
    private String fechaInicio;
    private String fechaFin;
    private boolean abiertas;

    public Votaciones(int id, int circunscripcion, String fechaInicio, String fechaFin, boolean abiertas) {
        this.id = id;
        this.circunscripcion = circunscripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.abiertas = abiertas;
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

    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isAbiertas() {
        return abiertas;
    }
    public void setAbiertas(boolean abiertas) {
        this.abiertas = abiertas;
    }

    @Override
    public String toString() {
        return "Votaciones{" +
                "id=" + id +
                ", circunscripcion=" + circunscripcion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", abiertas=" + abiertas +
                '}';
    }
}
