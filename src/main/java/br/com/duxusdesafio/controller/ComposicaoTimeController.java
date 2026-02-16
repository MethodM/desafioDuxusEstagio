package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.controller.request.CadastroIntegranteTimeRequest;
import br.com.duxusdesafio.service.ComposicaoTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/composicao-time")
public class ComposicaoTimeController {

  public final ComposicaoTimeService composicaoTimeService;

  public ComposicaoTimeController(ComposicaoTimeService composicaoTimeService) {
    this.composicaoTimeService = composicaoTimeService;
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrarComposicaoTime(@RequestBody CadastroIntegranteTimeRequest cadastroIntegranteTimeRequest) {
    // TODO Implementar método seguindo as instruções!
    return null;
  }
}