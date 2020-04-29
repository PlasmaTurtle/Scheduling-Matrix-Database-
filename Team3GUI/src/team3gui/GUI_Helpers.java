/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team3gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public void updateCourses(String[] courses);
    public void addCourses(String[] courses);
    public void deleteCourses(String[] courses);
    
}
