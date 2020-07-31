package com.slenderman.game;

import com.slenderman.scenes.Scene;
import com.slenderman.scenes.SceneImage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

public class Console extends JFrame implements ActionListener {
  JTextField tfIn;
  JLabel lblOut;
  JTextArea outText;
  static JTextArea mapArea;

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

    mapArea= new JTextArea(10,80);
    mapArea.setBackground(Color.BLACK);
    mapArea.setForeground(Color.YELLOW);
    mapArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
    panel.add(mapArea,BorderLayout.NORTH);

//    mapArea.setText(SceneImage.printForest());


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
    setVisible(true);
    setSize(1300, 1000);

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


  @Override
  public void actionPerformed(ActionEvent e) {
    String text = tfIn.getText();
    tfIn.setText("");

    inWriter.println(text);
  }
}
