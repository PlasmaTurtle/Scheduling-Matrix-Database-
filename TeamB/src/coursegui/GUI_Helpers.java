/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursegui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kylel
 */
public class GUI_Helpers implements SchedulingMatrixInterf_Test {
    
    String credits;
    String contactHours;
    String courseDescription;
    String courseID;
    ArrayList<String> courses = new ArrayList();
    
    private void purgeCourses() {
        courses = new ArrayList();
    }
    
    @Override
    public ArrayList<String> getCourses() {
        
        String line;
        BufferedReader reader;
        purgeCourses();
        
        try{       
            reader = new BufferedReader(new FileReader("resources/Spring.txt"));
            while((line = reader.readLine()) != null) 
            {
               courses.add(line); 
            }
            reader.close();
         }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
        return courses;
    }
    
    @Override
    public void updateCourses(ArrayList<String> courses) {
        
        try {   
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Spring.txt"));
            String updatedFile = "";

            for (String course : courses) {
                updatedFile += course + "\n";
            }
            writer.write(updatedFile);
            writer.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(GUI_Helpers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void addCourses(ArrayList<String> courses) {
                try {   
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Spring.txt"));
            String updatedFile = "";

            for (String course : courses) {
                updatedFile += course + "\n";
            }
            writer.write(updatedFile);
            writer.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(GUI_Helpers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void deleteCourses(ArrayList<String> courses) {
        try {   
            BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Spring.txt"));
            String updatedFile = "";

            for (String course : courses) {
                updatedFile += course + "\n";
            }
            writer.write(updatedFile);
            writer.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(GUI_Helpers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
