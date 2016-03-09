package com.example.aluras.mockupalgum;

import android.os.Bundle;
import android.widget.ListView;

import com.example.aluras.mockupalgum.customAdapters.ResumoDespesaAdapter;
import com.example.aluras.mockupalgum.entities.ResumoDespesa;

public class PlanejamentoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamento);
        super.onCreateDrawer();


        ListView list = (ListView)findViewById(R.id.listView);

        ResumoDespesa resumo[] = new ResumoDespesa[]{
                new ResumoDespesa("Alimentação",658.32F,663.57F),
                new ResumoDespesa("Educação",2000.25F,2469.61F),
                new ResumoDespesa("Saúde",9.36F,61.50F),
                new ResumoDespesa("Transporte",650.58F,600F),
                new ResumoDespesa("Moradia",560.25F,700F),
                new ResumoDespesa("Lazer",153.25F,200F),
                new ResumoDespesa("Vestuário",102.36F,200F),
                new ResumoDespesa("Despesas Pessoais",44.39F,100F),
                new ResumoDespesa("Saúde",9.36F,50F),
        };

        ResumoDespesaAdapter adapter = new ResumoDespesaAdapter(this,R.layout.resumo_lancamento,resumo);

/*
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Alimentação");
        lista.add("Educação");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
*/
        list.setAdapter(adapter);

    }

}
