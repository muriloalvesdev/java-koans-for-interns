package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes aborda o padrão de projeto Singleton, garantindo que uma classe tenha
 * somente uma instância.
 */
public class NineteenthKoans {

  /** Testa se a instância do DatabaseConnection é única. */
  @Koan("Teste do padrão Singleton")
  public void testSingleton() {
    DatabaseConnection instance1 = DatabaseConnection.getInstance();
    DatabaseConnection instance2 = DatabaseConnection.getInstance();
    Assert.isTrue(instance1 == instance2, "Ambas as instâncias devem ser as mesmas");
  }

  /** Classe DatabaseConnection que implementa o padrão Singleton. */
  static class DatabaseConnection {
    private static DatabaseConnection instance;

    /** Construtor privado para impedir a criação de múltiplas instâncias. */
    private DatabaseConnection() {
      // Inicializações de conexão simuladas
    }

    /**
     * Retorna a instância única da classe.
     *
     * @return a instância única de DatabaseConnection.
     */
    public static DatabaseConnection getInstance() {
      if (instance == null) {
        instance = new DatabaseConnection();
      }
      return instance;
    }
  }
}
