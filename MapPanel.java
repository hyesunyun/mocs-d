/** 
 * MOCS-D Project
 * File Name: MapPanel.java
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
import java.awt.Image;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import javax.swing.border.Border;


public class MapPanel extends JPanel {
  
  //instance variables
  private CSProfessors profList;
  private JButton e131, e129, e128, e127, e126, e120, e116, e114, e112, e108, e106, e104;
  private String[] byProfessorString;
  Border raisedbevel;
  
  /**
   * Constructs the MapPanel which includes a map depicting various relevent locations in 
   * the Wellesley CS department as well as buttons labled with the numbers of individual
   * buttons which bring up more about the professors who work there.
   */
  public MapPanel () {
    
    // JPanel with BorderLayout to contain text header, image and buttons
    JPanel main = new JPanel(new BorderLayout());
    main.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    
    // set layout and background color of this JPanel
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
    Color blue = new Color(0,191,255);
    main.setBackground (blue); 
    
    // JLabel containing text header of MapPanel
    JLabel a = new JLabel ("<html>Map of the Wellesley College Computer Science Department</html>", SwingConstants.CENTER);
    a.setFont(new Font("San Serif", Font.BOLD, 24));
    a.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    
    // creates ImageIcon from jpg
    ImageIcon icon = new ImageIcon("CSMapImage.jpg");
    JLabel image = new JLabel(icon);  
    
    // defines Border raisedbevel for modifying buttons
    raisedbevel = BorderFactory.createRaisedBevelBorder();
    
    // new JPanel to contain office buttons
    JPanel buttons = new JPanel();
    
    // set layout and background color
    BoxLayout boxLayout = new BoxLayout(buttons, BoxLayout.Y_AXIS);
    buttons.setLayout(boxLayout);
    buttons.setBackground (blue); 
    buttons.add(Box.createVerticalGlue());
    buttons.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    
    // all office buttons created with same background colors, opacity, and border type
    JButton e131 = new JButton("   e131   ");
    e131.setFont(new Font("San Serif", Font.BOLD, 16));
    e131.setBackground(Color.ORANGE); 
    e131.setContentAreaFilled(false);
    e131.setOpaque(true);
    e131.setBorder(raisedbevel);
    
    JButton e129 = new JButton("   e129   ");
    e129.setFont(new Font("San Serif", Font.BOLD, 16));
    e129.setBackground(Color.ORANGE); 
    e129.setContentAreaFilled(false);
    e129.setOpaque(true);
    e129.setBorder(raisedbevel);
    
    JButton e128 = new JButton("   e128   ");
    e128.setFont(new Font("San Serif", Font.BOLD, 16));
    e128.setBackground(Color.ORANGE); 
    e128.setContentAreaFilled(false);
    e128.setOpaque(true);
    e128.setBorder(raisedbevel);
    
    JButton e127 = new JButton("   e127   ");
    e127.setFont(new Font("San Serif", Font.BOLD, 16));
    e127.setBackground(Color.ORANGE); 
    e127.setContentAreaFilled(false);
    e127.setOpaque(true);
    e127.setBorder(raisedbevel);
    
    JButton e126 = new JButton("   e126   ");
    e126.setFont(new Font("San Serif", Font.BOLD, 16));
    e126.setBackground(Color.ORANGE); 
    e126.setContentAreaFilled(false);
    e126.setOpaque(true);
    e126.setBorder(raisedbevel);
    
    JButton e120 = new JButton("   e120   ");
    e120.setFont(new Font("San Serif", Font.BOLD, 16));
    e120.setBackground(Color.ORANGE); 
    e120.setContentAreaFilled(false);
    e120.setOpaque(true);
    e120.setBorder(raisedbevel);
    
    JButton e116 = new JButton("   e116   ");
    e116.setFont(new Font("San Serif", Font.BOLD, 16));
    e116.setBackground(Color.ORANGE); 
    e116.setContentAreaFilled(false);
    e116.setOpaque(true);
    e116.setBorder(raisedbevel);
    
    JButton e114 = new JButton("   e114   ");
    e114.setFont(new Font("San Serif", Font.BOLD, 16));
    e114.setBackground(Color.ORANGE); 
    e114.setContentAreaFilled(false);
    e114.setOpaque(true);
    e114.setBorder(raisedbevel);
    
    JButton e112 = new JButton("   e112   ");
    e112.setFont(new Font("San Serif", Font.BOLD, 16));
    e112.setBackground(Color.ORANGE); 
    e112.setContentAreaFilled(false);
    e112.setOpaque(true);
    e112.setBorder(raisedbevel);
    
    JButton e108 = new JButton("   e108   ");
    e108.setFont(new Font("San Serif", Font.BOLD, 16));
    e108.setBackground(Color.ORANGE); 
    e108.setContentAreaFilled(false);
    e108.setOpaque(true);
    e108.setBorder(raisedbevel);
    
    JButton e106 = new JButton("   e106   ");
    e106.setFont(new Font("San Serif", Font.BOLD, 16));
    e106.setBackground(Color.ORANGE); 
    e106.setContentAreaFilled(false);
    e106.setOpaque(true);
    e106.setBorder(raisedbevel);
    
    JButton e104 = new JButton("   e104   ");
    e104.setFont(new Font("San Serif", Font.BOLD, 16));
    e104.setBackground(Color.ORANGE); 
    e104.setContentAreaFilled(false);
    e104.setOpaque(true);
    e104.setBorder(raisedbevel);
    
    // ButtonListener ActionListeners added to each button
    e131.addActionListener(new ButtonListener());
    e129.addActionListener(new ButtonListener());
    e128.addActionListener(new ButtonListener());
    e127.addActionListener(new ButtonListener());
    e126.addActionListener(new ButtonListener());
    e120.addActionListener(new ButtonListener());
    e116.addActionListener(new ButtonListener());
    e114.addActionListener(new ButtonListener());
    e112.addActionListener(new ButtonListener());
    e108.addActionListener(new ButtonListener());
    e106.addActionListener(new ButtonListener());
    e104.addActionListener(new ButtonListener());
    
    // all buttons added to office panel
    buttons.add(e131);
    buttons.add(e129);
    buttons.add(e128);
    buttons.add(e127);
    buttons.add(e126);
    buttons.add(e120);
    buttons.add(e116);
    buttons.add(e114);
    buttons.add(e112);
    buttons.add(e108);
    buttons.add(e106);
    buttons.add(e104);
    
    // JPanel created to hold all buttons and create border around them
    JPanel offices = new JPanel(new BorderLayout());
    offices.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, Color.black));
    offices.add(buttons, BorderLayout.NORTH);
    offices.setBackground (Color.black); 
    
    // text header, image, and offices added to main 
    main.add(a, BorderLayout.NORTH);
    main.add(image);
    main.add(offices, BorderLayout.WEST);
    
    // main panel added to MapPanel
    add(main);
    
    // LinkedList of professors created
    profList = new CSProfessors("CSProfessors.txt");
    
  }
   
  /**
   * Private class ActionListener for the office buttons.
   * When each button is clicked, the corresponding Professor object appears
   * in a dialog box.
   * KNOWN BUG: the conditional (event.getSource == e131) did not work, went to
   * office hours and figured that using getText() on the button was next best
   * way to check which button was clicked.
   */
  class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) {
      if (((JButton)event.getSource()).getText().equals("   e131   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Stella Kakavouli").toString(), "Stella Kakavouli", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e129   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Jean Herbst").toString(), "Jean Herbst", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e128   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Ben Wood").toString(), "Ben Wood", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e127   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Sohie Lee").toString(), "Sohie Lee", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e126   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Franklyn A. Turbak (\"Lyn\")").toString(), "Franklyn A. Turbak (\"Lyn\")", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e120   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Rhys Price Jones").toString(), "Rhys Price Jones", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e116   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("P. Takis Metaxas").toString(), "P. Takis Metaxas", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e114   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Scott Anderson").toString(), "Scott Anderson", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e112   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Eni Mustafaraj").toString(), "En Mustafaraj", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e108   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Orit Shaer").toString(), "Orit Shaer", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e106   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Brian Tjaden").toString(), "Brian Tjaden", JOptionPane.PLAIN_MESSAGE);
      } else if (((JButton)event.getSource()).getText().equals("   e104   ")) {
        JOptionPane.showMessageDialog(null, profList.findProfessorByName("Darakhshan Mir").toString(), "Darakhshan Mir", JOptionPane.PLAIN_MESSAGE);
      }
    }
  }
}