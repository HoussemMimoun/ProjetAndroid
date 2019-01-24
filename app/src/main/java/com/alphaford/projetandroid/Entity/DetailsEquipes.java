package com.alphaford.projetandroid.Entity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Color;

import android.util.Log;
import android.view.View;

import android.widget.LinearLayout;

import android.widget.TableRow.LayoutParams;


import com.alphaford.projetandroid.PoolActivity;
import com.alphaford.projetandroid.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

public class DetailsEquipes extends AppCompatActivity {

    RequestQueue req;
    String url = "http://192.168.1.3/a.php";
    private List<Joueur> listee = new ArrayList<>();
    private ListView liste;
    private CustomListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_equipes);
      // eq1 = (TextView) findViewById(R.id.eq);
        Bundle extras = getIntent().getExtras();

        setTitle(extras.getCharSequence("equipe"));

     liste =  (ListView) findViewById(R.id.liste);
 //       adapter = new CustomListAdapter(this, listee);
        liste.setAdapter(adapter);


        JsonArrayRequest jsonreq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {

                                final JSONObject obj = response.getJSONObject(i);
                                Joueur joueur = new Joueur();
                                joueur.setNom_joueur(obj.getString("nom_joueur"));
                                 final String s1 = obj.getString("nom_joueur");
                                listee.add(joueur);



                                liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                        Intent intent = new Intent(getApplicationContext(), PoolActivity.class);
                                        intent.putExtra("Nom", s1);
                                        startActivity(intent);
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        req = Volley.newRequestQueue(DetailsEquipes.this);
        req.add(jsonreq);
    }



    }


