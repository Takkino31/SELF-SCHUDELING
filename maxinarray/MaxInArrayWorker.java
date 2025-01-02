package maxinarray;

public class MaxInArrayWorker implements Runnable {
    private final int[] tab;
    int max = 0;
    public MaxInArrayWorker(int[] tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        System.out.println("Max in array worker started : " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        for (int j : tab) {
            if (j > max) {
                max = j;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Max in array worker finished : " + Thread.currentThread().getName()+ " MAX = "+ getMax() + " " + " took " + (endTime - startTime) + " ms");
    }

    public int getMax() {
        return max;
    }
}
