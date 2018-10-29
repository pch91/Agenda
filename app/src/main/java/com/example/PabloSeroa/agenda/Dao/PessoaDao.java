package com.example.PabloSeroa.agenda.Dao;

import android.content.Context;
import com.example.PabloSeroa.agenda.model.pessoa;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class PessoaDao {



    public void add(pessoa p,Context c) throws IOException {
        FileOutputStream output = c.openFileOutput("Agenda.txt", Context.MODE_APPEND);
        OutputStreamWriter escreve = new OutputStreamWriter(output);

        escreve.append(p.to_jeson());

        escreve.append("\n");
        escreve.close();
        output.close();
    }

    public List<pessoa> listaAll(Context c) throws IOException, JSONException {
        List<pessoa> lp = new ArrayList<pessoa>();
        InputStream inputStream = c.openFileInput("Agenda.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String recebe_string;


        while((recebe_string = bufferedReader.readLine())!=null){
            lp.add(new pessoa(new JSONObject(recebe_string)));
        }

        inputStreamReader.close();
        bufferedReader.close();
        return lp;
    }

    public pessoa getPessoa(String pessoaid, Context c) throws IOException, JSONException {
        pessoa p = new pessoa();
        InputStream inputStream = c.openFileInput("Agenda.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String recebe_string;


        while((recebe_string = bufferedReader.readLine())!=null){
            p = new pessoa(new JSONObject(recebe_string));

            if(p.getId().equals(pessoaid)){
                break;
            }
        }
        inputStreamReader.close();
        bufferedReader.close();
        return p;
    }
    public void removePessoa(String pessoaid, Context c) throws IOException, JSONException {
        List<pessoa> s = new ArrayList<>();
        pessoa p = new pessoa();
        InputStream inputStream = c.openFileInput("Agenda.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String recebe_string;


        while((recebe_string = bufferedReader.readLine())!=null){
            p = new pessoa(new JSONObject(recebe_string));

            if(!(p.getId().equals(pessoaid))){
                s.add(p);
            }
        }

        bufferedReader.close();
        inputStreamReader.close();
        FileOutputStream output = c.openFileOutput("Agenda.txt", Context.MODE_PRIVATE);
        OutputStreamWriter escreve = new OutputStreamWriter(output);

        for (pessoa up: s) {
            escreve.append(up.to_jeson());
            escreve.append("\n");
        }
        escreve.flush();
        escreve.close();
        output.close();
    }

}
