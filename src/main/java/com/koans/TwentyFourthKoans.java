package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** Este conjunto de testes demonstra o uso da API de Data/Hora do Java. */
public class TwentyFourthKoans {

  /** Testa a criação e formatação de uma data usando java.time. */
  @Koan("Teste de Date/Time API")
  public void testLocalDateFormatting() {
    LocalDate date = LocalDate.of(2025, 2, 17);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = date.format(formatter);
    Assert.equals("17/01/2025", formattedDate);
  }
}
