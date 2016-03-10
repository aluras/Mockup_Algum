package com.example.aluras.mockupalgum;

import android.os.Bundle;

import com.example.aluras.mockupalgum.customViews.GraficoBarraView;

public class SituacaoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situacao);
        super.onCreateDrawer();

        double valorDespesa = 2178.76;
        double valorReceita = 4236.59;

        GraficoBarraView graficoDespesa = (GraficoBarraView) findViewById(R.id.graficoDespesa);
        GraficoBarraView graficoReceita = (GraficoBarraView) findViewById(R.id.graficoReceita);

        if(valorReceita > valorDespesa){
            Double d = new Double((valorDespesa/valorReceita)*100);
            graficoDespesa.setmSizePercent(d.intValue());
        }else{
            Double d = new Double((valorReceita/valorDespesa)*100);
            graficoReceita.setmSizePercent(d.intValue());
        }
    }

}
