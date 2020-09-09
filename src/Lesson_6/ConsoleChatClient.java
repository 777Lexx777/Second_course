package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleChatClient {
    private DataInputStream in;
    private DataOutputStream out;
    // private JTextArea charArea;
    Scanner scanner = new Scanner(System.in);

    //public ConsoleChatClient() {}
    public static void main(String[] args) {
        new ConsoleChatClient();
    }

    public ConsoleChatClient() {
       // this.charArea = charArea;
        final String[] a = new String[1];
        final String[] x = new String[1];

        try {
            Socket socket = new Socket("127.0.0.1", 18443);
            System.out.println("Client info: " + socket);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        try {
                        synchronized (a) {
                            a[0] = in.readUTF();
                            System.out.println("\n" + a[0] + "\n");
                        }
                        }catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                        while (true) {
                            String y = in.readUTF();
                            if(y.length() > 25) {
                                int limit = 25;
                                String subStr = y.codePointCount(0, y.length()) > limit ?
                                        y.substring(0, y.offsetByCodePoints(0, limit)) : y;
                                System.out.println("\n" +subStr + "\n");
                               continue;
                            }System.out.printf("\n" +y + "\n");
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
                    synchronized (a) {
                        try {
                            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                            System.out.println("                       Enter your massage for server");
                            while (true) {

                                x[0] = scanner.next();
                                System.out.println("                          For server - "   +   x[0]);
                                out.writeUTF("Client " + x[0]);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
                in.close();
            }
            catch (NullPointerException e) {
                //e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }
}
