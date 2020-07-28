package com.slenderman.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Console extends JPanel {

  public Console() {
    setFocusable(true);
    setDoubleBuffered(true);
    setLayout(new BorderLayout());

    JTextArea textArea = new JTextArea(100, 80);

    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.LIGHT_GRAY);

    textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

    JScrollPane scroll =
        new JScrollPane(
            textArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    System.setOut(
        new PrintStream(
            new OutputStream() {

              @Override
              public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
                textArea.setCaretPosition(textArea.getDocument().getLength());
              }
            }));

    textArea.addKeyListener(new WatchMyKeys());
    add(scroll);
  }

  /*
   * =============================================
   * =========== Private Class ===================
   * =============================================
   */

  private class WatchMyKeys extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent event) {
      super.keyReleased(event);
    }

    @Override
    public void keyPressed(KeyEvent event) {
      super.keyPressed(event);
      int key = event.getKeyCode();
      System.out.printf("Key Code: %s\n", key);
      System.out.printf("Key Char: %s\n", event.getKeyChar());
    }
  }
}
