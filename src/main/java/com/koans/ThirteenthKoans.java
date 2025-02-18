package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.ArrayList;
import java.util.List;

/**
 * Este conjunto de testes aborda a manipulação de Strings para simular o parsing de um CSV (Comma
 * Separated Values).
 */
public class ThirteenthKoans {

  /** Testa o parsing de uma string CSV em linhas e colunas. */
  @Koan("Teste de parsing de CSV")
  public void testCSVParsing() {
    String csv = "Name,Age,Location\nAlice,30,NY\nBob,25,LA";
    List<String[]> rows = parseCSV(csv);
    // Deve ter 3 linhas (cabeçalho + 2 dados)
    Assert.equals(3, rows.size());
    // Verifica a primeira coluna da segunda linha
    Assert.equals("Alice", rows.get(1)[0]);
    // Verifica a idade de Bob
    Assert.equals("25", rows.get(2)[1]);
  }

  /**
   * Faz o parsing de uma string CSV simples.
   *
   * @param csv a string CSV.
   * @return uma lista de arrays, onde cada array representa uma linha do CSV.
   */
  private List<String[]> parseCSV(String csv) {
    List<String[]> result = new ArrayList<>();
    String[] lines = csv.split("\n");
    for (String line : lines) {
      // Divide a linha por vírgula
      String[] columns = line.split(",");
      result.add(columns);
    }
    return result;
  }
}
