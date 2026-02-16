package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegranteService {

  @Autowired
  private final IntegranteRepository integranteRepository;

  public IntegranteService(IntegranteRepository integranteRepository, IntegranteRepository integranteRepository1) {
    this.integranteRepository = integranteRepository;
  }

  public Integrante cadastraOuRetorna(String nome, String funcao, String franquia) {
    if(integranteRepository.existsByNomeAndFuncaoAndFranquia(nome, funcao, franquia)){
      return integranteRepository.findByNomeAndFuncaoAndFranquia(nome, funcao, franquia);
    } else {
      Integrante integrante = new Integrante();
      integrante.setNome(nome);
      integrante.setFuncao(funcao);
      integrante.setFranquia(franquia);
      return integranteRepository.save(integrante);
    }

  }
}
