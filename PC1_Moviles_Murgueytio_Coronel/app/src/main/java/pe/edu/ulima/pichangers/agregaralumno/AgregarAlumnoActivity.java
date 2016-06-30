package pe.edu.ulima.pichangers.agregaralumno;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.adapters.ListaAlumnosAdapter;
import pe.edu.ulima.pichangers.beans.Alumno;
import pe.edu.ulima.pichangers.beans.Equipo;

public class AgregarAlumnoActivity extends AppCompatActivity implements AgregarAlumnoView {
    public static final boolean flagEquipo = true;
    private Long idEquipo;

    AgregarAlumnoPresenter mPresenter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_integrante);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Equipo equipo = (Equipo) getIntent().getSerializableExtra("equipo");
        idEquipo = equipo.getId();

        listView = (ListView) findViewById(R.id.lviAlumnos);
        setPresenter(new AgregarAlumnoPresenterImpl(this));
        mPresenter.obtenerAlumnos(flagEquipo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setPresenter(AgregarAlumnoPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void mostrarAlumnos(List<Alumno> alumnos) {
        ListaAlumnosAdapter adapter = new ListaAlumnosAdapter(this, alumnos);
        listView.setAdapter(adapter);
    }

    public void addCodAlumnoEquipo(String codAlumno) {
        mPresenter.addAlumnoEquipo(idEquipo, codAlumno);
    }

    @Override
    public void notifyAddSuccess(String codAlumno) {
        Toast.makeText(this, getString(R.string.notify_add_success, codAlumno), Toast.LENGTH_LONG).show();
        finish();
    }

    public Long getIdEquipo() {
        return idEquipo;
    }
}
