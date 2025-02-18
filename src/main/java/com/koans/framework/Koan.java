package com.koans.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation para marcar um método como um teste Koan. Permite adicionar uma descrição opcional
 * para o teste.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Koan {
  /**
   * Descrição opcional do teste.
   *
   * @return descrição do teste.
   */
  String value() default "";
}
