package com.example.tccv2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.R;
import com.example.tccv2.entidades.Registro;

import java.util.List;

public class AdapterRegistros extends RecyclerView.Adapter<AdapterRegistros.ViewHolder> {

    private List<Registro> registros;
    private OnItemClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_idRegistro;
        public TextView tv_idEquipe;
        public TextView tv_idPaciente;
        public TextView tv_idExamesA;
        public TextView tv_idPcir;
        public TextView tv_idPCec;
        public TextView tv_idCalculoI;
        public TextView tv_idExamesRep;
        public TextView tv_idCalculoRep;
        public TextView tv_idProcedimento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_idRegistro = itemView.findViewById(R.id.tv_idRegistro);
            tv_idEquipe = itemView.findViewById(R.id.tv_idEquipe);
            tv_idPaciente = itemView.findViewById(R.id.tv_Paciente);
            tv_idExamesA = itemView.findViewById(R.id.tv_idExamesA);
            tv_idPcir = itemView.findViewById(R.id.tv_idPCir);
            tv_idPCec = itemView.findViewById(R.id.tv_PCec);
            tv_idCalculoI = itemView.findViewById(R.id.tv_idCalculoI);
            tv_idExamesRep = itemView.findViewById(R.id.tv_idExamesRep);
            tv_idCalculoRep = itemView.findViewById(R.id.tv_idCalculoRep);
            tv_idProcedimento = itemView.findViewById(R.id.tv_Procedimento);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Registro registro);
    }

    public AdapterRegistros(List<Registro> registros, OnItemClickListener listener) {
        this.registros = registros;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_registro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Registro registro = registros.get(position);
        holder.tv_idRegistro.setText(registro.getIdRegistro());
        holder.tv_idEquipe.setText(registro.getEquipe());
        holder.tv_idPaciente.setText(registro.getPaciente());
        holder.tv_idExamesA.setText(registro.getExamesAdicionais());
        holder.tv_idPcir.setText(registro.getpCir());
        holder.tv_idPCec.setText(registro.getpCec());
        holder.tv_idCalculoI.setText(registro.getCalculoInicial());
        holder.tv_idExamesRep.setText(registro.getExamesRep());
        holder.tv_idCalculoRep.setText(registro.getCalculoRep());
        holder.tv_idProcedimento.setText(registro.getCalculoRep());
        // Preencha outros campos conforme necessário
        holder.itemView.setOnClickListener(v -> listener.onItemClick(registro));
    }

    @Override
    public int getItemCount() {
        return registros.size();
    }


}
