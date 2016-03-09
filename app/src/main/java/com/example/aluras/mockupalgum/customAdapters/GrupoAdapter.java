package com.example.aluras.mockupalgum.customAdapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aluras.mockupalgum.LancamentoValorActivity;
import com.example.aluras.mockupalgum.R;
import com.example.aluras.mockupalgum.entities.Grupo;

/**
 * Created by sn1007071 on 09/03/2016.
 */
public class GrupoAdapter extends ArrayAdapter {


    Context context;
    int layoutResourceId;
    Grupo data[] = null;

    public GrupoAdapter(Context context, int resource, Grupo[] data) {
        super(context, resource, data);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        GrupoHolder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new GrupoHolder();
            holder.txtNome = (TextView)row.findViewById(R.id.textViewTile);

            row.setTag(holder);
        }
        else
        {
            holder = (GrupoHolder)row.getTag();
        }

        Grupo grupo = data[position];
        holder.txtNome.setText(grupo.getNome());
        GradientDrawable gd = (GradientDrawable) holder.txtNome.getBackground();
        gd.setColor(context.getResources().getColor(grupo.getCor()));

        holder.txtNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancamentoValorIntent = new Intent(view.getContext(), LancamentoValorActivity.class);
                context.startActivity(lancamentoValorIntent);

            }
        });

        return row;
    }

    static class GrupoHolder {
        TextView txtNome;
    }

}
