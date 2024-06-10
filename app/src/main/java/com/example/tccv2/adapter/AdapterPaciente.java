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

public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.PacienteViewHolder> {
    private List<Paciente> resumoPaciente;

    public AdapterPaciente(List<Paciente> resumoPaciente) {
        this.resumoPaciente = resumoPaciente;
    }

    @NonNull
    @Override
    public PacienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paciente, parent, false);
        return new PacienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PacienteViewHolder holder, int position) {
        Paciente paciente = resumoPaciente.get(position);
        holder.tv_idade.setText(paciente.getIdade());
        holder.tv_genero.setText(paciente.getGenero());
        holder.tv_f1.setText(String.valueOf(paciente.getFluxo1()));
        holder.tv_f2.setText(String.valueOf(paciente.getFluxo2()));
        holder.tv_f3.setText(String.valueOf(paciente.getFluxo3()));
        holder.tv_diag.setText(paciente.getDiagnostico());
    }

    @Override
    public int getItemCount() {
        return resumoPaciente.size();
    }

    public static class PacienteViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_idade;
        public TextView tv_genero;
        public TextView tv_f1;
        public TextView tv_f2;
        public TextView tv_f3;
        public TextView  tv_diag;

        public PacienteViewHolder(View itemView) {
            super(itemView);
            tv_idade = itemView.findViewById(R.id.tv_idade);
            tv_genero = itemView.findViewById(R.id.tv_genero);
            tv_f2 = itemView.findViewById(R.id.tv_f2);
            tv_f3 = itemView.findViewById(R.id.tv_f3);
            tv_diag = itemView.findViewById(R.id.tv_diag);
        }
    }
}