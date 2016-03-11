package com.example.aluras.mockupalgum;

import android.os.Bundle;

import com.example.aluras.mockupalgum.customViews.GraficoBarraView;

import java.util.LinkedHashMap;

public class SituacaoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situacao);
        super.onCreateDrawer();

        double valorDespesa = 4178.76;
        double valorReceita = 4236.59;

        LinkedHashMap<String,Float> valores = new LinkedHashMap<>();
        valores.put("Educação",2000.25F);
        valores.put("Alimentação",658.32F);
        valores.put("Transporte",650.58F);
        valores.put("Moradia",560.25F);
        valores.put("Lazer",153.25F);
        valores.put("Vestuário",102.36F);
        valores.put("Despesas Pessoais",44.39F);
        valores.put("Saúde",9.36F);

        GraficoBarraView graficoDespesa = (GraficoBarraView) findViewById(R.id.graficoDespesa);
        GraficoBarraView graficoReceita = (GraficoBarraView) findViewById(R.id.graficoReceita);

        graficoDespesa.setValores(valores);

        if(valorReceita > valorDespesa){
            Double d = new Double((valorDespesa/valorReceita)*100);
            graficoDespesa.setmSizePercent(d.intValue());
        }else{
            Double d = new Double((valorReceita/valorDespesa)*100);
            graficoReceita.setmSizePercent(d.intValue());
        }
    }

}
