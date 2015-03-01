/** 
 * MOCS-D Project
 * File Name: Professor.java
 * Course is a class that creates a Course object which stores various
 * information about the Course. The class also includes a method which returns true
 * if a certain word is contained in the toString() of a Course object.
 * @author Alison Savage
 * @version 1.0 November 25, 2014
 */

import java.util.*;

public class Professor {
  
  //instance variables
  
  private String name;
  private String location;
  private String hours;
  private String course1;
  private String course2;
  private String title;
  private String interest;
  private String email;
  
  /**
    * Constructs a Professor object with information given in the parameter
    * @param name           name of professor
    * @param location       professor's office location
    * @param hours          professor's office hours
    * @param course1        title of course taught
    * @param course2        title of second course taught
    * @param interest       specific interests in computer science
    * @param email          professor's email address
    */
  
  public Professor (String name, String officeLocation, String officeHours, String course1, String course2, String officialTitle, String csInterest, String email) {
    this.name = name;
    this.location = officeLocation;
    this.hours = officeHours;
    this.course1 = course1;
    this.course2 = course2;
    this.title = officialTitle;
    this.interest = csInterest;
    this.email = email;
  }
  
  /**
   * Returns the name of the professor.
   * 
   * @return a string of the professor's name
   */
  
  public String getName () {
    return name;
  }
  
  /**
   * Sets the official name to be the name found in the argument.
   * 
   * @param name a string of the name to be set as the official name of the professor
   */
  
  public void setName (String name) {
    this.name = name;
  }
  
  /**
   * Returns the office location of the professor.
   * 
   * @return a string of office location
   */
  
  public String getLocation () {
    return location;
  }
  
  /**
   * Sets the official office location to be the location found in the argument.
   * 
   * @param location  a string of the location to be set as the official location of the office
   */
  
  public void setLocation (String location) {
    this.location = location;
  }
  
  /**
   * Returns the office hours of the professor.
   * 
   * @return a string of the professor's office hours
   */
  
  public String getHours () {
    return hours;
  }
  
  /**
   * Sets the official office hours to be the hours found in the argument.
   * 
   * @param hours  a string of the office hours to be set as the official hours of the professor
   */
  
  public void setHours (String hours) {
    this.hours = hours;
  }
  
  /**
   * Returns the name of a course taught by the professor.
   * 
   * @return a string of the name of a course the professor teaches
   */
  
  public String getCourse1 () {
    return course1;
  }
  
  /**
   * Sets the official course taught to be the first course found in the argument.
   * 
   * @param course1  a string of the course name to be set as an official course taught by the professor
   */
  
  public void setCourse1 (String course1) {
    this.course1 = course1;
  }
  
  /**
   * Returns the name of another course taught by the professor.
   * 
   * @return a string of the name of another course the professor teaches
   */
  
  public String getCourse2 () {
    return course2;
  }
  
  /**
   * Sets another official course taught to be the second course found in the argument.
   * 
   * @param course2  a string of the course name to be set as another official course taught by the professor
   */
  
  public void setCourse2 (String course2) {
    this.course2 = course2;
  }
  
  /**
   * Returns the professor's official title.
   * 
   * @return a string of the professor's title
   */
  
  public String getTitle () {
    return title;
  }
  
  /**
   * Sets the professor's official title to be the title found in the argument.
   * 
   * @param title  a string of the title to be set as the official title of the professor
   */
  
  public void setTitle (String title) {
    this.title = title;
  }
  
  /**
   * Returns the specific CS interests of the professor.
   * 
   * @return a string of the professor's interests
   */
  
  public String getInterest () {
    return interest;
  }
  
  /**
   * Sets the official interests of the professor to be the interests found in the argument.
   * 
   * @param interest  a string of the interests to be set as the official CS interests of the professor
   */
  
  public void setInterest (String interest) {
    this.interest = interest;
  }
  
  /**
   * Returns the professor's email address.
   * 
   * @return a string of email address of the professor
   */
  
  public String getEmail () {
    return email;
  }
  
  /**
   * Sets the official professor email to be the email found in the argument.
   * 
   * @param email  a string of the email address to be set as the official email of the professor
   */
  
  public void setEmail (String email) {
    this.email = email;
  }
  
  /**
   * Returns a true boolean if two professor objects have the same office location. Returns false if the office locations do not match.
   * 
   * @return a boolean if the two professor objects being compared have the same office location or not
   */
  
  public boolean equals(Object x){
    Professor professor = (Professor)x;
    return this.getLocation().equals(professor.getLocation());
  }
  
  /**
   * Compares "this" Professor object with the specified Professor object for order. 
   * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
   * The objects are compared by their office locations.
   * 
   * @return an integer which tells the order of this Professor object compared to the specified Professor object.
   */
  
  public int compareTo(Professor other) {
    return location.compareTo(other.location);
  }
  
  /**
   * Returns true if the search word in the parameter is found in the string representation of the Professor object. 
   * If the search word is not found in the string representation of the Professor object, returns false.
   * 
   * @return a boolean if the specified word in the Professor object's string representation.
   */
  
  public boolean searchWordInProf(String searchWord) {
    boolean result = false;
    Scanner s = new Scanner(this.toString().toLowerCase());
    s.useDelimiter("[^\\w]+");
   while (s.hasNext()) {
     if (s.next().equals(searchWord.toLowerCase())) {
       return true;
     }
   }
   return result;
  }
  
  /**
   * Returns a string representation of this Professor object.
   * 
   * @return a string representation of the professor
   */
  
  public String toString () {
    String s = "Professor name: " + name + "\n";
    s += "Office location: " + location + "\n";
    s += "Office hours: " + hours + "\n";
    s += "Courses taught: " + course1 + ", " + course2 + "\n";
    s += "Official title: " + title + "\n";
    s += "CS interests: " + interest + "\n";
    s += "E-mail address: " + email + "\n";
    return s;
  }
  
  //main method for testing
  public static void main (String[] args) {
    Professor benWood = new Professor ("Ben Wood", "E128", "Monday 4:00-6:00pm, Tuesday 9:00-10:00am " + 
                                       "3:00-4:00pm, \n Thursday 4:00-5:30pm, Friday 11:30-12:30pm", "CS 230",
                                       "CS 240", "Assistant Professor of Computer Science", "programming languages, " +
                                       "compilers and run-time systems, computer architecture", "bwood5@wellesley.edu");
    Professor stellaK = new Professor ("Stella Kakavouli", "E131", "Wednesday 1:30-3pm, Thursday 9:30-11:30am",
                                       "CS 230", "CS117", "Instructor in Computer Science Laboratory", "not given", "skakavou@wellesley.edu");
    System.out.println(benWood);
    System.out.println(stellaK);
    System.out.println(benWood.compareTo(stellaK));
    System.out.println(stellaK.compareTo(benWood));
    System.out.println(stellaK.compareTo(stellaK));
  }
  
}