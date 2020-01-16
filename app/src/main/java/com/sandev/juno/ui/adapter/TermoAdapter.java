package com.sandev.juno.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sandev.juno.R;
import com.sandev.juno.data.model.Termo;

import java.util.List;

public class TermoAdapter extends RecyclerView.Adapter<TermoAdapter.MyViewHolder> {

    private final List<Termo> mList;
    private final LayoutInflater mLayoutInflate;

    public TermoAdapter(Context c, List<Termo> list) {
        mList = list;
        mLayoutInflate = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = mLayoutInflate.inflate(R.layout.item_terms_list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvScore.setText("Score: " + mList.get(position).getScore());
        holder.tvName.setText(mList.get(position).getFull_name());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivImage;
        final TextView tvName;
        final TextView tvScore;

        MyViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.item_nome);
            tvScore = itemView.findViewById(R.id.item_score);
        }
    }
}
