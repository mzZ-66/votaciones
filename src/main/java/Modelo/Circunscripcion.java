package Modelo;

public class Circunscripcion {
    private int id;
    private String localidad;
    private String provincia;

    public Circunscripcion(int id, String localidad, String provincia) {
        this.id = id;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Circunscripcion{" +
                "id=" + id +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
