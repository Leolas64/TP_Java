package Rendu_TP.thread;

//Question 1 :
/* Le thread lié au compteur "1" a une priorité plus élevée et a donc plus de possibilités d'incrémenter son compteur
 * Alors que le thread lié au compteur "0" a pour une même exécution des possibilités parrallèles
 * Il est aussi possible que la puissance du processeur ait influencé le nombre d'incrémentation du compteur "1" comparé au compteur "0"
 *
 * Runnable est une interface qui contient une seule méthode : run.
 * Runnable permet entre autre de créer des thread. Pour cela, elle doit être implémenté par une autre classe.
 * */


public class Main {
    public static void main(String[] args){
        ImplementThreads runnableThreadFirst = new ImplementThreads(0);
        Thread num1 = new Thread(runnableThreadFirst);
        num1.start();

        ImplementThreads runnableThreadSecond = new ImplementThreads(1);
        Thread num2 = new Thread(runnableThreadSecond);
        num2.start();
    }
}