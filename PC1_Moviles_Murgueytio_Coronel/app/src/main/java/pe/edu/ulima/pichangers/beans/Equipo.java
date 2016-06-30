package pe.edu.ulima.pichangers.beans;

import java.io.Serializable;

public class Equipo implements Serializable {
    private long id;
    private String nombre;
    private int partidosGanados;
    private int partidosPerdidos;
    private String urlFoto;

    public Equipo(long id, String nombre, int partidosGanados, int partidosPerdidos, String urlFoto) {
        this.id = id;
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.urlFoto = urlFoto;
    }

    public Equipo(){

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

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String foto) {
        this.urlFoto = foto;
    }
}
