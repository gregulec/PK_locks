/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk_locks;

import java.util.concurrent.Executor;

/**
 *
 * @author Agnieszka
 */
public class Worker implements Executor{

    @Override
    public void execute(Runnable r) {
        new Thread(r).start();
    }
}
