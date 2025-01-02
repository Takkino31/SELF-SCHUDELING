package sommeparallele;

import java.util.Arrays;

public class SommeParallele {

    static int [] tabInt ;
    final static int NUM_THREADS = 5;
    final static int ITERATION_SIZE = 20;
    static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        /*Initialisation du tableau*/
        initTabInt();

        System.out.println("La somme du tableau devrait etre "+  sommeParalleleNormal());

// Creation de tableau de 5 Threads et workers
        Thread[] threads = new Thread[NUM_THREADS];
        SommeParalleleWorker[] workers = new SommeParalleleWorker[NUM_THREADS];


        int totalSize = tabInt.length;
        int iterationSize = totalSize / NUM_THREADS; // Calculer la taille pour chaque thread

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * iterationSize;
            final int end = (i +1) * ITERATION_SIZE -1;
//            final int end = (i == NUM_THREADS - 1) ? totalSize : (i + 1) * iterationSize; // Le dernier thread prend le reste du tableau

            int[] tab = Arrays.copyOfRange(tabInt,start,end);

            workers[i] = new SommeParalleleWorker(tab);
            threads[i] = new Thread(workers[i]);
            threads[i].setName("SommeParalleleWorker-" + i);
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].join();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            sum += workers[i].getSum();
        }

        System.out.println("La somme du tableau est : "+  sum);

    }

    public static void initTabInt() {
        tabInt = new int[100];
        for (int i = 0; i < tabInt.length; i++) {
            tabInt[i] = (int) (Math.random() * 10) + 1;
        }
    }

    public static int sommeParalleleNormal() {
        int sum = 0;
        for (int j : tabInt) {
            sum += j;
        }
        return sum;
    }
}
