package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thierry.anlisesensorial.dominio.Categoria;

public class CodigoProduto extends AppCompatActivity {

    private static final String PREF_NAME = "CodeProductActivityPrefences";

    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_product);
        Button btn = (Button) findViewById(R.id.ok);
        EditText ed = (EditText) findViewById(R.id.codigo1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCadaster()) {
                        Intent inte = new Intent(CodigoProduto.this, AnaliseSensorial.class);
                        startActivity(inte);
                }

            }
        });


    }

    private boolean checkCadaster() {
        EditText ed1 = (EditText) findViewById(R.id.codigo1);

        if (TextUtils.isEmpty(ed1.getText().toString())) {
            ed1.requestFocus();
            ed1.setError("Campo Obrigatório!");
            return false;
        }else{
            Categoria categoria = new Categoria();
            String[] valores = categoria.categoria(Integer.parseInt(ed1.getText().toString()));
            String posi = valores[1];
            if(posi.equals(String.valueOf(101))){
                ed1.requestFocus();
                ed1.setError("Codigo não encontrado!");
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        sp1.unregisterOnSharedPreferenceChangeListener(callback);
    }


    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp1.edit();
        int nAnalise = sp1.getInt("nAnalise_1",0)+1;
        if(nAnalise>5){
            nAnalise = 1;
        }

        EditText ed1 = (EditText) findViewById(R.id.codigo1);
        if(!ed1.getText().toString().isEmpty()) {
            editor.putInt("codigo_1", Integer.parseInt(ed1.getText().toString()));
        }
       editor.putInt("nAnalise_1",nAnalise);
        editor.commit();

    }
}
