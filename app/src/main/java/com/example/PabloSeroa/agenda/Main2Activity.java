package com.example.PabloSeroa.agenda;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.PabloSeroa.agenda.Dao.PessoaDao;
import com.example.PabloSeroa.agenda.model.pessoa;

import org.json.JSONException;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    pessoa p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_pessoa);
        p = (pessoa)getIntent().getSerializableExtra("pessoa");

        ((TextView)findViewById(R.id.etNome)).setText(p.getCidade());
        ((TextView)findViewById(R.id.etEmail)).setText(p.getEmail());
        ((TextView)findViewById(R.id.etTel)).setText(p.getTelefone());
        ((TextView)findViewById(R.id.etCidade)).setText(p.getNome());


        findViewById(R.id.btnRemover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PessoaDao pdao = new PessoaDao();
                try {
                    pdao.removePessoa(p.getId(), getBaseContext());
                    Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                    intent.putExtra("resp", "Pessoa removida com sucesso.");
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_lef);

                } catch (IOException e) {
                    Snackbar snk = Snackbar.make(findViewById(R.id.add_pessoa_const),"ocorreu um erro ao executar a operação", Snackbar.LENGTH_LONG);

                    snk.show();
                    e.printStackTrace();
                } catch (JSONException e) {
                    Snackbar snk = Snackbar.make(findViewById(R.id.add_pessoa_const),"ocorreu um erro ao executar a operação", Snackbar.LENGTH_LONG);

                    snk.show();
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_lef);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_lef);
    }
}
