package com.slenderman.game;

import com.slenderman.musicplayer.SimplePlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

class Console extends JFrame implements ActionListener {
  JTextField tfIn;
  JLabel lblOut;
  JTextArea outText;
  JButton enableMusic, disableMusic;

  private final PipedInputStream inPipe = new PipedInputStream();
  private final PipedInputStream outPipe = new PipedInputStream();
  //placeholder boolean;
  private boolean clicked = false;

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

    JPanel panel = new JPanel(new BorderLayout());

//ADDING TOP SET PANEL FOR INSTRUCTIONS
    //TODO adjust size of JPanel to make text look cleaner
//    JTextArea instructions = new JTextArea(5, 10);
//    instructions.setBackground(Color.black);
//    instructions.setForeground(Color.white);
    JPanel instructions = new JPanel();
    instructions.setBounds(10, 0, 400, 350);
    instructions.setBackground(Color.black);


    JLabel instructionsText = new JLabel("Commands: \n\n " +
      "Travel: go + direction, \n"
      + " Check Inventory: I/Inventory");
    instructionsText.setForeground(Color.white);
    instructions.add(instructionsText);
    panel.add(instructions, BorderLayout.NORTH);

//trying to get music button to work
    JButton musicOptions = new JButton("Music Off");
    musicOptions.setBounds(30, 10, 95, 30);
    musicOptions.setBackground(Color.WHITE);
    musicOptions.setForeground(Color.WHITE);
    instructions.add(musicOptions);

    //TODO actionPerformed uses deprecated method, ticket id 200.

    musicOptions.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          game.thread2.stop();
      }
    });

    //end of music panel

    //End of instructions panel

    // Adding Side Map JPanel
    GameMap gMap = new GameMap();
    JPanel locMap = new JPanel(new BorderLayout());
    locMap.setBounds(100,100,200,200);

    // Loading Initial Side Map
    locMap.add(gMap.makeMap(game.getPlayer().getCurrentSceneName()));
    panel.add(locMap, BorderLayout.EAST);

    // Property change listener for scene change to update map
    game.getPlayer().addPropertyChangeListener(evt -> {
    System.out.println("did I make it in here?");
      if(evt.getPropertyName().equals(game.getPlayer().getCurrentSceneName())){
        locMap.removeAll();
        locMap.add(gMap.makeMap(game.getPlayer().getCurrentSceneName()));
        panel.add(locMap, BorderLayout.EAST);
        revalidate();
        repaint();
      }
    });




    int jColumns = 80;
    int jRows = 100;

    outText = new JTextArea(jRows, jColumns);
    outText.setBackground(Color.BLACK);
    outText.setForeground(Color.WHITE);
    outText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

    //This prevents users from deleting text from this JTextArea
    outText.setEditable(false);

    JScrollPane scroll =
        new JScrollPane(
            outText,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    panel.add(scroll, BorderLayout.CENTER);

    System.setOut(
        new PrintStream(
            new OutputStream() {

              @Override
              public void write(int b) throws IOException {
                outText.append(String.valueOf((char) b));
                outText.setCaretPosition(outText.getDocument().getLength());
              }
            }));
  //beginning of text input placeholder logic
    tfIn = new JTextField();
    //trying placeholder here
    tfIn.setText("Enter Game Commands Here");
    tfIn.addMouseListener(new MouseAdapter(){
      @Override
      public void mousePressed(MouseEvent e){
        if(!clicked){
          clicked = true;
          tfIn.setText("");
        }
      }
    });
    tfIn.setBackground(Color.LIGHT_GRAY);

    //ending placeholder logic



    tfIn.addActionListener(this);

    tfIn.setToolTipText("Please type your command here (such as go *direction* or quit) and then press ENTER/RETURN on your keyboard");

    panel.add(tfIn, BorderLayout.SOUTH);
    add(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    int jframeWidth = 800;
    int jframeHeight = 800;

    setSize(jframeWidth, jframeHeight);

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

  @Override
  public void actionPerformed(ActionEvent e) {
    String text = tfIn.getText();
    tfIn.setText("");

    inWriter.println(text);
  }
}
