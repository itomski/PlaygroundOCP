package de.lubowiecki.oca.playground.threads;

import java.awt.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println("Barierre gebrochen... weiter geht's!"));

        Ranger r1 = new Ranger(new Point(5, 10), new Point(80,35), barrier);
        Ranger r2 = new Ranger(new Point(-20, -20), new Point(40,15), barrier);

        new Thread(r1).start();
        new Thread(r2).start();
    }
}

class Ranger implements Runnable {

    private Point curPos = new Point();

    private Point target1;

    private Point target2;

    private CyclicBarrier barrier;

    public Ranger(Point target1, Point target2, CyclicBarrier barrier) {
        this.target1 = target1;
        this.target2 = target2;
        this.barrier = barrier;
    }

    @Override
    public void run() {

        try {
            while(!move(target1)) {
                Thread.sleep(500);
            }

            System.out.println(Thread.currentThread().getName() + " erstes Ziel erreicht");
            barrier.await();

            if(barrier.isBroken()) // Eine gebruchene Barriere wird neu aufgestellt
                barrier.reset();

            while(!move(target2)) {
                Thread.sleep(500);
            }
            System.out.println(Thread.currentThread().getName() + " zweites Ziel erreicht");
            barrier.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public boolean move(Point target) {

        if(curPos.x < target.x)
            curPos.x++;

        if(curPos.x > target.x)
            curPos.x--;

        if(curPos.y < target.y)
            curPos.y++;

        if(curPos.y > target.y)
            curPos.y--;

        System.out.println(Thread.currentThread().getName() + " " + curPos + " --> " + target);

        return curPos.equals(target);

    }
}
