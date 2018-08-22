package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {

    private static final String PREF_NAME = "CadastroActivityPrefences";


    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);



    }

    public void goInfoProduto(View v){
        if(checkcadaster()) {
            Intent inten = new Intent(Cadastro.this, InfoProduto.class);
            startActivity(inten);
        }
    }

    public void checkFeminino(View v){
        final CheckBox  chk2 = (CheckBox)findViewById(R.id.masculino);
        if (chk2.isChecked()){
            chk2.toggle();
        }
    }

    public void checkMasculino(View v){
        final CheckBox chk1 = (CheckBox)findViewById(R.id.feminino);
        if (chk1.isChecked()){
            chk1.toggle();
        }
    }


    public void checkEnsinoMedio(View v){
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.ensinosup);
        final CheckBox chk5 = (CheckBox)findViewById(R.id.posGraduacao);
        if (chk4.isChecked()){
            chk4.toggle();
        }
        if (chk5.isChecked()){
            chk5.toggle();
        }
    }
    public void checkEnsinoSup(View v){
        final CheckBox chk3 = (CheckBox)findViewById(R.id.ensinomedio);
        final CheckBox chk5 = (CheckBox)findViewById(R.id.posGraduacao);
        if (chk3.isChecked()){
            chk3.toggle();
        }
        if (chk5.isChecked()){
            chk5.toggle();
        }
    }
    public void checkPosGraduacao(View v){
        final CheckBox chk3 = (CheckBox)findViewById(R.id.ensinomedio);
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.ensinosup);
        if (chk3.isChecked()){
            chk3.toggle();
        }
        if (chk4.isChecked()){
            chk4.toggle();
        }
    }


    private boolean checkcadaster() {

        EditText ed2 = (EditText) findViewById(R.id.idade);

        if (TextUtils.isEmpty(ed2.getText().toString())) {
                ed2.requestFocus();
                ed2.setError("Campo Obrigatório!");
                return false;
        }
        if(Integer.parseInt(ed2.getText().toString())>122 ||Integer.parseInt(ed2.getText().toString())<1){
            ed2.requestFocus();
            ed2.setError("Idade errada!");
            return false;
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

        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText idade = (EditText) findViewById(R.id.idade);
        if(!nome.getText().toString().isEmpty()) {
            editor.putString("nome_1", nome.getText().toString());
        }else{
            editor.putString("nome_1", "");
        }
        if(!idade.getText().toString().isEmpty()){
            editor.putInt("idade_1", Integer.parseInt(idade.getText().toString()));
        }
        final CheckBox feminino = (CheckBox)findViewById(R.id.feminino);
        final CheckBox  masculino = (CheckBox)findViewById(R.id.masculino);

        if(!feminino.isChecked() && !masculino.isChecked()){
            editor.putString("genero_1","NA");
        }else {
            if (masculino.isChecked()) {
                editor.putString("genero_1", "masculino");
            }else {
                editor.putString("genero_1", "feminino");

            }
        }

        final CheckBox ensinomedio = (CheckBox)findViewById(R.id.ensinomedio);
        final CheckBox posgraduacao = (CheckBox)findViewById(R.id.posGraduacao);
        final CheckBox ensinosup= (CheckBox)findViewById(R.id.ensinosup);

        if(!ensinomedio.isChecked() && !posgraduacao.isChecked() && !ensinosup.isChecked()){
            editor.putString("escolaridade_1","NA");
        }else{
            if(ensinomedio.isChecked()){
                editor.putString("escolaridade_1","ensino medio");
            }else{
                if(posgraduacao.isChecked()){
                    editor.putString("escolaridade_1","pos-graduação");
                }else{
                    editor.putString("escolaridade_1","ensino superior");
                }
            }
        }

        editor.commit();

    }


}
