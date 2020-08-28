package Lesson_2;

public class ArraySize {

    public void myArray(String [][] arr1) throws MyArrayDataException,MyArraySizeException{

            if (arr1.length != 4 || arr1[0].length != 4 || arr1[1].length != 4|| arr1[2].length != 4 || arr1[3].length != 4) {
                throw new MyArrayDataException();
            }
            int summ = 0;

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1.length; j++) {

                   try {
                       summ += Integer.parseInt(arr1[i][j]);
                        new NumberFormatException();
                   } catch (NumberFormatException e) {
                       throw new MyArraySizeException();
                   }

                    System.out.println(summ);
                }

            }

    };
}
