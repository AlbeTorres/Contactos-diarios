package com.example.eureka.contactosdiarios;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eureka.contactosdiarios.Pojo.Contacto;

import java.util.List;

/**
 * Created by Eureka on 20/1/2021.
 */

public class ContactoAdapter extends RecyclerView.Adapter <ContactoAdapter.ViewHolder>  {

    Context contexto;
    List<Contacto> contactoList;

    public ContactoAdapter (Context contexto,List<Contacto> contactoList ){
        this.contexto = contexto;
        this.contactoList = contactoList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(contactoList.get(position).getNombre());
        holder.telefono.setText(contactoList.get(position).getTelefono());

    }

    @Override
    public int getItemCount() {
        return contactoList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView nombre,telefono;

    public ViewHolder(View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.nombre);
        telefono = (TextView) itemView.findViewById(R.id.telefono);
    }
}
}
