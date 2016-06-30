package pe.edu.ulima.pichangers.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.pichangers.agregaralumno.AgregarAlumnoActivity;
import pe.edu.ulima.pichangers.infoequipo.InfoEquipoActivity;
import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.Equipo;

public class ListaEquiposAdapter extends BaseAdapter {

    private List<Equipo> mEquipos;
    private LayoutInflater mInflater;
    Context mContext;

    public ListaEquiposAdapter(Context context, List<Equipo> equipos){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mEquipos = equipos;
    }

    @Override
    public int getCount() {
        return mEquipos.size();
    }

    @Override
    public Object getItem(int position) {
        return mEquipos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mEquipos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_listado_equipos, null);

            viewHolder = new ViewHolder();
            viewHolder.tviNombreEquipo = (TextView) view.findViewById(R.id.iviText);
            viewHolder.imgEquipo = (ImageView) view.findViewById(R.id.imagen_equipo);
            viewHolder.iviAdd = (ImageView) view.findViewById(R.id.iviAdd);
            viewHolder.iviInfo = (ImageView) view.findViewById(R.id.iviUsers);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        final Equipo equipo = mEquipos.get(position);

        viewHolder.tviNombreEquipo.setText(equipo.getNombre());
        Picasso.with(mContext)
                .load(equipo.getUrlFoto())
                .fit()
                .centerCrop()
                .into(viewHolder.imgEquipo);

        viewHolder.iviAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, AgregarAlumnoActivity.class);
                intent.putExtra("equipo", equipo);
                mContext.startActivity(intent);
            }
        });

        View.OnClickListener infoListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, InfoEquipoActivity.class);
                intent.putExtra("equipo",equipo);
                mContext.startActivity(intent);
            }
        };
        viewHolder.iviInfo.setOnClickListener(infoListener);
        viewHolder.imgEquipo.setOnClickListener(infoListener);

        return view;
    }

    class ViewHolder{
        ImageView imgEquipo;
        TextView tviNombreEquipo;
        ImageView iviAdd;
        ImageView iviInfo;
    }

}
