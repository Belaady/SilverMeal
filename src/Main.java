import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import data.*;

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
        tableInput();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }


    public void tableInput(){
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };

        // Column Names 
        String[] columnNames = { "Name", "Roll Number", "Department" };

        // Initializing the JTable 
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 100, 200, 300);

        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(j);
        frame.add(sp);
        // Frame Size
        frame.setSize(500, 200);
        // Frame Visible = true
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