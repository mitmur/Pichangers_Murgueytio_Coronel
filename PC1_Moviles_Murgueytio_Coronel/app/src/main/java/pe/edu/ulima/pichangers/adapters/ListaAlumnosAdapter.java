package pe.edu.ulima.pichangers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.agregaralumno.AgregarAlumnoActivity;
import pe.edu.ulima.pichangers.beans.Alumno;


public class ListaAlumnosAdapter extends BaseAdapter {

    private List<Alumno> mAlumnos;
    private LayoutInflater mInflater;
    Context mContext;

    public ListaAlumnosAdapter(Context mContext, List<Alumno> mAlumnos) {
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
        this.mAlumnos = mAlumnos;
    }

    @Override
    public int getCount() {
        return mAlumnos.size();
    }

    @Override
    public Object getItem(int position) {
        return mAlumnos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mAlumnos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;

        if (view == null){
            view = mInflater.inflate(R.layout.item_listado, null);

            viewHolder = new ViewHolder();
            viewHolder.tviName = (TextView) view.findViewById(R.id.tviName);
            viewHolder.tviCode = (TextView) view.findViewById(R.id.tviCode);
            viewHolder.iviAdd = (ImageView) view.findViewById(R.id.iviAdd);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Alumno alumno = mAlumnos.get(position);

        viewHolder.tviName.setText(alumno.getNombre());
        viewHolder.tviCode.setText(alumno.getCodigo());
        viewHolder.iviAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AgregarAlumnoActivity) mContext).addCodAlumnoEquipo(alumno.getCodigo());
            }
        });

        return view;
    }

    class ViewHolder {
        TextView tviName;
        TextView tviCode;
        ImageView iviAdd;
    }
}
