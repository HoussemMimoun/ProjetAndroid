package com.alphaford.projetandroid.Entity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphaford.projetandroid.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by user on 22/12/2017.
 */

public class PartieAdapter extends RecyclerView.Adapter<PartieAdapter.ViewHolder> {
    private Context context;
    private List<Partie> parties;

    public PartieAdapter(Context context, List<Partie> parties)
    {
        this.context = context;
        this.parties = parties;
    }

    public PartieAdapter(Context context){
        this.context = context;
    }

    @Override
    public PartieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PartieAdapter.ViewHolder holder, int position) {
        holder.home.setText(parties.get(position).getEquipe1());
        holder.away.setText(parties.get(position).getEquipe2());
        holder.date.setText(parties.get(position).getDate_match().toString());
        holder.heure.setText(parties.get(position).getHeure_match());
        holder.stade.setText(parties.get(position).getStade());
      Glide.with(context).load(parties.get(position).getDrapeau_equipe1()).into(holder.imageView1);
        Glide.with(context).load(parties.get(position).getDrapeau_equipe2()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return parties.size();
    }



    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView home;
        public TextView away;
        public TextView date;
        public TextView heure;
        public TextView stade;
        public ImageView imageView;
        public ImageView imageView1;

        public ViewHolder(View itemView) {
            super(itemView);
            home = (TextView) itemView.findViewById(R.id.home_name);
            away = (TextView) itemView.findViewById(R.id.away_name);
            date = (TextView) itemView.findViewById(R.id.date);
            stade = (TextView) itemView.findViewById(R.id.stade);
            heure = (TextView) itemView.findViewById(R.id.heure);
            imageView = (ImageView) itemView.findViewById(R.id.away_crest);
            imageView1 = (ImageView) itemView.findViewById(R.id.home_crest);


        }


    }
}
