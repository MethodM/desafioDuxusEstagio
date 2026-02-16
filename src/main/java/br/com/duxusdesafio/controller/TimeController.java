package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.controller.request.CadastroTimeRequest;
import br.com.duxusdesafio.controller.request.TimeVencedorSemanaRequest;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.service.ComposicaoTimeService;
import br.com.duxusdesafio.service.IntegranteService;
import br.com.duxusdesafio.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

  @Autowired
  private final TimeService timeService;

  @Autowired
  private final IntegranteService integranteService;

  @Autowired
  private final ComposicaoTimeService composicaoTimeService;

  public TimeController(TimeService timeService, IntegranteService integranteService, ComposicaoTimeService composicaoTimeService) {
    this.timeService = timeService;
    this.integranteService = integranteService;
    this.composicaoTimeService = composicaoTimeService;
  }

  //TODO: Implementar os endpoints para criar, listar, atualizar e deletar times

  @PostMapping("/cadastroTime")
  public ResponseEntity<?> cadastroDeTime(@RequestBody CadastroTimeRequest time) {
    timeService.cadastrarTime(time.getNomeTime(), time.getData());
    return ResponseEntity.ok("Time salvo com sucesso!");
  }

  @DeleteMapping("/removerTime/{id}")
  public ResponseEntity<?> removerTime(@PathVariable Long id) {
//    timeService.deletarTime(id);
    return ResponseEntity.ok("Time removido com sucesso");
  }

  @PostMapping("/timeVencedorSemana")
  public ResponseEntity<?> timeVencedorSemana(@RequestBody TimeVencedorSemanaRequest timeVencedorSemanaRequest) {
    Time time = timeService.cadastrarTime(timeVencedorSemanaRequest.getNomeTime(), timeVencedorSemanaRequest.getData());

//    for(IntegrantesRequest integrantesRequest : timeVencedorSemanaRequest.getIntegrantes()){
//      Integrante integrante = integranteService.cadastraOuRetorna(
//          integrantesRequest.getNome(),
//          integrantesRequest.getFuncao(),
//          integrantesRequest.getFranquia());
//
//      composicaoTimeService.create(time, integrante);
//    }
    //TODO retornar algo
    return null;
  }
}