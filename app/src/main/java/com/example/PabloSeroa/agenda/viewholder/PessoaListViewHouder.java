package com.example.PabloSeroa.agenda.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.PabloSeroa.agenda.R;
import com.xwray.groupie.ViewHolder;

public class PessoaListViewHouder extends ViewHolder {

    //elementos da viel que vai dentro do recicle view
    public TextView nome;
    public TextView telefone;
    public TextView email;
    public TextView cidade;
    public LinearLayout lnt;

    public PessoaListViewHouder(@NonNull View rootView) {
        super(rootView);

        nome = itemView.findViewById(R.id.textNomeView);
        telefone = itemView.findViewById(R.id.textTelView);
        email = itemView.findViewById(R.id.textEmailView);
        cidade = itemView.findViewById(R.id.textCidView);
        lnt = itemView.findViewById(R.id.blockmain);

    }

}
