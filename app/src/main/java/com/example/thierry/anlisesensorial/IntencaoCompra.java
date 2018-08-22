package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntencaoCompra extends AppCompatActivity {

    private int checado = -1;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private static final String MY_PREF_NAME = "IntencaoActivityPrefences";
    private int intencao = 0;
    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intencao_compra);
        SharedPreferences sp1 = getSharedPreferences(MY_PREF_NAME,MODE_PRIVATE);


        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
    }

    public void changeActivity(){
        Intent inten = new Intent(IntencaoCompra.this,Comentario.class);
        startActivity(inten);
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

    }

    public void putValue1(View v){
        button = (Button) findViewById(R.id.button);
        if (checado(0,button)){
            intencao =5;
            changeActivity();
        }
    }

    public void putValue2(View v){
        button = (Button) findViewById(R.id.button2);
        if (checado(1,button)) {
            intencao = 4;
            changeActivity();
        }
    }

    public void putValue3(View v){
        button = (Button) findViewById(R.id.button3);
        if (checado(2,button)) {
            intencao = 3;
            changeActivity();
        }
    }
    public void putValue4(View v){
        button = (Button) findViewById(R.id.button4);
        if (checado(3,button)) {
            intencao = 2;
            changeActivity();
        }
    }
    public void putValue5(View v){
        button = (Button) findViewById(R.id.button5);
        if (checado(4,button)) {
            intencao = 1;
            changeActivity();
        }
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

        SharedPreferences sp2 = getSharedPreferences(MY_PREF_NAME,MODE_PRIVATE);

        SharedPreferences.Editor editor = sp2.edit();

        editor.putInt("intencao_compra_1", intencao);

        editor.commit();

    }
}
