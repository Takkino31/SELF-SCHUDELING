package matriceparallele;


public class Matrice {
    static int [][] matrice;
    static int nbrRow, nbrCel;
    static int sum = 0;
    static double product;

    public static void main(String[] args) throws InterruptedException {
        createMatrice();
        Thread[] threads = new Thread[nbrRow];
        MatriceWorker[] workers = new MatriceWorker[nbrRow];
        for (int i = 0; i < nbrRow; i++) {
            int [] tab = new int[nbrCel];
            System.arraycopy(matrice[i], 0, tab, 0, nbrCel);
            workers[i] = new MatriceWorker(tab);
            threads[i] = new Thread(workers[i]);
            threads[i].setName("MATRICE WORKER - " + i);
            threads[i].start();
        }

        for (int i = 0; i < nbrRow; i++) {
            threads[i].join();
        }

        for (int i = 0; i < nbrRow; i++) {
            sum += workers[i].getSumRow();
            product *= workers[i].getProductRow();
        }

        System.out.println("La somme des elements de la matrice est " + sum);
        System.out.println("Le produit des elements de la matrice est " + product);
    }

    public static void createMatrice() {
        nbrRow = (int) (Math.random()* 4 ) + 2;
        nbrCel = (int) (Math.random()* 4 ) + 2;
        matrice = new int[nbrRow][nbrCel];
        for (int i = 0; i < nbrRow; i++) {
            for (int j = 0; j < nbrCel; j++) {
                matrice[i][j] = (int) (Math.random()* 10);
                System.out.print(" " + matrice[i][j]);
            }
            System.out.println();
        }
    }
}
