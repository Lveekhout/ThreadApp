package nl.lveekhout.threadapp.threads;

/**
 * Created by leekhout on 18-2-2015.
 * class ScrollThread
 */

public class ScrollThread extends Thread {

    private double i = 0;
    public double x = 0;
    public double y = 0;

    @Override
    public void run() {
        try {
            while (true) {
                x = Math.sin(i);
                i += 0.1;
                if (i>Math.PI) i -= Math.PI;
                sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }
}