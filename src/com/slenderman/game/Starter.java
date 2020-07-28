package com.slenderman.game;

import com.slenderman.game.Game;

import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Starter instantiates the Game class and begins the game. Nothing but code needed to start the
 * game should be in this class. It should be very small.
 */
public class Starter extends JFrame {
    // We can use give args a filename and read a file in to replace the
    // console input with a text file for testing.
    public static void main(String[] args) throws InterruptedException { // change input to come from a file


      Console console = new Console();


      console.init();


      Game game = new Game();
      Scanner scanMe = new Scanner(System.in);

      game.start(scanMe);

    }


//    public static void restart() throws InterruptedException {
//      Console console = new Console();
//
//      console.init();
//
//
//      Game game = new Game();
//      Scanner scanMe = new Scanner(System.in);
//
//      game.start(scanMe);
//    }




}


