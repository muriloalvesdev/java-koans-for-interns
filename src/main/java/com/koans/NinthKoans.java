package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/** Este conjunto de testes aborda o uso de classes internas (inner classes) e classes anônimas. */
public class NinthKoans {

  /** Testa o uso de uma classe interna para fornecer um identificador. */
  @Koan("Teste de classe interna")
  public void testInnerClass() {
    Outer outer = new Outer("TestID");
    String id = outer.getInner().getIdentifier();
    Assert.equals("testId", id);
  }

  /** Testa o uso de uma classe anônima para implementar uma interface funcional. */
  @Koan("Teste de classe anônima")
  public void testAnonymousClass() {
    Greeting greeting =
        new Greeting() {
          @Override
          public String greet(String name) {
            return "Hello, " + name;
          }
        };
    Assert.equals("Hello, Interns", greeting.greet("Intern"));
  }

  /** Classe Outer que contém uma classe interna. */
  class Outer {
    private String id;

    /**
     * Construtor que define o identificador.
     *
     * @param id o identificador.
     */
    public Outer(String id) {
      this.id = id;
    }

    /**
     * Retorna uma instância da classe interna Inner.
     *
     * @return uma instância de Inner.
     */
    public Inner getInner() {
      return new Inner();
    }

    /** Classe interna que retorna o identificador do objeto Outer. */
    class Inner {
      /**
       * Retorna o identificador.
       *
       * @return o identificador.
       */
      public String getIdentifier() {
        return id;
      }
    }
  }

  /** Interface funcional para demonstrar o uso de classes anônimas. */
  interface Greeting {
    /**
     * Gera uma saudação para o nome informado.
     *
     * @param name o nome para saudação.
     * @return a saudação.
     */
    String greet(String name);
  }
}
