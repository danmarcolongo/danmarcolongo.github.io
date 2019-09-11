/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it252;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel
 */
public class IT252 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaration of variables for later use
        String[] strDist = {"North", "South", "East", "West"};
        String phoneString = "Phone";
        String emailString = "Email";
        String visitString = "Visit";
        
        
        //Creating the forms to be used in the GUI
        JPanel panel = new JPanel(new GridLayout(0,1));
        JPanel panel2 = new JPanel(new GridLayout(0,1));
        JPanel panel3 = new JPanel(new GridLayout(0,1));
        JPanel panel4 = new JPanel(new GridLayout(0,1));
        JPanel panel5 = new JPanel(new GridLayout(0,1));
        
        //creates the frame for the data and sets the parameters
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(400, 250, 300, 500);
        fr.setResizable(true);
        
        
        //Creating the 3 radio buttons and creating a boolean for use in entry submission form
        JRadioButton selPhone = new JRadioButton(phoneString);
        selPhone.setMnemonic(KeyEvent.VK_B);
        selPhone.setActionCommand(phoneString);
        selPhone.setSelected(false);
        
        JRadioButton selEmail = new JRadioButton(emailString);
        selEmail.setMnemonic(KeyEvent.VK_C);
        selEmail.setActionCommand(emailString);
        selEmail.setSelected(false);
        
        JRadioButton selVisit = new JRadioButton(visitString);
        selVisit.setMnemonic(KeyEvent.VK_D);
        selVisit.setActionCommand(visitString);
        selVisit.setSelected(false);
        
        //Setting a button group for cleaner code
        ButtonGroup selPref = new ButtonGroup();
        selPref.add(selPhone);
        selPref.add(selEmail);
        selPref.add(selVisit);
        
        //setting the text area for submission form
        JTextArea area = new JTextArea();
        area.setEditable(false);
        
        //creating the text entry and combo box
        JTextField txtID = new JTextField("");
        JTextField txtFName = new JTextField("");
        JTextField txtLName = new JTextField("");
        JTextField txtTotal = new JTextField("");
        JTextField txtBookTotal = new JTextField("");
        JTextField txtPapTotal = new JTextField("");
        JComboBox cmbDist = new JComboBox(strDist);
        JTextArea txta = new JTextArea("Total Sales Representatives:" );
        txta.setEditable(false);
        JScrollPane scroll = new JScrollPane(txta);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //panel message screen creation
        panel4.add(new JLabel("Congratulations! You're a star! Data added to file 'stars.txt'."));
        panel2.add(new JLabel("Data added to file 'customers.txt'. Enter more data or cancel."));
        panel3.add(new JLabel("This sale was not enough to be a star sale."));
        panel5.add(scroll);
        
        JButton evalB = new JButton("Evaluate");
        evalB.setBounds(50, 100, 95, 30);
        evalB.addActionListener((ActionEvent b) -> {
            int tot = 0;
            String allWord = "";
            //getting the sales totals added together as the condition
            try {
                //making the file reader
                BufferedReader reader = new BufferedReader(new FileReader("customers.txt"));
                String currentLine = reader.readLine();
                //making variables for use in calculation of total
                int fi = 0;
                int fj = 0;
                int fh = 0;
                //making variables for creating the document
                String aa,ab,ac,ad,ae,af,ag,ah,aj;
                aa = "";
                ab = "";
                ac = "";
                ad = "";
                ae = "";
                af = "";
                ag = "";
                ah = "";
                aj = "";
                String delims = "[ ]+";
                //read all lines in the file
                while (currentLine != null){
                
                //for loop to parse through the tokens and assign variables
                String[] tokens = currentLine.split(delims);
                for (int i=0; i<tokens.length;i++){
                    if (i == 0) {
                        aj = tokens[i];
                    } else if(i == 1){
                        aa = tokens[i];
                    }else if(i == 2){
                        ab = tokens[i];
                    }else if(i == 3){
                        ac = tokens[i];
                    }else if(i == 4){
                        fi = Integer.parseInt(tokens[i]);
                    }else if(i == 5){
                        ad = tokens[i];
                    }else if(i == 6){
                        fj = Integer.parseInt(tokens[i]);
                    }else if(i == 7){
                        ae = tokens[i];
                    }else if(i == 8){
                        fh = Integer.parseInt(tokens[i]);
                    }else if (i == 9){
                        af = tokens[i];
                    }else if(i == 10){
                        ag = tokens[i];
                    }else if(i == 11){
                        ah = tokens[i];
                    }
                }
                //create the write to file variables
                allWord = aj + " " + aa + " " + ab + " " + ac + " " + fi + " " + ad + " "
                + fj + " " + ae + " " + fh + " " + af + " " + ag + " " + ah;
                tot = fi+fj+fh;
                    if (tot >= 8000) {
                        //while true, create the file/write to the file
                        try (FileWriter fw = new FileWriter("stars.txt", true);
                                BufferedWriter bw = new BufferedWriter(fw);
                                PrintWriter out = new PrintWriter(bw)) {
                            out.println(allWord);
                        } catch (IOException e) {
                            System.err.println("IOException");
                        }
                        //display the confirmation message
                        JOptionPane.showConfirmDialog(null, panel4, "Data Entry Submission",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    } else {
                        //do not write to file, notify to enter submission normally
                        JOptionPane.showConfirmDialog(null, panel3, "Attention!",
                                JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
                    }
                currentLine = reader.readLine();
                }
                
                reader.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IT252.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(IT252.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        });
        
        JButton dispB = new JButton("Display");
        dispB.setBounds(50, 100, 95, 30);
        dispB.addActionListener((ActionEvent a) -> {
            String allWord = "";
            ArrayList<String> arr = new ArrayList<String>();
            try {
                //making the file reader
                BufferedReader reader = new BufferedReader(new FileReader("stars.txt"));
                String currentLine = reader.readLine();
                //making variables for use in calculation of total
                String fi = "";
                String fj = "";
                String fh = "";
                //making variables for creating the document
                String aa,ab,ac,ad,ae,af,ag,ah,aj;
                aa = "";
                ab = "";
                ac = "";
                ad = "";
                ae = "";
                af = "";
                ag = "";
                ah = "";
                aj = "";
                String delims = "[ ]+";
                //read all lines in the file
                while (currentLine != null){
                
                //for loop to parse through the tokens and assign variables
                String[] tokens = currentLine.split(delims);
                for (int i=0; i<tokens.length;i++){
                    if (i == 0) {
                        aj = tokens[i];
                    }else if(i == 1){
                        aa = tokens[i];
                    }else if(i == 2){
                        ab = tokens[i];
                    }else if(i == 3){
                        ac = tokens[i];
                    }else if(i == 4){
                        fi = tokens[i];
                    }else if(i == 5){
                        ad = tokens[i];
                    }else if(i == 6){
                        fj = tokens[i];
                    }else if(i == 7){
                        ae = tokens[i];
                    }else if(i == 8){
                        fh = tokens[i];
                    }else if (i == 9){
                        af = tokens[i];
                    }else if(i == 10){
                        ag = tokens[i];
                    }else if(i == 11){
                        ah = tokens[i];
                    }
                }
                //create a variable for use in the array
                allWord = aj + " " + aa + " " + ab + " \n" + ac + " " + fi + " \n" + ad + " "
                + fj + " \n" + ae + " " + fh + " " + af + " \n" + ag + " \n" + ah;
                
                //iterate the reader and add the variable to the arraylist
                currentLine = reader.readLine();
                arr.add(allWord);
                
                }
                
                //create a string value to display the amount of salespeople in the array
                String yel = String.valueOf(arr.size());
                //add the value of yel to the textarea
                txta.append(yel + "\n" + "\n");
                //iterate through the array for each value to display
                for (int f = 0; f < arr.size(); f++){
                    txta.append(arr.get(f));
                    txta.append("\n");
                }
                
                //display the stars values in a textarea
                JOptionPane.showConfirmDialog(null, panel5, "Sales Numbers",
                                JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
                //close the reader
                reader.close();
                //catch exceptions
                }catch (FileNotFoundException ex) {
                    Logger.getLogger(IT252.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex) {
                    Logger.getLogger(IT252.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
        
        //creates the enter button
        JButton entB = new JButton("Enter");
        entB.setBounds(50, 100, 95, 30);
        //sets action listener for the enter button
        entB.addActionListener((ActionEvent a) -> {
            
            String varx = "";
            //creating variable for use in selection below
            boolean phoneSel = selPhone.isSelected();
            boolean emailSel = selEmail.isSelected();
            boolean visitSel = selVisit.isSelected();
            //setting a variable for the radio button selection
            if (phoneSel == true){
                varx = phoneString;
            } else if (emailSel == true){
                varx = emailString;
            } else if (visitSel == true){
                varx = visitString;
            } else {
                varx = "None Selected";
            }
            //setting a variable for the combo box value
            String combos = String.valueOf(cmbDist.getSelectedItem());
            //sets the string to upper case
            combos = combos.toUpperCase();
            //Creating the variable to be used in the writer
            String allWord = (txtID.getText() + " " + txtFName.getText() + " " 
                    + txtLName.getText() + " " + "SUPPLIES " + txtTotal.getText()
                    + " BOOKS " + txtBookTotal.getText() + " PAPER " +  txtPapTotal.getText()
                    + " " + combos + " " + varx );
            
            //writes the data created by the user to the file and adds a line to
            //the end.
            try (FileWriter fw = new FileWriter("customers.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                    out.println(allWord);
            } catch (IOException e) {
                System.err.println("IOException");
            }
            
            //create a confirmation screen for the data submission
            
            JOptionPane.showConfirmDialog(null, panel2, "Data Entry Submission",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
            //refresh the text data areas
            txtID.setText("");
            txtFName.setText("");
            txtLName.setText("");
            txtTotal.setText("");
            txtBookTotal.setText("");
            txtPapTotal.setText("");
            //reenable eval if false
            if (evalB.isEnabled() == false){
                evalB.setEnabled(true);
            }
            
        });
        
        //creates the cancel button to exit the program
        JButton canB = new JButton("Cancel");
        canB.setBounds(50, 100, 95, 30);
        canB.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        //adding components to "panel"
        panel.add(new JLabel("Enter ID"));
        panel.add(txtID);
        panel.add(new JLabel("Enter First Name"));
        panel.add(txtFName);
        panel.add(new JLabel("Enter Last Name"));
        panel.add(txtLName);
        panel.add(new JLabel("Enter Total Supplies Sold"));
        panel.add(txtTotal);
        panel.add(new JLabel("Enter Total Books Sold"));
        panel.add(txtBookTotal);
        panel.add(new JLabel("Enter Total Paper Sold"));
        panel.add(txtPapTotal);
        panel.add(new JLabel("Select a District"));
        panel.add(cmbDist);
        panel.add(new JLabel("Select a Preffered Means of Contact"));
        panel.add(selPhone);
        panel.add(selEmail);
        panel.add(selVisit);
        panel.add(evalB);
        panel.add(dispB);
        panel.add(entB);
        panel.add(canB);
        
        
        
        panel.setVisible(true);
        
        fr.getContentPane().add(panel);
        fr.setVisible(true);
        
        
    }
    
}
