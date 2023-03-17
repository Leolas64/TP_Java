package Rendu_TP.thread;

import java.util.ArrayList;
import java.util.Scanner;


class ImplementThreads implements Runnable {
    int number = 0;
    int count = 0;
    public ImplementThreads(int num) {
        this.number = num;
    }
    public void createThread(int max){
        for(int i = 0; i < max; i++){
            ImplementThreads runnableThread = new ImplementThreads(count);
            Thread threader = new Thread(runnableThread);
            if (i < 10) {
                threader.setPriority(Thread.MIN_PRIORITY + i);
                System.out.println("Le thread "+count+" a pour niveau de priorité : " + threader.getPriority());
            }
            threader.start();
            count +=1;
        }
    }
    @Override
    public void run() {

        for(int i = 0; i < 4; i++){
            System.out.println("hello "+number+" "+i);
        }
    }
}