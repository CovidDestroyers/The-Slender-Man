package com.slenderman.scenes;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Introduction {

  // For Resource Bundle //
  static final String FILE_BASE_NAME = "storyIntroNoColor";
  static final String PATH = "com.slenderman.scenes.files.";

  static ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  static ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
  /////////////////////////

  public static void playIntro() throws InterruptedException {

    System.out.println();
    Thread.sleep(3000);
    //System.out.println(Scene.ANSI_GREEN + "\n" +
    System.out.println(textPainter(bundle.getString("intro_0")));
    System.out.println(
      "\n" +
      " ▄▄▄▄▄▄▄▄▄▄▄  ▄            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄ \n" +
      "▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌\n" +
      "▐░█▀▀▀▀▀▀▀▀▀ ▐░▌          ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌     ▐░▌\n" +
      "▐░▌          ▐░▌          ▐░▌          ▐░▌▐░▌    ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌       ▐░▌▐░▌▐░▌    ▐░▌\n" +
      "▐░█▄▄▄▄▄▄▄▄▄ ▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌ ▐░▌   ▐░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▐░▌ ▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌   ▐░▌\n" +
      "▐░░░░░░░░░░░▌▐░▌          ▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌\n" +
      " ▀▀▀▀▀▀▀▀▀█░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌   ▐░▌ ▐░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀ ▐░▌   ▀   ▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▐░▌ ▐░▌\n" +
      "          ▐░▌▐░▌          ▐░▌          ▐░▌    ▐░▌▐░▌▐░▌       ▐░▌▐░▌          ▐░▌     ▐░▌  ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌    ▐░▌▐░▌\n" +
      " ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░▌      ▐░▌ ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌     ▐░▐░▌\n" +
      "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌      ▐░░▌\n" +
      " ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀         ▀  ▀         ▀  ▀        ▀▀ \n" +
      "                                                                                                                                  \n");

    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_1")));
    //System.out.println(Scene.ANSI_WHITE + "You feel a breeze of crisp air against your cheek, while the other, a sensation of coarse dirt and rocks.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_2")));
    //System.out.println("You open your eyes to find yourself surrounded by a forest with seemingly no end, in total darkness.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_3")));
    //System.out.println("An overwhelmingly ominous feeling comes upon you as you gaze into the night, scanning your surroundings.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_4")));
    //System.out.println("As you stand up and fumble around, you find a watch and a flashlight, with a note laid perfectly underneath.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_5")));
    //System.out.println("You pick up the items and read the note:\n");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_6")));
    //System.out.println(Scene.ANSI_BLUE + "To whoever finds this, know that there is no escape.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_7")));
    //System.out.println("There is something in the forest… something truly sinister.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_8")));
    //System.out.println("I feel like it is watching my every move, waiting for it’s opportunity to strike.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_9")));
    //System.out.println("This watch I found was set to 10 minutes, almost as if whatever brought me here was taunting me with its patience.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_10")));
    //System.out.println( "I don’t know why this is happening or what is even out there, but I’m going to find a way to stop it and make it out of this god forsaken forest.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_11")));
    //System.out.println("If I don’t make it, follow my steps and finish what I couldn’t…\n");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_12")));
    //System.out.println(Scene.ANSI_WHITE + "You notice your watch’s timer mysteriously begins for 10 minutes of time.");
    Thread.sleep(5000);
    System.out.println(textPainter(bundle.getString("intro_13")));
    //System.out.println("You look once more into the vast forest as you plan your next move…\n");
    Thread.sleep(5000);

     }
  /**
   * Coloring the fonts
   *
   * <p>{0} : Scene.ANSI_GREEN {1} : Scene.ANSI_BLUE {2} : Scene.ANSI_RED {3} : Scene.ANSI_BLACK {4}
   * : Scene.ANSI_WHITE
   */
  private static String textPainter(String text) {
    return MessageFormat.format(
      text,
      Scene.ANSI_GREEN,
      Scene.ANSI_BLUE,
      Scene.ANSI_RED,
      Scene.ANSI_BLACK,
      Scene.ANSI_WHITE);
  }

}
