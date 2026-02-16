package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.ComposicaoTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComposicaoTimeService {

  @Autowired
  private final ComposicaoTimeRepository composicaoTimeRepository;

  public ComposicaoTimeService (ComposicaoTimeRepository composicaoTimeRepository){
    this.composicaoTimeRepository = composicaoTimeRepository;
  }

  public ComposicaoTime create(Time time, Integrante integrante){
    return composicaoTimeRepository.save(new ComposicaoTime(time, integrante));
  }
}
