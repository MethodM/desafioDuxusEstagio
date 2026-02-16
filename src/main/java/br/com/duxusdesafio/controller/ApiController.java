package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.controller.response.IntegrantesResponse;
import br.com.duxusdesafio.controller.response.TimeDaDataResponse;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

  @Autowired
  ApiService apiService;

  @Autowired
  TimeRepository timeRepository;


  @GetMapping("/timeDaData")
  public ResponseEntity<?> getTimeDaData(@RequestParam int dia,
                                         @RequestParam int mes,
                                         @RequestParam int ano) {
    List<Time> todosOsTimes = timeRepository.findAll();

    Time time = apiService.timeDaData(LocalDate.of(ano, mes, dia), todosOsTimes);

    TimeDaDataResponse timeDaDataResponse = new TimeDaDataResponse();
    timeDaDataResponse.setData(time.getData());
    timeDaDataResponse.setNomeTime(time.getNome());

    List<IntegrantesResponse> integrantesResponseList = new ArrayList<>();

    // para cada composição do time, criar um IntegrantesResponse e adicionar à lista
    for (ComposicaoTime composicaoTime : time.getComposicaoTime()) {
      IntegrantesResponse integrantesResponse = new IntegrantesResponse();
      integrantesResponse.setNome(composicaoTime.getIntegrante().getNome());
      integrantesResponse.setFuncao(composicaoTime.getIntegrante().getFuncao());
      integrantesResponse.setFranquia(composicaoTime.getIntegrante().getFranquia());
      integrantesResponseList.add(integrantesResponse);
    }

    timeDaDataResponse.setIntegrantes(integrantesResponseList);

    return ResponseEntity.ok(timeDaDataResponse);
  }

  @GetMapping("/integranteMaisUsado")
  public ResponseEntity<?> getIntegranteMaisUsado(
      @RequestParam String dataInicial,
      @RequestParam String dataFinal) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate inicio = LocalDate.parse(dataInicial, formatter);
    LocalDate fim = LocalDate.parse(dataFinal, formatter);

    List<Time> todosOsTimes = timeRepository.findAll();

    Integrante integrante = apiService.integranteMaisUsado(inicio, fim, todosOsTimes);

    IntegrantesResponse response = new IntegrantesResponse();
    response.setNome(integrante.getNome());
    response.setFuncao(integrante.getFuncao());
    response.setFranquia(integrante.getFranquia());

    return ResponseEntity.ok(response);
  }

  @GetMapping("/integrantesDoTimeMaisComum")
  public ResponseEntity<?> getIntegrantesDoTimeMaisComum(
      @RequestParam String dataInicial,
      @RequestParam String dataFinal) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate inicio = LocalDate.parse(dataInicial, formatter);
    LocalDate fim = LocalDate.parse(dataFinal, formatter);

    List<Time> todosOsTimes = timeRepository.findAll();

    List<String> integrantesDoTimeMaisComum = apiService.integrantesDoTimeMaisComum(inicio, fim, todosOsTimes);
    Integrante integrante = apiService.integranteMaisUsado(inicio, fim, todosOsTimes);


    IntegrantesResponse response = new IntegrantesResponse();
    response.setNome(integrante.getNome());
    response.setFuncao(integrante.getFuncao());
    response.setFranquia(integrante.getFranquia());

    return ResponseEntity.ok(integrantesDoTimeMaisComum);
  }

  @GetMapping("/funcaoMaisComum")
  public ResponseEntity<?> getFuncaoMaisComum(
      @RequestParam String dataInicial,
      @RequestParam String dataFinal) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate inicio = LocalDate.parse(dataInicial, formatter);
    LocalDate fim = LocalDate.parse(dataFinal, formatter);

    List<Time> todosOsTimes = timeRepository.findAll();

    String funcao = apiService.funcaoMaisComum(inicio, fim, todosOsTimes);

    return ResponseEntity.ok(funcao);
  }
}