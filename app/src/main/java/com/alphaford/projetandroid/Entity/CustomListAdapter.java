package com.alphaford.projetandroid.Entity;

import android.app.Activity;
import android.content.Context;
import android.icu.text.MessagePattern;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphaford.projetandroid.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by user on 12/12/2017.
 */

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Partie> DataList;


    public CustomListAdapter(Activity activity, List<Partie> dataitem) {
        this.activity = activity;
        this.DataList = dataitem;
    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int location) {
        return DataList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);


      TextView stade = (TextView) convertView.findViewById(R.id.stade);
        TextView home = (TextView) convertView.findViewById(R.id.home_name) ;
        TextView away = (TextView) convertView.findViewById(R.id.away_name) ;
        ImageView img = (ImageView) convertView.findViewById(R.id.home_crest);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        ImageView img1 = (ImageView) convertView.findViewById(R.id.away_crest);
        TextView heure = (TextView) convertView.findViewById(R.id.heure);


        Partie p  = DataList.get(position);

       stade.setText(p.getStade());
        home.setText(p.getEquipe1());
        away.setText(p.getEquipe2());
        heure.setText(p.getHeure_match());
        Glide.with(activity).load(DataList.get(position).getDrapeau_equipe1()).into(img);
        Glide.with(activity).load(DataList.get(position).getDrapeau_equipe2()).into(img1);
        date.setText(p.getDate_match().toString());


        return convertView;
    }
}
