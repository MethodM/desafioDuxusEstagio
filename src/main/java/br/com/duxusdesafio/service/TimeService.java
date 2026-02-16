package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TimeService {

  @Autowired
  private final TimeRepository timeRepository;

  public TimeService(TimeRepository timeRepository) {
    this.timeRepository = timeRepository;
  }

  public Time cadastrarTime(String nomeTime, LocalDate data){
    Time time = new Time();
    time.setNomeTime(nomeTime);
    time.setData(data);
    return timeRepository.save(time);
  }
}
