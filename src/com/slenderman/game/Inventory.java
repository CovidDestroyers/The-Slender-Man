package com.slenderman.game;

import com.slenderman.actors.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Inventory {

  public JTextArea printInventory(List<Item> inventory){
    JTextArea result = new JTextArea(25,55);
    result.setBackground(Color.BLACK);
    result.setForeground(Color.WHITE);
    result.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    int count = 1;
    for(Item item : inventory){
      result.append("\n  ("+ count + ") " + item.getItemName() + "\n");
      count++;
    }
//    result.append("\n\n" +
//      "- lighter\n" +
//      "- note\n" +
//      "- torch\n");

    return result;
  }
}
