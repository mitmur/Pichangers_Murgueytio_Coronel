package pe.edu.ulima.pichangers.agregaralumno;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Alumno;
import pe.edu.ulima.pichangers.beans.ServerResponse;
import pe.edu.ulima.pichangers.remote.PichangersService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AgregarAlumnoPresenterImpl implements AgregarAlumnoPresenter {

    AgregarAlumnoView mView;

    public AgregarAlumnoPresenterImpl(AgregarAlumnoView view) {
        mView = view;
    }

    @Override
    public void obtenerAlumnos(boolean flagEquipo) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PichangersService.SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PichangersService service = retrofit.create(PichangersService.class);
        service.obtenerAlumnos(flagEquipo).enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                List<Alumno> equipos = response.body();
                mView.mostrarAlumnos(equipos);
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });
    }

    @Override
    public void addAlumnoEquipo(final Long idEquipo, final String codigoAlumno) {
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(PichangersService.SERVICE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        PichangersService service = retrofit.create(PichangersService.class);

        service.addAlumnoEquipo(idEquipo, codigoAlumno).enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.body() != null && ((ServerResponse) response.body()).getMsg().equalsIgnoreCase("OK")) {
                    mView.notifyAddSuccess(codigoAlumno);
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                    Log.e("Pichangers",t.getMessage());
            }
        });

    }
}
