package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Configuracao extends AppCompatActivity {
    private static final String PREF_NAME = "ConfigActivityPrefences";
    private boolean aparencia;
    private boolean aroma;
    private boolean saborresidual;
    private boolean sabor;
    private boolean docura;
    private boolean textura;
    private boolean odor;
    private boolean maciez;
    private boolean cor;
    private boolean consistencia;
    private boolean avalGlobal;
    private String nomeproduto;
    private String código;

    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };

    public void goMainClass(View v){
        if(checkcadaster() && checkcodigo()) {
            Intent inten = new Intent(Configuracao.this, MainActivity.class);
            startActivity(inten);
        }
    }

    private void checkAparencia(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        aparencia  = sp1.getBoolean("aparencia_1",false);
        final CheckBox chk1 = (CheckBox)findViewById(R.id.aparencia);
        if (aparencia){
            chk1.toggle();
        }
    }
    private void checkAroma(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        aroma = sp1.getBoolean("aroma_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.aroma);
        if (aroma){
            chk1.toggle();
        }
    }
    private void checkSaborResidual(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        saborresidual = sp1.getBoolean("saborresidual_1",false);
        final CheckBox chk1 = (CheckBox)findViewById(R.id.saborresidual);
        if (saborresidual){
            chk1.toggle();
        }
    }

    private void checkSabor(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        sabor = sp1.getBoolean("sabor_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.sabor);
        if (sabor){
            chk1.toggle();
        }
    }
    private void checkDocura(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        docura = sp1.getBoolean("doçura_1",false);
        final CheckBox chk1 = (CheckBox)findViewById(R.id.doçura);
        if (docura){
            chk1.toggle();
        }
    }

    private void checkTextura(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        textura = sp1.getBoolean("textura_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.textura);
        if (textura){
            chk1.toggle();
        }
    }
    private void checkOdor(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        odor = sp1.getBoolean("odor_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.odor);
        if (odor){
            chk1.toggle();
        }
    }

    private void checkMaciez(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        maciez = sp1.getBoolean("maciez_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.maciez);
        if (maciez){
            chk1.toggle();
        }
    }

    private void checkCor(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        cor = sp1.getBoolean("cor_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.cor);
        if (cor){
            chk1.toggle();
        }
    }

    private void checkConsistencia(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        consistencia = sp1.getBoolean("consistencia_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.consistencia);
        if (consistencia){
            chk1.toggle();
        }
    }

    private void checkAvalGlobal(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        avalGlobal = sp1.getBoolean("avalGlobal_1",false);
        final CheckBox  chk1 = (CheckBox)findViewById(R.id.avalglobal);
        if (avalGlobal){
            chk1.toggle();
        }
    }

    private void checkNomeProduto(){
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        nomeproduto = sp1.getString("nomeproduto_1","");
        final EditText ed1 = (EditText)findViewById(R.id.nomeproduto);
        if(!nomeproduto.equals("")) {
            ed1.setText(nomeproduto);
        }

    }



    private void check(){
        checkAparencia();
        checkAroma();
        checkDocura();
        checkSabor();
        checkSaborResidual();
        checkTextura();
        checkOdor();
        checkMaciez();
        checkCor();
        checkConsistencia();
        checkAvalGlobal();
        checkNomeProduto();
        checkCodigoProduto();
    }

    private void checkCodigoProduto() {
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        nomeproduto = sp1.getString("codigo_1","");
        final EditText ed1 = (EditText)findViewById(R.id.codigo);
        if(!nomeproduto.equals("")) {
            ed1.setText(nomeproduto);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        check();

        SharedPreferences sp1 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        sp1.registerOnSharedPreferenceChangeListener(callback);
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
        final CheckBox chk1 = (CheckBox)findViewById(R.id.aparencia);
        if(chk1.isChecked()) {
            editor.putBoolean("aparencia_1", true);
        }else{
            editor.putBoolean("aparencia_1", false);
        }
        final CheckBox  chk2 = (CheckBox)findViewById(R.id.aroma);
        if(chk2.isChecked()){
            editor.putBoolean("aroma_1",true);
        }else{
            editor.putBoolean("aroma_1",false);
        }
        final CheckBox chk3 = (CheckBox)findViewById(R.id.saborresidual);
        if(chk3.isChecked()){
            editor.putBoolean("saborresidual_1",true);
        }else{
            editor.putBoolean("saborresidual_1", false);
        }
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.sabor);
        if(chk4.isChecked()){
            editor.putBoolean("sabor_1",true);
        }else{
            editor.putBoolean("sabor_1",false);
        }
        final CheckBox chk5 = (CheckBox)findViewById(R.id.doçura);
        if(chk5.isChecked()){
            editor.putBoolean("doçura_1",true);
        }else{
            editor.putBoolean("doçura_1",false);
        }
        final CheckBox  chk6 = (CheckBox)findViewById(R.id.textura);
        if(chk6.isChecked()){
            editor.putBoolean("textura_1",true);
        }else{
            editor.putBoolean("textura_1",false);
        }
        final CheckBox  chk7 = (CheckBox)findViewById(R.id.odor);
        if(chk7.isChecked()){
            editor.putBoolean("odor_1",true);
        }else{
            editor.putBoolean("odor_1",false);
        }
        final CheckBox  chk8 = (CheckBox)findViewById(R.id.maciez);
        if(chk8.isChecked()){
            editor.putBoolean("maciez_1",true);
        }else{
            editor.putBoolean("maciez_1",false);
        }
        final CheckBox  chk9 = (CheckBox)findViewById(R.id.cor);
        if(chk9.isChecked()){
            editor.putBoolean("cor_1",true);
        }else{
            editor.putBoolean("cor_1",false);
        }
        final CheckBox  chk10 = (CheckBox)findViewById(R.id.consistencia);
        if(chk10.isChecked()){
            editor.putBoolean("consistencia_1",true);
        }else{
            editor.putBoolean("consistencia_1",false);
        }
        final CheckBox  chk11 = (CheckBox)findViewById(R.id.avalglobal);
        if(chk11.isChecked()){
            editor.putBoolean("avalGlobal_1",true);
        }else{
            editor.putBoolean("avalGlobal_1",false);
        }
        final EditText ed1 = (EditText)findViewById(R.id.nomeproduto);
        if(!ed1.getText().toString().equals("")) {
            editor.putString("nomeproduto_1",ed1.getText().toString());
        }else{
            editor.putString("nomeproduto_1","");
        }

        final EditText ed2 = (EditText)findViewById(R.id.codigo);
        if(!ed2.getText().toString().equals("")) {
            editor.putString("codigo_1",ed2.getText().toString());
        }else{
            editor.putString("codigo_1","");
        }


        editor.commit();

    }

    private boolean oneChecked(){
        final CheckBox chk1 = (CheckBox)findViewById(R.id.aparencia);
        final CheckBox  chk2 = (CheckBox)findViewById(R.id.aroma);
        final CheckBox chk3 = (CheckBox)findViewById(R.id.saborresidual);
        final CheckBox  chk4 = (CheckBox)findViewById(R.id.sabor);
        final CheckBox chk5 = (CheckBox)findViewById(R.id.doçura);
        final CheckBox  chk6 = (CheckBox)findViewById(R.id.textura);
        final CheckBox  chk7 = (CheckBox)findViewById(R.id.odor);
        final CheckBox  chk8 = (CheckBox)findViewById(R.id.maciez);
        final CheckBox  chk9 = (CheckBox)findViewById(R.id.cor);
        final CheckBox  chk10 = (CheckBox)findViewById(R.id.consistencia);
        final CheckBox  chk11 = (CheckBox)findViewById(R.id.avalglobal);

        return chk1.isChecked() || chk2.isChecked() || chk3.isChecked() || chk4.isChecked() || chk5.isChecked() || chk6.isChecked()|| chk7.isChecked()|| chk8.isChecked()|| chk9.isChecked()|| chk10.isChecked() || chk11.isChecked();
    }

    private boolean checkcadaster() {
        EditText ed1 = (EditText) findViewById(R.id.nomeproduto);
        if(!oneChecked()){
            String texto = "Pelo menos um atributo precisa ser marcado!";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), texto,duracao);
            toast.show();
            return false;
        }
        if (TextUtils.isEmpty(ed1.getText().toString())) {
            ed1.requestFocus();
            ed1.setError("Campo Obrigatório!");
            return false;
        }
        return true;
    }

    private boolean checkcodigo() {
        EditText ed1 = (EditText) findViewById(R.id.codigo);
        if(!oneChecked()){
            return false;
        }
        if (TextUtils.isEmpty(ed1.getText().toString())) {
            ed1.requestFocus();
            ed1.setError("Campo Obrigatório!");
            return false;
        }
        return true;
    }
}
