package br.com.duxusdesafio.service;

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

}
