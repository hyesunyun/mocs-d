/** 
 * MOCS-D Project
 * File Name: DependencyPanel.java
 * DependencyPanel creates a JPanel with an image of a graph depicting course dependencies. 
 * The user is also able to click a link to more information about CS major and
 * minor requirements.
 * @author Alison Savage
 * @version 1.0 December 9, 2014
 */

import javafoundations.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.net.*;
import java.io.*;

public class DependencyPanel extends JPanel {
  
  /**
   * Constructs the DependencyPanel which includes an image of a graph depicting 
   * course dependencies as well as a link to more information about requirements
   * for CS majors and minors.
   */
  public DependencyPanel () {
    
    // panel to contain text
    JPanel main = new JPanel(new BorderLayout());
    main.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    
    // background color and layout set
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    Color blue = new Color(0,191,255);
    main.setBackground (blue);
    
    // panel with BorderLayout and blue background to contain an image
    JPanel imagePanel = new JPanel(new BorderLayout());
    imagePanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    imagePanel.setBackground (blue);
    
    // panel with BorderLayout and blue background to contain a link
    JPanel linkPanel = new JPanel(new BorderLayout());
    linkPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    linkPanel.setBackground (blue);
    
    // two JLabels as a header to DependencyPanel (a and b) and one to create a space between them (c)
    JLabel a = new JLabel ("<html>Graph of Course Dependencies within the Wellesley College Computer Science Department</html>", SwingConstants.CENTER);
    a.setFont(new Font("San Serif", Font.BOLD, 24));
    
    JLabel b = new JLabel ("<html>To learn more about each course, visit the SEARCH tab!</html>", SwingConstants.CENTER);
    b.setFont(new Font("San Serif", Font.BOLD, 18));
    
    JLabel c = new JLabel ("          ");
    
    // ImageIcon created from jpg
    ImageIcon icon = new ImageIcon("CSDependenciesImage.jpg");
    JLabel image = new JLabel(icon);
    
    // JLabel describing link
    JLabel linkHeader = new JLabel ("<html>For more information about CS major and minor requirements, click the link below.</html>", SwingConstants.CENTER);
    
    // link JLabel created
    JLabel link =  new JLabel ("<html><br><u>Wellesley CS Major and Minor Requirements</u></html>", SwingConstants.CENTER);
    link.setForeground(Color.blue);
    
    // JLabel link is turned into fuctional link
    goCSMajorWebsite(link);
    
    // DependencyPanel header text is added to main panel
    main.add(a, BorderLayout.NORTH);
    main.add(b, BorderLayout.SOUTH);
    main.add(c);
    
    // linkHeader and actual link are added to linkPanel
    linkPanel.add(linkHeader, BorderLayout.NORTH);
    linkPanel.add(link, BorderLayout.SOUTH);
    
    //  main and linkPanel added to imagePanel, image added to imagePanel
    imagePanel.add(main, BorderLayout.NORTH);
    imagePanel.add(image);
    imagePanel.add(linkPanel, BorderLayout.SOUTH);
    
    //imagePanel added to DependencyPanel
    add(imagePanel);
  }
  
  /**
   * Method that opens the Wellesley Computer Science CS major and minor webpage on a 
   * default browser when the specified JLabel is clicked.
   * 
   * @throws URISyntaxException If the url of the website/webpage is invalid
   * @throws IOException        If an input or output exception occurred
   */
    private void goCSMajorWebsite(JLabel website) {
    website.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          Desktop.getDesktop().browse(new URI("http://www.wellesley.edu/cs/curriculum/major"));
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