/** 
 * MOCS-D Project
 * File Name: DepartmentSearch.java
 * CSProfsAndCourses is a class that creates an object that contains both CSProfessors and CSCourses.
 * CSProfsAndCourses is used to store professors and the courses of the Computer Science Department.
 * @author Hye Sun Yun
 * @version 1.0 December 10, 2014
 */

import java.io.*;
import java.util.*;

public class DepartmentSearch {
  //instance vars
  Hashtable<String,CSProfsAndCourses> hashtable; // String word is the key, CSProfsAndCourses with objects containing the word (key) is the value
  CSProfsAndCourses lists; // CSProfsAndCourses is used for the value of the hashtable
  
  /**
   * Constructs the DepartmentSearch which is a hashtable. The keys are the words found in the text files. 
   * The values are the CSProfsAndCourses which contains the objects containing the key word.
   *
   * @param coursetxtFile  a string of text file with information about courses
   * @param proftxtFile    a string of text file with information about professors
   * @throws IOException    If input or output exception occurred
   */
  public DepartmentSearch(String coursetxtFile, String proftxtFile) {
    hashtable = new Hashtable<String,CSProfsAndCourses>(10000);
    lists = new CSProfsAndCourses(coursetxtFile, proftxtFile);
    
    // Read through the course text file and add the words to hashtable
    try {
      Scanner reader = new Scanner(new File(coursetxtFile));
      
      while (reader.hasNext()) {
        String word = reader.next().trim().toLowerCase(); // All the words from text file are lowercase
        hashtable.put(word, lists.containsSearchWord(word)); // value of hashtable is found by calling the method found in CSProfsAndCourses class
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("error in reading words from file: " + coursetxtFile);
    }
    
    // Read through the professor text file and add the words to hashtable
    try {
      Scanner reader = new Scanner(new File(proftxtFile));
      
      while (reader.hasNext()) {
        String word = reader.next().trim().toLowerCase(); // All the words from text file are lowercase
        hashtable.put(word, lists.containsSearchWord(word)); // value of hashtable is found by calling the method found in CSProfsAndCourses class
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("error in reading words from file: " + proftxtFile);
    }
    
  }
  
  /**
   * Returns true if specified string word contains in the hashtable.
   * 
   * @return a boolean which explains if the specified string word is contained in the hashtable.
   */
  public boolean searchWord(String word) {
    return hashtable.containsKey(word.trim().toLowerCase());
  } 
  
  /**
   * Returns the CSProfsAndCourses that contains the specified string search word by returning the value of
   * the search word in the hashtable.
   * 
   * @return a CSProfsAndCourses object which is the value for the specified string search word found in the hashtable
   */
  public CSProfsAndCourses getSearchResult(String searchWord) {
    CSProfsAndCourses searchResults = null; 
    if (this.lists.isContainsSearchWord(searchWord)) {
      searchResults = this.hashtable.get(searchWord.toLowerCase()); // result gets the value of key (search word in lowercase)
    } else {
      System.out.println("search word not found!");
    }
    return searchResults;  
  }
  
  // main method for testing
  public static void main(String[] args) {
    DepartmentSearch ds = new DepartmentSearch("CSCourses.txt","CSProfessors.txt");
    //System.out.println("web: " + ds.searchWord("web"));
    //System.out.println("pizza: " + ds.searchWord("pizza"));
    //System.out.println(ds.getSearchResult("science"));
    //System.out.println(ds.getSearchResult("web"));
    System.out.println(ds.getSearchResult("111"));
  }
}