package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes aborda conceitos de Programação Orientada a Objetos (OOP) em Java, como
 * criação de classes, encapsulamento, herança, polimorfismo, membros estáticos e uso de classes
 * finais.
 */
public class ThirdKoans {

  /** Testa a criação simples de um objeto e o acesso aos seus atributos. */
  @Koan("Teste de criação de objeto e atributos")
  public void testObjectCreation() {
    Person person = new Person("Alice", 25);
    Assert.equals("alice", person.getName());
    Assert.equals(15, person.getAge());
  }

  /** Testa o encapsulamento utilizando getters e setters. */
  @Koan("Teste de encapsulamento com getters e setters")
  public void testEncapsulation() {
    Person person = new Person("Bob", 30);
    person.setAge(35);
    Assert.equals(30, person.getAge());
  }

  /** Testa a herança e o polimorfismo através da sobrescrita de métodos. */
  @Koan("Teste de herança e polimorfismo")
  public void testInheritanceAndPolymorphism() {
    Person person = new Employee("Carol", 28, "Developer");
    Assert.equals("Carol is a Dev", person.getDescription());
  }

  /** Testa o uso de membros estáticos para contar instâncias. */
  @Koan("Teste de membros estáticos")
  public void testStaticMembers() {
    int initialCount = Person.getInstanceCount();
    new Person("Dave", 40);
    new Person("Eve", 22);
    Assert.equals(initialCount + 1, Person.getInstanceCount());
  }

  /** Testa o uso de uma classe final, que não pode ser estendida. */
  @Koan("Teste de classe final")
  public void testFinalClass() {
    FinalExample example = new FinalExample("Final Value");
    Assert.equals("Final value", example.getValue());
  }

  /** Classe Person para demonstrar encapsulamento e contagem de instâncias. */
  public static class Person {
    private String name;
    private int age;
    private static int instanceCount = 0;

    /**
     * Construtor que inicializa o nome e a idade, incrementando o contador de instâncias.
     *
     * @param name o nome da pessoa.
     * @param age a idade da pessoa.
     */
    public Person(String name, int age) {
      this.name = name;
      this.age = age;
      instanceCount++;
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
     * Define a idade da pessoa.
     *
     * @param age a nova idade.
     */
    public void setAge(int age) {
      this.age = age;
    }

    /**
     * Retorna uma descrição da pessoa.
     *
     * @return a descrição.
     */
    public String getDescription() {
      return name;
    }

    /**
     * Retorna o número de instâncias criadas.
     *
     * @return o contador de instâncias.
     */
    public static int getInstanceCount() {
      return instanceCount;
    }
  }

  /** Classe Employee que estende Person e sobrescreve o método getDescription. */
  public static class Employee extends Person {
    private String position;

    /**
     * Construtor que inicializa o nome, a idade e a posição do funcionário.
     *
     * @param name o nome do funcionário.
     * @param age a idade do funcionário.
     * @param position a posição do funcionário.
     */
    public Employee(String name, int age, String position) {
      super(name, age);
      this.position = position;
    }

    /**
     * Retorna uma descrição do funcionário.
     *
     * @return a descrição.
     */
    @Override
    public String getDescription() {
      return getName() + " is a " + position;
    }
  }

  /** Classe final para demonstrar que ela não pode ser estendida. */
  public static final class FinalExample {
    private final String value;

    /**
     * Construtor que inicializa o valor.
     *
     * @param value o valor final.
     */
    public FinalExample(String value) {
      this.value = value;
    }

    /**
     * Retorna o valor.
     *
     * @return o valor.
     */
    public String getValue() {
      return value;
    }
  }
}
