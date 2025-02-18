package com.koans.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Runner para executar os testes Koan. Esse runner busca por métodos anotados com @Koan nas classes
 * localizadas em um pacote específico e os executa. Se um teste falhar, os demais não serão
 * executados. As saídas no console serão coloridas utilizando códigos ANSI. Além disso, exibe o
 * tempo de execução de cada teste e o tempo total de execução.
 */
public class KoanRunner {

  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_YELLOW = "\u001B[33m";
  private static final String ANSI_CYAN = "\u001B[36m";

  /**
   * Método principal para executar os testes Koan.
   *
   * @param args argumentos da linha de comando.
   */
  public static void main(String[] args) {
    String testPackage = "com.koans";
    List<Class<?>> koanClasses = getKoanClasses(testPackage);

    if (koanClasses.isEmpty()) {
      System.out.println(
          ANSI_RED + "Nenhuma classe de Koan encontrada no pacote: " + testPackage + ANSI_RESET);
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
            totalTests++;
            Koan annotation = method.getAnnotation(Koan.class);
            String description = annotation.value();
            System.out.println(
                ANSI_CYAN
                    + "Executando: "
                    + (description.isEmpty() ? method.getName() : description)
                    + ANSI_RESET);

            long testStartTime = System.nanoTime();
            try {
              method.invoke(instance);
              long testEndTime = System.nanoTime();
              long testDuration = (testEndTime - testStartTime) / 1_000_000; // em milissegundos
              System.out.println(ANSI_GREEN + ">> SUCESSO!!" + ANSI_RESET);
              System.out.println(
                  ANSI_YELLOW + "Tempo de execução: " + testDuration + " ms" + ANSI_RESET);
              System.out.println(
                  "________________________________________________________________");
              passedTests++;
            } catch (Exception e) {
              long testEndTime = System.nanoTime();
              long testDuration = (testEndTime - testStartTime) / 1_000_000;
              System.out.println(ANSI_RED + ">> Falhou! Motivo: " + e.getCause() + ANSI_RESET);
              System.out.println(
                  ANSI_YELLOW + "Tempo de execução: " + testDuration + " ms" + ANSI_RESET + "\n");
              failureOccurred = true;
              break outer;
            }
          }
        }
      } catch (Exception e) {
        System.out.println(
            ANSI_RED
                + "Erro ao instanciar a classe "
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

    System.out.println(ANSI_YELLOW + "Total de testes executados: " + totalTests + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "Testes aprovados: " + passedTests + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "Testes falhados: " + (totalTests - passedTests) + ANSI_RESET);
    System.out.println(
        ANSI_YELLOW + "Tempo total de execução: " + totalDuration + " ms" + ANSI_RESET);

    if (failureOccurred) {
      System.out.println(
          ANSI_RED + "\nInterrompendo a execução devido a uma falha em um teste." + ANSI_RESET);
    }
  }

  /**
   * Procura por classes no pacote especificado que contenham métodos anotados com @Koan.
   *
   * @param packageName o nome do pacote a ser escaneado.
   * @return uma lista de classes que possuem testes Koan.
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
          System.out.println(ANSI_RED + "Classe não encontrada: " + className + ANSI_RESET);
        }
      }
    }
    return classes;
  }
}
