package com.alphaford.projetandroid.Entity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alphaford.projetandroid.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by AndroidBash on 09/05/2016.
 */
public class ActualiteAdapter extends RecyclerView.Adapter<ActualiteAdapter.ViewHolder> {

    private Context context;
    private List<Actualite> actualites;

    public ActualiteAdapter(Context context, List<Actualite> actualites) {
        this.context = context;
        this.actualites = actualites;
    }

    public ActualiteAdapter(Context context) {
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.actualiteName.setText(actualites.get(position).getNom());
      //  holder.actualiteDescription.setText(actualites.get(position).getDescription());
        Glide.with(context).load(actualites.get(position).getImage()).into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        return actualites.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView actualiteName;
        public TextView actualiteDescription;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            actualiteName = (TextView) itemView.findViewById(R.id.actualitename);
            imageView = (ImageView) itemView.findViewById(R.id.image);
          //  actualiteDescription = (TextView) itemView.findViewById(R.id.actualitedesc);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Actualite clicked = actualites.get(position);
                Intent intent = new Intent(getContext(), ActualiteDetails.class);
                intent.putExtra("Image", actualites.get(position).getImage());
                intent.putExtra("Title", actualites.get(position).getNom());
                intent.putExtra("Description", actualites.get(position).getDescription());
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