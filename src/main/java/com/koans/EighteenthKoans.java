package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes aborda o padrão de projeto Builder para a criação de objetos de forma
 * flexível.
 */
public class EighteenthKoans {

  /** Testa a criação de um objeto Car utilizando o padrão Builder. */
  @Koan("Teste do padrão Builder")
  public void testCarBuilder() {
    Car car = new Car.Builder().withMake("Toyota").withModel("Corolla").withYear(2020).build();
    Assert.equals("Toyota", car.getMake());
    Assert.equals("Corolla", car.getModel());
    Assert.equals(2020, car.getYear());
  }

  /** Classe Car com padrão Builder para construção de objetos. */
  static class Car {
    private String make;
    private String model;
    private int year;

    private Car(Builder builder) {
      this.make = builder.make;
      this.model = builder.model;
      this.year = builder.year;
    }

    /**
     * Retorna a marca do carro.
     *
     * @return a marca.
     */
    public String getMake() {
      return make;
    }

    /**
     * Retorna o modelo do carro.
     *
     * @return o modelo.
     */
    public String getModel() {
      return model;
    }

    /**
     * Retorna o ano do carro.
     *
     * @return o ano.
     */
    public int getYear() {
      return year;
    }

    /** Classe Builder para a construção de objetos Car. */
    public static class Builder {
      private String make;
      private String model;
      private int year;

      /**
       * Define a marca do carro.
       *
       * @param make a marca.
       * @return a instância do Builder.
       */
      public Builder withMake(String make) {
        this.make = make;
        return this;
      }

      /**
       * Define o modelo do carro.
       *
       * @param model o modelo.
       * @return a instância do Builder.
       */
      public Builder withModel(String model) {
        this.model = model;
        return this;
      }

      /**
       * Define o ano do carro.
       *
       * @param year o ano.
       * @return a instância do Builder.
       */
      public Builder withYear(int year) {
        this.year = year;
        return this;
      }

      /**
       * Constrói e retorna o objeto Car.
       *
       * @return o objeto Car.
       */
      public Car build() {
        return new Car(this);
      }
    }
  }
}
