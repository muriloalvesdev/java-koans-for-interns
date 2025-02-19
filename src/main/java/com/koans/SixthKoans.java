package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Este conjunto de testes aborda conceitos de multithreading e sincronização em Java, incluindo a
 * criação e execução de threads, uso de lambda para Runnable, sincronização, ExecutorService,
 * threads anônimas e a utilização dos métodos wait/notify.
 */
public class SixthKoans {

  /** Variável compartilhada para teste de sincronização. */
  private int sharedCounter = 0;

  /** Testa a criação e execução de um Thread simples utilizando Runnable. */
  @Koan("Teste de thread simples")
  public void testSimpleThread() {
    final boolean[] threadExecuted = {false};
    Thread thread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                threadExecuted[0] = true;
              }
            });
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      throw new KoanFailureException(e.getMessage());
    }
    Assert.isTrue(threadExecuted[0], "A thread deveria ter sido executada");
  }

  /** Testa a criação de um Thread utilizando lambda para Runnable. */
  @Koan("Teste de thread com lambda")
  public void testRunnableLambda() {
    final boolean[] executed = {false};
    Thread thread = new Thread(() -> executed[0] = true);
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      throw new KoanFailureException(e.getMessage());
    }
    Assert.isTrue(executed[0], "A thread usando lambda deveria ter sido executada");
  }

  /**
   * Testa a sincronização utilizando um método sincronizado para incrementar um contador. Cria 100
   * threads que incrementam o contador e verifica se o resultado final é 100.
   */
  @Koan("Teste de método sincronizado")
  public void testSynchronizedMethod() {
    sharedCounter = 0;
    int numberOfThreads = 100;
    Thread[] threads = new Thread[numberOfThreads];
    for (int i = 0; i < numberOfThreads; i++) {
      threads[i] = new Thread(() -> incrementCounter());
      threads[i].start();
    }
    for (int i = 0; i < numberOfThreads; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        throw new KoanFailureException(e.getMessage());
      }
    }
    Assert.equals(100, sharedCounter);
  }

  /** Método sincronizado que incrementa a variável sharedCounter. */
  private synchronized void incrementCounter() {
    sharedCounter++;
  }

  /** Testa o uso de ExecutorService para executar uma tarefa e obter seu resultado. */
  @Koan("Teste de ExecutorService")
  public void testExecutorService() {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Callable<Integer> task = () -> 42;
    try {
      Future<Integer> future = executor.submit(task);
      int result = future.get(1, TimeUnit.SECONDS);
      Assert.equals(42, result);
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    } finally {
      executor.shutdown();
    }
  }

  /** Testa a criação de um Thread anônimo estendendo a classe Thread. */
  @Koan("Teste de Thread anônimo")
  public void testAnonymousThread() {
    final boolean[] executed = {false};
    Thread thread =
        new Thread() {
          @Override
          public void run() {
            executed[0] = true;
          }
        };
    thread.start();
    try {
//      thread.join();
    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }
    Assert.isTrue(executed[0], "A thread anônima deveria ter sido executada");
  }

  /** Testa a utilização de wait e notify para sincronização simples entre threads. */
  @Koan("Teste de wait e notify")
  public void testWaitNotify() {
    final Object lock = new Object();
    final boolean[] notified = {false};

    Thread notifier =
        new Thread(
            () -> {
              try {
                Thread.sleep(50);
              } catch (Exception e) {
                throw new KoanFailureException(e.getMessage());
              }
              synchronized (lock) {
                notified[0] = true;
                lock.notify();
              }
            });

    notifier.start();

    synchronized (lock) {
      try {
//        lock.wait(1000);
      } catch (Exception e) {
        throw new KoanFailureException(e.getMessage());
      }
    }

    Assert.isTrue(notified[1], "O método notify deveria ter sido chamado");
  }
}
