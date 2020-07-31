package com.slenderman.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

class Console extends JFrame implements ActionListener {
  JTextField tfIn;
  JLabel lblOut;
  JTextArea outText;

  BufferedImage axe1Img;
  BufferedImage axe2Img;
  BufferedImage axe3Img;
  BufferedImage axe4Img;

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

    JPanel panel = new JPanel(new BorderLayout());

    outText = new JTextArea(100, 80);
    outText.setBackground(Color.BLACK);
    outText.setForeground(Color.WHITE);
    outText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

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

    tfIn = new JTextField();
    tfIn.addActionListener(this);

    tfIn.setToolTipText("Please type your command here (such as go *direction* or quit) and then press ENTER/RETURN on your keyboard");

    panel.add(tfIn, BorderLayout.SOUTH);
    add(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(1300, 1000);
    setVisible(true);
    loadImage();

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


  //TODO: ActionPerformed Event Listener is triggering second thread run; need further study to solve it
  public void loadImage() {
    String axe1Path = "images/axe1.png";
    String axe2Path = "images/axe2.png";
    String axe3Path = "images/axe3.png";
    String axe4Path = "images/axe4.png";
    File axe1file = new File(axe1Path);
    File axe2file = new File(axe2Path);
    File axe3file = new File(axe3Path);
    File axe4file = new File(axe4Path);

    try {

      axe1Img = ImageIO.read(axe1file);
      axe2Img = ImageIO.read(axe2file);
      axe3Img = ImageIO.read(axe3file);
      axe4Img = ImageIO.read(axe4file);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void paint(Graphics g) {

    super.paint(g);

    try {
      g.drawImage(axe1Img, 1000, 50, null);
      Thread.sleep(1000);
      g.drawImage(axe2Img, 800, 50, null);
      Thread.sleep(1000);
      g.drawImage(axe3Img, 500, 50, null);
      Thread.sleep(1000);
      g.drawImage(axe4Img, 150, 50, null);
      Thread.sleep(1000);

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
