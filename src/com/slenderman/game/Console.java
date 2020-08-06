package com.slenderman.game;

import com.slenderman.scenes.SceneImage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class Console extends JFrame implements ActionListener {
  static JEditorPane imageRight, imageLeft, imageCenter;
  JTextField tfIn;
  static JTextArea mapArea,outText;

  BufferedImage axe1Img;
  BufferedImage axe2Img;
  BufferedImage axe3Img;
  BufferedImage axe4Img;
  BufferedImage axe5Img;
  BufferedImage axe6Img;
  BufferedImage axe7Img;
  BufferedImage axe8Img;

  private final PipedInputStream inPipe = new PipedInputStream();
  private final PipedInputStream outPipe = new PipedInputStream();

  PrintWriter inWriter;

  public Console(Game game) {
    super("SlenderMan");
    setFocusable(true);

    System.setIn(inPipe);

    try {
      inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
    } catch (IOException e) {
      System.out.println("Error: " + e);
      return;
    }

    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel northPanel = new JPanel(new BorderLayout());

    String forestScene =
          "<pre color='green'>               ,@@@@@@@,</pre>"
        + "<pre color='green'>       ,,,.   ,@@@@@@/@@,  .oo8888o.</pre>"
        + "<pre color='green'>    ,&%%&%&&%,@@@@@/@@@@@@,8888\\88/8o</pre>"
        + "<pre color='green'>   ,%&\\%&&%&&%,@@@\\@@@/@@@88\\88888/88'</pre>"
        + "<pre color='green'>   %&&%&%&/%&&%@@\\@@/ /@@@88888\\88888'</pre>"
        + "<pre color='green'>   %&&%/ %&%%&&@@\\ V /@@' `88\\8 `/88'</pre>"
        + "<pre color='green'>   `&%\\ ` /%&'    |.|        \\ '|8'</pre>"
        + "<pre color='red'>       |o|        | |         | |</pre>"
        + "<pre color='red'>       |.|        | |         | |</pre>"
        + "<pre color='green'>k*s \\\\/ ._\\//_/__/  ,\\_//__\\\\/.  \\_//__/_</pre>";

    // setting component in right
    imageRight = new JEditorPane();
    imageRight.setBackground(Color.BLACK);
    imageRight.setContentType("text/html");
    imageRight.setText(forestScene);

    //  setting component in left
    imageLeft = new JEditorPane();
    imageLeft.setBackground(Color.BLACK);
    imageLeft.setContentType("text/html");
    imageLeft.setText(forestScene);

    // setting component in center
    imageCenter = new JEditorPane();
    imageCenter.setBackground(Color.BLACK);
    imageCenter.setContentType("text/html");

    imageCenter.setMaximumSize(new Dimension(40,40));


    // adding component to top part of frame => main panel
    northPanel.add(imageRight, BorderLayout.EAST);
    northPanel.add(imageLeft, BorderLayout.WEST);

    outText = new JTextArea(30, 80);
    outText.setBackground(Color.BLACK);
    outText.setForeground(Color.WHITE);
    outText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

    mapArea= new JTextArea(10,80);
    mapArea.setBackground(Color.BLACK);
    mapArea.setForeground(Color.YELLOW);
    mapArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
    northPanel.add(mapArea,BorderLayout.CENTER);
    // adding component to main panel
    mainPanel.add(northPanel, BorderLayout.NORTH);

    JScrollPane scroll =
        new JScrollPane(
            outText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    mainPanel.add(scroll, BorderLayout.CENTER);

    System.setOut(
        new PrintStream(
            new OutputStream() {

              @Override
              public void write(int b) throws IOException {
                outText.append(String.valueOf((char) b));
                outText.setCaretPosition(outText.getDocument().getLength());
              }
            }));

    tfIn = new JTextField();
    tfIn.addActionListener(this);

    tfIn.setToolTipText("Please type your command here (such as go *direction* or quit) and then press ENTER/RETURN on your keyboard");

    mainPanel.add(tfIn, BorderLayout.SOUTH);

    // main panel is getting added to frame
    add(mainPanel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(1500, 1000);
    setVisible(true);

    new SwingWorker<Void, String>() {
      protected Void doInBackground() throws Exception {
        Scanner s = new Scanner(outPipe);

        while (s.hasNextLine()) {
          String line = s.nextLine();
          publish(line);
        }

        return null;
      }
    }.execute();

  }

  //Update maps in the mapPanel with game progression
  public static void updateMap(String sceneName){
    mapArea.setText(String.valueOf(SceneImage.sceneMap.get(sceneName)));
  }
  public static void updateImage(String imageName) {
    imageRight.setText(imageName);
  }

  //Clear screen static method
  public static void clearScreen(){
    outText.setText("");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String text = tfIn.getText();
    tfIn.setText("");

    inWriter.println(text);
  }

}
