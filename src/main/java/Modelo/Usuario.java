package Modelo;

public class Usuario {
    private String dni;
    private String password;
    private String nombreCompleto;
    private String fechaNac;
    private String domicilio;
    private TipoUsuario tipoUsuario;
    private int circunscripcion;
    private boolean activo;

    public enum TipoUsuario {
        Votante, Admin
    }

    public Usuario() {}

    public Usuario(String dni, String password, String nombreCompleto, String fechaNac, String domicilio, TipoUsuario tipoUsuario, int circunscripcion, boolean activo) {
        this.dni = dni;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
        this.tipoUsuario = tipoUsuario;
        this.circunscripcion = circunscripcion;
        this.activo = activo;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getCircunscripcion() {
        return circunscripcion;
    }
    public void setCircunscripcion(int circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", password='" + password + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", circunscripcion=" + circunscripcion +
                ", activo=" + activo +
                '}';
    }
}
