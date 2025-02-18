package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/** Esta classe demonstra o uso de CompletableFuture para operações assíncronas. */
public class ThirtyThirdKoansCompletableFuture {

  /** Testa uma cadeia simples de operações com CompletableFuture usando thenApply. */
  @Koan("Teste de CompletableFuture: thenApply")
  public void testCompletableFutureThenApply() {
    try {
      CompletableFuture<Integer> future =
          CompletableFuture.supplyAsync(() -> 5).thenApply(x -> x * 2);
      int result = future.get(1, TimeUnit.SECONDS);
      Assert.equals(10, result);
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }
  }

  /** Testa a combinação de dois CompletableFutures usando thenCombine. */
  @Koan("Teste de CompletableFuture: thenCombine")
  public void testCompletableFutureThenCombine() {
    try {
      CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 3);
      CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 7);
      CompletableFuture<Integer> combined = future1.thenCombine(future2, (a, b) -> a + b);
      int result = combined.get(1, TimeUnit.SECONDS);
      Assert.equals(10, result);
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }
  }
}
