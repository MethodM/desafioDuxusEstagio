package br.com.duxusdesafio.controller.request;

import java.time.LocalDate;
import java.util.List;


public class TimeVencedorSemanaRequest {
  private String nomeTime;
  private LocalDate data;

  List<IntegrantesRequest> integrantes;

  public String getNomeTime() {
    return nomeTime;
  }

  public void setNomeTime(String nomeTime) {
    this.nomeTime = nomeTime;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public List<IntegrantesRequest> getIntegrantes() {
    return integrantes;
  }

  public void setIntegrantes(List<IntegrantesRequest> integrantes) {
    this.integrantes = integrantes;
  }
}