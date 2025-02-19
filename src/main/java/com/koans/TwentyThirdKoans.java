package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.lang.reflect.Method;

/** Este conjunto de testes demonstra conceitos básicos de reflexão em Java. */
public class TwentyThirdKoans {

  /** Testa a criação dinâmica de um objeto e a invocação de um método usando Reflection. */
  @Koan("Teste de reflexão")
  public void testReflection() {
    try {
      Class<?> clazz = ReflectionDemo.class;
      Object instance = clazz.getDeclaredConstructor().newInstance();
      Method method = clazz.getDeclaredMethod("sayHello", String.class);
      String result = (String) method.invoke(instance, "Intern");
      Assert.equals("Hello Intern!", result);
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }
  }

  /** Classe de demonstração para reflexão. */
  public static class ReflectionDemo {

    /**
     * Método que retorna uma saudação personalizada.
     *
     * @param name o nome a ser saudado.
     * @return a saudação.
     */
    public String sayHello(String name) {
      return "Hello, " + name + "!";
    }
  }
}
