package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/** Este conjunto de testes aborda o uso de Timer e TimerTask para agendamento de tarefas. */
public class SeventeenthKoans {

  /** Testa o uso de Timer e TimerTask para executar uma tarefa após um atraso. */
  @Koan("Teste de Timer e TimerTask")
  public void testTimerTask() {
    AtomicBoolean taskExecuted = new AtomicBoolean(false);
    Timer timer = new Timer();
    TimerTask task =
        new TimerTask() {
          @Override
          public void run() {
            taskExecuted.set(true);
          }
        };

    timer.schedule(task, 100);

    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      throw new KoanFailureException(e.getMessage());
    }
    timer.cancel();
    Assert.isTrue(taskExecuted.get(), "A tarefa TimerTask deveria ter sido executada");
  }
}
