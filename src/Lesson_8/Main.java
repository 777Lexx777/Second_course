package Lesson_8;

public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

//        singlyLinkedList.add("Toyota");
//        singlyLinkedList.add("Honda");
//        singlyLinkedList.add("Subaru");
//        singlyLinkedList.add("Mazda");
//
//        System.out.println(singlyLinkedList);
//
//        singlyLinkedList.remove("Mazda");
//        System.out.println(singlyLinkedList);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add("Москва");
        doubleLinkedList.add("Пермь");
        doubleLinkedList.add("Уфа");
        doubleLinkedList.add("Казань");
        System.out.println("\n" + doubleLinkedList);
        doubleLinkedList.remove("Пермь");
        System.out.println("\n" + doubleLinkedList);

    }
}
