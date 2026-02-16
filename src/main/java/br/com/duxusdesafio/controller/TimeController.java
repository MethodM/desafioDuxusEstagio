package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.controller.request.CadastroTimeRequest;
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
@RequestMapping("/times")
public class TimeController {

  @Autowired
  private final TimeService timeService;

  public TimeController(TimeService timeService) {
    this.timeService = timeService;
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

}