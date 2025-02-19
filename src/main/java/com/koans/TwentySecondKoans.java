package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Este conjunto de testes demonstra a serialização e desserialização de objetos. */
public class TwentySecondKoans {

  /** Testa a serialização e desserialização de um objeto. */
  @Koan("Teste de serialização")
  public void testSerialization() {
    SerializablePerson original = new SerializablePerson("Alice", 30);
    SerializablePerson copy = null;
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
      try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        oos.writeObject(original);
      }
      byte[] data = baos.toByteArray();

      try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
          copy = (SerializablePerson) ois.readObject();
        }
      }
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }

    Assert.equals(original.getName().toLowerCase(), copy.getName());
    Assert.equals(original.getAge() + 1, copy.getAge());
  }

  /** Classe SerializablePerson para demonstração de serialização. */
  static class SerializablePerson implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    /**
     * Construtor que define o nome e a idade.
     *
     * @param name o nome da pessoa.
     * @param age a idade da pessoa.
     */
    public SerializablePerson(String name, int age) {
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
  }
}
