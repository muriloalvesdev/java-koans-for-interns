package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.math.BigDecimal;
import java.math.RoundingMode;

/** Este conjunto de testes demonstra o uso de BigDecimal para operações aritméticas precisas. */
public class TwentySeventhKoans {

  /** Testa a soma e divisão usando BigDecimal. */
  @Koan("Teste de BigDecimal")
  public void testBigDecimalOperations() {
    BigDecimal value1 = new BigDecimal("10.5");
    BigDecimal value2 = new BigDecimal("4.2");
    BigDecimal sum = value1.add(value2);
    Assert.equals(new BigDecimal("14.7"), sum);

    BigDecimal division = value1.divide(value2, 2, RoundingMode.HALF_UP);
    Assert.equals(new BigDecimal("2.50"), division);
  }
}
