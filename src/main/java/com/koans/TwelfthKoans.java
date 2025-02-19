package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Este conjunto de testes aborda a implementação de uma estrutura de dados personalizada: uma Stack
 * (pilha).
 */
public class TwelfthKoans {

  /** Testa as operações básicas de uma Stack personalizada. */
  @Koan("Teste de Stack personalizada")
  public void testCustomStack() {
    CustomStack<Integer> stack = new CustomStack<>();
    // A stack deve estar vazia inicialmente
    Assert.equals(0, stack.size());
    // Empilha elementos
    stack.push(10);
    stack.push(20);
    stack.push(30);
    Assert.equals(3, stack.size());
    // Testa o peek (topo da stack)
    Assert.equals(20, stack.peek());
    // Testa o pop
    int popped = stack.pop();
    Assert.equals(10, popped);
    Assert.equals(1, stack.size());
  }

  /**
   * Classe CustomStack que implementa uma pilha usando ArrayList.
   *
   * @param <T> o tipo de elementos da pilha.
   */
  class CustomStack<T> {
    private List<T> list = new ArrayList<>();

    /**
     * Adiciona um elemento no topo da pilha.
     *
     * @param element o elemento a ser adicionado.
     */
    public void push(T element) {
      list.add(element);
    }

    /**
     * Remove e retorna o elemento do topo da pilha.
     *
     * @return o elemento removido.
     * @throws EmptyStackException se a pilha estiver vazia.
     */
    public T pop() {
      if (list.isEmpty()) {
        throw new EmptyStackException();
      }
      return list.remove(list.size() - 1);
    }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     *
     * @return o elemento no topo.
     * @throws EmptyStackException se a pilha estiver vazia.
     */
    public T peek() {
      if (list.isEmpty()) {
        throw new EmptyStackException();
      }
      return list.get(list.size() - 1);
    }

    /**
     * Retorna o número de elementos na pilha.
     *
     * @return o tamanho da pilha.
     */
    public int size() {
      return list.size();
    }
  }
}
