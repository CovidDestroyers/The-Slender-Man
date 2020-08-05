package com.slenderman.game;

import javax.swing.*;
import java.awt.*;

public class Inventory {

  public JTextArea printInventory(){
    JTextArea result = new JTextArea(25,55);
    result.setBackground(Color.BLACK);
    result.setForeground(Color.WHITE);
    result.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    result.append("\n\n" +
      "- lighter\n" +
      "- note\n" +
      "- torch\n");

    return result;
  }
}
