package nl.lveekhout.threadapp.threads;

import javax.swing.*;
import java.awt.*;

/**
 * Created by leekhout on 18-2-2015.
 * class TestScrollThread
 */

public class TestScrollThread {

    public ScrollThread scrollThread;

    public static void main(String args[]) throws InterruptedException {
        new TestScrollThread().showSherm();
        System.out.println("Ready!!!");
    }

    public void showSherm() {
        scrollThread = new ScrollThread();

        TestScrollThreadGUIForm testScrollThreadGUIForm = new TestScrollThreadGUIForm(this);
        JFrame frame = new JFrame("testscrollthread");
        frame.setPreferredSize(new Dimension(640,480));
        frame.setContentPane(testScrollThreadGUIForm.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        scrollThread.start();
//        scrollThread.interrupt();
    }
}