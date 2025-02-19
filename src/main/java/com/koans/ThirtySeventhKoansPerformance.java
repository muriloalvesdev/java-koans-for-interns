package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Esta classe demonstra testes simples de performance, medindo o tempo de execução de um cálculo
 * intensivo.
 */
public class ThirtySeventhKoansPerformance {

  /** Testa o tempo de execução de um cálculo intensivo (soma de 1 a 10 milhões). */
  @Koan("Teste de performance: medição de tempo de execução")
  public void testPerformance() {
    long startTime = System.nanoTime();
    long sum = 0;
    for (int i = 1; i <= 10_000_000; i++) {
      sum += i;
    }
    long endTime = System.nanoTime();
    long durationMs = (endTime - startTime) / 1_000_000;
    Assert.isTrue(
        durationMs > 1000, "O cálculo levou " + durationMs + " ms, que excede o limite esperado");
  }
}
