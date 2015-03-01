/** 
 * MOCS-D Project
 * File Name: CSProfessors.java
 * CSProfessors is a class that creates a LinkedList that stores Professor objects.
 * CSProfessors is a good way to store all the Computer Science professors.
 * CSProfessors can be constructed by taking in a text file or without a text file.
 * @author Alison Savage
 * @version 1.0 November 25, 2014
 */

import java.util.*;
import java.io.*;

public class CSProfessors {
  
  // instance variables
  private LinkedList<Professor> professorList;
  private int numOfProfs;
  private static String semester = "Fall 2014";
  private final int NOT_FOUND = -1;
  
  /**
   * Constructs an empty CSProfessors object.
   */
  public CSProfessors() {
    professorList = new LinkedList<Professor>();
    numOfProfs = 0;
  }
  
  /** 
   * Construcst a CSProfessors object by taking in a text file.
   * 
   * @param fileName  a string from text file to be read to create Course object and stored in a LinkedList
   * @throws IOException  If input exception occurred (file is not found)
   */
  public CSProfessors (String fileName) {
    this();
    try {
      Scanner scan = new Scanner(new File(fileName));
      while (scan.hasNextLine()) {
        Professor p = new Professor (scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), 
                                     scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
        String line = scan.nextLine(); //skips over "#" in text file
        addProfessor(p); // adds professor object to LinkedList
      }
    }
    catch (IOException e) {
      System.out.println("This file was not found.");
    } 
  }
  
  /**
   * Returns a string representation of the CSProfessors object.
   * 
   * @return a string representation of the CSProfessors object.
   */
  public String toString() {
    String s = "Computer Science Professors for " + semester + ": \n";
    for (int i = 0; i < numOfProfs; i++) {
      s += professorList.get(i) + "\n";
    }
    return s;
  }
  
  /**
   * Returns the number of Professor objects in the CSProfessors object.
   * 
   * @return an integer of the number of Computer Science Professor objects in the professorList LinkedList
   */
  public int getNumOfProfs() {
    return numOfProfs;
  }
  
  /**
   * Returns the index value of the specified Professor object in the professorList LinkedList
   * 
   * @return an integer value of the index of the specified Professor object in the professorList LinkedList
   */
  public int findProfessor(Professor p) {
    return professorList.indexOf(p);
  }
  
  /**
   * Returns the Professor object found in the specified index of the professorList LinkedList
   * 
   * @return a Professor found in the specified index of the professorList LinkedList
   */
  public Professor getProfessor(int index) {
   return professorList.get(index); 
  }
  
  /**
   * Returns the Professor object which has the same name as the String found in the argument.
   * 
   * @return a Professor which has the same name as the specified String
   */
  public Professor findProfessorByName(String n) {
    Professor result = null;
    for (int i = 0; i < professorList.size(); i++) {
      if (professorList.get(i).getName().equals(n)) {
        result = professorList.get(i);
      }
    }
    return result;
  }
  
  /**
   * Method that adds a Professor object to the professorList LinkedList and increments the number of Professors. 
   * If the professor is already in the professorList, it is not added.
   */
  public void addProfessor (Professor p) {
    if (this.contains(p) != true) {
      professorList.add(p);
      numOfProfs++;
    } else {
      System.out.println("The professor is already in the list of professors.");
    }
  }
  
  /**
   * Method that removes a Professor object from the professorList LinkedList and decrements the number of Professors.
   */
  public void removeProfessor(Professor p) {
    professorList.remove(p);
  }
  
  /**
   * Returns true if the specified Professor is in the professorList LinkedList, false otherwise.
   *
   * @return a boolean which tells if the Professor is contained in the professorList or not
   */
  public boolean contains(Professor p) {
    return professorList.contains(p); 
  }
  
  /**
   * Returns the professorList LinkedList of CSProfessors.
   * 
   * @return a LinkedList of Professors
   */
  public LinkedList<Professor> getProfessorList() {
    return professorList;
  }
  
  // main method for testing
  public static void main (String[] args) {
    CSProfessors profList = new CSProfessors("CSProfessors.txt");
    System.out.println(profList);
    System.out.println(profList.findProfessorByName("P. Takis Metaxas").toString());
  }
  
}

