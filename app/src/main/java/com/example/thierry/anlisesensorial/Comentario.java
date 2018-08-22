package com.example.thierry.anlisesensorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.thierry.anlisesensorial.database.AnaliseWeb;
import com.example.thierry.anlisesensorial.dominio.Categoria;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;


public class Comentario extends AppCompatActivity {

    private static final String PREF_NAME = "ComentarioActivityPrefences";
    private static final String CODE_PREF_NAME = "CodeProductActivityPrefences";
    private static final String ANALISE_PREF_NAME = "AnaliseActivityPrefences";
    private static final String CONFIG_PREF_NAME = "ConfigActivityPrefences";
    private static final String CADASTRO_PREF_NAME = "CadastroActivityPrefences";
    private static final String INFO_PRODUTO_PREF_NAME = "InfoProdutoActivityPrefences";
    private static final String INTENCAO_PREF_NAME = "IntencaoActivityPrefences";

    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentario);

    }



    public void changeActivity(View v){
        inserirAnalise();
        Intent inten = new Intent(Comentario.this,TelaFinal.class);
        startActivity(inten);
    }

    private void inserirAnalise() {

        JSONObject post_dict = new JSONObject();

        AnaliseWeb analise = createNewAnalise();

        Gson gson = new Gson();
        String json = gson.toJson(analise);

        new SendDataToServer().execute(String.valueOf(json));


    }

    private AnaliseWeb createNewAnalise() {

        SharedPreferences sp2 = getSharedPreferences(CODE_PREF_NAME,MODE_PRIVATE);
        int codigo = sp2.getInt("codigo_1",0);
        int nAnalise = sp2.getInt("nAnalise_1",1);

        SharedPreferences sp1 = getSharedPreferences(ANALISE_PREF_NAME,MODE_PRIVATE);
        int aparencia  = sp1.getInt("analise_aparencia_1",0);
        int aroma  = sp1.getInt("analise_aroma_1",0);
        int saborresidual  = sp1.getInt("analise_saborresidual_1",0);
        int sabor  = sp1.getInt("analise_sabor_1",0);
        int docura  = sp1.getInt("analise_doçura_1",0);
        int textura  = sp1.getInt("analise_textura_1",0);
        int odor  = sp1.getInt("analise_odor_1",0);
        int maciez  = sp1.getInt("analise_maciez_1",0);
        int cor  = sp1.getInt("analise_cor_1",0);
        int consistencia  = sp1.getInt("analise_consistencia_1",0);
        int avalglobal  = sp1.getInt("analise_avalGlobal_1",0);

        SharedPreferences sp3 = getSharedPreferences(CONFIG_PREF_NAME,MODE_PRIVATE);

        String nomeproduto = sp3.getString("nomeproduto_1","");

        String codigoproduto = sp3.getString("codigo_1","");

        SharedPreferences sp4 = getSharedPreferences(CADASTRO_PREF_NAME,MODE_PRIVATE);

        String nome = sp4.getString("nome_1","");
        int idade = sp4.getInt("idade_1",0);
        String genero = sp4.getString("genero_1","");
        String escolaridade = sp4.getString("escolaridade_1","");

        SharedPreferences sp5 = getSharedPreferences(INFO_PRODUTO_PREF_NAME,MODE_PRIVATE);

        String consome = sp5.getString("consome_1","");
        String frequencia = sp5.getString("freq_1","");

        SharedPreferences sp6 = getSharedPreferences(PREF_NAME,MODE_PRIVATE);

        final EditText comentario1 = (EditText)findViewById(R.id.comentarios);

        String comentario = comentario1.getText().toString();

        SharedPreferences sp7 = getSharedPreferences(INTENCAO_PREF_NAME,MODE_PRIVATE);

        int intencao = sp7.getInt("intencao_compra_1",1);



        Categoria categoria = new Categoria();
        String[] valores = categoria.categoria(codigo);
        String cate = valores[0];
        String posi = valores[1];


        return new AnaliseWeb(codigo
                ,aparencia,sabor,aroma
                ,saborresidual,docura,textura
                ,odor,maciez,cor
                ,consistencia,avalglobal,nomeproduto
                ,nome,idade,genero
                ,escolaridade,consome,frequencia
                ,comentario,intencao,nAnalise
                ,cate,Integer.parseInt(posi),codigoproduto);
    }

    class SendDataToServer extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... params) {

            String JsonDATA = params[0];
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("http://192.168.15.14:8080/analises");//ALTERAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRR
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setDoOutput(true);

                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Accept", "application/json");

                Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
                writer.write(JsonDATA);

                writer.close();
                InputStream inputStream = urlConnection.getInputStream();




                return null;


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }


            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
        }
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

        final EditText comentario = (EditText)findViewById(R.id.comentarios);
        editor.putString("comentario_1",comentario.getText().toString());

        editor.commit();

    }


}
