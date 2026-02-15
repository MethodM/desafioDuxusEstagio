package br.com.duxusdesafio.controller.request;

public class CadastroTimeRequest {
  private String nome;
  private String franquia;
  private String funcao;
  private String nomeTime;

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFranquia(){
    return franquia;
  }
  public void setFranquia(String franquia){
    this.franquia = franquia;
  }

  public String getFuncao(){
    return funcao;
  }
  public void setFuncao(String funcao){
    this.funcao = funcao;
  }

  public String getNomeTime(){
    return nomeTime;
  }
  public void setNomeTime(String nomeTime){
    this.nomeTime = nomeTime;
  }
}
