/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kamalspizza;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Yasanka Jayawardane
 */
public class SharedData {
    AtomicInteger num_slices = new AtomicInteger(5);
    Semaphore pizza = new Semaphore(0);
    Semaphore pizza_deliver = new Semaphore(1);
    Semaphore mutex = new Semaphore(1);
    boolean isStudying = true;
    boolean isWorking = true;
}

