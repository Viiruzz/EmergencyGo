package com.viiruzz.emergencygo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView usuario, nombre, apellido, rut, telefono, fecha;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usuario=itemView.findViewById(R.id.idUsu);
            nombre=itemView.findViewById(R.id.idNombre);
            apellido=itemView.findViewById(R.id.idApellido);
            rut=itemView.findViewById(R.id.idRut);
            telefono=itemView.findViewById(R.id.idTel);
            fecha=itemView.findViewById(R.id.idFecha);
        }
    }

    public List<UsuarioModel> usuLista;

    public UsuarioAdaptador(List<UsuarioModel> usuLista) {
        this.usuLista = usuLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuario.setText(usuLista.get(position).getUsuario());
        holder.nombre.setText(usuLista.get(position).getNombre());
        holder.apellido.setText(usuLista.get(position).getApellido());
        holder.rut.setText(usuLista.get(position).getRut());
        holder.telefono.setText(usuLista.get(position).getTelefono());
        holder.fecha.setText(usuLista.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return usuLista.size();
    }
}
