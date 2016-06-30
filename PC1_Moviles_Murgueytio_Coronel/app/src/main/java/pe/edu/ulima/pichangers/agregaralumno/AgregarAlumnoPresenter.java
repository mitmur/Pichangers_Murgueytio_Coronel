package pe.edu.ulima.pichangers.agregaralumno;


public interface AgregarAlumnoPresenter {
    public void obtenerAlumnos(boolean flagEquipo);
    public void addAlumnoEquipo(Long idEquipo, String codigoAlumno);
}
