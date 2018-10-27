package com.example.PabloSeroa.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.PabloSeroa.agenda.Dao.PessoaDao;
import com.example.PabloSeroa.agenda.model.pessoa;
import com.xwray.groupie.GroupAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
        EditText mNome;
        EditText mEmail;
        EditText mTel;
        EditText mCidade;
      // final String = "$3PaR4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.PabloSeroa.agenda.R.layout.activity_main);
        RecyclerView PessoaView = findViewById(com.example.PabloSeroa.agenda.R.id.PessoasView);

        GroupAdapter adapter = new GroupAdapter();
        PessoaView.setAdapter(adapter);


        mNome = findViewById(R.id.etNome);
        mEmail = findViewById(R.id.etEmail);
        mTel = findViewById(R.id.etTel);
        mCidade = findViewById(R.id.etCidade);







        Button btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                     PessoaDao pdao =  new PessoaDao();
                     pdao.add(new pessoa(String.valueOf(new Random().nextInt(999999)),mNome.getText().toString(),mTel.getText().toString(),mEmail.getText().toString(),mCidade.getText().toString()), getApplicationContext());

                } catch (Exception e) {
                    Log.e("FileYest", "Error", e);

                }
            }
        });

        Button btnClear = findViewById(R.id.btnLimpar);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNome.setText("");
                mEmail.setText("");
                mTel.setText("");
                mCidade.setText("");
            }
        });
    }
}