package pe.edu.ulima.pichangers.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.LoginUser;
import pe.edu.ulima.pichangers.listaequipos.ListaEquiposActivity;


public class LoginActivity extends AppCompatActivity implements LoginView {

    EditText eteUsuario;
    EditText etePassword;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eteUsuario = (EditText)findViewById(R.id.txtUsuario);
        etePassword = (EditText)findViewById(R.id.txtContraseña);

        setPresenter(new LoginPresenterImpl(this));
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loginCorrecto() {
        Toast.makeText(this, "Login Correcto", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ListaEquiposActivity.class);
        startActivity(intent);
    }
    
    @Override
    public void loginIncorrecto() {
        Toast.makeText(this, "Login incorrecto, Verifique usuario o contraseña", Toast.LENGTH_LONG).show();
    }

    public void onLoginClicked(View view){
        LoginUser alumno_user = new LoginUser(
                eteUsuario.getText().toString(),
                etePassword.getText().toString()
        );
        presenter.loginUsuario(alumno_user);
    }


}
