package com.slenderman.scenes;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Introduction implements KeyListener {

//  private Scanner choice;

  // For Resource Bundle //
  static final String FILE_BASE_NAME = "storyIntroNoColor";
  static final String PATH = "com.slenderman.scenes.files.";

  static ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  static ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  //TODO change back to 5000 once complete or whatever number necessary.
  public static int sleep = 500;


  public static void playIntro() throws InterruptedException {

    System.out.println();
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_0")));
    System.out.println(
      "\n" +
      "  __        __        __   __   __        __      \n" +
        " /    /    /    /| ||/  | /    /  | /|/| /  | /| |\n" +
        "(___ (    (___ ( | ||   |(___ (___|( / |(___|( | |\n" +
        "    )|   )|    | | )|   )|    |\\   |   )|   )| | )\n" +
        " __/ |__/ |__  | |/ |__/ |__  | \\  |  / |  / | |/ \n" +
        "                                                  \n");

    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_1")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_2")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_3")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_4")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_5")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_6")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_7")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_8")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_9")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_10")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_11")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_12")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("intro_13")));

    Thread.sleep(sleep);

     }

  /**
   * Coloring the fonts
   *
   * <p>{0} : Scene.ANSI_GREEN {1} : Scene.ANSI_BLUE {2} : Scene.ANSI_RED {3} : Scene.ANSI_BLACK {4}
   * : Scene.ANSI_WHITE
   */

  public void skipIntro(){
    sleep = 0;
  }

  private static String textPainter(String text) {
    return MessageFormat.format(
      text,
      Scene.ANSI_GREEN,
      Scene.ANSI_BLUE,
      Scene.ANSI_RED,
      Scene.ANSI_BLACK,
      Scene.ANSI_WHITE);
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
