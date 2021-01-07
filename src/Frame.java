// Silver Meal Trial using Java Swing

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
//import javax.xml.crypto.Data;
//import java.time.Duration;
//import java.time.Instant;
//import java.util.concurrent.TimeUnit;
//import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import data.*;

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
    private JLabel type; 
    private JRadioButton WW; 
    private JRadioButton SM; 
    private JRadioButton SMmodif; 
    private ButtonGroup group; 
    private JButton sub;
    private JButton reset;
    private DefaultTableModel tableModel;
    private JButton calculate;
    private JTextArea tout;
    private JLabel res;
    private JLabel ww;
    private JLabel ori;
    private JLabel modif;
    private JTextArea resModif;
    private JTextArea resOri;
    private JTextArea resadd;


    public Frame()
    {
        setTitle("Silver-Meal Trial");
        setBounds(300, 90, 1350, 650);
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
        period = new JLabel("Period:");
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
        setup = new JLabel("Setup Cost:");
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
        saving = new JLabel("Saving Cost:");
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
        sub.setLocation(200, 250);
        sub.addActionListener(this);
        c.add(sub);

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
        sp.setSize(400, 175);
        sp.setLocation(30,300);
        c.add(sp);

        // Calculation types
        type = new JLabel("Type:"); 
        type.setFont(new Font("Arial", Font.PLAIN, 16)); 
        type.setSize(180, 20); 
        type.setLocation(50, 500); 
        c.add(type); 
  
        WW = new JRadioButton("WW"); 
        WW.setFont(new Font("Arial", Font.PLAIN, 15)); 
        WW.setSelected(true); 
        WW.setSize(75, 20); 
        WW.setLocation(125, 500); 
        c.add(WW); 
  
        SM = new JRadioButton("SM"); 
        SM.setFont(new Font("Arial", Font.PLAIN, 15)); 
        SM.setSelected(false); 
        SM.setSize(80, 20); 
        SM.setLocation(225, 500); 
        c.add(SM); 

        SMmodif = new JRadioButton("SM modif"); 
        SMmodif.setFont(new Font("Arial", Font.PLAIN, 15)); 
        SMmodif.setSelected(false); 
        SMmodif.setSize(100, 20); 
        SMmodif.setLocation(320, 500); 
        c.add(SMmodif); 

        group = new ButtonGroup(); 
        group.add(WW); 
        group.add(SM);
        group.add(SMmodif);

        //Button Reset
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(100, 550);
        reset.addActionListener(this);
        c.add(reset);

        // Button Calculate
        calculate = new JButton("Calculate");
        calculate.setFont(new Font("Arial", Font.PLAIN, 15));
        calculate.setSize(100, 20);
        calculate.setLocation(250, 550);
        calculate.addActionListener(this);
        c.add(calculate);

        // Output print
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(200, 100);
        tout.setLocation(450, 470);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        //Calculation success
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(150, 580);
        c.add(res);


        //Label ori
        ori = new JLabel("SM Ori Result :");
        ori.setFont(new Font("Arial", Font.PLAIN, 16));
        ori.setSize(200, 20);
        ori.setLocation(450, 75);
        c.add(ori);

        resOri = new JTextArea();
        resOri.setFont(new Font("Arial", Font.PLAIN, 13));
        resOri.setSize(290, 350);
        resOri.setLocation(450, 100);
        resOri.setLineWrap(true);
        c.add(resOri);

        //Label Modif
        modif = new JLabel("SM Modif Result :");
        modif.setFont(new Font("Arial", Font.PLAIN, 16));
        modif.setSize(200, 20);
        modif.setLocation(750, 75);
        c.add(modif);

        resModif = new JTextArea();
        resModif.setFont(new Font("Arial", Font.PLAIN, 13));
        resModif.setSize(290, 350);
        resModif.setLocation(750, 100);
        resModif.setLineWrap(true);
        c.add(resModif);

        //Label Modif
        ww = new JLabel("SM Modif Result :");
        ww.setFont(new Font("Arial", Font.PLAIN, 16));
        ww.setSize(200, 20);
        ww.setLocation(1050, 75);
        c.add(ww);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 13));
        resadd.setSize(290, 350);
        resadd.setLocation(1050, 100);
        resadd.setLineWrap(true);
        c.add(resadd);


        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
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

            //Create table
            int period = Integer.parseInt(tperiod.getText());
            for(int i =0; i<period; i++){
                tableModel.addRow(new Object[] { i+1});
            }

            tout.setText(data);
            tout.setEditable(false);
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
            WW.setSelected(true);
            SM.setSelected(false);
            SMmodif.setSelected(false);
        }


        //Buat print isi table dulu
        //BUAT CALCULATE
        else if (e.getSource() == calculate) {

//            ArrayList<Integer> listDemand = new ArrayList<>();
            int[] listDemand = new int[tableModel.getRowCount()];

            //Get demand
            for(int i =0; i<tableModel.getRowCount(); i++){
//                listDemand.add(Integer.parseInt(tableModel.getValueAt(i,1).toString()));
                listDemand[i] = Integer.parseInt(tableModel.getValueAt(i,1).toString()); // masih salah di sini
            }

            //Cek isi table
            Vector dataTable =  tableModel.getDataVector();
//            System.out.println(dataTable);

            //Print Demand
            double setup = Double.parseDouble(tsetup.getText());
            double saving = Double.parseDouble(tsaving.getText());
            for
            (int r=0; r< listDemand.length; r++){
                System.out.print(listDemand[r]);

            }
            
            // WW
            if (WW.isSelected()) {
                List result = countWW(listDemand);
                // System.out.println("MASHOKK WW");
                StringBuilder str
                        = new StringBuilder();
                for (int v=0; v< result.size();v++){
                    str.append(String.valueOf(result.get(v))+"\n");
                    System.out.println(result.get(v));

                }
                String dataWW = str.toString();
                resadd.setText(dataWW);
                resadd.setEditable(false);

            }

            // SM
            else if (SM.isSelected()) { 
                System.out.println("MASHOKK SM");
            }

            // SM Modif
            else if (SMmodif.isSelected()) { 
                List result = countModif(listDemand);
                StringBuilder str = new StringBuilder();
                for (int v=0; v< result.size();v++){
                    str.append(String.valueOf(result.get(v))+"\n");
                    System.out.println(result.get(v));

                }
                String hasil = str.toString();
                resadd.setText(hasil);
                resadd.setEditable(false);
            }
            res.setText("Calculation success!");

        }

    }

    private List countWW(int[] listDemand) {
        //Initiate component
        List<List<Double>> myList = new ArrayList<List<Double>>();
        int period = Integer.parseInt(tperiod.getText());
        double setup = Double.parseDouble(tsetup.getText());
        double saving = Double.parseDouble(tsaving.getText());
        List<String> resultWW = new ArrayList<>();

        List<Double> minToBuy = new ArrayList<>();
        List<Integer> buyingMonth = new ArrayList<Integer>();
        List<Integer> totalDemand = new ArrayList<Integer>();

        long startTime = System.nanoTime();

        //Start list awal
        List<Double> start = new ArrayList<>();
        start.add(setup);
        myList.add(start);

        //For first row
        for (int y = 1; y < period; y++) {
            List<Double> afbefore = new ArrayList<>(myList.get(y - 1));
            List<Double> nextMonth = new ArrayList<>();
            double result2 = afbefore.get(0) + listDemand[y] * saving * y;
            nextMonth.add(Math.round(result2 * 100.0) / 100.0);
            myList.add(nextMonth);
        }

        //Second until end
        for(int x=1; x< period; x++) {
            List<Double> afbefore = new ArrayList<>(myList.get(x - 1));
            Collections.sort(afbefore);
            double result2 = afbefore.get(0) + setup;
            myList.get(x).add(Math.round(result2 * 100.0) / 100.0);
            for (int z = x+1; z < period; z++) {
                List<Double> before = new ArrayList<>(myList.get(z - 1));
                double result = before.get(x) + listDemand[z] * saving * (z-x);
                myList.get(z).add(Math.round(result * 100.0) / 100.0);
            }
        }

        //Checking all array
        System.out.println(myList);

        //Check when to buy
        for(int month =period-1; month>-1; month--){
            List<Double> findMin = new ArrayList<>(myList.get(month));
            Collections.sort(findMin);
            double minValue = findMin.get(0);

            int indexValue = myList.get(month).indexOf(minValue);
            int via = month+1;
            if(indexValue==month){

//                System.out.println("Beli pada bulan ke-"+via+" dengan harga "+minValue);
                buyingMonth.add(via);
                minToBuy.add(minValue);
            }
            else {

                int bela = indexValue+1;
                List<Double> jumpColumn = new ArrayList<>(myList.get(indexValue));
                Collections.sort(jumpColumn);
                double minJump = jumpColumn.get(0);

//                System.out.println(" Masuk loop Beli pada bulan ke-"+bela+" dengan harga "+ minJump);
                minToBuy.add(minJump);
                buyingMonth.add(bela);
                month=indexValue;

            }
        }
        Collections.reverse(buyingMonth);
        Collections.reverse(minToBuy);
        for(int col=0; col<buyingMonth.size(); col++){
            int jumlah =0;
            int param =0;
            int value=0;
            if (col<buyingMonth.size()-1){
                param+=col+1;
                value = buyingMonth.get(param);
            }
            else{
                value = period+1;

            }

//            System.out.println("Ini value " + value);
//            System.out.println("Ini col " + col);

            for(int b= buyingMonth.get(col)-1; b<value-1; b++){
                jumlah+= listDemand[b];
//                System.out.println(listDemand[b]);
//                System.out.println("ini col"+ b +" Ini jumlah " + jumlah);
            }
            totalDemand.add(jumlah);

        }

        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds  : " + timeElapsed);

        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);

        System.out.println( "ini minimal harga pembelian " + minToBuy);
        System.out.println("Ini bulan pembelian " + buyingMonth);
        System.out.println("Total demand tiap pembelian " + totalDemand);
        List<Double> listTotalCost = new ArrayList<>( myList.get(myList.size()-1));
        Collections.sort(listTotalCost);
        double totalCost = listTotalCost.get(0);
        for(int r=0; r< buyingMonth.size(); r++){
            resultWW.add("Beli pada periode " +buyingMonth.get(r)+ " sejumlah " + totalDemand.get(r));

        }
        resultWW.add("Dengan Total Cost :" + totalCost);
        resultWW.add("Execution time in nanoseconds  : " + timeElapsed);

        resultWW.add("Execution time in milliseconds : " +
                timeElapsed / 1000000);

        return resultWW;

    }

    private List countModif(int[] listDemand) {

        List<String> resultModif = new ArrayList<>();
        int period = Integer.parseInt(tperiod.getText()); // inputan aaaa
        double setup = Double.parseDouble(tsetup.getText()); // a
        double saving = Double.parseDouble(tsaving.getText()); // h

        int thisPeriod = 1; // idx nya kurang 1
        int count = 1; // ngitung t
        int section = 0; // index awal section itu pada demand
        int sumCounter = 1; // counter untuk sum

        ArrayList<data> listRow = new ArrayList<>();
        
        long startTime = System.nanoTime();

        while(sumCounter<period+1){
            data temp = new data();
            if (count==1)
            {
                temp.setPeriod(thisPeriod);
                temp.setT(1);
                temp.setTotalSetup(setup);
                temp.setSavingSum(0);
                temp.setSavingFee(0);
                temp.setDiff(setup);
                temp.setStatus("Next");
                temp.setQuantity(listDemand[0]);
                temp.setTotalCost(0);

                count++;
                thisPeriod++;
                if (sumCounter==period){
                    temp.setTotalCost(setup);
                    sumCounter++;
                }
            }
            else
            {
                data restPart = listRow.get(thisPeriod-2);
                int demand = listDemand[sumCounter];

                int sum=0;
                double sumTotal=0;
                int a=0;
                
                for(int x = section; x<=sumCounter; x++)
                {
                    // System.out.println("ini yg di sum "+listDemand[x]);
                    sum+=listDemand[x];
                    sumTotal+=listDemand[x]*(a);
                    a++;
                }

                // System.out.println("ini sum nya datanya dibawah"+sum);
                // System.out.println("ini section "+section);
                // System.out.println("ini count "+sumCounter);

                int tSebelum = restPart.getT();
                double ssSebelum = restPart.getSavingSum();
                // System.out.println("ini t sebelum "+tSebelum);
                // System.out.println("ini ss sebelum "+ssSebelum);
                // System.out.println("ini demand "+demand);
                double ssNow = ssSebelum+(tSebelum*(demand*sum));
                double ongkos =saving*ssNow/sum;
                double selisih = Math.abs(setup-ongkos);
                double totalCost= (sumTotal*saving)+setup;

                temp.setPeriod(thisPeriod);
                temp.setT(count);
                temp.setTotalSetup(setup);
                temp.setSavingSum(ssNow);
                temp.setSavingFee(ongkos);
                temp.setDiff(selisih);
                temp.setTotalCost(totalCost);
                if (selisih <= restPart.getDiff()){
                    temp.setStatus("Next");
                    count++;
                    thisPeriod++;
                    sumCounter++;
                    if (sumCounter==period){
                        sumCounter++;
                    }

                }
                else{
                    temp.setStatus("Stop");
                    count=1;
                    section=sumCounter;
                    thisPeriod++;
                    sumCounter++;

                }
            }
            listRow.add(temp);
            // System.out.println(temp.getPeriod());
            // System.out.println(temp.getT());
            // System.out.println(temp.getTotalSetup());
            // System.out.println(temp.getSavingSum());
            // System.out.println(temp.getSavingFee());
            // System.out.println(temp.getDiff());
            // System.out.println(temp.getTotalCost());
            // System.out.println(temp.getStatus());
        }

        double total = 0;
        int j = 1;
        for(int i = 0; i<listRow.size(); i++)
        {
            // System.out.println(listRow.get(i).getTotalCost());
            if(listRow.get(i).getStatus()=="Stop"){
                resultModif.add("Pemesanan ke-"+j+" = "+listRow.get(i-1).getTotalCost());
                j++;
                total+=listRow.get(i-1).getTotalCost();
            }
        }
        total+=listRow.get(listRow.size()-1).getTotalCost();
        resultModif.add("Pemesanan ke-"+j+" = "+listRow.get(listRow.size()-1).getTotalCost());
        resultModif.add("Total Cost = "+total);
        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;
        resultModif.add("Execution time in nanoseconds  : " + timeElapsed);

        resultModif.add("Execution time in milliseconds : " +
                timeElapsed / 1000000);
        return resultModif;
    }
}


