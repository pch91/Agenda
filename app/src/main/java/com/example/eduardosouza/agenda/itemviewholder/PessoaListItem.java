package com.example.eduardosouza.agenda.itemviewholder;

import android.support.annotation.NonNull;
import android.view.View;

import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class PessoaListItem extends Item {

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {

    }

    @Override
    public int getLayout() {
        return 0;
    }

    @NonNull
    @Override
    public ViewHolder createViewHolder(@NonNull View itemView) {
        return new ViewHolder(itemView);
    }
}
