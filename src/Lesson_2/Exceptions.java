package Lesson_2;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Integer.parseInt(String.valueOf(1));
        Integer.parseInt("1");
        Integer.parseInt("1q");
        System.out.println("Switch engine on");
        try {
            new Airplane().doStabilityCheck();
        } finally {
            System.out.println("Switch engine off");
        }
    }
}
