package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import java.util.ArrayList;
import java.util.List;

/**
 * Este conjunto de testes aborda o padrão Observer, onde um objeto notifica outros objetos sobre
 * mudanças de estado.
 */
public class TwentiethKoans {

  /** Testa o padrão Observer, verificando se os Observers são notificados. */
  @Koan("Teste do padrão Observer")
  public void testObserverPattern() {
    Subject subject = new Subject();

    TestObserver observer1 = new TestObserver();
    TestObserver observer2 = new TestObserver();

    subject.registerObserver(observer1);
    subject.registerObserver(observer2);

    subject.setState("Updated");

    Assert.equals("Updated", observer1.getState());
    Assert.equals("Updated", observer2.getState());
  }

  /** Interface Observer para receber atualizações. */
  interface Observer {
    /**
     * Atualiza o estado do observer.
     *
     * @param state o novo estado.
     */
    void update(String state);
  }

  /** Classe Subject que gerencia observers e notifica mudanças de estado. */
  class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    /**
     * Registra um observer.
     *
     * @param observer o observer a ser registrado.
     */
    public void registerObserver(Observer observer) {
      observers.add(observer);
    }

    /**
     * Define um novo estado e notifica os observers.
     *
     * @param state o novo estado.
     */
    public void setState(String state) {
      this.state = state;
      notifyObservers();
    }

    /** Notifica todos os observers sobre a mudança de estado. */
    private void notifyObservers() {
      for (Observer observer : observers) {
        observer.update(state);
      }
    }
  }

  /** Implementação de Observer para testes. */
  class TestObserver implements Observer {
    private String state;

    /**
     * Retorna o estado atual do observer.
     *
     * @return o estado.
     */
    public String getState() {
      return state;
    }

    /**
     * Atualiza o estado do observer.
     *
     * @param state o novo estado.
     */
    @Override
    public void update(String state) {
      this.state = state;
    }
  }
}
