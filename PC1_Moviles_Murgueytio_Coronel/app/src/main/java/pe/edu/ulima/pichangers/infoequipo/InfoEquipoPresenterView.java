package pe.edu.ulima.pichangers.infoequipo;

import pe.edu.ulima.pichangers.beans.Equipo;


public interface InfoEquipoPresenterView {
    public void setPresenter(InfoEquipoPresenter presenter);
    public void mostrarEquipo(Equipo equipo);
}
