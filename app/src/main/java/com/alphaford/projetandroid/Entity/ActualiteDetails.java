package com.alphaford.projetandroid.Entity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphaford.projetandroid.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class ActualiteDetails extends AppCompatActivity {
     ImageView image;
    TextView txt1, txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualite_details);
        image = (ImageView) findViewById(R.id.img11);
        txt1 = (TextView) findViewById(R.id.text2);
        txt2 = (TextView) findViewById(R.id.text3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        String img = getIntent().getExtras().getString("Image");
        String name = getIntent().getExtras().getString("Title");
        String desc = getIntent().getExtras().getString("Description");

        txt1.setText(name);
      txt2.setText(desc);
        Glide.with(this).load(img).into(image);
    //   getSupportActionBar().setTitle("Detail Actualite");
    }
}
