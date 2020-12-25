// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

class Frame extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel period;
    private JTextField tperiod;
    private JLabel setup;
    private JTextField tsetup;
    private JLabel saving;
    private JTextField tsaving;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private DefaultTableModel tableModel;
    private JButton calculate;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;


    public Frame()
    {
        setTitle("Silver-Meal Trial");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);


        //Title
        title = new JLabel("Silver-Meal Trial");
        title.setFont(new Font("Arial", Font.PLAIN, 24));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);


        //Button Period
        period = new JLabel("Period");
        period.setFont(new Font("Arial", Font.PLAIN, 16));
        period.setSize(100, 20);
        period.setLocation(100, 100);
        c.add(period);

        //Textfield Period
        tperiod = new JTextField();
        tperiod.setFont(new Font("Arial", Font.PLAIN, 15));
        tperiod.setSize(180, 20);
        tperiod.setLocation(200, 100);
        c.add(tperiod);


        //Button Setup Cost
        setup = new JLabel("Setup Cost");
        setup.setFont(new Font("Arial", Font.PLAIN, 16));
        setup.setSize(100, 20);
        setup.setLocation(100, 150);
        c.add(setup);


        //Textfield Setup Cost
        tsetup = new JTextField();
        tsetup.setFont(new Font("Arial", Font.PLAIN, 15));
        tsetup.setSize(180, 20);
        tsetup.setLocation(200, 150);
        c.add(tsetup);


        //Button Saving Cost
        saving = new JLabel("Saving Cost");
        saving.setFont(new Font("Arial", Font.PLAIN, 16));
        saving.setSize(100, 20);
        saving.setLocation(100, 200);
        c.add(saving);


        //Textfield Saving Cost
        tsaving = new JTextField();
        tsaving.setFont(new Font("Arial", Font.PLAIN, 15));
        tsaving.setSize(180, 20);
        tsaving.setLocation(200, 200);
        c.add(tsaving);


        //Button Submit
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 250);
        sub.addActionListener(this);
        c.add(sub);


        //Button Reset
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 250);
        reset.addActionListener(this);
        c.add(reset);


        // Table
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        tableModel.addColumn("Period");
        tableModel.addColumn("Demand");
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(60);

        JScrollPane sp = new JScrollPane(table);
        sp.setFont(new Font("Arial", Font.PLAIN, 20));
        sp.setSize(400, 100);
        sp.setLocation(30,310);
        c.add(sp);

        //Button Calculate
        calculate = new JButton("calculate");
        calculate.setFont(new Font("Arial", Font.PLAIN, 15));
        calculate.setSize(100, 20);
        calculate.setLocation(270, 420);
        calculate.addActionListener(this);
        c.add(calculate);


        //Output print
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(150, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);




        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if(tableModel.getRowCount()!=0){
                for (int x = tableModel.getRowCount() - 1; x > -1; x--) {
                    tableModel.removeRow(x);
                }
            }
            String data
                    = "Period : "
                    + tperiod.getText() + "\n"
                    + "Setup Cost : "
                    + tsetup.getText() + "\n"
                    + "Saving Cost : "
                    + tsaving.getText() + "\n";

            int hehe = Integer.parseInt(tperiod.getText());
            for(int i =0; i<hehe; i++){
                tableModel.addRow(new Object[] { i+1});
            }
            tout.setText(data);
            tout.setEditable(false);
            res.setText("Calculation success!");


        }

        else if (e.getSource() == reset) {
            String def = "";
            tperiod.setText(def);
            tsetup.setText(def);
            tsaving.setText(def);
            res.setText(def);
            tout.setText(def);
            resadd.setText(def);
            for (int r = tableModel.getRowCount() - 1; r > -1; r--) {
                tableModel.removeRow(r);
            }
            term.setSelected(false);
        }

        //Buat print isi table dulu
        else if (e.getSource() == calculate) {
            Vector dataTable =  tableModel.getDataVector();
            System.out.println(dataTable);
            ArrayList<String> listDemand = new ArrayList<>();

//            for(Object i : dataTable) {
//                listDemand.add(i[1].to);
//            }
//            System.out.println(dataTable.get(0).);

        }

    }
}

