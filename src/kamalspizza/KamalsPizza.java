/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kamalspizza;

/**
 *
 * @author Yasanka Jayawardane
 */
public class KamalsPizza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SharedData sharedData = new SharedData();
        KamalThread kThread = new KamalThread(sharedData, 5);
        StudentThread stuThread1 = new StudentThread(sharedData);
        StudentThread stuThread2 = new StudentThread(sharedData);
        StudentThread stuThread3 = new StudentThread(sharedData);
        
        kThread.start();
        stuThread1.start();
        stuThread2.start();
        stuThread3.start();
    }

}

