package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 * <p>
 * OBS ao candidato: PREFERENCIALMENTE, NÃO ALTERE AS ASSINATURAS DOS MÉTODOS!
 * Trabalhe com a proposta pura.
 *
 * @author carlosau
 */
@Service
public class ApiService {

  private List<Time> filtrarTimesPorPeriodo(LocalDate dataInicio, LocalDate dataFim, List<Time> todosOsTimes) {
    return null;
  }

  /**
   * Vai retornar um Time, com a composição do time daquela data
   */
  public Time timeDaData(LocalDate data, List<Time> todosOsTimes) {
    if (data == null)
      throw new IllegalArgumentException("Data não pode ser nula");

    if (todosOsTimes == null)
      throw new IllegalArgumentException("Lista de times não pode ser nula");

    return todosOsTimes.stream()
        .filter(time -> time.getData() != null)
        .filter(time -> time.getData().isEqual(data))
        .findFirst()
        .orElse(null);
  }


  /**
   * Vai retornar o integrante que estiver presente na maior quantidade de times
   * dentro do período
   */
  public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    //preciso filtrar datas válidas, período informado e composições de times
    if (todosOsTimes == null) {
      throw new IllegalArgumentException("Lista de times não pode ser nula");
    }
    Map<Integrante, Integer> contagem = new HashMap<>(); // Mapa para contar a frequência de cada integrante
    for (Time time : filtrarTimesPorPeriodo(dataInicial, dataFinal, todosOsTimes)) {

      if (time.getComposicaoTime() == null)
        continue;

      for (ComposicaoTime composicao : time.getComposicaoTime()) {
        Integrante integrante = composicao.getIntegrante();
        if (integrante == null)
          continue;
        contagem.put(integrante, contagem.getOrDefault(integrante, 0) + 1); // Incrementa a contagem para o integrante
      }
    }
    Integrante maisUsado = null;
    int maiorContagem = 0;

    for (Map.Entry<Integrante, Integer> entry : contagem.entrySet()) {
      if (entry.getValue() > maiorContagem) {
        maiorContagem = entry.getValue();
        maisUsado = entry.getKey();
      }
    }

    return maisUsado;
  }

  /**
   * Vai retornar uma lista com os nomes dos integrantes do time mais comum
   * dentro do período
   */
  public List<String> integrantesDoTimeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    if (todosOsTimes == null) {
      throw new IllegalArgumentException("Lista de times não pode ser nula");
    }

    Map<String, Integer> contagem = new HashMap<>();

    for (Time time : filtrarTimesPorPeriodo(dataInicial, dataFinal, todosOsTimes)) {

      if (time.getComposicaoTime() == null)
        continue;

      List<String> nomes = new ArrayList<>();

      for (ComposicaoTime composicaoTime : time.getComposicaoTime()) {
        if (composicaoTime.getIntegrante() != null) {
          nomes.add(composicaoTime.getIntegrante().getNome());
        }
      }

      Collections.sort(nomes);

      String chave = String.join("|", nomes);

      contagem.put(chave, contagem.getOrDefault(chave, 0) + 1);
    }

    String timeMaisComum = null;
    int maiorContagem = 0;

    for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
      if (entry.getValue() > maiorContagem) {
        maiorContagem = entry.getValue();
        timeMaisComum = entry.getKey();
      }
    }

    if (timeMaisComum == null)
      return null;

    return Arrays.asList(timeMaisComum.split("\\|"));
  }

  /**
   * Vai retornar a função mais comum nos times dentro do período
   */
  public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    return null;
  }

  /**
   * Vai retornar o nome da Franquia mais comum nos times dentro do período
   */
  public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    return null;
  }


  /**
   * Vai retornar o número (quantidade) de Franquias dentro do período
   */
  public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    return null;
  }

  /**
   * Vai retornar o número (quantidade) de Funções dentro do período
   */
  public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    return null;
  }

}
