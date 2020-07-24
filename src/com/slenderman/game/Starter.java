package com.slenderman.game;

import com.slenderman.game.Game;

import javax.swing.*;
import java.util.Scanner;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Starter instantiates the Game class and begins the game. Nothing but code
 * needed to start the game should be in this class. It should be very small.
 *
 */
public class Starter extends JFrame {
    // We can use give args a filename and read a file in to replace the
    // console input with a text file for testing.
    public static void main(String[] args) throws InterruptedException { // change input to come from a file
      Console console = new Console();

      console.init();
      Starter launcher = new Starter();

      launcher.setVisible(true);


      Game game = new Game();
      Scanner scanMe = new Scanner(System.in);

      game.start(scanMe);
    }

  private Starter() {
    super();
    setSize(600, 600);
    setResizable(false);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


}


