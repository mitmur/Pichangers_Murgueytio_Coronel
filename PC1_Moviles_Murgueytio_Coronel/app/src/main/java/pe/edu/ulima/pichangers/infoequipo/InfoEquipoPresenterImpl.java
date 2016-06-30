package pe.edu.ulima.pichangers.infoequipo;

import android.util.Log;

import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.remote.PichangersService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InfoEquipoPresenterImpl implements InfoEquipoPresenter {

    InfoEquipoPresenterView mView;
    public InfoEquipoPresenterImpl (InfoEquipoPresenterView view){
        mView=view;
    }

    @Override
    public void mostrarInfo(Long id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PichangersService.SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PichangersService service = retrofit.create(PichangersService.class);

        service.mostrarInfo(id).enqueue(new Callback<Equipo>() {
            @Override
            public void onResponse(Call<Equipo> call, Response<Equipo> response) {
                Equipo equipo = response.body();
                mView.mostrarEquipo(equipo);
            }

            @Override
            public void onFailure(Call<Equipo> call, Throwable t) {
                Log.e("Pichangers",t.getMessage());
            }
        });
    }


}
