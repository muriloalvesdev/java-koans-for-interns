package com.koans.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Este runner procura por métodos anotados com @Koan nas classes localizadas no pacote
 * especificado, os executa e exibe os resultados com um visual aprimorado, utilizando cores ANSI e
 * separadores. Se um teste falhar, a execução é interrompida e um resumo final é exibido.
 *
 * <p>Opcionalmente, você pode passar o nome de um método ou uma descrição como argumento para
 * executar somente aquele teste. Exemplo: mvn exec:java
 * -Dexec.mainClass="com.koans.framework.KoanRunner" -Dexec.args="testexceptionHandling" (a busca é
 * case-insensitive)
 */
public class KoanRunner {

  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_CYAN = "\u001B[36m";
  private static final String ANSI_BOLD = "\u001B[1m";

  /**
   * Método principal para executar os testes Koan.
   *
   * @param args argumentos da linha de comando. Se um argumento for passado, ele é interpretado
   *     como o nome ou descrição do método a ser executado.
   */
  public static void main(String[] args) {
    clearScreen();
    printHeader();

    String target = args.length > 0 ? args[0].trim() : null;
    if (target != null && !target.isEmpty()) {
      System.out.println(
          ANSI_BOLD
              + ANSI_YELLOW
              + "Modo individual: executando somente os testes que correspondem a '"
              + target
              + "'"
              + ANSI_RESET);
    } else {
      target = null;
    }

    String testPackage = "com.koans";
    List<Class<?>> koanClasses = getKoanClasses(testPackage);

    if (koanClasses.isEmpty()) {
      System.out.println(
          ANSI_RED + "No Koan classes found in package: " + testPackage + ANSI_RESET);
      return;
    }

    int totalTests = 0;
    int passedTests = 0;
    boolean failureOccurred = false;
    long totalStartTime = System.nanoTime();

    outer:
    for (Class<?> clazz : koanClasses) {
      try {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
          if (method.isAnnotationPresent(Koan.class)) {
            String methodName = method.getName();
            String methodDesc = method.getAnnotation(Koan.class).value();
            if (target != null
                && !(methodName.equalsIgnoreCase(target)
                    || (!methodDesc.isEmpty() && methodDesc.equalsIgnoreCase(target)))) {
              continue;
            }
            totalTests++;
            String testTitle =
                (methodDesc == null || methodDesc.isEmpty()) ? methodName : methodDesc;
            printTestHeader(testTitle);

            long testStartTime = System.nanoTime();
            try {
              method.invoke(instance);
              long testEndTime = System.nanoTime();
              long testDuration = (testEndTime - testStartTime) / 1_000_000;
              printSuccess(testDuration);
              passedTests++;
            } catch (Exception e) {
              long testEndTime = System.nanoTime();
              long testDuration = (testEndTime - testStartTime) / 1_000_000;
              printFailure(e.getCause(), testDuration);
              failureOccurred = true;
              break outer;
            }
          }
        }
      } catch (Exception e) {
        System.out.println(
            ANSI_RED
                + "Error instantiating class "
                + clazz.getName()
                + ": "
                + e.getMessage()
                + ANSI_RESET);
        failureOccurred = true;
        break;
      }
    }

    long totalEndTime = System.nanoTime();
    long totalDuration = (totalEndTime - totalStartTime) / 1_000_000;
    printSummary(totalTests, passedTests, totalDuration);

    if (failureOccurred) {
      System.out.println(ANSI_RED + "\nExecution halted due to a test failure." + ANSI_RESET);
      System.exit(1);
    }
  }

  /** Limpa a tela do console. */
  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /** Imprime o cabeçalho principal com ASCII art. */
  private static void printHeader() {
    System.out.println(ANSI_BOLD + ANSI_CYAN);
    System.out.println("==================================================");
    System.out.println("           JAVA KOANS FOR INTERNS");
    System.out.println("==================================================");
    System.out.println(ANSI_RESET);
  }

  /**
   * Imprime o cabeçalho de um teste.
   *
   * @param title Título ou descrição do teste.
   */
  private static void printTestHeader(String title) {
    System.out.println(ANSI_CYAN + ANSI_BOLD + "\n>> Executing: " + title + ANSI_RESET);
  }

  /**
   * Imprime uma mensagem de sucesso com o tempo de execução.
   *
   * @param duration Tempo de execução em milissegundos.
   */
  private static void printSuccess(long duration) {
    System.out.println(ANSI_GREEN + ">> SUCCESS!" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "   Execution time: " + duration + " ms" + ANSI_RESET);
    System.out.println("--------------------------------------------------");
  }

  /**
   * Imprime uma mensagem de falha com o motivo e o tempo de execução.
   *
   * @param cause Causa da falha.
   * @param duration Tempo de execução em milissegundos.
   */
  private static void printFailure(Throwable cause, long duration) {
    System.out.println(ANSI_RED + ">> FAILURE! Reason: " + cause + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "   Execution time: " + duration + " ms" + ANSI_RESET);
    System.out.println("--------------------------------------------------");
  }

  /**
   * Imprime um resumo final da execução dos testes.
   *
   * @param total Total de testes executados.
   * @param passed Total de testes aprovados.
   * @param totalDuration Tempo total de execução em milissegundos.
   */
  private static void printSummary(int total, int passed, long totalDuration) {
    System.out.println(ANSI_BOLD + ANSI_YELLOW);
    System.out.println("\n==================================================");
    System.out.println("               TEST SUMMARY");
    System.out.println("==================================================");
    System.out.println("Total tests executed: " + total);
    System.out.println("Tests passed:         " + passed);
    System.out.println("Tests failed:         " + (total - passed));
    System.out.println("Total execution time: " + totalDuration + " ms");
    System.out.println("==================================================" + ANSI_RESET);
  }

  /**
   * Procura por classes no pacote especificado que contenham métodos anotados com @Koan.
   *
   * @param packageName Nome do pacote a ser escaneado.
   * @return Lista de classes que possuem testes Koan.
   */
  private static List<Class<?>> getKoanClasses(String packageName) {
    List<Class<?>> classes = new ArrayList<>();
    String path = packageName.replace('.', '/');
    URL packageUrl = Thread.currentThread().getContextClassLoader().getResource(path);
    if (packageUrl == null) {
      return classes;
    }
    File directory = new File(packageUrl.getFile());
    if (!directory.exists()) {
      return classes;
    }
    File[] files = directory.listFiles();
    if (files == null) {
      return classes;
    }
    for (File file : files) {
      String fileName = file.getName();
      if (fileName.endsWith(".class")) {
        String className = packageName + "." + fileName.substring(0, fileName.length() - 6);
        try {
          Class<?> clazz = Class.forName(className);
          for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Koan.class)) {
              classes.add(clazz);
              break;
            }
          }
        } catch (ClassNotFoundException e) {
          System.out.println(ANSI_RED + "Class not found: " + className + ANSI_RESET);
        }
      }
    }
    return classes;
  }
}
