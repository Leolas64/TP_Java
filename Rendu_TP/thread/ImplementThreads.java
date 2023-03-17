package Rendu_TP.thread;

import java.util.ArrayList;

public class ImplementThreads implements Runnable {
    int number = 0;
    int count = 0;
    ArrayList<Thread> listeThread = new ArrayList<Thread>();

    public ImplementThreads(int num) {
        this.number = num;
    }
    public void createThread(int n){
        for(int i = 0; i < n; i++){
            ImplementThreads runnableLeader = new ImplementThreads(count);
            Thread threadLeader = new Thread(runnableLeader);
            listeThread.add(threadLeader);
            if (i < 10) {
                threadLeader.setPriority(Thread.MIN_PRIORITY + i);
                System.out.println("Niveau de priorite du thread "+count+" : " + threadLeader.getPriority());
                System.out.println("Id du thread : " + threadLeader.getId());
            }
            threadLeader.start();
            count +=1;
        }
    }
    @Override
    public void run() {

        for(int n = 0; n < 4; n++){
            System.out.println("hello "+number+" "+n);
        }
    }

    public void killThreadById(long id){
        for (Thread idThread : listeThread) {
            long num_thread = idThread.getId();
            if ( num_thread == id) {
                idThread.interrupt();
                listeThread.remove(idThread);
                System.out.println("Le thread d'index "+ id + " a été tué");
                break;
            }
        }
    }

    public void killRemainThreads(){
        for (Thread idThread : listeThread) {
            idThread.interrupt();
        }
        listeThread.clear();
        System.out.println("Tous les threads on été tués");
    }

}