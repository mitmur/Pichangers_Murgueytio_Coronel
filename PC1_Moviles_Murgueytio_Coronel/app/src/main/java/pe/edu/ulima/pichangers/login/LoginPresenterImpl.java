package pe.edu.ulima.pichangers.login;

import android.util.Log;

import pe.edu.ulima.pichangers.beans.ServerResponse;
import pe.edu.ulima.pichangers.beans.LoginUser;
import pe.edu.ulima.pichangers.remote.PichangersService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginPresenterImpl implements LoginPresenter {
    LoginView mView;

    public LoginPresenterImpl(LoginView pase) {
        mView = pase;
    }

    public void loginUsuario(final LoginUser alumno_user) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PichangersService.SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PichangersService service = retrofit.create(PichangersService.class);

        service.loginUsuario(alumno_user).enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call call, Response response) {
                String msg = ((ServerResponse) response.body()).getMsg();

                if (msg.equalsIgnoreCase("ok")) {
                    mView.loginCorrecto();
                } else {
                    mView.loginIncorrecto();
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });
    }


}
