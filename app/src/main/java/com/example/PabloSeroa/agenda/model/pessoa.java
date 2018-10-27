package com.example.PabloSeroa.agenda.model;

import org.json.JSONException;
import org.json.JSONObject;

public class pessoa {

    String Id;
    String nome;
    String telefone;
    String email;
    String cidade;

    public pessoa(){

    }

    public pessoa(String id, String nome, String telefone, String email, String cidade) {
        Id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
    }

    public pessoa(JSONObject j) throws JSONException {
        this.Id = j.getString("id");
        this.nome = j.getString("name");
        this.telefone = j.getString("telefone");
        this.email = j.getString("email");
        this.cidade = j.getString("cidade");
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String to_jeson() {

        JSONObject obj = new JSONObject();

        try {
            obj.put("id", getId());
            obj.put("name", getNome());
            obj.put("telefone", getTelefone());
            obj.put("email", getEmail());
            obj.put("cidade", getCidade());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj.toString();
    }

}
