package com.jonmid.segundoparcial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.Array.Images;
import com.jonmid.segundoparcial.Model.TeamModelAlvarezKarol;
import com.jonmid.segundoparcial.R;
import com.jonmid.segundoparcial.Views.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17/10/17.
 */

public class TeamAdapterAlvarezKarol  extends RecyclerView.Adapter<TeamAdapterAlvarezKarol.ViewHolder> {


    List<TeamModelAlvarezKarol> teamModelAlvarezKarolList = new ArrayList<>();
    Context context;

    // Constructor de la clase
    public TeamAdapterAlvarezKarol(List<TeamModelAlvarezKarol> List, Context context) {
        this.teamModelAlvarezKarolList = List;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Configuracion del ViewAdapter

        // Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);

        // Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(context).load(Images.imageRandom()).into((holder.foto));

        // Encargado de trabajar con el item.xml y sus componentes


        holder.name.setText("Name: " + teamModelAlvarezKarolList.get(position).getName());
        holder.code.setText("Email: " + teamModelAlvarezKarolList.get(position).getCode());



    }

    @Override
    public int getItemCount() {
        return teamModelAlvarezKarolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, code;

        ImageView foto;

        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);
            foto = (ImageView) item.findViewById(R.id.id_img_team);
            name = (TextView) item.findViewById(R.id.id_tv_name_team);
            code = (TextView) item.findViewById(R.id.id_tv_cod_team);

        }

        @Override
        public void onClick(View view) {

            Context contextItem = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name", teamModelAlvarezKarolList.get(getLayoutPosition()).getName());
            intent.putExtra("code", teamModelAlvarezKarolList.get(getLayoutPosition()).getCode());


            contextItem.startActivity(intent);
        }
    }


}
