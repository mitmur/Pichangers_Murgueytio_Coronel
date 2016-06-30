package pe.edu.ulima.pichangers.remote;


import java.util.List;

import pe.edu.ulima.pichangers.beans.Alumno;
import pe.edu.ulima.pichangers.beans.ServerResponse;
import pe.edu.ulima.pichangers.beans.LoginUser;
import pe.edu.ulima.pichangers.beans.Equipo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PichangersService {
    public static final String SERVICE_URL = "http://pichangers-api.mybluemix.net/rest/";

    @POST("alumnos/login")
    Call<ServerResponse> loginUsuario(@Body LoginUser alumno_user);

    @GET("alumnos")
    Call<List<Alumno>> obtenerAlumnos(@Query("sin_equipo") boolean flagEquipo);

    @GET("equipos")
    Call<List<Equipo>> obtenerEquipos();

    @POST("equipos/{id}/{codigo_alumno}")
    Call<ServerResponse> addAlumnoEquipo(@Path("id") Long idEquipo, @Path("codigo_alumno") String codAlumno);

    @GET("equipos/{id}")
    Call<Equipo> mostrarInfo(@Path("id")Long id);

}
