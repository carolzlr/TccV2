package com.example.tccv2.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.tccv2.R;
import com.example.tccv2.entidades.Paciente;


public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.ViewHolder> {
    private List<Paciente> pacienteList;

    public AdapterPaciente(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_paciente, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Paciente paciente = pacienteList.get(position);
        holder.tv_idade.setText(String.valueOf(paciente.getIdade()));
        holder.tv_genero.setText(paciente.getGenero());
        holder.tv_diag.setText(paciente.getDiagnostico());
    }

    @Override
    public int getItemCount() {
        return pacienteList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_idade;
        public TextView tv_genero;
        public TextView tv_diag;

        public ViewHolder (View view) {
            super(view);
            tv_idade = view.findViewById(R.id.tv_idade);
            tv_genero = view.findViewById(R.id.tv_genero);
            tv_diag = view.findViewById(R.id.tv_diag);
        }
    }
}