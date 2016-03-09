package com.example.aluras.mockupalgum;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.View;
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


        //TODO-Mock das contas - Tirar
        GradientDrawable gdConta1 = (GradientDrawable) findViewById(R.id.textView3).getBackground();
        gdConta1.setColor(getResources().getColor(R.color.tile1));
        GradientDrawable gdConta2 = (GradientDrawable) findViewById(R.id.textView4).getBackground();
        gdConta2.setColor(getResources().getColor(R.color.tile2));
        GradientDrawable gdConta3 = (GradientDrawable) findViewById(R.id.textView5).getBackground();
        gdConta3.setColor(getResources().getColor(R.color.tile3));
        GradientDrawable gdConta4 = (GradientDrawable) findViewById(R.id.textView6).getBackground();
        gdConta4.setColor(getResources().getColor(R.color.tile1));

        //TODO-Mock das grupos - Tirar
        GradientDrawable gdConta40 = (GradientDrawable) findViewById(R.id.textView40).getBackground();
        gdConta40.setColor(getResources().getColor(R.color.tile1));
        GradientDrawable gdConta41 = (GradientDrawable) findViewById(R.id.textView41).getBackground();
        gdConta41.setColor(getResources().getColor(R.color.tile2));
        GradientDrawable gdConta42 = (GradientDrawable) findViewById(R.id.textView42).getBackground();
        gdConta42.setColor(getResources().getColor(R.color.tile3));
        GradientDrawable gdConta43 = (GradientDrawable) findViewById(R.id.textView43).getBackground();
        gdConta43.setColor(getResources().getColor(R.color.tile1));
        GradientDrawable gdConta44 = (GradientDrawable) findViewById(R.id.textView44).getBackground();
        gdConta44.setColor(getResources().getColor(R.color.tile2));
        GradientDrawable gdConta45 = (GradientDrawable) findViewById(R.id.textView45).getBackground();
        gdConta45.setColor(getResources().getColor(R.color.tile3));
        GradientDrawable gdConta46 = (GradientDrawable) findViewById(R.id.textView46).getBackground();
        gdConta46.setColor(getResources().getColor(R.color.tile1));
        GradientDrawable gdConta47 = (GradientDrawable) findViewById(R.id.textView47).getBackground();
        gdConta47.setColor(getResources().getColor(R.color.tile2));
        GradientDrawable gdConta48 = (GradientDrawable) findViewById(R.id.textView48).getBackground();
        gdConta48.setColor(getResources().getColor(R.color.tile3));
        GradientDrawable gdConta49 = (GradientDrawable) findViewById(R.id.textView49).getBackground();
        gdConta49.setColor(getResources().getColor(R.color.tile1));
        GradientDrawable gdConta50 = (GradientDrawable) findViewById(R.id.textView50).getBackground();
        gdConta50.setColor(getResources().getColor(R.color.tile2));

        View btnCaixa = (View) findViewById(R.id.textView4);
        btnCaixa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent lancamentoGruposIntent = new Intent(view.getContext(), LancamentoGrupos.class);
                //startActivity(lancamentoGruposIntent);

                View botoesContas = (View) findViewById(R.id.botoesContas);
                botoesContas.setVisibility(View.INVISIBLE);

                View botoesGrupos = (View) findViewById(R.id.botoesGrupos);
                botoesGrupos.setVisibility(View.VISIBLE);


            }
        });

        View btnAlimentacao = (View) findViewById(R.id.textView40);
        btnAlimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent lancamentoGruposIntent = new Intent(view.getContext(), LancamentoGrupos.class);
                //startActivity(lancamentoGruposIntent);

                View botoesGrupos = (View) findViewById(R.id.botoesGrupos);
                botoesGrupos.setVisibility(View.INVISIBLE);


            }
        });

    }


}
