package Lesson_2;
//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
//   при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
//   Если в каком-то элементе массива преобразование не удалось (например,
//   в ячейке лежит символ или текст вместо числа),
//   должно быть брошено исключение MyArrayDataException,
//   с детализацией в какой именно ячейке лежат неверные данные.

//3. В методе main() вызвать полученный метод,
//   обработать возможные исключения MySizeArrayException и MyArrayDataException,
//   и вывести результат расчета.

public class Main {

    public static void main(String[] args) {
        ArraySize arr2 = new ArraySize();

        try {
        String [][] arr1 = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1", "2", "3","k"},};

            arr2.myArray(arr1);
        }catch (MyArrayDataException e ) {
                throw new MyArrayDataException("Wrong size of the array ", e);

        }catch ( MyArraySizeException e) {
                throw new MyArraySizeException("Invalid array elementy  ", e);

        }finally {
            System.out.println("Program completed ");
        };
    }
}
