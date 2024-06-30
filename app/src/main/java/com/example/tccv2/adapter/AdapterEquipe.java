package com.example.tccv2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.tccv2.R;
import com.example.tccv2.entidades.Equipe;
public class AdapterEquipe extends RecyclerView.Adapter<AdapterEquipe.EquipeViewHolder> {
    private List<Equipe> resumoEquipe;

    public AdapterEquipe(List<Equipe> resumoEquipe) {
        this.resumoEquipe = resumoEquipe;
    }

    @NonNull
    @Override
    public EquipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipe, parent, false);
        return new EquipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EquipeViewHolder holder, int position) {
        Equipe equipe = resumoEquipe.get(position);
        holder.tv_cirurgiao.setText(equipe.getCirurgiao());
        holder.tv_auxiliar1.setText(equipe.getAuxiliar1());
        holder.tv_auxiliar2.setText(equipe.getAuxiliar2());
        holder.tv_perfusionista.setText(equipe.getPerfusionista());
        holder.tv_instrumentador.setText(equipe.getInstrumentador());
        holder.tv_anestesista.setText(equipe.getAnestesista());
        holder.tv_circulante.setText(equipe.getCirculante());
        holder.tv_hospital.setText(equipe.getHospital());

    }

    @Override
    public int getItemCount() {
        return resumoEquipe.size();
    }

    public static class EquipeViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_cirurgiao;
        public TextView tv_auxiliar1;
        public TextView tv_auxiliar2;
        public TextView tv_perfusionista;
        public TextView tv_instrumentador;
        public TextView tv_anestesista;
        public  TextView tv_circulante;
        public TextView tv_hospital;

        public EquipeViewHolder(View itemView) {
            super(itemView);
            tv_cirurgiao = itemView.findViewById(R.id.tv_cirurgiao);
            tv_auxiliar1 = itemView.findViewById(R.id.tv_auxiliar1);
            tv_auxiliar2 = itemView.findViewById(R.id.tv_auxiliar2);
            tv_perfusionista = itemView.findViewById(R.id.tv_perfusionista);
            tv_instrumentador = itemView.findViewById(R.id.tv_instrumentador);
            tv_anestesista = itemView.findViewById(R.id.tv_anestesista);
            tv_circulante = itemView.findViewById(R.id.tv_circulante);
            tv_hospital = itemView.findViewById(R.id.tv_hospital);
        }
    }
}