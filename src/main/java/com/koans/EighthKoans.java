package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;

/**
 * Este conjunto de testes aborda o uso de classes abstratas e a implementação de métodos abstratos.
 */
public class EighthKoans {

  /** Testa o cálculo da área de um círculo. */
  @Koan("Teste de área de círculo")
  public void testCircleArea() {
    Shape circle = new Circle(5);
    double area = circle.area();
    Assert.equals(78.53981633974483, area);
  }

  /** Testa o cálculo da área de um retângulo. */
  @Koan("Teste de área de retângulo")
  public void testRectangleArea() {
    Shape rectangle = new Rectangle(4, 6);
    double area = rectangle.area();
    Assert.equals(24.0, area);
  }

  /** Classe abstrata Shape que define a estrutura para formas geométricas. */
  abstract class Shape {
    /**
     * Calcula a área da forma.
     *
     * @return a área da forma.
     */
    abstract double area();
  }

  /** Classe Circle que estende Shape para representar um círculo. */
  class Circle extends Shape {
    private double radius;

    /**
     * Construtor que define o raio do círculo.
     *
     * @param radius o raio do círculo.
     */
    public Circle(double radius) {
      this.radius = radius;
    }

    /**
     * Calcula a área do círculo.
     *
     * @return a área do círculo.
     */
    @Override
    double area() {
      return Math.PI * radius * radius;
    }
  }

  /** Classe Rectangle que estende Shape para representar um retângulo. */
  class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * Construtor que define a largura e a altura do retângulo.
     *
     * @param width a largura do retângulo.
     * @param height a altura do retângulo.
     */
    public Rectangle(double width, double height) {
      this.width = width;
      this.height = height;
    }

    /**
     * Calcula a área do retângulo.
     *
     * @return a área do retângulo.
     */
    @Override
    double area() {
      return width * height;
    }
  }
}
