package br.com.duxusdesafio.controller;

import br.com.duxusdesafio.controller.request.CadastroTimeRequest;
import br.com.duxusdesafio.controller.response.IntegrantesResponse;
import br.com.duxusdesafio.controller.response.TimeDaDataResponse;
import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
}