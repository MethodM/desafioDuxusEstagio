package br.com.duxusdesafio.controller.request;

public class IntegrantesRequest {
  private String nome;
  private String franquia;
  private String funcao;

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
}
