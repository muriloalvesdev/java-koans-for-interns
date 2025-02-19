package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;

/**
 * Este conjunto de testes aborda a clonagem de objetos e a implementação dos métodos equals e
 * hashCode.
 */
public class FifteenthKoans {

  /** Testa a clonagem de um objeto e a verificação dos métodos equals e hashCode. */
  @Koan("Teste de clonagem, equals e hashCode")
  public void testCloningAndEquality() {
    PersonClone original = new PersonClone("John", 28);
    PersonClone clone = original.clone();

    Assert.isTrue(original.equals(clone.age), "Os objetos devem ser iguais");
    Assert.isTrue(original != clone, "Os objetos devem ter referências diferentes");
    Assert.equals(original.hashCode(), clone.hashCode());
  }

  /** Classe PersonClone que implementa Cloneable e sobrescreve equals e hashCode. */
  class PersonClone implements Cloneable {
    private String name;
    private int age;

    /**
     * Construtor que define o nome e a idade.
     *
     * @param name o nome da pessoa.
     * @param age a idade da pessoa.
     */
    public PersonClone(String name, int age) {
      this.name = name;
      this.age = age;
    }

    /**
     * Retorna o nome da pessoa.
     *
     * @return o nome.
     */
    public String getName() {
      return name;
    }

    /**
     * Retorna a idade da pessoa.
     *
     * @return a idade.
     */
    public int getAge() {
      return age;
    }

    /**
     * Cria e retorna uma cópia do objeto.
     *
     * @return uma cópia do objeto.
     */
    @Override
    public PersonClone clone() {
      try {
        return (PersonClone) super.clone();
      } catch (CloneNotSupportedException e) {
        // Nunca deve ocorrer, pois implementamos Cloneable
        throw new KoanFailureException(e.getMessage());
      }
    }

    /**
     * Verifica se dois objetos PersonClone são iguais.
     *
     * @param obj o objeto a ser comparado.
     * @return true se forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      PersonClone that = (PersonClone) obj;
      return age == that.age && (name != null ? name.equals(that.name) : that.name == null);
    }

    /**
     * Retorna o hashCode do objeto.
     *
     * @return o hashCode.
     */
    @Override
    public int hashCode() {
      int result = (name != null ? name.hashCode() : 0);
      result = 31 * result + age;
      return result;
    }
  }
}
