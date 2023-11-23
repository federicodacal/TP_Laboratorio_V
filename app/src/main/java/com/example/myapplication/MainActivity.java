package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, SearchView.OnQueryTextListener {

    public static List<Libro> libros;
    private AdapterLibro adapterLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        ThreadConnection tc = new ThreadConnection(handler, "https://gutendex.com/books/");
        tc.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.search_bar);
        SearchView sv = (SearchView) menuItem.getActionView();
        sv.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.profile) {
            Log.d("Click", "Perfil");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {

        JSONObject json;

        this.libros = new ArrayList<>();

        try {

            json = new JSONObject(message.obj.toString());

            JSONArray jsonArray = json.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                Libro nuevoLibro = new Libro();

                nuevoLibro.setTitulo(obj.getString("title"));
                nuevoLibro.setId(obj.getLong("id"));

                JSONObject formats = (obj.getJSONObject("formats"));
                nuevoLibro.setUrlImg(formats.getString("image/jpeg"));

                JSONArray authorsJson = obj.getJSONArray("authors");

                JSONObject author = authorsJson.getJSONObject(0);

                nuevoLibro.setAutor(author.getString("name"));

                Log.d("Libro", nuevoLibro.toString());

                this.libros.add(nuevoLibro);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        this.adapterLibro = new AdapterLibro(this.libros, this);
        RecyclerView rv = findViewById(R.id.rvLibro);
        rv.setAdapter(adapterLibro);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);

        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("onQueryTextSubmit", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("onQueryTextChange", newText);
        if (adapterLibro != null) {
            adapterLibro.getFilter().filter(newText);
        }
        return false;
    }
}