/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursegui;

import java.util.ArrayList;

/**
 *
 * @author kylel
 */
public interface SchedulingMatrixInterf_Test {
    
    public ArrayList<String> getCourses();
    public void updateCourses(ArrayList<String> courses);
    public void addCourses(ArrayList<String> courses);
    public void deleteCourses(ArrayList<String> courses);
    
}
