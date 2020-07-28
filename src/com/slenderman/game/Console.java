package com.slenderman.game;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

class Console {
  final JFrame frame = new JFrame("SlenderMan");
  final GridLayout layout = new GridLayout(2, 1);
  final JPanel outputPanel = new JPanel();

  final JPanel inputPanel = new JPanel(new BorderLayout());






  public Console() {
    frame.setLocation(100, 100);
    frame.setLayout(layout);
    frame.add(outputPanel);
    frame.add(inputPanel);

    JTextPane textPane = new JTextPane();

    SimpleAttributeSet attributeSet = new SimpleAttributeSet();
    StyleConstants.setItalic(attributeSet, true);
    StyleConstants.setForeground(attributeSet, Color.BLUE);
    textPane.setBackground(Color.white);
    textPane.setCharacterAttributes(attributeSet, true);

    inputPanel.add(textPane);
    textPane.setText(textPane.getText());
    System.out.println(textPane.getText());


    JTextArea textArea = new JTextArea(24, 80);
    JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
    outputPanel.add(scroll);


    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
