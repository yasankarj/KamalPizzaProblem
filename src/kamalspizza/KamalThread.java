/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kamalspizza;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasanka Jayawardane
 */
public class KamalThread extends Thread {

    SharedData sharedData;
    int S = 0;

    public KamalThread(SharedData sharedData , int S) {
        this.sharedData = sharedData;
        this.S = S;
    }

    @Override
    public void run() {
        while (sharedData.isWorking) {
            try {
                sharedData.pizza_deliver.acquire();
		bringPizza();
		sharedData.mutex.acquire();
		sharedData.num_slices.set(S);
		sharedData.mutex.release();
		
                for (int i = 0; i < S; i++) {
                    sharedData.pizza.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void bringPizza() throws InterruptedException {
        System.out.println(this.getId() + " Kamal bought Pizza");
    }
}
