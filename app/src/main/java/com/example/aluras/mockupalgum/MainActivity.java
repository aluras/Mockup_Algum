package com.example.aluras.mockupalgum;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.widget.GridView;

import com.example.aluras.mockupalgum.customAdapters.ContaAdapter;
import com.example.aluras.mockupalgum.entities.Conta;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer();

        GridView gridContas = (GridView) findViewById(R.id.gridViewContas);
        Conta contas[] = new Conta[]{
                new Conta("CC Banco do Brasil",R.color.tile1),
                new Conta("Cartão CEF",R.color.tile2),
                new Conta("Carteira",R.color.tile3),
                new Conta("Vale Refeição",R.color.tile1)
        };

        ContaAdapter contasAdapter = new ContaAdapter(this,R.layout.tiles, contas);

        gridContas.setAdapter(contasAdapter);


        //Define cores para os botões de tipo de lançamento
        GradientDrawable gdDespesa = (GradientDrawable) findViewById(R.id.textDespesa).getBackground();
        gdDespesa.setColor(getResources().getColor(R.color.despesa));
        GradientDrawable gdReceita = (GradientDrawable) findViewById(R.id.textReceita).getBackground();
        gdReceita.setColor(getResources().getColor(R.color.receitaDisable));
        GradientDrawable gdTransferencia = (GradientDrawable) findViewById(R.id.textTransferencia).getBackground();
        gdTransferencia.setColor(getResources().getColor(R.color.transferenciaDisable));


    }


}
