package pk_locks;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agnieszka
 */
public class Buffer implements IBuffer{
   private final Lock lock = new ReentrantLock();
   private final Condition producers  = lock.newCondition(); 
   private final Condition consumers = lock.newCondition(); 

   private final int[] buffer = new int[10];
   private static int indexPut = 0, indexGet = 0;
   private int in = 0;

   @Override
   public void put(int v) {
        lock.lock();
        try {
            while (in == 10) producers.await();
            buffer[indexPut] = v;
            indexPut = (indexPut +1) % 10;
            in++;
            consumers.signalAll();
        } catch (InterruptedException ex) { 
            System.out.println(" producer interrupted");
        } finally {
            lock.unlock();
        }
   }

   @Override
   public int get() {
        int temp = 0;
        lock.lock();
        try {
            while (in == 0) consumers.await();
            temp = buffer[indexGet];
            indexGet = (indexGet +1) % 10;
            in--;
            producers.signalAll();
        } catch (InterruptedException ex) { 
            System.out.println(" consumer interrupted");
        } finally {
            lock.unlock();
        }
        return temp;
    }
}
