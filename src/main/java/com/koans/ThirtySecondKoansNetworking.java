package com.koans;

import com.koans.framework.Assert;
import com.koans.framework.Koan;
import com.koans.framework.KoanFailureException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/** Esta classe demonstra operações básicas de networking usando TCP. */
public class ThirtySecondKoansNetworking {

  /** Testa uma comunicação simples entre um servidor TCP e um cliente TCP. */
  @Koan("Teste de Networking: Comunicação TCP simples")
  public void testTCPCommunication() {
    final String[] clientResponse = {""};

    try (ServerSocket serverSocket = new ServerSocket(0)) {
      int port = serverSocket.getLocalPort();

      Thread serverThread = getServerThread(serverSocket);

      try (Socket clientSocket = new Socket("localhost", port);
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
          BufferedReader in =
              new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
        out.println("Hello Server");
        clientResponse[0] = in.readLine();
      }
      serverThread.join();

    } catch (Exception e) {
      throw new KoanFailureException(e.getMessage());
    }
    Assert.equals("Echo: Hello Server", clientResponse[0]);
  }

  private static Thread getServerThread(ServerSocket serverSocket) {
    Thread serverThread =
        new Thread(
            () -> {
              try (Socket socket = serverSocket.accept();
                  BufferedReader in =
                      new BufferedReader(new InputStreamReader(socket.getInputStream()));
                  PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String message = in.readLine();
                out.println("Echo: " + message);
              } catch (Exception e) {
                throw new KoanFailureException(e.getMessage());
              }
            });
    serverThread.start();
    return serverThread;
  }
}
