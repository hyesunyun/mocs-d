/** 
 * MOCS-D Project
 * File Name: QuizPanel.java
 * MapPanel creates a JPanel with a map depicting various relevent locations in 
 * the Wellesley CS department. 
 * The user is also able to click buttons labled with the numbers of individual
 * buttons which bring up more about the professors who work there.
 * @author Alison Savage
 * @version 1.0 December 9, 2014
 */

import javafoundations.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.net.*;
import java.io.*;


public class QuizPanel extends JPanel {
  
  //instance variables
  private LinkedBinaryTree<String> tree;
  private CSCourses courseList;
  private JButton startButton;
  private JLabel statusLabel;
  private String a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
  private LinkedBinaryTree<String> n2, n3, n4, n5, n6, n7, n8, n9, n10, n11;
  
  /**
   * Constructs the QuizPanel which includes a descriptive header, a start button
   * which begins a quiz for determining which introductory CS is right for the user
   * (based on a decision tree and executed using Yes/No questions in dialog
   * boxes), and a link to a website containing more detailed information
   * about each introductory course.
   */
  public QuizPanel() {
    
    // new JPanel to contain headers and button for starting quiz
    JPanel main = new JPanel(new BorderLayout());
    main.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    
    // new JPanel to contain image of CS department offices
    JPanel imagePanel = new JPanel(new BorderLayout());
    imagePanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    
    // new JPanel to contain a link to more information about intro courses
    // and a line of text describing the link
    JPanel linkPanel = new JPanel(new BorderLayout());
    linkPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    
    // backgrounds of all JPanels are set
    Color blue = new Color(0,191,255);
    setBackground (blue); 
    main.setBackground (blue); 
    imagePanel.setBackground(blue);
    linkPanel.setBackground(blue);
    
    // introductory text headers above button for starting quiz
    JLabel quizWelcome = new JLabel("<html>Which Introductory CS Course is Right for You?<html>", SwingConstants.CENTER);
    quizWelcome.setFont(new Font("San Serif", Font.BOLD, 16));
    quizWelcome.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    JLabel quizDescription = new JLabel("<html>Answer a series of Yes/No questions to determine which CS course you should start with.<html>", SwingConstants.CENTER);
    quizDescription.setFont(new Font("Sans Serif", Font.BOLD, 14));
    quizDescription.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
    // LinkedList of courses created to be accessed at end of quiz
    courseList = new CSCourses("CSCourses.txt");
    
    //elements of tree defined
    
    tree = new LinkedBinaryTree<String>();
    a1 = "Do you enjoy problem-solving?";
    a2 = "Computer Science courses may not be right for you!";
    a3 = "Do you prefer project-based courses?";
    a4 = "Are you planning to major in Computer Science?";
    a5 = "Are you more interested in a web-(select NO) or an app-(select YES) oriented course?";
    a6 = "Are you more interested in social (select NO) or natural/physical (select YES) sciences?";
    a7 = courseList.findCourseByName("CS 111-01").toString();
    a8 = courseList.findCourseByName("CS 110-01").toString();
    a9 = courseList.findCourseByName("CS 117-01").toString();
    a10 = courseList.findCourseByName("CS 114-01").toString();
    a11 = "We recommend CS 112: Computation for the Sciences (not offered in Fall 2014)";
    
    // decision tree nodes defined
    
    n10 = new LinkedBinaryTree<String>(a10);
    n11 = new LinkedBinaryTree<String>(a11);
    n6 = new LinkedBinaryTree<String>(a6, n10, n11);
    
    n7 = new LinkedBinaryTree<String>(a7);
    n4 = new LinkedBinaryTree<String>(a4, n6, n7);
    
    n8 = new LinkedBinaryTree<String>(a8);
    n9 = new LinkedBinaryTree<String>(a9);
    n5 = new LinkedBinaryTree<String>(a5, n8, n9);
    
    n3 = new LinkedBinaryTree<String>(a3,  n4, n5);
    
    n2 = new LinkedBinaryTree<String>(a2);
    
    tree = new LinkedBinaryTree<String> (a1, n2, n3);
    
    // text headers added to main JPanel
    main.add(quizWelcome, BorderLayout.NORTH);
    main.add(quizDescription, BorderLayout.SOUTH);
    
    //button for starting quiz
    startButton = new JButton("Start Quiz");
    main.add(startButton);
    startButton.addActionListener(new ButtonListener());
    
    //indicates whether user has begun quiz
    statusLabel = new JLabel("Unstarted");
    main.add(statusLabel, BorderLayout.EAST);
    
    //image located below button and text
    ImageIcon icon = new ImageIcon("csoffices.jpg");
    JLabel image = new JLabel(icon);   
    
    // JLabel describing link
    JLabel linkHeader = new JLabel ("<html>For more information about each introductory CS course, click the link below.</html>", SwingConstants.CENTER);
    
    // link JLabel created
    JLabel link =  new JLabel ("<html><br><u>Wellesley CS Introductory Courses</u></html>", SwingConstants.CENTER);
    link.setForeground(Color.blue);
    
    // JLabel link is turned into functional link
    goCSIntroWebsite(link);
    
    // link and linkHeader added to linkPanel
    linkPanel.add(linkHeader, BorderLayout.NORTH);
    linkPanel.add(link, BorderLayout.SOUTH);
    
    // main JPanel, image, and linkPanel JPanel are added to imagePanel JPanel
    imagePanel.add(main, BorderLayout.NORTH);
    imagePanel.add(image);
    imagePanel.add(linkPanel, BorderLayout.SOUTH);
    
    // imagePanel added to this JPanel
    add(imagePanel);
    
  }
  
  /**
   * Private class ActionListener for the button to start quiz.
   * When the button is clicked, the status label changes from "Unstarted" to
   * "Quiz Started" and the first dialog box with a Yes/No question appears.
   */
  class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      tree = new LinkedBinaryTree<String> (a1, n2, n3);
      if (event.getSource() == startButton) {
        
        statusLabel.setText("Quiz Started");
        while (tree.size() >= 2) {
          int reply = JOptionPane.showConfirmDialog(null,tree.getRootElement(),"QUIZ", JOptionPane.YES_NO_OPTION);
          if (reply == JOptionPane.YES_OPTION) {
            tree = tree.getRight();
          } else if (reply == JOptionPane.NO_OPTION) {
            tree = tree.getLeft();
          }
        }
        JOptionPane.showMessageDialog(null, tree.getRootElement(), "QUIZ COMPLETE", JOptionPane.PLAIN_MESSAGE);
      }
    }
  }
  
  
   /**
   * Method that opens the Wellesley Computer Science Introductory Courses webpage on a 
   * default browser when the specified JLabel is clicked.
   * 
   * @throws URISyntaxException If the url of the website/webpage is invalid
   * @throws IOException        If an input or output exception occurred
   */
  private void goCSIntroWebsite(JLabel website) {
    website.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("http://www.wellesley.edu/cs/curriculum/introductory"));
        } catch (URISyntaxException ex) {
          //if an exception appears
          System.out.println("There is a problem opening the URL");
        } catch (IOException exc) {
          System.out.println("There is a problem opening the URL");
        }
      }
    });
  }
  

  
  
}