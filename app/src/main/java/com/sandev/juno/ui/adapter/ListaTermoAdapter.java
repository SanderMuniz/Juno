package com.sandev.juno.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sandev.juno.R;
import com.sandev.juno.data.model.Termo;

import java.util.ArrayList;
import java.util.List;

public class ListaTermoAdapter extends RecyclerView.Adapter<ListaTermoAdapter.MyViewHolder> {

    private final List<Termo> mList;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public ListaTermoAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_terms_list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Termo termo = pegaTermoPorPosicao(position);
        holder.vincula(termo);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void atualiza(List<Termo> termos) {
        this.mList.clear();
        this.mList.addAll(termos);
        atualizaLista();
    }

    public void atualizaLista() {
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvScore;
        private Termo termo;

        MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_nome);
            tvScore = itemView.findViewById(R.id.item_score);

            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(termo));
        }

        void vincula(Termo termo) {
            this.termo = termo;
            tvScore.setText(termo.getScoreAdaptado());
            tvName.setText(termo.getFull_name());
        }
    }

    private Termo pegaTermoPorPosicao(int posicao) {
        return this.mList.get(posicao);
    }

    public interface OnItemClickListener {
        void onItemClick(Termo termo);
    }
}
