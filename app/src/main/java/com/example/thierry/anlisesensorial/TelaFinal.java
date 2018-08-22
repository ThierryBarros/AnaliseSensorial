package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TelaFinal extends AppCompatActivity {

    private boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);
        Button btn = (Button) findViewById(R.id.realizar);
        check = false;
    }

    public void backCode(View v){
        Intent inten = new Intent(TelaFinal.this,CodigoProduto.class);
        startActivity(inten);
    }

    public void backBegin(View v){
        if(check){
            Intent inten = new Intent(TelaFinal.this,MainActivity.class);
            startActivity(inten);
        }else {
            String texto = "Tem certeza que deseja sair?";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), texto, duracao);
            toast.show();
            check = true;
        }
    }
}
