import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    private int count = 0;
    JLabel label;
    JFrame frame;
    JPanel panel;


    public Main() {
        frame = new JFrame("My First GUI");
        JButton button = new JButton("Press");
        button.addActionListener(this);

        label = new JLabel("Number of clicks: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new Main();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: "+count);

    }
}