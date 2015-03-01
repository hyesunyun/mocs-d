/** 
 * MOCS-D Project
 * File Name: SearchPanel.java
 * SearchPanel creates a JPanel with the search features. 
 * The user is able to search by entering a search word or selecting a certain
 * professor or course.
 * @author Hye Sun Yun
 * @version 1.0 December 9, 2014
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

public class SearchPanel extends JPanel {
  // instance variables
  private CSCourses csCourses;
  private CSProfessors csProfs;
  private JButton searchButton;
  private JLabel searchLabel, resultLabel;
  private JTextField bySearchWord;
  private JComboBox searchBy, byProfessors, byCourses;
  private JPanel titlePanel, instructions1Panel, instructions2Panel, boxPanel, resultPanel;
  private String selectedSearchBy, searchWord, selectedProfessor, selectedCourse; 
  private String[] searchByString, byProfessorString, byCoursesString;
  private DepartmentSearch hashtable;
  
  private String defaultResult = "Your result will be here.";
  private Color blue = new Color(0,191,255); // the blue color used throughout the entire JPanel
  
  
  /**
   * Constructs a SearchPanel by taking in course text file and professor text file.
   *
   * @param coursetxtFile  a string from a text file of information about courses
   * @param profstxtFile   a string from a text file of information about professors
   */
  public SearchPanel(String coursetxtFile, String profstxtFile) { 
    hashtable = new DepartmentSearch(coursetxtFile, profstxtFile); // instantiates the hashtable
    
    // set layout and background color of this JPanel
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    setBackground (blue);
    
    // JPanel containing title and instructions Jlabel 
    titlePanel = makeLabel("Wellesley College Computer Science Department Search", "San Serif", Font.BOLD, 25, Color.black, blue);
    
    instructions1Panel = makeLabel("The search feature allows the user to search by typing search word or choosing a specific professor or course.",
                                   "San Serif", Font.BOLD, 18, Color.black, blue);
    
    instructions2Panel = makeLabel("Use the drop box menu to choose the method of search.",
                                   "San Serif", Font.BOLD, 18, Color.black, blue);
    
    
    // JPanel with the combo boxes and search functions
    boxPanel = new JPanel();
    boxPanel.setBackground (blue);
    
    // JLabel for the searchWord textfield
    searchLabel = new JLabel("Search Box: ");
    // searchWord textfield
    bySearchWord = new JTextField (10);
    bySearchWord.addKeyListener
      (new KeyAdapter() { // KeyListener allows user to hit enter key to get results after typing a search word
      public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {   
          System.out.println("ENTER pressed");
          searchButton.doClick(); // if the key is ENTER, than the search button is clicked
        }
      }
    }
    );
    
    // String for the combo box to decide which way to search
    String[] search = {"Search By...", "by Search Word", "by Professor", "by Course"};
    
    searchByString = search;
    
    // String for the combo box containing the different professors of the department
    csProfs = new CSProfessors("CSProfessors.txt");
    byProfessorString = new String[csProfs.getNumOfProfs()+1];
    byProfessorString[0] = "Choose Professor";
    for (int i = 1; i < csProfs.getNumOfProfs()+1; i++) {
      byProfessorString[i] = csProfs.getProfessor(i-1).getName();
    }
    
    // String for the combo box containing the differenct courses offered in the semester
    csCourses = new CSCourses("CSCourses.txt");
    byCoursesString = new String[csCourses.getNumOfCourses()+1];
    byCoursesString[0] = "Choose Course";
    for (int i = 1; i < csCourses.getNumOfCourses()+1; i++) {
      byCoursesString[i] = csCourses.getCourse(i-1).getCourseNum();
    }
    
    
    // Search By... comboBox
    searchBy = new JComboBox(searchByString);
    searchBy.addActionListener (new SearchByListener());
    
    // by professor comboBox
    byProfessors = new JComboBox(byProfessorString);
    byProfessors.addActionListener (new ComboListener());
    
    // by Courses comboBox
    byCourses = new JComboBox(byCoursesString);
    byCourses.addActionListener (new ComboListener());
    
    selectedSearchBy = null;
    searchWord = null;
    selectedProfessor = null;
    selectedCourse = null; 
    
    // Search Button
    searchButton = new JButton("Search");
    searchButton.addActionListener(new ButtonListener());
    
    // Adding the Search By... comboBox to boxPanel
    boxPanel.add(searchBy);
    
    // Result Panel 
    resultPanel = new JPanel();
    resultPanel.setLayout(new BorderLayout(10,10));
    resultPanel.setBackground(blue);
    // resultLabel with defaultResult
    resultLabel = new JLabel(defaultResult, SwingConstants.CENTER);
    resultLabel.setFont(new Font("San Serif", Font.BOLD, 12));
    resultPanel.add(resultLabel,BorderLayout.PAGE_START);   
    
    // adding the different JPanels to this JPanel
    add(Box.createRigidArea(new Dimension (0,25)));
    add(titlePanel);
    add(Box.createRigidArea(new Dimension (0,15)));
    add(instructions1Panel);
    add(instructions2Panel);
    add(Box.createRigidArea(new Dimension (0,15)));
    add(boxPanel);
    add(Box.createRigidArea(new Dimension (0,30)));
    add(resultPanel);
  }
  
  /**
   * Method that creates a JPanel containing a specfic JLabel created by taking in the arguments.
   * 
   * @param s           a string for the JLabel
   * @param font        a string of the type of font for the JLabel
   * @prarm fontStyle   an integer of the font style for the JLabel
   * @param fontSize    an integer of the size of the font for the JLabel
   * @param fontColor   a color of the font for the JLabel
   * @param panelColor  a color of the background of the JPanel
   */
  static JPanel makeLabel(String s, String font, int fontStyle, int fontSize, Color fontColor, Color panelColor) {
    JLabel l = new JLabel(s);
    l.setHorizontalAlignment(JLabel.CENTER);
    l.setVerticalAlignment(JLabel.CENTER);
    l.setFont(new Font(font, fontStyle, fontSize));
    l.setForeground(fontColor);
    JPanel p = new JPanel(new BorderLayout());
    p.setBackground(panelColor);
    p.add(l, BorderLayout.CENTER);
    p.setMaximumSize(l.getMinimumSize()); // sets the maximum size of the JPanel to be the size of the JLabel
    return p;
  }
  
  /**
   * Private class ActionListener for the SearchBy combo box.
   * Based on how the user wants to search, the corresponding text field or combo box and search button appears.
   */
  private class SearchByListener implements ActionListener {
    
    //method taking in the values the user enters for each combo box
    public void actionPerformed (ActionEvent event) {
      
      // initialize all the variables to be null everytime the user selects the SearchBy combo box
      selectedSearchBy = null;
      searchWord = null;
      selectedProfessor = null;
      selectedCourse = null;
      
      selectedSearchBy = searchByString[searchBy.getSelectedIndex()];
      
      resultPanel.add(resultLabel, BorderLayout.PAGE_START);
      
      boxPanel.removeAll();
      boxPanel.add(searchBy);
      
      if (selectedSearchBy.equals(searchByString[0])) { // if no specific choice is made
        
        resultLabel.setText("Please select how you would like to search.");
        
      } else if (selectedSearchBy.equals(searchByString[1])) { // if the user selects search by search word
        resultLabel.setText(defaultResult);
        boxPanel.add(searchLabel);
        boxPanel.add(bySearchWord);
        boxPanel.add(searchButton);
        
        add(boxPanel);
        add(resultPanel);
        
      } else if (selectedSearchBy.equals(searchByString[2])) { // if the user selects search by professors
        resultLabel.setText(defaultResult);
        boxPanel.add(byProfessors);
        boxPanel.add(searchButton);
        
        add(boxPanel);
        add(resultPanel);
        
      } else { // if the user selects search by courses
        resultLabel.setText(defaultResult);
        boxPanel.add(byCourses);
        boxPanel.add(searchButton);
        
        add(boxPanel);
        add(resultPanel);
      }
    }
  }
  
  /**
   * Private class ActionListener to get the name of Professor or Course from a combo box.
   */
  private class ComboListener implements ActionListener {
    public void actionPerformed (ActionEvent e) {
      
      if (selectedSearchBy != null) {
        
        if (selectedSearchBy.equals(searchByString[0])) { // if SearchBy combo box is still Search by...
          resultLabel.setText("Please select how you would like to search.");
        } else if (selectedSearchBy.equals(searchByString[2])) { // if the user selects search by Professor
          selectedProfessor = byProfessorString[byProfessors.getSelectedIndex()]; // get the selected Professor
        } else { // if the user selects search by Course
          selectedCourse = byCoursesString[byCourses.getSelectedIndex()]; // get the selected Course
        }
      }
    }
  }
  
  /**
   * Private class ActionListener for the search button. When the search button is clicked, the results are displayed.
   */
  private class ButtonListener implements ActionListener {
    //create pane to show the results of the search
    JTextPane textPane = new JTextPane();
    JScrollPane scrollPane = new JScrollPane(textPane);
    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);
    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
    
    
    public void actionPerformed (ActionEvent event) {
      textPane.setText(""); // set the text of the textPane to be empty
      
      // Style details for the document
      StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
      StyleConstants.setFontSize(style, 12);
      StyleConstants.setSpaceAbove(style, 3);
      StyleConstants.setSpaceBelow(style, 3);
      
      
      textPane.setDocument(document); // sets document to textPane
      textPane.setEditable(false);
      textPane.setBackground(blue);
      
      // scroll feature for the results
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBorder(BorderFactory.createEmptyBorder());
      
      // adding the scrollPane which contains the textPane (results)
      resultPanel.add(scrollPane, BorderLayout.CENTER);
      
      if (selectedSearchBy.equals(searchByString[1])) { // if the user selects to search by search word
        searchWord = bySearchWord.getText(); // get the search word from the text field
      }
      
      if (searchWord != null) { // Results: search word
        System.out.println(searchWord);
        resultLabel.setText("<html><center>Your Result:</center><br><center>Search Word: " + searchWord + "</html>");
        CSProfsAndCourses result = hashtable.getSearchResult(searchWord); // get the results from hashtable 
        
        if (result != null) {
          try {
            document.insertString(document.getLength(), result.toString(), style); // result is inserted to the document
          } catch (BadLocationException badLocationException) {
            System.err.println("Error");
          }
          
        } else { // if there is no result for the search word/if the search word is invalid
          resultLabel.setText("<html><center>NO Result for the search word: " + searchWord +
                              "</center><br>Please type in a new search word. Search word with space(s)/punctuations does not work.</html>");
        }
        
      } else if (selectedProfessor != null) { // Results: professor
        System.out.println(selectedProfessor);
        
        if (selectedProfessor.equals("Choose Professor")) {
          textPane.setText("");
          resultLabel.setText("Please select a specific professor or course");
        } else {
          
          resultLabel.setText("<html><center>Your Result:</html>");
          Professor result = csProfs.findProfessorByName(selectedProfessor); // get the result by finding the specified professor
          
          if (result != null) {
            try {
              document.insertString(document.getLength(), result.toString(), style); // result is inserted to the document
            } catch (BadLocationException badLocationException) {
              System.err.println("Error");
            }
            
          }
        }
      } else if (selectedCourse !=null) { // Results: course
        System.out.println(selectedCourse);
        
        if (selectedCourse.equals("Choose Course")) {
          textPane.setText("");
          resultLabel.setText("Please select a specific professor or course");
        } else {
          
          resultLabel.setText("<html></center>Your Result:</html>");
          Course result = csCourses.findCourseByName(selectedCourse); // get the result by finding the specified course
          
          if (result != null) {
            try {
              document.insertString(document.getLength(), result.toString(), style); // result is inserted to the document
            } catch (BadLocationException badLocationException) {
              System.err.println("Error");
            }
          }
        }
      } else {
        // if user does not pick a specific professor or course from a combo box, this message appears.
        textPane.setText("");
        resultLabel.setText("Please select a specific professor or course");
      }
    }
  }
}




