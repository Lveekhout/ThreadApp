package nl.lveekhout.threadapp.threads;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by leekhout on 18-2-2015.
 * class TestScrollThreadGUIForm
 */

public class TestScrollThreadGUIForm {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton getXButton;

    public TestScrollThreadGUIForm(final TestScrollThread testScrollThread) {
        getXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append(testScrollThread.scrollThread.x + "\n");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
