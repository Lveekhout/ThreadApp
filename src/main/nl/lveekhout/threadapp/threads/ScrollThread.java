package nl.lveekhout.threadapp.threads;

/**
 * Created by leekhout on 18-2-2015.
 * class ScrollThread
 */

public class ScrollThread extends Thread {

    public int sleepTime;
    private double smoothness;
    private double i = 0;
    public double x = 0;
    public double y = 1;

    public ScrollThread(int speed, int smoothness) {
        this.sleepTime = speed;
        this.smoothness = 1/(double)smoothness;
    }

    @Override
    public void run() {
        try {
            while (true) {
                x = Math.cos(i);
                y = Math.sin(i);
                i += smoothness;
                if (i>2*Math.PI) i -= 2*Math.PI;
                sleep(sleepTime);
            }
        } catch (InterruptedException e) {
        }
    }

    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }
}