package com.alphaford.projetandroid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.AsyncTask;
import android.widget.TextView;

import com.alphaford.projetandroid.Entity.Actualite;
import com.alphaford.projetandroid.Entity.ActualiteAdapter;
import com.alphaford.projetandroid.Entity.Main2Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Actualite> actualites;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private ActualiteAdapter adapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigationView;
    TextView t1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("News");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        actualites = new ArrayList<>();
        getActualitesFromDB(0);
        gridLayout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayout);

        adapter = new ActualiteAdapter(this, actualites);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (gridLayout.findLastCompletelyVisibleItemPosition() == actualites.size() - 1) {
                    getActualitesFromDB(actualites.get(actualites.size() - 1).getId());
                }

            }
        });


        mDrawerLayout=(DrawerLayout) findViewById(R.id.container);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView=(NavigationView) findViewById(R.id.navigation_view);















        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.groupes:
                        startActivity(new Intent( MainActivity.this, Main2Activity.class));

                        break;

                    case R.id.calendrier:

                        break;

                    case R.id.elimination:

                        break;

                    case R.id.profil:


                        break;
                    case R.id.stade:
                        startActivity(new Intent(MainActivity.this, PoolActivity.class));

                        break;

                }
                return false;
            }
        });


    }

    private void getActualitesFromDB(int id) {

        AsyncTask<Integer, Void, Void> asyncTask = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... actualiteIds) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                            .url("http://192.168.1.3/actualites.php?id=" + actualiteIds[0])
                        .build();
                try {
                        Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        Actualite actualite = new Actualite(object.getInt("id"), object.getString("nom"),
                                object.getString("description"), object.getString("image"));

                        MainActivity.this.actualites.add(actualite);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        asyncTask.execute(id);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
