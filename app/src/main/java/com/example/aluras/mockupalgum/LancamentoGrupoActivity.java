package com.example.aluras.mockupalgum;

import android.os.Bundle;
import android.widget.GridView;

import com.example.aluras.mockupalgum.customAdapters.GrupoAdapter;
import com.example.aluras.mockupalgum.entities.Grupo;

public class LancamentoGrupoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_grupo);
        super.onCreateDrawer();

        GridView gridGrupos = (GridView) findViewById(R.id.gridViewGrupos);
        Grupo grupos[] = new Grupo[]{
                new Grupo("Alimentação",R.color.tile1),
                new Grupo("Educação",R.color.tile2),
                new Grupo("Saúde",R.color.tile3),
                new Grupo("Transporte",R.color.tile1),
                new Grupo("Moradia",R.color.tile2),
                new Grupo("Lazer",R.color.tile3),
                new Grupo("Dívidas",R.color.tile1),
                new Grupo("Despesas Pessoais",R.color.tile2),
                new Grupo("Despesas Financeiras",R.color.tile3),
                new Grupo("Vestuário",R.color.tile1),
                new Grupo("Outras",R.color.tile2)
        };

        GrupoAdapter gruposAdapter = new GrupoAdapter(this,R.layout.tiles, grupos);

        gridGrupos.setAdapter(gruposAdapter);

    }
}
