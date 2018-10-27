package com.example.PabloSeroa.agenda.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.example.PabloSeroa.agenda.R;
import com.xwray.groupie.ViewHolder;

public class PessoaListViewHouder extends ViewHolder {

    //elementos da viel que vai dentro do recicle view
    TextView nome;
    TextView telefone;
    TextView email;
    TextView cidade;

    public PessoaListViewHouder(@NonNull View rootView) {
        super(rootView);

        nome = itemView.findViewById(R.id.textNomeView);
        telefone = itemView.findViewById(R.id.textTelView);
        email = itemView.findViewById(R.id.textEmailView);
        cidade = itemView.findViewById(R.id.textCidView);

    }

}
