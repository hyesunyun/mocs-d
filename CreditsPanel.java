/** 
 * MOCS-D Project
 * File Name: CreditsPanel.java
 * CreditsPanel is a class that creates a JPanel which contains important
 * information about the authors of the MOCS-D program and the help received and resources used to
 * create the program.
 * @author Hye Sun Yun
 * @version 1.0 November 25, 2014
 */

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;

public class CreditsPanel extends JPanel {
  
  /**
   * Constructs the CreditsPanel which includes information about the authors of the MOCS-D program
   * and the  help received and the resources used and to create the program.
   */
  public CreditsPanel() {
    // setting this panel background to a specific color
    Color blue = new Color(0,191,255);
    setBackground (blue);
    
    // JPanel for the image
    JPanel main = new JPanel(new BorderLayout());
    main.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, Color.black)); 
    
    // Box that contains the all JLabels 
    Box box = Box.createVerticalBox();

    // creates the JLabels about authors and the resources used to create the program
    JLabel l1 = new JLabel ("Thank you for using MOCS-D (Map Of Computer Science Department)!", SwingConstants.CENTER);
    l1.setFont(new Font("San Serif", Font.BOLD, 23));
    JLabel l2 = new JLabel ("<html>-------------------------------------------------------------------------------</html>", SwingConstants.CENTER);
    JLabel l3 = new JLabel ("<html>CS 230 Fall 2014 Project</html>", SwingConstants.CENTER);
    l3.setFont(new Font("San Serif", Font.BOLD, 20));
    JLabel l4 = new JLabel ("<html>-------------------------------------------------------------------------------</html>", SwingConstants.CENTER);
    
    // Information about the authors of the program
    JLabel l5 = new JLabel ("<html><br>Creators</html>", SwingConstants.CENTER);
    l5.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 18));
    l5.setForeground(Color.white);
    JLabel l6 = new JLabel ("<html><br>Alison Savage ('17)</html>", SwingConstants.CENTER);
    l6.setFont(new Font("San Serif", Font.BOLD, 15));
    JLabel l7 = new JLabel ("<html>Alison loves owls and art!</html>", SwingConstants.CENTER);
    JLabel l8 = new JLabel ("<html><br>Hye Sun Yun ('17)</html>", SwingConstants.CENTER);
    l8.setFont(new Font("San Serif", Font.BOLD, 15));
    JLabel l9 = new JLabel ("<html>Hye Sun loves cereal and puns!</html>", SwingConstants.CENTER);
    
    JLabel l10 = new JLabel ("<html><br>-------------------------------------------------------------------------------</html>", SwingConstants.CENTER);
    
    // Special Thanks
    JLabel l11 = new JLabel ("<html>Special Thanks To!</html>", SwingConstants.CENTER);
    l11.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 18));
    l11.setForeground(Color.white);
    JLabel l12 = new JLabel ("<html><br>CS230 professors: Orit Shaer, Ben Wood, Stella Kakavouli</html>", SwingConstants.CENTER);
    
    
    JLabel l13 = new JLabel ("<html><br>-------------------------------------------------------------------------------</html>", SwingConstants.CENTER);
    
    // Resources used to create the program
    JLabel l14 =  new JLabel ("<html>Resources</html>", SwingConstants.CENTER);
    l14.setFont(new Font("San Serif", Font.BOLD+Font.ITALIC, 18));
    l14.setForeground(Color.white);
    
    JLabel l15 = new JLabel ("<html>For more information, click on the hyperlink to open websites/webpages</html>", SwingConstants.CENTER);
    
    
    JLabel l16 =  new JLabel ("<html><br><u>Wellesley Computer Science Department Webpage</html>", SwingConstants.CENTER);
    l16.setForeground(Color.blue);
    // Setting l16 to be the JLabel, when clicked, opens the Wellesley Computer Science Department Webpage
    goCSDeptWebsite(l16);

    // Image that is placed main JPanel
    ImageIcon icon = new ImageIcon("cshci.jpg");
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
    
    // adding the image to main
    main.add(image);
    
    // adding both main and box to this JPanel
    add(main, BorderLayout.SOUTH);
    add(box, BorderLayout.NORTH);
  }
  
  /**
   * Method that opens the Wellesley Computer Science department webpage on a default browser when the specified JLabel is clicked.
   * 
   * @throws URISyntaxException If the url of the website/webpage is invalid
   * @throws IOException        If an input or output exception occurred
   */
  private void goCSDeptWebsite(JLabel website) {
    website.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("http://www.wellesley.edu/cs"));
        } catch (URISyntaxException ex) {
          System.out.println("There is a problem opening the URL");
        } catch (IOException exc) {
          System.out.println("There is a problem opening the URL");
        }
      }
    });
  }
  
}

