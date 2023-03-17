package Rendu_TP.thread;

import java.util.Scanner;

public class Main {
    //Part 1
    public static void main(String[] args) {
        //Part1
        ImplementThreads threadLeader = new ImplementThreads(0);
        Scanner numberThread = new Scanner(System.in);
        System.out.println("Combien de thread voulez-vous ?");
        int mesThreads = numberThread.nextInt();
        threadLeader.createThread(mesThreads);

        //Part2
        System.out.println("Entrez : 'kill ID' ou 'exit'");
        Scanner cin = new Scanner(System.in);
        String cmd = cin.nextLine();
        if (cmd.equals("kill ID")) {
            System.out.println("Entrez l'ID");
            long id = cin.nextInt();
            threadLeader.killThreadById(id);
        } else if (cmd.equals("exit")) {
            threadLeader.killRemainThreads();
        } else {
            System.out.println("Erreur, Choisir entre 'kill ID' ou 'exit'");
        }

    }
}