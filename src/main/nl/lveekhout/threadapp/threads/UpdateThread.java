package nl.lveekhout.threadapp.threads;

/**
 * Created by eekhout.l on 19-02-2015.
 * class UpdateThread
 */

public class UpdateThread extends Thread {

    private int sleepTime;
    private Callable callable;

    public UpdateThread(Callable callable, int interval) {
        this.callable = callable;
        this.sleepTime = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                callable.onUpdate();
                sleep(sleepTime);
            }
        } catch (InterruptedException e) {
        }
    }
}
