package com.example.PabloSeroa.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.PabloSeroa.agenda.Dao.PessoaDao;
import com.example.PabloSeroa.agenda.interfaces.MyClickListener;
import com.example.PabloSeroa.agenda.itemviewholder.PessoaListItem;
import com.example.PabloSeroa.agenda.model.pessoa;
import com.example.PabloSeroa.agenda.viewholder.PessoaListViewHouder;
import com.xwray.groupie.GroupAdapter;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
        EditText mNome;
        EditText mEmail;
        EditText mTel;
        EditText mCidade;
      // final String = "$3PaR4";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_top_title, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ListPerson:
                findViewById(R.id.add_pessoa_const).setVisibility(View.INVISIBLE);
                findViewById(R.id.PessoasView).setVisibility(View.VISIBLE);
                return true;

            case R.id.add_pessoa:
                findViewById(R.id.add_pessoa_const).setVisibility(View.VISIBLE);
                findViewById(R.id.PessoasView).setVisibility(View.INVISIBLE);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void populateViewListPessoa(List<pessoa> lp, GroupAdapter ga, MyClickListener listener){
        for (pessoa p: lp) {
            ga.add(new PessoaListItem(listener,p));
            ga.add(new PessoaListItem(listener,p));
            ga.add(new PessoaListItem(listener,p));
            ga.add(new PessoaListItem(listener,p));
            ga.add(new PessoaListItem(listener,p));
            ga.add(new PessoaListItem(listener,p));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.PabloSeroa.agenda.R.layout.activity_main);


        RecyclerView PessoaView = findViewById(R.id.PessoasView);
        PessoaView.setLayoutManager(new GridLayoutManager(this, 1));

        final GroupAdapter<PessoaListViewHouder> adapter = new GroupAdapter();
        PessoaView.setAdapter(adapter);

        mNome = findViewById(R.id.etNome);
        mEmail = findViewById(R.id.etEmail);
        mTel = findViewById(R.id.etTel);
        mCidade = findViewById(R.id.etCidade);

        final MyClickListener listener = new MyClickListener() {
            @Override
            public void onClick(String position) {
                Toast.makeText(
                        MainActivity.this,
                        "Clicado position: " + position,
                        Toast.LENGTH_LONG
                ).show();
            }
        };

        PessoaDao pdao =  new PessoaDao();
        List<pessoa> lp;
        try {
            lp = pdao.listaAll(getApplicationContext());
            populateViewListPessoa(lp,adapter,listener);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
