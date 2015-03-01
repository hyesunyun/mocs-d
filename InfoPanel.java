/** 
 * MOCS-D Project
 * File Name: InfoPanel.java
 * InfoPanel is a class that creates a JPanel which contains important
 * information about the MOCS-D program, its purpose, and its implementations.
 * @author Alison Savage
 * @version 1.0 November 25, 2014
 */

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Image;

public class InfoPanel extends JPanel {
  
  /**
   * InfoPanel is a class that creates a JPanel which contains important
   * information about the MOCS-D program, its purpose, and its implementations.
   */
  
  public InfoPanel() {
    
    // set background color of InfoPanel
    Color blue = new Color(0,191,255);
    setBackground (blue);
    
    // JPanel to contain image
    JPanel imagePanel = new JPanel(new BorderLayout());
    imagePanel.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, Color.black));
    
    // Box that contains the all JLabels 
    Box box = Box.createVerticalBox();
    
    // JLabels describing MOCS-D program
    JLabel l1 = new JLabel ("<html>Welcome to MOCS-D (Map of the Computer Science Department)!</html>", SwingConstants.CENTER);
    l1.setFont(new Font("San Serif", Font.BOLD, 25));
    JLabel l2 = new JLabel ("<html>This program will help you learn more about the Computer Science Department at Wellesley College and</html>", SwingConstants.CENTER);
    l2.setFont(new Font("San Serif", Font.BOLD, 18));
    JLabel l3 = new JLabel ("<html>to decide which introductory CS class might be right for you.</html>", SwingConstants.CENTER);
    l3.setFont(new Font("San Serif", Font.BOLD, 18));
    
    // JLabels describing the JPanel with a map of the CS department
    JLabel l4 = new JLabel ("<html>................................................................</html>", SwingConstants.CENTER);
    JLabel l5 = new JLabel ("<html>OFFICE MAP</html>", SwingConstants.CENTER);
    l5.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 15));
    l5.setForeground(Color.white);
    JLabel l6 = new JLabel ("<html>Select the 'OFFICE MAP' tab to view a visualization of the offices of the various professors and press buttons to learn more about each professor</html>", SwingConstants.CENTER);
    
    // JLabels describing the JPanel with the course dependencies graph
    JLabel l7 = new JLabel ("<html>................................................................</html>", SwingConstants.CENTER);
    JLabel l8 = new JLabel ("<html>COURSE GRAPH</html>", SwingConstants.CENTER);
    l8.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 15));
    l8.setForeground(Color.white);
    JLabel l9 = new JLabel ("<html>Select the 'COURSE GRAPH' tab to view a graph representing dependencies amongst CS Courses</html>", SwingConstants.CENTER);
    
    // JLabels describing the JPanel with various search options for courses and professors
    JLabel l10 = new JLabel ("<html>................................................................</html>", SwingConstants.CENTER);
    JLabel l11 = new JLabel ("<html>SEARCH<</html>", SwingConstants.CENTER);
    l11.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 15));
    l11.setForeground(Color.white);
    JLabel l12 = new JLabel ("<html>Select the 'SEARCH' tab to learn more about individual professors as well as the courses they teach.</html>", SwingConstants.CENTER);
    
    // JLabels describing the JPanel with a decision tree quiz
    JLabel l13 = new JLabel ("<html>................................................................</html>", SwingConstants.CENTER);
    JLabel l14 = new JLabel ("<html>QUIZ</html>", SwingConstants.CENTER);
    l14.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 15));
    l14.setForeground(Color.white);
    JLabel l15 = new JLabel ("<html>Select the 'QUIZ' tab to briefly answer some questions to determine which introductory CS course at Wellesley might be right for you.</html>", SwingConstants.CENTER);
    
    // JLabels describing the JPanel which elaborates on the creators of the program and the resources they used
    JLabel l16 = new JLabel ("<html>................................................................</html>", SwingConstants.CENTER);
    JLabel l17 = new JLabel ("<html>CREDITS</html>", SwingConstants.CENTER);
    l17.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 15));
    l17.setForeground(Color.white);
    JLabel l18 = new JLabel ("<html>Select the 'CREDITS' tab to learn more about the creators of this application, as well as about the resources used in developing the program.</html>", SwingConstants.CENTER);
    
    // image placed above text on "this" panel
    ImageIcon icon = new ImageIcon("cshall.jpg");
    JLabel image = new JLabel(icon);   
    image.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20, blue));
    
    // adding the JLabels to box
    box.add(l1);
    box.add(l2);
    box.add(l3);
    box.add(l4);
    box.add(l5);
    box.add(l6);
    box.add(l7);
    box.add(l8);
    box.add(l9);
    box.add(l10);
    box.add(l11);
    box.add(l12);
    box.add(l13);
    box.add(l14);
    box.add(l15);
    box.add(l16);
    box.add(l17);
    box.add(l18);
    
    //image is added to main panel
    imagePanel.add(image);
    
    // adding both main and box to "this" JPanel
    add(imagePanel, BorderLayout.SOUTH);
    add(box, BorderLayout.NORTH);
    
  }
  
}