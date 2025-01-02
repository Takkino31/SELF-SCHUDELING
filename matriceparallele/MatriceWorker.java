package matriceparallele;

public class MatriceWorker implements Runnable {
    int[] matrice;
    int sumRow = 0, productRow = 1;

    MatriceWorker(int[] matrice) {
        this.matrice = matrice;
    }


    @Override
    public void run() {
        System.out.println("MatriceWorker started : " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        for (int j : matrice){
            sumRow += j;
            productRow *= j;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("MatriceWorker finished : " + Thread.currentThread().getName()+ " SUM = "+ getSumRow() + " " + " took " + (endTime - startTime) + " ms");
        System.out.println("MatriceWorker finished : " + Thread.currentThread().getName()+ " PRODUCT = "+ getProductRow() + " " + " took " + (endTime - startTime) + " ms");
    }

    public int getSumRow() {
        return sumRow;
    }

    public int getProductRow() {
        return productRow;
    }
}
