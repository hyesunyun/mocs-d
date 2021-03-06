/** 
 * MOCS-D Project
 * File Name: CSProfsAndCourses.java
 * CSProfsAndCourses is a class that creates an object that contains both CSProfessors and CSCourses.
 * CSProfsAndCourses is used to store professors and the courses of the Computer Science Department.
 * @author Hye Sun Yun
 * @version 1.0 December 9, 2014
 */

import java.util.*;
import java.io.*;

public class CSProfsAndCourses {
  
  // instance variables
  private CSCourses courseList;
  private CSProfessors professorList;
  
  /**
   * Constructs the CSProfsAndCourses object by creating empty CSCourses and empty CSProfessors.
   */
  public CSProfsAndCourses() {
    courseList = new CSCourses();
    professorList = new CSProfessors();
  }
  
  /**
   * Constructs the CSProfsAndCourses object by taking in two text files (a text file with courses information and a text
   * file with professors information). The text file with courses information is used to construct the CSCourses, and the
   * text file with professors information is used to construct the CSProfessors.
   * 
   * @param coursetxtFile  a string from text file with information about the courses
   * @param proftxtFile    a string from text file with information about the professors
   */
  public CSProfsAndCourses(String coursetxtFile, String proftxtFile) {
    courseList = new CSCourses(coursetxtFile);
    professorList = new CSProfessors(proftxtFile);
  }
  
  /**
   * Returns the CSCourses of the CSProfsAndCourses
   * 
   * @return a CSCourses of a CSProfsAndCourses
   */
  public CSCourses getCSCourses() {
    return this.courseList; 
  }
  
  /** 
   * Returns the CSProfessors of the CSProfsAndCourses
   * 
   * @return a CSProfessors of a CSProfsAndCourses
   */
  public CSProfessors getCSProfessors() {
    return this.professorList; 
  }
  
  /**
   * Returns true if the specified String search word is contained in any of the objects (both Professor and Course objects)
   * in CSProfsAndCourses. Returns false if the specified String search word is not found in any of the Objects.
   * 
   * @return a boolean which explains if a specified string word is contained in any of the objects
   */
  public boolean isContainsSearchWord(String searchWord) {
    
    // Searches through the CSCourses
    for (int i = 0; i < courseList.getNumOfCourses(); i++) {
      if (courseList.getCourse(i).searchWordInCourse(searchWord)) { //searchWordInCourse method is found in Course class
        return true;
      }
    }
    
    // Searches through the CSProfessors
    for (int j = 0; j < professorList.getNumOfProfs(); j++) {
      if (professorList.getProfessor(j).searchWordInProf(searchWord)) { //searchWordInProf method is found in Professor class
        return true; 
      }
    }
    return false;
  }
  
  /**
   * Returns a CSProfsAndCourses with objects that contains the specified string search word.
   * The method creates a new CSProfsAndCourses and adds the objects containing the search word to its respective LinkedList.
   * 
   * @return a CSProfsAndCourses of Professor and Courses objects containing the specified search word.
   */
  public CSProfsAndCourses containsSearchWord(String searchWord) {
    CSProfsAndCourses result = new CSProfsAndCourses(); // creates a CSProfsAndCourses for the result
    
    // Searches through the CSCourses 
    for (int i = 0; i < this.courseList.getNumOfCourses(); i++) {
      Course c = this.courseList.getCourse(i);
      // System.out.println(c);
      if (c.searchWordInCourse(searchWord)) { //searchWordInCourse method found in Course class
        result.courseList.addCourse(c);
      }
    }
    
    // Searches through the CSProfessors
    for (int i = 0; i < this.professorList.getNumOfProfs(); i++) {
      Professor p = this.professorList.getProfessor(i);
      if (p.searchWordInProf(searchWord)) { //searchWordInProf method found in Professor class
        result.professorList.addProfessor(p);
      }
    }
    return result;
  }
  
  /**
   * Returns a string representation of the CSProfsAndCourses
   * 
   * @return a string representation of the CSProfsAndCourses
   */
  public String toString() {
    String s = "Computer Science Courses:\n";
    for (int i = 0; i < courseList.getNumOfCourses(); i++) {
      s += courseList.getCourse(i);
      s += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    s += "Computer Science Professors: \n";
    for (int i = 0; i < professorList.getNumOfProfs(); i++) {
      s += professorList.getProfessor(i);
      s += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }
    return s;
  }
  
  // main method for testing
  public static void main (String[] args) {
    CSProfsAndCourses m = new CSProfsAndCourses("CSCourses.txt","CSProfessors.txt");
    //System.out.println(m);
    
    //System.out.println(m.isContainsSearchWord("web"));
    //System.out.println(m.containsSearchWord("web"));
    //System.out.println(m.containsSearchWord("programming"));
    //System.out.println(m.containsSearchWord("science"));
    System.out.println(m.containsSearchWord("111"));
    //System.out.println(m.containsSearchWord("research"));
  }
  
}