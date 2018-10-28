package com.example.PabloSeroa.agenda.itemviewholder;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.PabloSeroa.agenda.R;
import com.example.PabloSeroa.agenda.interfaces.MyClickListener;
import com.example.PabloSeroa.agenda.model.pessoa;
import com.example.PabloSeroa.agenda.viewholder.PessoaListViewHouder;
import com.xwray.groupie.Item;

public class PessoaListItem extends Item<PessoaListViewHouder> {

    private MyClickListener listener;
    pessoa pessoa;

    public PessoaListItem(MyClickListener listener, pessoa p) {
        this.listener = listener;
        this.pessoa = p;
    }

    @Override
    public void bind(@NonNull PessoaListViewHouder viewHolder, final int position) {
        viewHolder.nome.setText(pessoa.getNome());
        viewHolder.telefone.setText(pessoa.getTelefone());
        viewHolder.email.setText(pessoa.getEmail());
        viewHolder.cidade.setText(pessoa.getCidade());
        viewHolder.lnt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                listener.onClick(pessoa.getId());
              }
          }
        );
    }

    @Override
    public int getLayout() {
        return R.layout.pessoa_information_list;
    }

    @NonNull
    @Override
    public PessoaListViewHouder createViewHolder(@NonNull View itemView) {
        return new PessoaListViewHouder(itemView);
    }
}
