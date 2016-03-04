package com.example.aluras.mockupalgum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class EditConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        ArrayList<String> tipoGrupo = new ArrayList<String>();
        tipoGrupo.add("Conta corrente");
        tipoGrupo.add("Cartão de crédito");
        tipoGrupo.add("Espécie");
        tipoGrupo.add("Investimento");
        tipoGrupo.add("Outras");

        ArrayAdapter<String> tipoGrupoAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tipoGrupo);
        spinner.setAdapter(tipoGrupoAdapter);
    }

}
