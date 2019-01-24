package com.alphaford.projetandroid.Entity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.alphaford.projetandroid.R;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class GroupeFFragment extends Fragment {

    RequestQueue req;
    String url = "http://192.168.1.3/e5.php";
    String result = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_groupe_a, container, false);



        sendjsonrequest();

        return  view;

    }
    public void sendjsonrequest() {
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(com.android.volley.Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    TableLayout tv = (TableLayout) getView().findViewById(R.id.table);
                    tv.removeAllViewsInLayout();





                    int flag = 1;

                    JSONArray jr = new JSONArray(response.toString());

                    for (int i = -1; i < response.length()   ; i++) {
                        TableRow tr = new TableRow(getActivity().getApplicationContext());
                        tr.setLayoutParams(new TableRow.LayoutParams(
                                TableRow.LayoutParams.FILL_PARENT,
                                TableRow.LayoutParams.WRAP_CONTENT));




                        if (flag == 1) {

                            TextView b9 = new TextView(getActivity().getApplicationContext());
                            b9.setPadding(20, 0, 0, 0);
                            b9.setTextSize(10);
                            b9.setText("Drapeau");
                            b9.setTextColor(Color.BLUE);
                            tr.addView(b9);
                            TextView b19 = new TextView(getActivity().getApplicationContext());
                            b19.setPadding(10, 0, 0, 0);
                            b19.setTextSize(15);
                            b19.setText("Team_Name");
                            b19.setTextColor(Color.BLUE);
                            tr.addView(b19);
                            TextView b29 = new TextView(getActivity().getApplicationContext());
                            b29.setPadding(10, 0, 0, 0);
                            b29.setText("Buts_marque");
                            b29.setTextColor(Color.BLUE);
                            b29.setTextSize(15);
                            tr.addView(b29);
                            TextView b39 = new TextView(getActivity().getApplicationContext());
                            b39.setPadding(10, 0, 0, 0);
                            b39.setText("But_Recu");
                            b39.setTextColor(Color.BLUE);
                            b39.setTextSize(15);
                            tr.addView(b39);
                            TextView b49 = new TextView(getActivity().getApplicationContext());
                            b49.setPadding(10, 0, 0, 0);
                            b49.setText("Win");
                            b49.setTextColor(Color.BLUE);
                            b49.setTextSize(15);
                            tr.addView(b49);
                            TextView b59 = new TextView(getActivity().getApplicationContext());
                            b59.setPadding(10, 0, 0, 0);
                            b59.setText("Null");
                            b59.setTextColor(Color.BLUE);
                            b59.setTextSize(15);
                            tr.addView(b59);
                            TextView b69 = new TextView(getActivity().getApplicationContext());
                            b69.setPadding(10, 0, 0, 0);
                            b69.setText("Lose");
                            b69.setTextColor(Color.BLUE);
                            b69.setTextSize(15);
                            tr.addView(b69);
                            TextView b79 = new TextView(getActivity().getApplicationContext());
                            b79.setPadding(10, 0, 0, 0);
                            b79.setText("Points");
                            b79.setTextColor(Color.BLUE);
                            b79.setTextSize(15);
                            tr.addView(b79);
                            tv.addView(tr);
                            final View vline = new View(getActivity().getApplicationContext());
                            vline.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 2));
                            vline.setBackgroundColor(Color.BLUE);
                            tv.addView(vline);
                            flag = 0;
                        } else {

                            JSONObject object = jr.getJSONObject(i);


                            Log.i("log_tag", "nom_equipe " + object.getString("nom_equipe") + ", but_marque: " + object.getInt("but_marque") + ", but_recu: " + object.getInt("but_recu")
                                    + ", nb_victoire: " + object.getInt("nb_victoire") + ", nb_null: " + object.getInt("nb_null")
                                    + ", nb_defaite: " + object.getInt("nb_defaite") + ", nb_point: " + object.getInt("nb_point"));
                            ImageView img = new ImageView(getActivity().getApplicationContext());
                            img.setPadding(10 , 0, 0, 0);
                            Glide.with(getActivity().getApplicationContext()).load(object.getString("drapeau_equipe"))
                                    .into(img);
                            tr.addView(img);
                            TextView b1 = new TextView(getActivity().getApplicationContext());
                            b1.setPadding(10, 0, 0, 0);
                            b1.setTextSize(15);
                            String stime1 = object.getString("nom_equipe");
                            b1.setText(stime1);
                            b1.setTextColor(Color.BLACK);
                            b1.setLinkTextColor(Color.BLACK);
                            b1.setTypeface(null, Typeface.BOLD_ITALIC);
                            tr.addView(b1);

                            TextView b2 = new TextView(getActivity().getApplicationContext());
                            b2.setPadding(10, 0, 0, 0);
                            String stime2 = object.getString("but_marque");
                            b2.setText(stime2);
                            b2.setTextColor(Color.BLACK);
                            b2.setTextSize(15);
                            tr.addView(b2);
                            TextView b3 = new TextView(getActivity().getApplicationContext());
                            b3.setPadding(10, 0, 0, 0);
                            String stime3 = object.getString("but_recu");
                            b3.setText(stime3);
                            b3.setTextColor(Color.BLACK);
                            b3.setTextSize(15);
                            tr.addView(b3);
                            TextView b4 = new TextView(getActivity().getApplicationContext());
                            b4.setPadding(10, 0, 0, 0);
                            String stime4 = object.getString("nb_victoire");
                            b4.setText(stime4);
                            b4.setTextColor(Color.BLACK);
                            b4.setTextSize(15);
                            tr.addView(b4);
                            TextView b5 = new TextView(getActivity().getApplicationContext());
                            b5.setPadding(10, 0, 0, 0);
                            String stime5 = object.getString("nb_null");
                            b5.setText(stime5);
                            b5.setTextColor(Color.BLACK);
                            b5.setTextSize(15);
                            tr.addView(b5);
                            TextView b6 = new TextView(getActivity().getApplicationContext());
                            b6.setPadding(10, 0, 0, 0);
                            String stime6 = object.getString("nb_defaite");
                            b6.setText(stime6);
                            b6.setTextColor(Color.BLACK);
                            b6.setTextSize(15);
                            tr.addView(b6);
                            TextView b7 = new TextView(getActivity().getApplicationContext());
                            b7.setPadding(10, 0, 0, 0);
                            String stime7 = object.getString("nb_point");
                            b7.setText(stime7);
                            b7.setTextColor(Color.BLACK);
                            b7.setTextSize(15);
                            tr.addView(b7);
                            tv.addView(tr);
                            final View vline1 = new View(getActivity().getApplicationContext());
                            vline1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
                            vline1.setBackgroundColor(Color.WHITE);
                            tv.addView(vline1);
                            //     flag = 1;

                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }


        });
        req = Volley.newRequestQueue(getActivity().getApplicationContext());
        req.add(jsonArrayRequest);
    }

}
