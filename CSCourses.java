/** 
 * MOCS-D Project
 * File Name: CSCourse.java
 * CSCourses is a class that creates a LinkedList that stores Course objects.
 * CSCourses is a good way to store all the Computer Science courses from a specified semester.
 * CSCourses can be constructed by taking in a text file or without a text file.
 * @author Hye Sun Yun
 * @version 1.0 November 25, 2014
 */

import java.util.*;
import java.io.*;

public class CSCourses {
  // instance variables
  private LinkedList<Course> courseList;
  private int numOfCourses;
  
  private static String semester = "Fall 2014";
  private final int NOT_FOUND = -1;
  
  /**
   * Constructs an empty CSCourses object.
   */
  public CSCourses() {
    courseList = new LinkedList<Course>(); 
    numOfCourses = 0;
  }
  
  /** 
   * Construcst a CSCourses object by taking in a text file.
   * 
   * @param fileName  a string from text file to be read to create Course object and stored in a LinkedList
   * @throws IOException  If input exception occurred
   */
  public CSCourses(String fileName) {
    this();
    try {
      Scanner scan = new Scanner(new File(fileName));
      while (scan.hasNextLine()) {
        Course c = new Course(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine());
        String line = scan.nextLine(); // takes care of the "#" 
        addCourse(c); // after creating a Course object, it is added to the courseList LinkedList
      }
    }
    catch (IOException e) {
      System.out.println("Not able to read file: " + fileName);
    }
  }
  
  /**
   * Returns a string representation of the CSCourses object.
   * 
   * @return a string representation of the CSCourses object.
   */
  public String toString() {
    String s = "Computer Science Courses for " + semester + ":\n";
    for (int i = 0; i < courseList.size(); i++) {
      s += courseList.get(i) + "\n";
    }
    return s;
  }
  
  /**
   * Returns the number of Course objects in the CSCourses object.
   * 
   * @return an integer of the number of Computer Science Course objects in the courseList LinkedList
   */
  public int getNumOfCourses() {
    return numOfCourses;
  }
  
  /**
   * Returns the Course object found in the specified index of the courseList LinkedList
   * 
   * @return a Course found in the specified index of the courseList LinkedList
   */
  public Course getCourse(int index) {
    return courseList.get(index); 
  }
  
  /**
   * Returns the index value of the specified Course object in the courseList LinkedList
   * 
   * @return an integer value of the index of the specified Course object in the courseList LinkedList
   */
  public int findCourseIndex(Course c) {
    return courseList.indexOf(c);
  }
  
  /**
   * Returns the Course object which has the same course number as the String found in the argument.
   * 
   * @return a Course which has the same course number as the specified String
   */
  public Course findCourseByName(String n) {
    for (int i = 0; i < numOfCourses; i++) {
      if (this.getCourse(i).getCourseNum().equals(n)) { //get the course number of the course at index i and then compare it with the specified string
        return this.getCourse(i);
      }
    }
    return null;
  }
  
  /**
   * Method that adds a Course object to the courseList LinkedList and increments the number of Courses. 
   * If the course is already in the courseList, it is not added.
   */
  public void addCourse(Course c) {
    if (this.contains(c) != true) { // checking if the course is in the courseList or not
      courseList.add(c);
      numOfCourses++;
    } else {
      // message if the course is already in the courseList
      System.out.println("The course is already in the list of courses.");
    }
  }
  
  /**
   * Method that removes a Course object from the courseList LinkedList and decrements the number of Courses.
   */
  public void removeCourse(Course c) {
    courseList.remove(c);
    numOfCourses--;
  }
  
  /**
   * Returns true if the specified Course is in the courseList LinkedList, false elsewise.
   *
   * @return a boolean which tells if the Course is contained in the courseList or not
   */
  public boolean contains(Course c) {
    return courseList.contains(c); 
  }
  
  /**
   * Returns the courseList LinkedList of CSCourses.
   * 
   * @return a LinkedList of Course 
   */
  public LinkedList<Course> getCourseList() {
    return courseList;
  }
  
  // main method for testing
  public static void main (String[] args) {
    CSCourses csList = new CSCourses("CSCourses.txt");
    System.out.println(csList);
    System.out.println("Course index of 1:\n" + csList.getCourse(1));
    System.out.println("Course CS 235-01:\n" + csList.findCourseByName("CS 235-01"));
    System.out.println("Number of Total courses: " + csList.getNumOfCourses());
  }
  
  
}