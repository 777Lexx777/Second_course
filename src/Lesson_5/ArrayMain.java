package Lesson_5;

public class ArrayMain {
    static final int size = 10000000;
    static final int h = size / 2;

    private static float[] arr1 = new float[size];
    private static float[] arr2 = new float[h];

    static void arrayOne(){
        long a = System.currentTimeMillis();
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = 1;
                arr1[i] = (float) (arr1[ i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        System.currentTimeMillis();
        System.out.println("\nCalculation per cycle  " + (System.currentTimeMillis() - a));
    }

        static void arrayTwo() {
            long a = System.currentTimeMillis();

            for (int j = 0; j < arr1.length; j++) { arr1[j] = 1; }

            System.arraycopy(arr1, 0, arr2, 0, h);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int q = 0; q < arr1.length / 2; q++) {
                        arr1[q] = (float) (arr1[q] * Math.sin(0.2f + q / 5) * Math.cos(0.2f + q / 5) * Math.cos(0.4f + q / 2));
                    }
                }
            }).start();

                for (int e = 0; e < arr2.length; e++) {
                    arr2[e] = (float) (arr2[e] * Math.sin(0.2f + e / 5) * Math.cos(0.2f + e / 5) * Math.cos(0.4f + e / 2));
                }
                System.arraycopy(arr2, 0, arr1, arr2.length-1, h);

                System.currentTimeMillis();
                System.out.println("\nTime calculation for splitting one array into 2 and calculating filling in two threads=  "
                                   + (System.currentTimeMillis() - a));
        }

    public static void main(String[] args) {
        arrayOne();
        arrayTwo();
    }
}
