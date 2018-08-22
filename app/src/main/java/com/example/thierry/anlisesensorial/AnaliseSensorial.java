package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class AnaliseSensorial extends AppCompatActivity {
    private ArrayList<String> carac;
    private ArrayList<Integer> valores;
    private int ind;
    private int checado = -1;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private static final String PREF_NAME = "ConfigActivityPrefences";
    private static final String MY_PREF_NAME = "AnaliseActivityPrefences";

    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };
    public AnaliseSensorial(){

        carac = new ArrayList<>();
        valores = new ArrayList<>();
        ind = 1;
    }

    private boolean checado(int valor,Button but){


        if ( valor == checado) {
            deschecar();
            checado =-1;
            return true;
        }else {
            deschecar();
            checado = valor;
            but.setBackgroundDrawable(getResources().getDrawable(R.drawable.mybutton));
        }
        return false;
    }

    private void deschecar(){
        button1.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button2.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button3.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button4.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button5.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button6.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button7.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button8.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));
        button9.setBackgroundDrawable(getResources().getDrawable(R.drawable.myb));

    }

    private void createAnalise() {
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean aparencia = sp1.getBoolean("aparencia_1", false);
        boolean aroma = sp1.getBoolean("aroma_1", false);
        boolean saborresidual = sp1.getBoolean("saborresidual_1", false);
        boolean sabor = sp1.getBoolean("sabor_1", false);
        boolean doçura = sp1.getBoolean("doçura_1", false);
        boolean textura = sp1.getBoolean("textura_1", false);
        boolean odor = sp1.getBoolean("odor_1", false);
        boolean maciez = sp1.getBoolean("maciez_1", false);
        boolean cor = sp1.getBoolean("cor_1", false);
        boolean consistencia = sp1.getBoolean("consistencia_1", false);
        boolean avalGlobal = sp1.getBoolean("avalGlobal_1", false);

        if (aparencia) {
            carac.add("Aparência");
        }
        if (aroma) {
            carac.add("Aroma");
        }
        if (saborresidual) {
            carac.add("Sabor Residual");
        }
        if (sabor) {
            carac.add("Sabor");
        }
        if (doçura) {
            carac.add("Doçura");
        }
        if (textura) {
            carac.add("Textura");
        }
        if (odor) {
            carac.add("Odor");
        }
        if (maciez) {
            carac.add("Maciez");
        }
        if (cor) {
            carac.add("Cor");
        }
        if (consistencia) {
            carac.add("Consistência");
        }
        if (avalGlobal) {
            carac.add("Avaliação Global");
        }

        if (carac.size() == 0) {
            carac.add("Aparência");
            SharedPreferences.Editor editor = sp1.edit();
            editor.putBoolean("aparencia_1", true);
        }
    }

    public void putValue1(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n1);
        if (checado(0,button)){
            if ((carac.size() > ind)) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(1);
            } else {
                valores.add(1);
                changeActivity();
            }
        }
    }

    public void putValue2(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n2);
        if (checado(1,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(2);
            } else {
                valores.add(2);
                changeActivity();
            }
        }
    }

    public void putValue3(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n3);
        if (checado(2,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(3);
            } else {
                valores.add(3);
                changeActivity();
            }
        }
    }
    public void putValue4(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n4);
        if (checado(3,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(4);
            } else {
                valores.add(4);
                changeActivity();
            }
        }
    }
    public void putValue5(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n5);
        if (checado(4,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(5);
            } else {
                valores.add(5);
                changeActivity();
            }
        }
    }

    public void putValue6(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n6);
        if (checado(5,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(6);
            } else {
                valores.add(6);
                changeActivity();
            }
        }
    }
    public void putValue7(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n7);
        if (checado(6,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(7);
            } else {
                valores.add(7);
                changeActivity();
            }
        }
    }

    public void putValue8(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n8);
        if (checado(7,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(8);
            } else {
                valores.add(8);
                changeActivity();
            }
        }
    }

    public void putValue9(View v){
        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        button = (Button) findViewById(R.id.n9);
        if (checado(8,button)) {
            if (carac.size() > ind) {
                ed.setText(carac.get(ind));
                ind++;
                valores.add(9);
            } else {
                valores.add(9);
                changeActivity();
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise_sensorial);

        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        createAnalise();

        final TextView ed=(TextView)findViewById(R.id.caracteristica);
        ed.setText(carac.get(0));

        button1 = (Button) findViewById(R.id.n1);
        button2 = (Button) findViewById(R.id.n2);
        button3 = (Button) findViewById(R.id.n3);
        button4 = (Button) findViewById(R.id.n4);
        button5 = (Button) findViewById(R.id.n5);
        button6 = (Button) findViewById(R.id.n6);
        button7 = (Button) findViewById(R.id.n7);
        button8 = (Button) findViewById(R.id.n8);
        button9 = (Button) findViewById(R.id.n9);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sp2 = getSharedPreferences(MY_PREF_NAME,MODE_PRIVATE);
        sp2.unregisterOnSharedPreferenceChangeListener(callback);
    }
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences sp2 = getSharedPreferences(MY_PREF_NAME,MODE_PRIVATE);

        SharedPreferences.Editor editor = sp2.edit();

        boolean aparencia  = sp1.getBoolean("aparencia_1",false);
        boolean aroma = sp1.getBoolean("aroma_1",false);
        boolean saborresidual = sp1.getBoolean("saborresidual_1",false);
        boolean sabor = sp1.getBoolean("sabor_1",false);
        boolean doçura = sp1.getBoolean("doçura_1",false);
        boolean textura = sp1.getBoolean("textura_1",false);
        boolean odor = sp1.getBoolean("odor_1",false);
        boolean maciez = sp1.getBoolean("maciez_1",false);
        boolean cor = sp1.getBoolean("cor_1",false);
        boolean consistencia = sp1.getBoolean("consistencia_1",false);
        boolean avalGlobal = sp1.getBoolean("avalGlobal_1",false);


        int ind = 0;


            if (aparencia) {
                editor.putInt("analise_aparencia_1", valores.get(ind++));
            } else {
                editor.putInt("analise_aparencia_1", 0);
            }
            if (aroma) {
                editor.putInt("analise_aroma_1", valores.get(ind++));
            } else {
                editor.putInt("analise_aroma_1", 0);
            }
            if (saborresidual) {
                editor.putInt("analise_saborresidual_1", valores.get(ind++));
            } else {
                editor.putInt("analise_saborresidual_1", 0);
            }
            if (sabor) {
                editor.putInt("analise_sabor_1", valores.get(ind++));
            } else {
                editor.putInt("analise_sabor_1", 0);
            }
            if (doçura) {
                editor.putInt("analise_doçura_1", valores.get(ind++));
            } else {
                editor.putInt("analise_doçura_1", 0);
            }
            if (textura) {
                editor.putInt("analise_textura_1", valores.get(ind++));
            } else {
                editor.putInt("analise_textura_1", 0);
            }
            if (odor) {
                editor.putInt("analise_odor_1", valores.get(ind++));
            } else {
                editor.putInt("analise_odor_1", 0);
            }
            if (maciez) {
                editor.putInt("analise_maciez_1", valores.get(ind++));
            } else {
                editor.putInt("analise_maciez_1", 0);
            }
            if (cor) {
                editor.putInt("analise_cor_1", valores.get(ind++));
            } else {
                editor.putInt("analise_cor_1", 0);
            }
            if (consistencia) {
                editor.putInt("analise_consistencia_1", valores.get(ind++));
            } else {
                editor.putInt("analise_consistencia_1", 0);
            }
            if (avalGlobal) {
                editor.putInt("analise_avalGlobal_1", valores.get(ind));
            } else {
                editor.putInt("analise_avalGlobal_1", 0);


        }

        editor.commit();



    }
    public void changeActivity(){
        Intent inten = new Intent(AnaliseSensorial.this,IntencaoCompra.class);
        startActivity(inten);
    }

}

