package com.slenderman.game;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

class Console {
  final JFrame frame = new JFrame();





  public Console() {




    JTextArea textArea = new JTextArea(24, 80);
    JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.LIGHT_GRAY);
    textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    System.setOut(new PrintStream(new OutputStream() {
      @Override
      public void write(int b) throws IOException {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
      }
    }));
    frame.add(scroll);

    // only a configuration to the jScrollPane...

  }
  public void init() {
    frame.pack();
    frame.setVisible(true);

  }
  public JFrame getFrame() {
    return frame;
  }
}
