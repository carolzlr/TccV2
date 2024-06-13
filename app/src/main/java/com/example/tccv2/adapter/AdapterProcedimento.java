package com.example.tccv2.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.R;
import com.example.tccv2.entidades.Paciente;
import com.example.tccv2.entidades.Procedimento;

import java.util.List;

public class AdapterProcedimento extends RecyclerView.Adapter<AdapterProcedimento.ProcedimentoViewHolder>{
    private List<Procedimento> resumoProcedimento;

    public AdapterProcedimento(List<Procedimento> resumoProcedimento) {
        this.resumoProcedimento = resumoProcedimento;
    }


    @NonNull
    @Override
    public AdapterProcedimento.ProcedimentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_procedimento, parent, false);
        return new ProcedimentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProcedimento.ProcedimentoViewHolder holder, int position) {
        Procedimento procedimento = resumoProcedimento.get(position);
        holder.tv_nome.setText(procedimento.getNomeProc());
        holder.tv_datainicio.setText(String.valueOf(procedimento.getDataInicio()));
        holder.tv_oxi.setText(procedimento.getOxigenador());
        holder.tv_canulaAA.setText(procedimento.getCanulaAA());
        holder.tv_canulaV.setText(procedimento.getCanulaV());
        holder.tv_totalCEC.setText(String.valueOf(procedimento.getTotalCec()));
        holder.tv_totalClamp.setText(String.valueOf(procedimento.getTotalClamp()));
        holder.tv_datafim.setText(String.valueOf(procedimento.getDatafProc()));

    }

    @Override
    public int getItemCount() {
        return resumoProcedimento.size();
    }

    public static class ProcedimentoViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nome;
        public TextView tv_datainicio;
        public TextView tv_horainicio;
        public TextView tv_oxi;
        public TextView tv_canulaAA;
        public TextView tv_canulaV;
        public TextView tv_totalCEC;
        public TextView tv_totalClamp;
        public TextView tv_datafim;
        public ProcedimentoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nome = itemView.findViewById(R.id.tv_nome);
            tv_datainicio = itemView.findViewById(R.id.tv_datainicio);
            tv_horainicio = itemView.findViewById(R.id.tv_horainicio);
            tv_oxi = itemView.findViewById(R.id.tv_oxi);
            tv_canulaAA = itemView.findViewById(R.id.tv_canulaAA);
            tv_canulaV = itemView.findViewById(R.id.tv_canulaV);
            tv_totalCEC = itemView.findViewById(R.id.tv_totalCEC);
            tv_totalClamp = itemView.findViewById(R.id.tv_totalClamp);
            tv_datafim = itemView.findViewById(R.id.tv_datafim);
        }
    }
}

