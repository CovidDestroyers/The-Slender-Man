package com.slenderman.scenes;

import com.slenderman.music.Music;
import com.slenderman.tools.Sound;

import java.io.File;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Introduction {
  public static String playerName;
  public static final String FILE_BASE_NAME = "storyIntroNoColor";
  public static final String PATH = "com.slenderman.scenes.files.";
  public static ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  public static ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  public static void playIntro() throws Exception {
    Scanner scanner = new Scanner(System.in);
    long introDelaySlow = 2500;
    Thread.sleep(introDelaySlow);
    System.out.println(textPainter(bundle.getString("intro_0")));

    System.out.println("Please enter your name to start your journey...");
    setPlayerName(scanner.nextLine());
    System.out.println("Your name has been set to " + getPlayerName() + " ... good luck.");
    Music introMusic= new Music(new File("./Music/field.wav"));
    introMusic.play();

    System.out.println(textPainter(bundle.getString("intro_1")));
    Sound.play(new File("./Speech/Introduction/I_intro1.mp3"));

    System.out.println(textPainter(bundle.getString("intro_2")));
    Sound.play(new File("./Speech/Introduction/I_intro2.mp3"));

    System.out.println(textPainter(bundle.getString("intro_3")));
    Sound.play(new File("./Speech/Introduction/I_intro3.mp3"));

    System.out.println(textPainter(bundle.getString("intro_4")));
    Sound.play(new File("./Speech/Introduction/I_intro4.mp3"));

    System.out.println(textPainter(bundle.getString("intro_5")));
    Sound.play(new File("./Speech/Introduction/I_intro5.mp3"));

    System.out.println(textPainter(bundle.getString("intro_6")));
    System.out.println(textPainter(bundle.getString("intro_7")));
    System.out.println(textPainter(bundle.getString("intro_8")));
    System.out.println(textPainter(bundle.getString("intro_9")));
    System.out.println(textPainter(bundle.getString("intro_10")));
    System.out.println(textPainter(bundle.getString("intro_11")));
    Sound.play(new File("./Speech/Introduction/I_note.mp3"));

    System.out.println(textPainter(bundle.getString("intro_12")));
    Sound.play(new File("./Speech/Introduction/I_intro12.mp3"));

    System.out.println(textPainter(bundle.getString("intro_13")));
    Sound.play(new File("./Speech/Introduction/I_intro13.mp3"));
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

  public static String getPlayerName() {
    return playerName;
  }

  public static void setPlayerName(String playerName) {
    Introduction.playerName = playerName;
  }
}
