package java20.core.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java20.core.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class ReplayDialog extends JDialog {
    JPanel panel;
    JButton cancelButton;
    JButton replayButton;

    public ReplayDialog(){
        super(LookingGUI.getInstance().getFrame(), "replay", true);
        panel = new JPanel();
        cancelButton = new JButton("Cancel");
        replayButton = new JButton("Replay");
    }
    public void go() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(550, 275, 300, 150);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(BorderLayout.CENTER, this.panel);
        panel.add(cancelButton);
        panel.add(replayButton);
        cancelButton.addActionListener(new CancelAction());
        replayButton.addActionListener(new ReplayAction());
        this.setVisible(true);
    }

    public class CancelAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ReplayDialog.this.setEnabled(false);
            ReplayDialog.this.setVisible(false);
            ReplayDialog.this.dispose();
            LookingGUI.getInstance().disable();
        }

    }

    public class ReplayAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getInstance().set();
            Controller.getInstance().getTurnPanel().setTurn(Controller.getInstance().getTurns());
            ReplayDialog.this.setEnabled(false);
            ReplayDialog.this.setVisible(false);
            ReplayDialog.this.dispose();
        }
        
    }

}
