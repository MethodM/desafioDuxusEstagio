package br.com.duxusdesafio.controller.response;

import java.time.LocalDate;
import java.util.List;

public class TimeDaDataResponse {
  private String nomeTime;
  private LocalDate data;

  List<IntegrantesResponse> integrantes;


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

  public List<IntegrantesResponse> getIntegrantes() {
    return integrantes;
  }

  public void setIntegrantes(List<IntegrantesResponse> integrantes) {
    this.integrantes = integrantes;
  }


}