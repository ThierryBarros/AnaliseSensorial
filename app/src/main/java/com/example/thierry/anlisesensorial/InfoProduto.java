package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class InfoProduto extends AppCompatActivity {
    private static final String PREF_NAME = "ConfigActivityPrefences";
    private static final String MY_PREF_NAME = "InfoProdutoActivityPrefences";
    private static final String CODE_PREF_NAME = "CodeProductActivityPrefences";

    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_produto);

        setContentInfo();

    }

    public void goCodeProduct(View v){
        Intent inten = new Intent(InfoProduto.this,CodigoProduto.class);
        startActivity(inten);
    }

    public void checkSim(View v){
        final CheckBox  chk2 = (CheckBox)findViewById(R.id.nao);
        if (chk2.isChecked()){
            chk2.toggle();
        }
    }
    public void checkNao(View v){
        final CheckBox chk1 = (CheckBox)findViewById(R.id.sim);
        if (chk1.isChecked()){
            chk1.toggle();
        }
    }

    private void setContentInfo() {
        SharedPreferences   sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        final TextView tv1 = (TextView)findViewById(R.id.consome);
        tv1.setText("Consome " + sp1.getString("nomeproduto_1","este produto") + "?");
        final TextView tv2 = (TextView)findViewById(R.id.freq);
        tv2.setText("Com que frequência você consome "+sp1.getString("nomeproduto_1","este produto") + "?");
    }

    public void checkTodo(View v){
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.semana1);
        final CheckBox chk5 = (CheckBox)findViewById(R.id.semana2);
        final CheckBox chk6 = (CheckBox)findViewById(R.id.mes1);

        if (chk4.isChecked()){
            chk4.toggle();
        }
        if (chk5.isChecked()){
            chk5.toggle();
        }
        if (chk6.isChecked()){
            chk6.toggle();
        }
    }

    public void checkSemana1(View v){
        final CheckBox chk3 = (CheckBox)findViewById(R.id.todo);
        final CheckBox chk5 = (CheckBox)findViewById(R.id.semana2);
        final CheckBox chk6 = (CheckBox)findViewById(R.id.mes1);

        if (chk3.isChecked()){
            chk3.toggle();
        }
        if (chk5.isChecked()){
            chk5.toggle();
        }
        if (chk6.isChecked()){
            chk6.toggle();
        }
    }

    public void checkSemana2(View v){
        final CheckBox chk3 = (CheckBox)findViewById(R.id.todo);
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.semana1);
        final CheckBox chk6 = (CheckBox)findViewById(R.id.mes1);

        if (chk3.isChecked()){
            chk3.toggle();
        }
        if (chk4.isChecked()){
            chk4.toggle();
        }
        if (chk6.isChecked()){
            chk6.toggle();
        }
    }

    public void checkMes1(View v){
        final CheckBox chk3 = (CheckBox)findViewById(R.id.todo);
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.semana1);
        final CheckBox chk5 = (CheckBox)findViewById(R.id.semana2);

        if (chk3.isChecked()){
            chk3.toggle();
        }
        if (chk4.isChecked()){
            chk4.toggle();
        }
        if (chk5.isChecked()){
            chk5.toggle();
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
        SharedPreferences sp1 = getSharedPreferences(MY_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp1.edit();

        SharedPreferences sp2 = getSharedPreferences(CODE_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sp2.edit();
        editor.putInt("nAnalise_1",0);

        final CheckBox sim = (CheckBox)findViewById(R.id.sim);
        final CheckBox  nao = (CheckBox)findViewById(R.id.nao);

        if(!sim.isChecked() && !nao.isChecked()){
            editor.putString("consome_1","NA");
        }else {
            if (sim.isChecked()) {
                editor.putString("consome_1", "sim");
            }else {
                editor.putString("consome_1", "nao");

            }
        }


        final CheckBox todo = (CheckBox)findViewById(R.id.todo);
        final CheckBox semana1 = (CheckBox)findViewById(R.id.semana1);
        final CheckBox semana2 = (CheckBox)findViewById(R.id.semana2);
        final CheckBox mes= (CheckBox)findViewById(R.id.mes1);

        if(!todo.isChecked() && !semana1.isChecked() && !semana2.isChecked() && !mes.isChecked()){
            editor.putString("freq_1","NA");
        }else{
            if(todo.isChecked()){
                editor.putString("freq_1","Todos os dias");
            }else{
                if(semana1.isChecked()){
                    editor.putString("freq_1","2 a 3 vezes por semana");
                }else{
                    if(semana2.isChecked()){
                    editor.putString("freq_1", "1 vez por semana");
                    }else{
                        editor.putString("freq_1","1 a 2 vezes por mês");
                    }
                }
            }
        }

        editor.commit();

    }




}
