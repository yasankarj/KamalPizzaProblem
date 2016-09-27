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
public class StudentThread extends Thread {

    SharedData sharedData;

    StudentThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.isStudying) {
            try {
                this.sharedData.pizza.acquire();
                this.sharedData.mutex.acquire();
                this.sharedData.num_slices.decrementAndGet();
                if (this.sharedData.num_slices.get() == 0) {
                    System.out.println("Pizza finished. Student "+this.getId()+" calls Kamal");
                    this.sharedData.pizza_deliver.release();
                }
                this.sharedData.mutex.release();
                eatAndStudy();
            } catch (InterruptedException ex) {
                Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void eatAndStudy() throws InterruptedException {
        System.out.println(this.getId() + " student eats and study");
        Thread.sleep(100);
        System.out.println(this.getId() + " students finished his pizza");
    }
}