package br.com.duxusdesafio.service;

import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    if (todosOsTimes == null)
      throw new IllegalArgumentException("Lista de times não pode ser nula");
    return todosOsTimes.stream().filter(time -> {
          LocalDate data = time.getData();

          if (dataInicio != null && data.isBefore(dataInicio))
            return false;
          if (dataFim != null && data.isAfter(dataFim))
            return false;

          return true;

        })
        .collect(Collectors.toList());
  }

  /**
   * Vai retornar um Time, com a composição do time daquela data
   */
  public Time timeDaData(LocalDate data, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    assert data != null : "Data não pode ser nula";
    return null;
  }

  /**
   * Vai retornar o integrante que estiver presente na maior quantidade de times
   * dentro do período
   */
  public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    return null;
  }

  /**
   * Vai retornar uma lista com os nomes dos integrantes do time mais comum
   * dentro do período
   */
  public List<String> integrantesDoTimeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
    // TODO Implementar método seguindo as instruções!
    return null;
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
    // Validações iniciais
    if (dataInicial == null || dataFinal == null) {
      throw new IllegalArgumentException("Data inicial e data final não podem ser nulas");
    }
    if (todosOsTimes == null) {
      return null;
    }

    // Filtra os times pelo período, percorre as composições, extrai os integrantes e suas franquias,
    // agrupa por franquia e retorna a franquia com maior contagem.
    return filtrarTimesPorPeriodo(dataInicial, dataFinal, todosOsTimes).stream()
        .flatMap(time -> time.getComposicaoTime() == null ? java.util.stream.Stream.empty() : time.getComposicaoTime().stream())
        .map(composicao -> composicao.getIntegrante())
        .map(integrante -> integrante.getFranquia())
        .collect(Collectors.groupingBy(franquia -> franquia, Collectors.counting()))
        .entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse("");
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