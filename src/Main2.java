// Java program to implement 
// a Simple Registration Form 
// using Java Swing 
  
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
  
class Frame 
    extends JFrame 
    implements ActionListener { 
  
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
  
        title = new JLabel("Silver-Meal Trial"); 
        title.setFont(new Font("Arial", Font.PLAIN, 24)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        period = new JLabel("Period"); 
        period.setFont(new Font("Arial", Font.PLAIN, 16)); 
        period.setSize(100, 20); 
        period.setLocation(100, 100); 
        c.add(period); 
  
        tperiod = new JTextField(); 
        tperiod.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tperiod.setSize(180, 20); 
        tperiod.setLocation(200, 100); 
        c.add(tperiod); 
  
        setup = new JLabel("Setup Cost"); 
        setup.setFont(new Font("Arial", Font.PLAIN, 16)); 
        setup.setSize(100, 20); 
        setup.setLocation(100, 150); 
        c.add(setup); 
  
        tsetup = new JTextField(); 
        tsetup.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tsetup.setSize(180, 20); 
        tsetup.setLocation(200, 150); 
        c.add(tsetup); 

        saving = new JLabel("Saving Cost"); 
        saving.setFont(new Font("Arial", Font.PLAIN, 16)); 
        saving.setSize(100, 20); 
        saving.setLocation(100, 200); 
        c.add(saving); 
  
        tsaving = new JTextField(); 
        tsaving.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tsaving.setSize(180, 20); 
        tsaving.setLocation(200, 200); 
        c.add(tsaving);
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 450); 
        reset.addActionListener(this); 
        c.add(reset); 
  
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
            String data 
                = "Period : "
                    + tperiod.getText() + "\n"
                    + "Setup Cost : "
                    + tsetup.getText() + "\n"
                    + "Saving Cost : "
                    + tsaving.getText() + "\n";  
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
            term.setSelected(false); 
            resadd.setText(def); 
        } 
    } 
} 
  
// Driver Code 
class Main2 { 
  
    public static void main(String[] args) throws Exception 
    { 
        Frame f = new Frame(); 
    } 
} 