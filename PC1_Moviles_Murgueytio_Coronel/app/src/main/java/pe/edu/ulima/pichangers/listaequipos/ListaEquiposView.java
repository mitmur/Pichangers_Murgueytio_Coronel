package pe.edu.ulima.pichangers.listaequipos;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;

public interface ListaEquiposView {
    public void setPresenter(ListaEquiposPresenter presenter);
    public void mostrarEquipos(List<Equipo> equipos);

}
