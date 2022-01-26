/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_locks;

/**
 *
 * @author Agnieszka
 */
public class PK_locks {

    /**
     * @param args the command line arguments
     */
    static Buffer buffer = new Buffer();
    public static void main(String[] args) {
       Producer producer = new Producer();
       Consumer consumer = new Consumer();
       Worker p1 = new Worker();
       Worker p2 = new Worker();
       Worker p3 = new Worker();
       Worker c1 = new Worker();
       Worker c2 = new Worker();
       Worker c3 = new Worker();
       
       p1.execute(producer);
       p2.execute(producer);
       p3.execute(producer);
       c1.execute(consumer);
       c2.execute(consumer);
       c3.execute(consumer);
    }
    
}
