package com.alphaford.projetandroid;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alphaford.projetandroid.Entity.DetailsEquipes;
import com.alphaford.projetandroid.Entity.EquipeActivity;
import com.alphaford.projetandroid.Entity.Main2Activity;
import com.alphaford.projetandroid.Entity.PlayersFragment;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class PoolActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, PlayersFragment.OnFragmentInteractionListener {
     ImageView img;
     TextView continent;
    TextView name;
    TextView winner;
    TextView fifa;
    TextView coach;
    Context context;


    Dialog myDialog;
    Dialog myDialogue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stade_list_row);
        myDialog = new Dialog(this);

        final ImageView players = (ImageView) findViewById(R.id.player);
        Bundle bundle = getIntent().getExtras();

     players.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             PlayersFragment fragment = new PlayersFragment();

            getSupportFragmentManager().beginTransaction().
             replace(R.id.cc, fragment).commit();



         }
     });

    }

    public void ShowPopupe(View v1){
        TextView txtclose;
        Button btnFollow;
        Bundle extras = getIntent().getExtras();
        myDialog.setContentView(R.layout.popupformation);


    //   img = (ImageView) myDialog.findViewById(R.id.imageTeam);


        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();;
    }
    public void ShowPopup(View v) {
        TextView txtclose;
        Button btnFollow;
        Bundle extras = getIntent().getExtras();
     myDialog.setContentView(R.layout.custompopup);
        name = (TextView) myDialog.findViewById(R.id.pays);
        name.setText(extras.getCharSequence("equipe"));
        continent = (TextView) myDialog.findViewById(R.id.team_continent);
        continent.setText(extras.getCharSequence("continent"));
        winner = (TextView) myDialog.findViewById(R.id.winner);
        winner.setText(extras.getCharSequence("winner"));
        coach = (TextView) myDialog.findViewById(R.id.coach);
        coach.setText(extras.getCharSequence("coach"));
        fifa = (TextView) myDialog.findViewById(R.id.fifa);
        fifa.setText(extras.getCharSequence("fifa"));
        img = (ImageView) myDialog.findViewById(R.id.imageTeam);
        Glide.with(this).load(extras.getCharSequence("drapeau")).into(img);

        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
