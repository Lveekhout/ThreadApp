package nl.lveekhout.threadapp.threads;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eekhout.l on 19-02-2015.
 * class MyJTextArea
 */

public class MyJPanel extends JPanel implements Callable {

    Image offScreen;
    Graphics bufferGraphics;
    private TestScrollThread testScrollThread;
    private UpdateThread updateThread;

    public MyJPanel(TestScrollThread testScrollThread) {
        this.testScrollThread = testScrollThread;
    }

    @Override
    public void doLayout() {
        super.doLayout();
        offScreen = createImage(getWidth(), getHeight());
        bufferGraphics = offScreen.getGraphics();
        updateThread = new UpdateThread(this, 1);
        updateThread.start();
    }

    @Override
    public void onUpdate() {
        bufferGraphics.setColor(Color.CYAN);
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());
        bufferGraphics.setColor(Color.BLACK);
        int newX = (int)(getWidth()/2) + (int)(testScrollThread.scrollThread.x*100);
        int newY = (int)(getHeight()/2) - (int)(testScrollThread.scrollThread.y*100);
        bufferGraphics.drawOval(newX, newY, 10, 10);
        bufferGraphics.drawString(String.format("%d, %d", (int) (testScrollThread.scrollThread.x * 100), (int)(testScrollThread.scrollThread.y*100)), 10, 10);

        getGraphics().drawImage(offScreen, 0, 0, this);
    }
}
