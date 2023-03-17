package Rendu_TP.thread;

class ImplementThreads implements Runnable {
    int number;
    public ImplementThreads(int id) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 0; i < 4; i++){
            System.out.println("hello "+ number +" "+ i);
        }
    }
}