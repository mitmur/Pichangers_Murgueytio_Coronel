package pe.edu.ulima.pichangers.agregaralumno;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Alumno;

public interface AgregarAlumnoView {
    public void setPresenter(AgregarAlumnoPresenter presenter);
    public void mostrarAlumnos(List<Alumno> alumnos);
    public void notifyAddSuccess(String codAlumno);
}
