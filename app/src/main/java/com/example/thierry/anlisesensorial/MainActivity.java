package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String PREF_NAME = "CodeProductActivityPrefences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp1.edit();
        editor.putInt("nAnalise_1",0);
        editor.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();
        if(id==R.id.mnuSettings) {
            Intent settings = new Intent(MainActivity.this, Configuracao.class);
            startActivity(settings);
        }
        return super.onOptionsItemSelected(item);
    }

    public void goCadaster(View v){
        Intent inte = new Intent(MainActivity.this,Cadastro.class);
        startActivity(inte);
    }



}
