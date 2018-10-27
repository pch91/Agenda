package com.example.PabloSeroa.agenda.itemviewholder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.PabloSeroa.agenda.viewholder.PessoaListViewHouder;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;
import com.xwray.groupie.OnItemLongClickListener;
import com.xwray.groupie.ViewHolder;

import java.util.List;

public class PessoaListItem extends Item<PessoaListViewHouder> {

    @Override
    public void bind(@NonNull PessoaListViewHouder viewHolder, int position) {

    }

    @Override
    public int getLayout() {
        return 0;
    }

    @NonNull
    @Override
    public PessoaListViewHouder createViewHolder(@NonNull View itemView) {
        return super.createViewHolder(itemView);
    }
}
