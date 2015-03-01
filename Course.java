/** 
 * MOCS-D Project
 * File Name: Course.java
 * Course is a class that creates a Course object which stores various
 * information about the Course. The class also includes a method which returns true
 * if a certain word is contained in the toString() of a Course object.
 * @author Hye Sun Yun
 * @version 1.0 November 25, 2014
 */

import java.util.*;

public class Course implements Comparable<Course>{
  /**instance variables*/
  private String courseNum, courseTitle, meetingTimes, prerequisite, briefInfo, roomNum, professor;
  
  /**
   * Constructs a Course object with information given in the parameter
   * @param courseNum      a string of the course number
   * @param courseTitle    a string of the official course title
   * @param briefInfo      a string of description of the course
   * @param prerequisite   a string of the prerequistie(s) for the course
   * @param meetingTimes   a string of the when the course meets for class time
   * @param professor      a string of the professor/instructor who teaches the course
   * @param roomNum        a string of the location of where the course is taught
   */
  public Course (String courseNum, String courseTitle, String briefInfo, String prerequisite, String meetingTimes, String professor, String roomNum) {
    this.courseNum = courseNum;
    this.courseTitle = courseTitle;
    this.briefInfo = briefInfo;
    this.prerequisite = prerequisite;
    this.meetingTimes = meetingTimes;
    this.professor = professor;
    this.roomNum = roomNum;
  }
  
  /**
   * Returns the official course number of the course.
   * 
   * @return a string of the course number of the course
   */
  public String getCourseNum() {
    return courseNum; 
  }
  
  /**
   * Sets the official course number to be the course number found in the argument.
   * 
   * @param courseNum  a string of the course number to be set as the official course number of the course
   */
  public void setCourseNum(String courseNum) {
    this.courseNum = courseNum;
  }
  
  /**
   * Returns the official course title of the course.
   * 
   * @return a string of the course title of the course
   */
  public String getCourseTitle() {
    return courseTitle;
  }
  
