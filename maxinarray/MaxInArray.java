package maxinarray;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class MaxInArray {
    static int [] tabInt;
    static int maxInt= 0;
    static LinkedList<Integer> maxLinkedList = new LinkedList<>();

    public static void initTabInt() {
        tabInt = new int[1000];
        for (int i = 0; i < tabInt.length; i++) {
            tabInt[i] = (int) (Math.random() * 1000+1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        initTabInt();

        int iteration_size = 100;
        int nbr_threads = tabInt.length % iteration_size > 0 ? (tabInt.length / iteration_size) + 1 : (tabInt.length / iteration_size);

        Thread[] threads = new Thread[nbr_threads];
        MaxInArrayWorker[] workers = new MaxInArrayWorker[nbr_threads];

        for (int i = 0; i < nbr_threads; i++) {
            int start = i*iteration_size ;
            int end = i == (nbr_threads - 1 )? tabInt.length: (i+1)*iteration_size - 1;;

            int[] tab = Arrays.copyOfRange(tabInt,start,end);
            workers[i] = new MaxInArrayWorker(tab);
            threads[i] = new Thread(workers[i]);
            threads[i].setName("MAX IN ARRAY WORKER -" + i);
            threads[i].start();
        }

        for (int i = 0; i < nbr_threads; i++) {
            threads[i].join();
            maxLinkedList.add(workers[i].getMax());
        }

        System.out.println("Le max des elements du tableau est " + Collections.max(maxLinkedList));
    }


}
