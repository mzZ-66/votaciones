package Modelo;

public class Partido {
    private int id;
    private String siglas;
    private String nombreCompleto;

    public Partido(int id, String siglas, String nombreCompleto) {
        this.id = id;
        this.siglas = siglas;
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSiglas() {
        return siglas;
    }
    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", siglas='" + siglas + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
