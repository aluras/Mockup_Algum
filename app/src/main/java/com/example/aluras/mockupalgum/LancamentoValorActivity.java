package com.example.aluras.mockupalgum;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LancamentoValorActivity extends BaseActivity implements View.OnClickListener {

    static final int DATE_DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_valor);
        super.onCreateDrawer();

        TextView txtData = (TextView) findViewById(R.id.txtData);
        TextView txtValor = (TextView) findViewById(R.id.txtValor);
        TextView txtDetalhe = (TextView) findViewById(R.id.txtDetalhe);
        final Button button = (Button) findViewById(R.id.button);

        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        txtData.setText(format.format(data));
        txtData.setOnClickListener(this);

        if(txtValor.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gravar();
            }
        });

        txtValor.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    gravar();
                }
                return false;
            }
        });

     }

    protected void gravar(){
        TextView valor = (TextView) findViewById(R.id.txtValor);
        if (valor.getText().toString().trim().equals("")){
            valor.setError("Digite o valor!");
        }else{
            Toast.makeText(this,"Lançamento registrado.",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendario = Calendar.getInstance();

        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, ano, mes, dia);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                Calendar cal = Calendar.getInstance();
                cal.set(year,monthOfYear,dayOfMonth);
                Date data = cal.getTime();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                TextView txtData = (TextView) findViewById(R.id.txtData);
                txtData.setText(format.format(data));
            }
        };

    @Override
    public void onClick(View v) {
        if (v == (TextView) findViewById(R.id.txtData)){
            showDialog(DATE_DIALOG_ID);
        }
    }
}
