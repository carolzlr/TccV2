package com.example.tccv2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tccv2.R;
import com.example.tccv2.entidades.Relatorio;

import java.util.List;

public class AdapterRelatorios extends RecyclerView.Adapter<AdapterRelatorios.RelatoriosViewHolder> {
    private List<Relatorio> resumoRelatorios;

    public AdapterRelatorios(List<Relatorio> resumoRelatorios){
        this.resumoRelatorios = resumoRelatorios;
    }


    @NonNull
    @Override
    public AdapterRelatorios.RelatoriosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_relatorio, parent, false);
       return new RelatoriosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRelatorios.RelatoriosViewHolder holder, int position) {
        Relatorio relatorio = resumoRelatorios.get(position);
        holder.tv_nome.setText(relatorio.getProcedimento());
        holder.tv_datainicio.setText(relatorio.getDataInicio());
        holder.tv_oxi.setText(relatorio.getOxigenador());
        holder.tv_canulaAA.setText(relatorio.getCanulaAA());
        holder.tv_canulaV.setText(relatorio.getCanulaV());
        holder.tv_totalCEC.setText(relatorio.getTotalCEC());
        holder.tv_totalClamp.setText(relatorio.getTotalClamp());
        holder.tv_datafim.setText(relatorio.getDataFim());
        holder.tv_cirurgiao.setText(relatorio.getCirurgiao());
        holder.tv_aux1.setText(relatorio.getAuxiliar1());
        holder.tv_aux2.setText(relatorio.getAuxiliar2());
        holder.tv_perf.setText(relatorio.getPerfusionista());
        holder.tv_hosp.setText(relatorio.getHospital());
        holder.tv_vo2.setText(relatorio.getVo2Escolhido());

    }

    @Override
    public int getItemCount() {
        return resumoRelatorios.size();
    }


    public static class RelatoriosViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_nome;
        public TextView tv_datainicio;
        public TextView tv_horainicio;
        public TextView tv_oxi;
        public TextView tv_canulaAA;
        public TextView tv_canulaV;
        public TextView tv_totalCEC;
        public TextView tv_totalClamp;
        public TextView tv_datafim;
        public TextView tv_cirurgiao;
        public TextView tv_aux1;
        public TextView tv_aux2;
        public TextView tv_perf;
        public TextView tv_hosp;
        public TextView tv_vo2;


        public RelatoriosViewHolder(@NonNull View itemView) {
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
            tv_cirurgiao = itemView.findViewById(R.id.tv_cirurgiao);
            tv_aux1 = itemView.findViewById(R.id.tv_aux1);
            tv_aux2 = itemView.findViewById(R.id.tv_aux2);
            tv_perf = itemView.findViewById(R.id.tv_perf);
            tv_hosp = itemView.findViewById(R.id.tv_hosp);
            tv_vo2 = itemView.findViewById(R.id.tv_vo2);
        }
    }
}
