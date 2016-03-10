package com.example.aluras.mockupalgum;

import android.os.Bundle;
import android.widget.ListView;

import com.example.aluras.mockupalgum.customAdapters.ExtratoAdapter;
import com.example.aluras.mockupalgum.entities.Lancamento;

import java.util.ArrayList;
import java.util.Calendar;

public class ExtratoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);
        super.onCreateDrawer();

        ListView list = (ListView)findViewById(R.id.listExtrato);

        Calendar cal = Calendar.getInstance();

        ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();

        lancamentos.add(new Lancamento(cal.getTime(),"Transporte",-145F));
        lancamentos.add(new Lancamento(cal.getTime(),"Alimentação",-90F));
        lancamentos.add(new Lancamento(cal.getTime(),"Salário",3569.25F));

        cal.add(Calendar.DATE,-1);
        lancamentos.add(new Lancamento(cal.getTime(),"Alimentação",-14.25F));
        lancamentos.add(new Lancamento(cal.getTime(),"Moradia",-145.26F));
        lancamentos.add(new Lancamento(cal.getTime(),"Vestuário",-223.65F));
        lancamentos.add(new Lancamento(cal.getTime(),"Saúde",-9.23F));

        cal.add(Calendar.DATE,-1);
        lancamentos.add(new Lancamento(cal.getTime(),"Alimentação",-12.50F));
        lancamentos.add(new Lancamento(cal.getTime(),"Lazer",-61F));
        lancamentos.add(new Lancamento(cal.getTime(),"Lazer",-29.99F));
        lancamentos.add(new Lancamento(cal.getTime(),"Educação",-1020.65F));

        Lancamento[] l = new Lancamento[lancamentos.size()];
        l = lancamentos.toArray(l);

        ExtratoAdapter adapter = new ExtratoAdapter(this, R.layout.item_extrato,l);

        list.setAdapter(adapter);

    }

}
