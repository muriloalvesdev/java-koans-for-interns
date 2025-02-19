package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/** Esta classe demonstra o uso de anotações avançadas e seu processamento por reflexão. */
public class ThirtyFourthKoansAnnotations {

  /** Testa se os métodos anotados com @AdvancedTest possuem o atributo 'info' preenchido. */
  @Koan("Teste de processamento de anotações avançadas")
  public void testAdvancedAnnotationsProcessing() {
    int count = 0;
    try {
      for (Method method : this.getClass().getDeclaredMethods()) {
        if (method.isAnnotationPresent(AdvancedTest.class)) {
          AdvancedTest annotation = method.getAnnotation(AdvancedTest.class);
          if (!annotation.info().isEmpty()) {
            count++;
          }
        }
      }
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }
    Assert.equals(4, count);
  }

  /** Método dummy anotado para demonstração. */
  @AdvancedTest(info = "Primeiro teste avançado")
  public void dummyTest1() {
    // método dummy
  }

  /** Segundo método dummy anotado para demonstração. */
  @AdvancedTest(info = "Segundo teste avançado")
  public void dummyTest2() {
    // método dummy
  }

  /** Anotação personalizada para testes avançados. */
  @Retention(RetentionPolicy.RUNTIME)
  public @interface AdvancedTest {
    /**
     * Informação adicional sobre o teste.
     *
     * @return uma string com informações.
     */
    String info() default "";
  }
}
