package heartom.edu.simplecrud;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tomas on 13/06/2017.
 */

public class PacienteAdapter extends RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder> {

    List<Paciente> lista;

    public PacienteAdapter(List<Paciente> lista) {
        this.lista = lista;
    }

    @Override
    public PacienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paciente_row,parent,false);

        return new PacienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PacienteViewHolder holder, int position) {
        holder.bindPaciente(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class PacienteViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        TextView tvId;

        public PacienteViewHolder(View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvPaciente);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
        }

        public void bindPaciente(Paciente paciente){
            String nombre = paciente.getApPaterno() + " " + paciente.getApMaterno() + " " + paciente.getNombres();
            tvNombre.setText(nombre);
            tvId.setText(String.valueOf(paciente.getIdPaciente()));
        }


    }
}
