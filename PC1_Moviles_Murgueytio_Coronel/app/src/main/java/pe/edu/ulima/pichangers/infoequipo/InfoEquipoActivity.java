package pe.edu.ulima.pichangers.infoequipo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.Equipo;

public class InfoEquipoActivity extends AppCompatActivity /*implements InfoEquipoPresenterView*/{

    TextView tviNombreEquipo;
    TextView tviWins;
    TextView tviLosses;
    ImageView imgEquipo;
    InfoEquipoPresenter mPresenter;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tviNombreEquipo =(TextView) findViewById(R.id.tviNombreEquipo);
        tviWins =(TextView) findViewById(R.id.tviWins);
        tviLosses = (TextView) findViewById(R.id.tviLosses);
        imgEquipo = (ImageView)findViewById(R.id.imgEquipo);

        Equipo equipo = (Equipo) getIntent().getSerializableExtra("equipo");


        tviNombreEquipo.setText(equipo.getNombre());
        Picasso.with(this)
                .load(equipo.getUrlFoto())
                .into(imgEquipo);

        tviWins.setText(getString(R.string.wins_count, equipo.getPartidosGanados()));
        tviLosses.setText(getString(R.string.losses_count, equipo.getPartidosPerdidos()));

    }

}
