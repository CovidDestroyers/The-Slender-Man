package com.slenderman.game;

import com.slenderman.actors.Player;
import com.slenderman.actors.SlenderMan;
import com.slenderman.musicplayer.SimplePlayer;
import com.slenderman.scenes.House;
import com.slenderman.scenes.Introduction;
import com.slenderman.scenes.Scene;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.List;

class Console extends JFrame implements ActionListener {
  JTextField tfIn;
  JTextArea outText;
  Player player = new Player();
  public Game game;
  private Thread t;

  private final PipedInputStream inPipe = new PipedInputStream();
  private final PipedInputStream outPipe = new PipedInputStream();
  private boolean clicked = false;

  PrintWriter inWriter;


  public Console(Game game) {
    super("SlenderMan");
    setFocusable(true);
    this.game = game;
    System.setIn(inPipe);

    try {
      inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
    } catch (IOException e) {
      System.out.println("Error: " + e);
      return;
    }

    JPanel panel = new JPanel(new BorderLayout());
    Border whiteline = BorderFactory.createLineBorder(Color.white);

//ADDING TOP SET PANEL FOR INSTRUCTIONS
    //TODO adjust size of JPanel to make text look cleaner
    JPanel instructions = new JPanel();
    instructions.setBounds(10, 0, 400, 350);
    instructions.setBackground(Color.black);


    JLabel instructionsText = new JLabel("Commands: \n\n " +
      "Travel: go + direction");
    instructionsText.setForeground(Color.white);
    instructions.add(instructionsText);
    panel.add(instructions, BorderLayout.NORTH);

//trying to get music button to work
    JButton musicOptions = new JButton("Music On/Off");
//    musicOptions.setText(game.isMusicOn() ? "Music On" : "Music Off");
    musicOptions.setBounds(30, 10, 95, 30);
    musicOptions.setBackground(Color.WHITE);
    instructions.add(musicOptions);

    //Would like to change the sleep values with the click of a button
    JButton speed = new JButton("Text Speed +");
    speed.setPreferredSize(new Dimension(110, 30));
    instructions.add(speed);

    JButton speedDown = new JButton("Text Speed -");
    speedDown.setPreferredSize(new Dimension(110, 30));
    instructions.add(speedDown);

    //TODO actionPerformed uses deprecated method, ticket id 200.

    musicOptions.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(game.isMusicOn()){
          game.thread2.stop();
          game.setMusicOn(false);
          try {
            music(false);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          }
//          musicOptions.setText("Music On");
        }
        else {
          try {
            music(true);
            game.setMusicOn(true);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          }
//          musicOptions.setText("Music Off");
        }
      }
    });


    //Speed up the intro...and all other text scenes
    speed.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Introduction introduction = new Introduction();
        introduction.skipIntro();
      }
    });

    speedDown.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Introduction introduction = new Introduction();
        introduction.returnOriginalSpeed();
      }
    });

    //end of music panel

    //End of instructions panel

    // Adding Side Map JPanel
    GameMap gMap = new GameMap();
    JPanel locMapPanel = new JPanel(new BorderLayout());
    JLabel mapLabel = new JLabel("PLAYER MAP LOCATION", SwingConstants.CENTER);
    locMapPanel.setBorder(whiteline);
    locMapPanel.add(mapLabel, BorderLayout.NORTH);

    // Loading Initial Side Map
    locMapPanel.add(gMap.makeMap(game.getPlayer().getCurrentSceneName()));

    Inventory inventory = new Inventory();
    JPanel inventoryPanel = new JPanel(new BorderLayout());
    JLabel inventoryLabel = new JLabel("PLAYER INVENTORY", SwingConstants.CENTER);
    inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
    inventoryPanel.add(inventory.printInventory(game.getPlayer().getInventoryList()));
    inventoryPanel.setBorder(whiteline);
    locMapPanel.add(inventoryPanel, BorderLayout.SOUTH);

    // Property change listener for inventory updates
    game.getPlayer().addPropertyChangeListener(evt -> {
      if(evt.getPropertyName().equals("inventory")){
        inventoryPanel.removeAll();
        inventoryPanel.add(inventory.printInventory(game.getPlayer().getInventoryList()));
        inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
        locMapPanel.add(inventoryPanel, BorderLayout.SOUTH);
        panel.add(locMapPanel, BorderLayout.EAST);
        revalidate();
        repaint();
      }
    });


    panel.add(locMapPanel, BorderLayout.EAST);

    // Property change listener for scene change to update map
    game.getPlayer().addPropertyChangeListener(evt -> {
      if (evt.getPropertyName().equals(game.getPlayer().getCurrentSceneName())) {
        locMapPanel.removeAll();
        locMapPanel.add(gMap.makeMap(game.getPlayer().getCurrentSceneName()));
        locMapPanel.add(mapLabel, BorderLayout.NORTH);
        locMapPanel.add(inventoryPanel, BorderLayout.SOUTH);
        panel.add(locMapPanel, BorderLayout.EAST);
        revalidate();
        repaint();
      }
    });
    // Change font color for different scenes
    game.getPlayer().addPropertyChangeListener(evt -> {
      if (evt.getPropertyName().equals(game.getPlayer().getCurrentSceneName())) {
        changeColors(outText);
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
    outText.setLineWrap(true);
    outText.setWrapStyleWord(true);

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
      public void mousePressed(MouseEvent e) {
        if (!clicked) {
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

  public Thread getT() {
    return t;
  }

  public void setT(Thread t) {
    this.t = t;
  }

  public void changeColors(JTextArea outText) throws NullPointerException{
    switch (game.getPlayer().getCurrentSceneName()) {
      case "forest":
        outText.setForeground(Color.GREEN);
        break;
      case "house":
        outText.setForeground(Color.RED);
        break;
      case "shed":
        outText.setForeground(Color.PINK);
        break;
      case "cave":
        outText.setForeground(Color.GRAY);
        break;
      case "pond":
        outText.setForeground(Color.CYAN);
        break;
      case "field":
        outText.setForeground(Color.ORANGE);
        break;
      case "tree":
        outText.setForeground(Color.YELLOW);
        break;
      default:
        outText.setForeground(Color.RED);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String text = tfIn.getText();
    tfIn.setText("");
    inWriter.println(text);
    clicked = true;
  }

  private void music(boolean isStop) throws InterruptedException {
    if(isStop) {
      setT(new Thread(() -> {
        try {
          Thread.sleep(1500);
          while (!SlenderMan.isGameDone) {
            SimplePlayer player = new SimplePlayer("Paranormal_Lullaby.mp3");
          }
        } catch (InterruptedException er) {
          Thread.currentThread().interrupt();
          System.out.println("Thread was interrupted");
        }
      }));
      getT().start();
    }
    else {
      getT().stop();
    }
  };
}
