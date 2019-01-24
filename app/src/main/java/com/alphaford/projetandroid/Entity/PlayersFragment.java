package com.alphaford.projetandroid.Entity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;

import com.alphaford.projetandroid.MainActivity;
import com.alphaford.projetandroid.R;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayersFragment extends Fragment {
   RequestQueue req1;
    private List<Joueur> joueurs;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout1;
    private JoueurAdapter adapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String item;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
//  String item = getActivity().getIntent().getExtras().getString("id1");
    public PlayersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayersFragment newInstance(String param1, String param2) {
        PlayersFragment fragment = new PlayersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getString("id");
            Log.i("log_tag", item);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_players, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewjj);
        joueurs = new ArrayList<>();

        gridLayout1 = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayout1);
        adapter = new JoueurAdapter(getContext(), joueurs);
        recyclerView.setAdapter(adapter);


        sendjsonReq1();
        return  view;
    }



    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void sendjsonReq1()

    {


        final JsonArrayRequest jsonreq = new JsonArrayRequest(com.android.volley.Request.Method.GET, "http://192.168.1.2/aa.php?id_equipe= " + item, null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {

                                final JSONObject obj = response.getJSONObject(i);
                               Joueur j= new Joueur();
                                j.setNom_joueur(obj.getString("nom_joueur"));
                                j.setPhoto_joueur(obj.getString("photo_joueur"));

                                joueurs.add(j);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        req1 = Volley.newRequestQueue(getActivity().getApplicationContext());
        req1.add(jsonreq);

    }
}
