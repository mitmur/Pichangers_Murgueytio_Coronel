package pe.edu.ulima.pichangers.beans;

public class Alumno {
    private long id;
    private String nombre;
    private String codigo;
    private Long equipo;

    public Alumno() {
    }

    public Alumno(long id, String nombre, String codigo, Long equipo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.equipo = equipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getEquipo() {
        return equipo;
    }

    public void setEquipo(Long equipo) {
        this.equipo = equipo;
    }
}
