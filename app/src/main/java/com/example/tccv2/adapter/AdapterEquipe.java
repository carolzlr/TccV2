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


public class AdapterEquipe extends RecyclerView.Adapter<AdapterEquipe.ViewHolder> {
    private List<Equipe> equipeList;

    public AdapterEquipe(List<Equipe> equipeList) {
        this.equipeList = equipeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_equipe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Equipe equipe = equipeList.get(position);
        holder.tv_cirurgiao.setText(equipe.getCirurgiao());
        holder.tv_auxiliar1.setText(equipe.getAuxiliar1());
        holder.tv_perfusionista.setText(equipe.getPerfusionista());
        holder.tv_hospital.setText(equipe.getHospital());
    }

    @Override
    public int getItemCount() {
        return equipeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_cirurgiao;
        public TextView tv_auxiliar1;
        public TextView tv_perfusionista;
        public TextView tv_hospital;

        public ViewHolder(View view) {
            super(view);
            tv_cirurgiao = view.findViewById(R.id.tv_cirurgiao);
            tv_auxiliar1 = view.findViewById(R.id.tv_auxiliar1);
            tv_perfusionista = view.findViewById(R.id.tv_perfusionista);
            tv_hospital = view.findViewById(R.id.tv_hospital);
        }
    }
}