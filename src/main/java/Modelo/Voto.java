package Modelo;

public class Voto {
    private int id;
    private String votante;
    private int partido;
    private int votaciones;
    private String fechaVoto;

    public Voto(int id, String votante, int partido, int votaciones, String fechaVoto) {
        this.id = id;
        this.votante = votante;
        this.partido = partido;
        this.votaciones = votaciones;
        this.fechaVoto = fechaVoto;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getVotante() {
        return votante;
    }
    public void setVotante(String votante) {
        this.votante = votante;
    }

    public int getPartido() {
        return partido;
    }
    public void setPartido(int partido) {
        this.partido = partido;
    }

    public int getVotaciones() {
        return votaciones;
    }
    public void setVotaciones(int votaciones) {
        this.votaciones = votaciones;
    }

    public String getFechaVoto() {
        return fechaVoto;
    }
    public void setFechaVoto(String fechaVoto) {
        this.fechaVoto = fechaVoto;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", votante='" + votante + '\'' +
                ", partido=" + partido +
                ", votaciones=" + votaciones +
                ", fechaVoto='" + fechaVoto + '\'' +
                '}';
    }
}
