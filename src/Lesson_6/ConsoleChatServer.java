package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//1. Написать консольный вариант клиент\серверного приложения,
//   в котором пользователь может писать сообщения, как на клиентской стороне, так и на серверной.
//   Т.е. если на клиентской стороне написать "Привет", нажать Enter то сообщение должно передаться на сервер
//   и там отпечататься в консоли. Если сделать то же самое на серверной стороне, сообщение соответственно
//   передается клиенту и печатается у него в консоли. Есть одна особенность, которую нужно учитывать:
//   клиент или сервер может написать несколько сообщений подряд, такую ситуацию необходимо корректно обработать
//   Разобраться с кодом с занятия, он является фундаментом проекта-чата
//   ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл,
//   который будет ожидать второго/третьего/n-го клиентов
public class ConsoleChatServer {
    private DataInputStream in;
    private DataOutputStream out;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new ConsoleChatServer();
    }
    public ConsoleChatServer() {
        final String[] x = new String[1];

        try {
            System.out.println("Server is starting up...");
            ServerSocket serverSocket = new ServerSocket(18443);
            System.out.println("Server waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                            while (true) {
                                String message = in.readUTF();
                                System.out.println(message + "\n\10");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            out.writeUTF("Hello i'am your server: ");
                            System.out.println("                          Enter your massage for client");

                            while (true) {
                                x[0] = scanner.next();
                                System.out.println("                          For client - "   +   x[0]);
                                out.writeUTF("Server "  + x[0]);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e) {
                //e.printStackTrace();
            }
        }
    }
}
