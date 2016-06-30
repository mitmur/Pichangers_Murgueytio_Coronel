package pe.edu.ulima.pichangers.listaequipos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.remote.PichangersService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaEquiposPresenterImpl implements ListaEquiposPresenter {
    String id;
    ListaEquiposView mView;
    Equipo team;

    public ListaEquiposPresenterImpl(ListaEquiposView view) {
        mView = view;
    }

    @Override
    public void obtenerEquipos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PichangersService.SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PichangersService service = retrofit.create(PichangersService.class);
        service.obtenerEquipos().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                List<Equipo> equipos = response.body();
                mView.mostrarEquipos(equipos);
            }

            @Override
            public void onFailure(Call<List<Equipo>> call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });
    }
}
