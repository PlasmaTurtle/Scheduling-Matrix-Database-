/*
Develop “CourseGUI”, Figure 1 application to display contents, and perform
DML activities (insert, update and delete) on the table using a “JTable” GUI
component.  Use the JTable features that provides for editing (i.e. updating
the cells within the CourseGUI and the TableModel to be updated).

The “Insert” button should provide for entering data for all the fields in the table.                      [Complete]
The “Delete” button will cause the selected row to be deleted from the TableModel.                         [Complete]
Both “Insert” & “Delete” will cause the JTable to beredisplayed after the changes have been completed.     [Complete]
The JavaDB database must also be updated with any changes that have been applied.
 */
package team3gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author kylel
 */
public class Team3GUI extends JFrame {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        // Initialize Helper Class
        GUI_Helpers helper = new GUI_Helpers();

        // GUI Objects
        JFrame courseGUI = new JFrame();
        JTable courseTable = new JTable();
        
       // Table Parameters
        String[] courseFields = new String[] {
            "COURSE ID", "COURSE DESCRIPTION", "CREDITS", "CONTACT HOURS"
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(courseFields,0); 
        tableModel.setColumnIdentifiers(courseFields);
        
        courseTable.setModel(tableModel);
        
        // Table Appearance
        courseTable.setBackground(Color.WHITE);
        courseTable.setForeground(Color.black);
        Font font = new Font("",1,14);
        courseTable.setFont(font);
        courseTable.setRowHeight(30);
        
        
        // Fields
        JTextField fldCourseID = new JTextField();
        JTextField fldCourseDescription = new JTextField();
        JTextField fldCredits = new JTextField();
        JTextField fldContactHours = new JTextField();
        
        // Buttons
        JButton btnInsert = new JButton("Insert");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        
        // Labels
        JLabel lblCourseID = new JLabel("Course ID");
        JLabel lblCourseDescription = new JLabel("Course Description");
        JLabel lblCredits = new JLabel("Credits");
        JLabel lblContactHours = new JLabel("Contact Hours");
        
        // Set Boundaries
        fldCourseID.setBounds(330, 370, 180, 25);
        fldCourseDescription.setBounds(330, 400, 180, 25);
        fldCredits.setBounds(330, 430, 180, 25);
        fldContactHours.setBounds(330, 460, 180, 25);
        
        lblCourseID.setBounds(200, 370, 180, 25);
        lblCourseDescription.setBounds(200, 400, 180, 25);
        lblCredits.setBounds(200, 430, 180, 25);
        lblContactHours.setBounds(200, 460, 180, 25);
        
        btnInsert.setBounds(530, 380, 100, 25);
        btnUpdate.setBounds(530, 415, 100, 25);
        btnDelete.setBounds(530, 450, 100, 25);
        
        courseTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        courseTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        courseTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        courseTable.getColumnModel().getColumn(3).setPreferredWidth(25);
        
        courseGUI.setBounds(30,30,800,800);
        
        // Scroll Pane Parameters
        JScrollPane pane = new JScrollPane(courseTable);
        pane.setBounds(0, 0, 920, 300);
        courseGUI.setLayout(null);
        courseGUI.add(pane);
        
        // Populate Frame with JObjects
        courseGUI.add(fldCourseID);
        courseGUI.add(fldCourseDescription);
        courseGUI.add(fldCredits);
        courseGUI.add(fldContactHours);
        
        courseGUI.add(lblCourseID);
        courseGUI.add(lblCourseDescription);
        courseGUI.add(lblCredits);
        courseGUI.add(lblContactHours);

        courseGUI.add(btnInsert);
        courseGUI.add(btnDelete);
        courseGUI.add(btnUpdate);
        
     // Event Handlers -------------------------------------
        Object[] record = new Object[7];
        
        // button add row
        btnInsert.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                record[0] = fldCourseID.getText();
                record[1] = fldCourseDescription.getText();
                record[2] = fldCredits.getText();
                record[3] = fldContactHours.getText();
                
                tableModel.addRow(record);
            }
        });
        
         // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
            
                // i = the index of the selected row
                int i = courseTable.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    tableModel.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        // Populate text fields with table data
        courseTable.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            int i = courseTable.getSelectedRow();
            
            fldCourseID.setText(tableModel.getValueAt(i, 0).toString());
            fldCourseDescription.setText(tableModel.getValueAt(i, 1).toString());
            fldCredits.setText(tableModel.getValueAt(i, 2).toString());
            fldContactHours.setText(tableModel.getValueAt(i, 3).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
             
                // i = the index of the selected row
                int i = courseTable.getSelectedRow();
                
                if(i >= 0) 
                {
                   tableModel.setValueAt(fldCourseID.getText(), i, 0);
                   tableModel.setValueAt(fldCourseDescription.getText(), i, 1);
                   tableModel.setValueAt(fldCredits.getText(), i, 2);
                   tableModel.setValueAt(fldContactHours.getText(), i, 3);
                }
                else{
                    System.out.println("Update Failed, please try again");
                }
            }
        });
        
        // Populate Table Model   
        ArrayList<String> courses;
        helper.getCourses();
        courses = helper.getCourses();
           
        for (String line : courses) 
        {
           tableModel.addRow(line.split(",")); 
        }
        
        // Load Frame on Screen
        courseGUI.setLocationRelativeTo(null);
        courseGUI.setTitle("CourseGUI");
        courseGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        courseGUI.setSize(960, 720);
        courseGUI.setVisible(true);
    }
    
}