  /** 
   * Sets the official course title to be the course title found in the argument.
   * 
   * @param courseTitle  a string of the course title to be set as the official course title of the course
   */
  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle; 
  }
  
  /**
   * Returns the meeting times of the course.
   * 
   * @return a string of the meeting time of the course
   */
  public String getMeetingTimes() {
    return meetingTimes;
  }
  
  /**
   * Sets the meeting times of the course to be the meeting times found in the argument.
   * 
   * @param meetingTimes  a string of the meeting times to be set as the meeting times of the course
   */
  public void setMeetingTimes(String meetingTimes) {
    this.meetingTimes = meetingTimes; 
  }
  
  /**
   * Returns the prerequisite(s) of the course.
   * 
   * @return a string of the prerequisite(s) of the course
   */
  public String getPrerequisite() {
    return prerequisite;
  }
  
  /**
   * Sets the prerequisite(s) of the course to be the prerequisite course(s) found in the argument.
   * 
   * @param prerequisite  a string of the prerequisite course(s) to be set as the prerequisite(s) of the course
   */
  public void setPrerequisite(String prerequisite) {
    this.prerequisite = prerequisite; 
  }
  
  /**
   * Returns the brief information/description about the course.
   * 
   * @return a string of a brief information/description about the course.
   */
  public String getbriefInfo() {
    return briefInfo;
  }
  
  /**
   * Sets the brief information/description of the course to be information/description found in the argument.
   * 
   * @param briefInfo  a string of the information/description to be set as the information/description of the course
   */
  public void setBriefInfo(String briefInfo) {
    this.briefInfo = briefInfo; 
  }
  
  /**
   * Returns the professor who is teaching the course.
   * 
   * @return a string of the name of the professor who is teaching the course
   */
  public String getProfessor() {
    return professor;
  }
  
  /**
   * Sets the name of the professor who is teaching the course to be set as the professor found in the argument.
   * 
   * @param professor  a string of the name of the professor to be set as the professor of the course
   */
  public void setProfessor(String professor) {
    this.professor = professor; 
  }
  
  /**
   * Returns the room number/location where the course is being taught.
   * 
   * @return a string of the room number/location where the course is being taught
   */
  public String getRoomNum() {
    return roomNum;
  }
  
  /**
   * Sets the room number of the course to be set as the room number found in the argument.
   * 
   * @param roomNum  a string of the room number to be set as the room number of the course
   */
  public void setRoomNum(String roomNum) {
    this.roomNum = roomNum; 
  }
  
  /**
   * Returns a true boolean if two course objects have the same course number. Returns false if the course number do not match.
   * 
   * @return a boolean if the two course objects being compared have the same course number or not
   */
  public boolean equals(Object c){
    Course course = (Course) c;
    return this.getCourseNum().equals(course.getCourseNum());
  }
  
  /**
   * Compares this Course object with the specified Course object for order. 
   * Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
   * The objects are compared by their course numbers.
   * 
   * @return an integer which tells the order of this Course object compared to the specified Course object.
   */
  public int compareTo (Course other) {
    return courseNum.compareTo(other.courseNum);
  }
  
  /**
   * Returns true if the search word in the parameter is found in the string representation of the Course object. 
   * If the search word is not found in the string representation of the Course object, returns false.
   * 
   * @return a boolean if the specified word in the Course object's string representation.
   */
  public boolean searchWordInCourse(String searchWord) {
    boolean result = false;
    Scanner s = new Scanner(this.toString().trim().toLowerCase());
    s.useDelimiter("[^\\w]+");
    while (s.hasNext()) {
      if (s.next().equals(searchWord.trim().toLowerCase())) {
        return true;
      }
    }
    s.close();
    return result;
  }
  
  /**
   * Returns a string representation of this Course object.
   * 
   * @return a string representation of the course
   */
  public String toString() {
    String s = "Course: " + courseNum + "\n";
    s += "Title: " + courseTitle + "\n";
    // wrap of the briefInfo String to avoid having one line of very very long String
    String f = briefInfo;
    int spaceCounter = 0; // counts the number of space that comes after a word
    String print = ""; // the wrapped String
    for (int i = 0; i < f.length(); i++) {
      if (f.charAt(i) != ' ') { // if the char is not a space
        print += f.charAt(i); // add the character to print String
      } else if (f.charAt(i) == ' ' && spaceCounter < 20)  { // if the char is a space and the spaceCounter is less than 20
        print += f.charAt(i); // add the character to print String
        spaceCounter++;
      } else { // if the spaceCounter is or greater than 20
        print += "\n"; // start a new line
        spaceCounter = 0; // spaceCounter is reset
      }
    }
    
    s += "Information: " + print + "\n";
    s += "Prerequisite(s): " + prerequisite + "\n";
    s += "Meeting Times: "  + meetingTimes + "\n";
    s += "Professor: " + professor + "\n";
    s += "Room number: " + roomNum + "\n";
    return s;
  }
  
  //main method for testing
  public static void main (String[] args) {
    Course cs111 = new Course("CS111", "Programming and stuuf", "Bla bla. bal BUGGG yay", "CS101", "M,TH 2:30-10:00pm", "Peach", "124");
    Course cs240 = new Course("CS240", "Dancing and Coding", "we the people. of cs like to party!!", "CS2222", "TU 1-1:10pm", "Apple", "Room 1034");
    System.out.println(cs111);
    System.out.println(cs240);
//    System.out.println("expected results (-1): " + cs111.compareTo(cs240));
//    System.out.println("expected results (1): " + cs240.compareTo(cs111));
//    System.out.println("expected results (0): " + cs240.compareTo(cs240));
//    System.out.println("Does cs111 contain word stuuf?(true) " + cs111.searchWordInCourse("stuuf"));
//    System.out.println("Does cs111 contain word web?(false) " + cs111.searchWordInCourse("web"));
//    System.out.println("Does cs111 contain word cs?(false) " + cs111.searchWordInCourse("cs"));
    System.out.println("Does cs240 contain word room?(true) " + cs240.searchWordInCourse("room"));
    System.out.println("Does cs240 contain word we?(true) " + cs240.searchWordInCourse("we"));
    System.out.println("Does cs240 contain word CS240?(true) " + cs240.searchWordInCourse("CS240"));
    System.out.println("Does cs240 contain word pear?(false) " + cs240.searchWordInCourse("pear"));
    System.out.println("Does cs240 contain word apple?(true) " + cs240.searchWordInCourse("apple"));
    System.out.println("Does cs240 contain word 1034?(true) " + cs240.searchWordInCourse("1034"));
  }
  
}