/** 
 * MOCS-D Project
 * File Name: MocsdGUI.java
 * MocsdGUI creates the Graphical User Interface for the MOCS-D program.
 * It instantiates the different JPanels in tabs for the program.
 * @author Hye Sun Yun
 * @author Alison Savage
 * @version 1.0 December 9, 2014
 */

import javax.swing.*; 

public class MocsdGUI {
  
 public static void main (String[] args) {
   // creates and shows a Frame 
    JFrame frame = new JFrame("MOCS-D (Map Of Computer Science Department)");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    JTabbedPane tp = new JTabbedPane();
    
    // adding the different tabs with JPanels
    tp.addTab ("INFORMATION", new InfoPanel());
    tp.addTab ("MAP", new MapPanel());
    tp.addTab ("COURSE GRAPH", new DependencyPanel());
    tp.addTab ("SEARCH", new SearchPanel("CSCourses.txt","CSProfessors.txt"));
    tp.addTab ("QUIZ", new QuizPanel());
    tp.addTab ("CREDITS", new CreditsPanel());
    
         
    frame.getContentPane().add(tp);
    frame.pack();
    frame.setVisible(true);

 }
 
}
