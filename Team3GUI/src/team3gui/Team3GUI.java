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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TeamBGUI extends JFrame {
/**
* @param args the command line arguments
*/
public static void main(String[] args) {

// Table Parameters
String[] courseFields = new String[] {
"COURSE", "TITLE", "PB", "MELB", "COCOA", "TVILLE","VC"

};

JFrame courseGUI = new JFrame();
JTable courseTable = new JTable();



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
JTextField fldCourse = new JTextField();
JTextField fldTitle = new JTextField();
JTextField fldPb = new JTextField();
JTextField fldMelb = new JTextField();
JTextField fldCocoa = new JTextField();
JTextField fldTville = new JTextField();
JTextField fldVc = new JTextField();

// Buttons
JButton btnInsert = new JButton("Insert");
JButton btnDelete = new JButton("Delete");
JButton btnUpdate = new JButton("Update");

// Labels
JLabel lblCourse = new JLabel("Course");
JLabel lblTitle = new JLabel("Title");
JLabel lblPb = new JLabel("Palm Bay");
JLabel lblMelb = new JLabel("Melbourne");
JLabel lblCocoa = new JLabel("Cocoa");
JLabel lblTville = new JLabel("Titusville");
JLabel lblVc = new JLabel("Virtual Class");

// Set Boundaries
fldCourse.setBounds(200, 370, 180, 25);
fldTitle.setBounds(200, 400, 180, 25);
fldPb.setBounds(200, 430, 180, 25);
fldMelb.setBounds(200, 460, 180, 25);
fldCocoa.setBounds(200, 490, 180, 25);
fldTville.setBounds(200, 520, 180, 25);
fldVc.setBounds(200, 550, 180, 25);

lblCourse.setBounds(100, 370, 180, 25);
lblTitle.setBounds(100, 400, 180, 25);
lblPb.setBounds(100, 430, 180, 25);
lblMelb.setBounds(100, 460, 180, 25);
lblCocoa.setBounds(100, 490, 180, 25);
lblTville.setBounds(100, 520, 180, 25);
lblVc.setBounds(100, 550, 180, 25);

btnInsert.setBounds(420, 425, 100, 25);
btnUpdate.setBounds(420, 460, 100, 25);
btnDelete.setBounds(420, 495, 100, 25);

courseGUI.setBounds(10,30,800,800);

// Scroll Pane
JScrollPane pane = new JScrollPane(courseTable);
pane.setBounds(0, 0, 880, 350);
courseGUI.setLayout(null);
courseGUI.add(pane);

// Populate Frame with JObjects
courseGUI.add(fldCourse);
courseGUI.add(fldTitle);
courseGUI.add(fldPb);
courseGUI.add(fldMelb);
courseGUI.add(fldCocoa);
courseGUI.add(fldTville);
courseGUI.add(fldVc);

courseGUI.add(lblCourse);
courseGUI.add(lblTitle);
courseGUI.add(lblPb);
courseGUI.add(lblMelb);
courseGUI.add(lblCocoa);
courseGUI.add(lblTville);
courseGUI.add(lblVc);

courseGUI.add(btnInsert);
courseGUI.add(btnDelete);
courseGUI.add(btnUpdate);

// Event Handlers -------------------------------------
Object[] record = new Object[7];

// button add row
btnInsert.addActionListener(new ActionListener(){

@Override
public void actionPerformed(java.awt.event.ActionEvent e) {
record[0] = fldCourse.getText();
record[1] = fldTitle.getText();
record[2] = fldPb.getText();
record[3] = fldMelb.getText();
record[4] = fldCocoa.getText();
record[5] = fldTville.getText();
record[6] = fldVc.getText();

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

fldCourse.setText(tableModel.getValueAt(i, 0).toString());
fldTitle.setText(tableModel.getValueAt(i, 1).toString());
fldPb.setText(tableModel.getValueAt(i, 2).toString());
fldMelb.setText(tableModel.getValueAt(i, 3).toString());
fldCocoa.setText(tableModel.getValueAt(i, 4).toString());
fldTville.setText(tableModel.getValueAt(i, 5).toString());
fldVc.setText(tableModel.getValueAt(i, 6).toString());
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
tableModel.setValueAt(fldCourse.getText(), i, 0);
tableModel.setValueAt(fldTitle.getText(), i, 1);
tableModel.setValueAt(fldPb.getText(), i, 2);
tableModel.setValueAt(fldMelb.getText(), i, 3);
tableModel.setValueAt(fldCocoa.getText(), i, 3);
tableModel.setValueAt(fldTville.getText(), i, 3);
tableModel.setValueAt(fldVc.getText(), i, 3);
}
else{
System.out.println("Update Failed, please try again");
}
}
});

// Populate Table Model
String line;
BufferedReader reader;
try{
reader = new BufferedReader(new FileReader("resources/Spring.txt"));
while((line = reader.readLine()) != null)
{
tableModel.addRow(line.split(","));
}
reader.close();
}
catch(IOException e){
JOptionPane.showMessageDialog(null, "Error");
e.printStackTrace();
}

// Load Frame on Screen
courseGUI.setLocationRelativeTo(null);
courseGUI.setTitle("CourseGUI");
courseGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
courseGUI.setSize(890, 720);
courseGUI.setVisible(true);
courseGUI.getContentPane().setBackground(Color.LIGHT_GRAY);
}

}
