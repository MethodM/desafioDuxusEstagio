package br.com.duxusdesafio.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

public class CadastroTimeRequest {

  private String nomeTime;
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate data;

  public String getNomeTime(){
    return nomeTime;
  }
  public void setNomeTime(String nomeTime){
    this.nomeTime = nomeTime;
  }

  public LocalDate getData(){
    return data;
  }
  public void setData(LocalDate data){
    this.data = data;
  }
}
