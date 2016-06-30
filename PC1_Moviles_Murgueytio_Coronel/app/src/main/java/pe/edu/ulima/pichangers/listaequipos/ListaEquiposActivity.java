package pe.edu.ulima.pichangers.listaequipos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.adapters.ListaEquiposAdapter;
import pe.edu.ulima.pichangers.beans.Equipo;

public class ListaEquiposActivity extends AppCompatActivity implements ListaEquiposView {

    ListaEquiposPresenter mPresenter;
    GridView gridView;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_equipos);

        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        gridView = (GridView)findViewById(R.id.gridView);
        setPresenter(new ListaEquiposPresenterImpl(this));
        mPresenter.obtenerEquipos();
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
    public void setPresenter(ListaEquiposPresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarEquipos(List<Equipo> equipos) {
        ListaEquiposAdapter adapter = new ListaEquiposAdapter(this, equipos);
        gridView.setAdapter(adapter);
    }








}
