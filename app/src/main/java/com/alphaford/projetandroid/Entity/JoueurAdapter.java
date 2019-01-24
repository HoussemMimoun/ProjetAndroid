package com.alphaford.projetandroid.Entity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphaford.projetandroid.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by user on 26/12/2017.
 */

public class JoueurAdapter extends RecyclerView.Adapter<JoueurAdapter.ViewHolder> {
    private Context context;
    private List<Joueur> joueurs;

    public JoueurAdapter (Context context, List<Joueur> joueurs) {
        this.context = context;
        this.joueurs = joueurs;
    }

    public JoueurAdapter(Context context) {
        this.context = context;

    }

    @Override
    public JoueurAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.joueur_list,parent,false);

        return new JoueurAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final JoueurAdapter.ViewHolder holder, int position) {

        holder.name.setText(joueurs.get(position).getNom_joueur());
        //  holder.actualiteDescription.setText(actualites.get(position).getDescription());
        Glide.with(context).load(joueurs.get(position).getPhoto_joueur()).into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return joueurs.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public TextView actualiteDescription;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
           name = (TextView) itemView.findViewById(R.id.joueurnom);
            imageView = (ImageView) itemView.findViewById(R.id.imagejj);
            //  actualiteDescription = (TextView) itemView.findViewById(R.id.actualitedesc);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Joueur clicked = joueurs.get(position);
                Intent intent = new Intent(getContext(), ActualiteDetails.class);
                intent.putExtra("Image", joueurs.get(position).getPhoto_joueur());
                intent.putExtra("Title", joueurs.get(position).getNom_joueur());
                intent.putExtra("Description", joueurs.get(position).getAge());
                getContext().startActivity(intent);
            }
            //      showPopupMenu(v,position);
        }
    }

  /*  private void showPopupMenu(View view, int poaition) {
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_context, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuClickListener(poaition));
        popup.show();
    }*/


 /*   class MenuClickListener implements PopupMenu.OnMenuItemClickListener {
        Integer pos;
        public MenuClickListener(int pos) {
            this.pos=pos;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_favourite:
                    Toast.makeText(context, actualites.get(pos).getNom()+" is added to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_watch:
                    Toast.makeText(context, actualites.get(pos).getNom()+" is added to watchlist", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_book:
                    Toast.makeText(context, "Booked Ticket for "+actualites.get(pos).getNom(), Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }*/

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
