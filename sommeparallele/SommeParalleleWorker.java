package sommeparallele;

public class SommeParalleleWorker implements Runnable {

    int [] tab;
    int sum = 0;
    public SommeParalleleWorker(int[] tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        System.out.println("SommeParalleleWorker started by " + Thread.currentThread().getName());
        for (int i : tab) {
            sum += i;
        }
        System.out.println("SommeParalleleWorker finished by " + Thread.currentThread().getName());
    }

    public int getSum() {
        return sum;
    }
}
