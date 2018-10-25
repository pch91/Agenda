package com.example.eduardosouza.agenda;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
        EditText mNome;
        EditText mEmail;
        EditText mTel;
        EditText mCidade;
      // final String = "$3PaR4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNome = (EditText) findViewById(R.id.etNome);
        mEmail = (EditText) findViewById(R.id.etEmail);
        mTel = (EditText) findViewById(R.id.etTel);
        mCidade = (EditText) findViewById(R.id.etCidade);



        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream output = openFileOutput("Agenda.txt", Context.MODE_APPEND);
                    OutputStreamWriter escreve = new OutputStreamWriter(output);

                    escreve.append(mNome.getText());
                    escreve.append(", ");

                    escreve.append(mEmail.getText());
                    escreve.append(",");

                    escreve.append(mTel.getText());
                    escreve.append(",");

                    escreve.append(mCidade.getText());
                    escreve.append(",");


                    escreve.append("\n");
                    escreve.close();
                    output.close();

                } catch (Exception e) {
                    Log.e("FileYest", "Error", e);

                }
            }
        });

        Button btnClear = (Button) findViewById(R.id.btnLimpar);
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
