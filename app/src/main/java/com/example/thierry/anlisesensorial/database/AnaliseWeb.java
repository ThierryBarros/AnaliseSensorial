package com.example.thierry.anlisesensorial.database;

/**
 * Created by Thierry on 2/22/2018.
 */

public class AnaliseWeb {
    private int id;
    private int codigo;
    private int aparencia;
    private int sabor;
    private int aroma;
    private int saborresidual;
    private int docura;
    private int textura;
    private int odor;
    private int maciez;
    private int cor;
    private int consistencia;
    private int avalglobal;
    private String nomeproduto;
    private String nome;
    private int idade;
    private String genero;
    private String escolaridade;
    private String consome;
    private String freq;
    private String comentario;
    private int intencao;
    private int nAnalise;
    private String categoria;
    private int posicao;
    private String codigoAnalise;
    public AnaliseWeb( ) {

    }

    public AnaliseWeb(int codigo, int aparencia, int sabor, int aroma, int saborresidual, int docura, int textura, int odor, int maciez, int cor, int consistencia, int avalglobal, String nomeproduto, String nome, int idade, String genero, String escolaridade, String consome, String freq, String comentario, int intencao, int nAnalise, String categoria, int posicao, String codigoAnalise) {
        this.codigo = codigo;
        this.aparencia = aparencia;
        this.sabor = sabor;
        this.aroma = aroma;
        this.saborresidual = saborresidual;
        this.docura = docura;
        this.textura = textura;
        this.odor = odor;
        this.maciez = maciez;
        this.cor = cor;
        this.consistencia = consistencia;
        this.avalglobal = avalglobal;
        this.nomeproduto = nomeproduto;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.escolaridade = escolaridade;
        this.consome = consome;
        this.freq = freq;
        this.comentario = comentario;
        this.intencao = intencao;
        this.nAnalise = nAnalise;
        this.categoria = categoria;
        this.posicao = posicao;
        this.codigoAnalise = codigoAnalise;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getnAnalise() {return nAnalise;}

    public void setnAnalise(int nAnalise) {this.nAnalise = nAnalise;}

    public int getIntencao() {
        return intencao;
    }

    public void setIntencao(int intencao) {
        this.intencao = intencao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getConsome() {
        return consome;
    }

    public void setConsome(String consome) {
        this.consome = consome;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAparencia() {
        return aparencia;
    }

    public void setAparencia(int aparencia) {
        this.aparencia = aparencia;
    }

    public int getSabor() {
        return sabor;
    }

    public void setSabor(int sabor) {
        this.sabor = sabor;
    }

    public int getAroma() {
        return aroma;
    }

    public void setAroma(int aroma) {
        this.aroma = aroma;
    }

    public int getSaborresidual() {
        return saborresidual;
    }

    public void setSaborresidual(int saborresidual) {
        this.saborresidual = saborresidual;
    }

    public int getDocura() {
        return docura;
    }

    public void setDocura(int docura) {
        this.docura = docura;
    }

    public int getTextura() {
        return textura;
    }

    public void setTextura(int textura) {
        this.textura = textura;
    }

    public int getOdor() {
        return odor;
    }

    public void setOdor(int odor) {
        this.odor = odor;
    }

    public int getMaciez() {
        return maciez;
    }

    public void setMaciez(int maciez) {
        this.maciez = maciez;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getConsistencia() {
        return consistencia;
    }

    public void setConsistencia(int consistencia) {
        this.consistencia = consistencia;
    }

    public int getAvalglobal() {
        return avalglobal;
    }

    public void setAvalglobal(int avalglobal) {
        this.avalglobal = avalglobal;
    }

    public String getCodigoAnalise() { return codigoAnalise; }

    public void setCodigoAnalise(String codigoAnalise) { this.codigoAnalise = codigoAnalise; }
}
