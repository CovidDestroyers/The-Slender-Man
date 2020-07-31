package com.slenderman.scenes;

import com.slenderman.actors.Player;
import music.Music;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Forest extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Forest() {
    setSceneName("forest");
  }

  // For Resource Bundle //
  final String FILE_BASE_NAME = "storyForestNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
  /////////////////////////

  // Unit testing purpose //
  private boolean _max_iteration_not_reached;
  //////////////////////////

  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  public Forest(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

  @Override
  public void enter(Scanner in, Player player) throws Exception {
    SceneImage.printForest();
    Music music = new Music();
    music.forestMusic();

    System.out.println(
              "               ,@@@@@@@,\n"
            + "       ,,,.   ,@@@@@@/@@,  .oo8888o.\n"
            + "    ,&%%&%&&%,@@@@@/@@@@@@,8888\\88/8o\n"
            + "   ,%&\\%&&%&&%,@@@\\@@@/@@@88\\88888/88'\n"
            + "   %&&%&%&/%&&%@@\\@@/ /@@@88888\\88888'\n"
            + "   %&&%/ %&%%&&@@\\ V /@@' `88\\8 `/88'\n"
            + "   `&%\\ ` /%&'    |.|        \\ '|8'\n"
            + "       |o|        | |         | |\n"
            + "       |.|        | |         | |\n"
            + "jgs \\\\/ ._\\//_/__/  ,\\_//__\\\\/.  \\_//__/_\n"
            + "\n"
            + "------------------------------------------------\n");
    displayStories("forest");
  }
  /**
   * Coloring the fonts
   *
   * <p>{0} : Scene.ANSI_GREEN {1} : Scene.ANSI_BLUE {2} : Scene.ANSI_RED {3} : Scene.ANSI_BLACK {4}
   * : Scene.ANSI_WHITE
   */
  private String textPainter(String text) {
    return MessageFormat.format(
      text,
      Scene.ANSI_GREEN,
      Scene.ANSI_BLUE,
      Scene.ANSI_RED,
      Scene.ANSI_BLACK,
      Scene.ANSI_WHITE);
  }

  /** For accessing and displaying stories in Resource Bundle file */
  private void displayStories(String key) {
    _max_iteration_not_reached = false;
    for (int i = 0; i < MAX_ITERATION_DISPLAY_STORIES; i++) {
      try {
        System.out.println(textPainter(bundle.getString(key + "[" + Integer.toString(i) + "]")));
      } catch (MissingResourceException e) {
        _max_iteration_not_reached = true;
        break;
      }
    }
  }
}
