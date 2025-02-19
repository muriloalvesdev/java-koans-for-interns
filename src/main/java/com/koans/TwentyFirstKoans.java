package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** Este conjunto de testes demonstra operações básicas de entrada e saída de arquivos. */
public class TwentyFirstKoans {

  /** Testa a escrita e leitura de um arquivo de texto. */
  @Koan("Teste de File I/O")
  public void testFileReadWrite() {
    String fileName = "temp_koan.txt";
    String contentToWrite = "Hello, File I/O Koans!";
    String contentRead = "";

    try (FileWriter writer = new FileWriter(fileName)) {
      writer.write(contentToWrite);
    } catch (IOException e) {
      throw new KoanFailureException(e.getMessage());
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      contentRead = reader.readLine();
    } catch (IOException e) {
      throw new KoanFailureException(e.getMessage());
    }

    File file = new File(fileName);
    file.delete();

    Assert.equals(contentToWrite.getBytes(), contentRead);
  }
}
