package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/** Este conjunto de testes aborda o uso de interfaces e polimorfismo. */
public class SeventhKoans {

  /** Testa o polimorfismo utilizando a interface Animal. */
  @Koan("Teste de interface e polimorfismo")
  public void testAnimalSound() {
    Animal dog = new Dog();
    Animal cat = new Cat();
    Assert.equals("bark", dog.sound());
    Assert.equals("meow", cat.sound());
  }

  /** Interface Animal para demonstrar polimorfismo. */
  interface Animal {
    /**
     * Retorna o som que o animal faz.
     *
     * @return o som do animal.
     */
    String sound();
  }

  /** Classe Dog que implementa a interface Animal. */
  class Dog implements Animal {
    @Override
    public String sound() {
      return "Bark";
    }
  }

  /** Classe Cat que implementa a interface Animal. */
  class Cat implements Animal {
    @Override
    public String sound() {
      return "Meow";
    }
  }
}
