package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;
import com.slenderman.game.Console;
import com.slenderman.music.Music;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Field extends Scene {

  // For Resource Bundle //
  final String FILE_BASE_NAME = "storyFieldNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc =
      ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  // Unit testing purpose //
  private boolean _max_iteration_not_reached;

  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  private Scanner scanner;
  private Player player;

  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("field");

  private final Item Blade = ItemDirector.findThisItem("blade", itemsInThisScene);

  // default constructor
  public Field() {
    setDescription("You have reached am empty field.");
    setSceneName("field");
    setItemsInScene(itemsInThisScene);
  }

  public Field(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setDescription("You have reached an empty field.");
    setSceneName("field");
    setItemsInScene(itemsInThisScene);
  }

  public void enter(Scanner in, Player player) throws Exception {
    scanner = in;
    this.player = player;
    String choice;
    Console.updateMap(this.getSceneName());
    Console.clearScreen();
    displayStories("enter");
    choice = playerChoice();


    if (choice.equals("0")) {
      smellIt(in, player);
    } else {
      footCut(in, player);
    }
  }



  private void smellIt(Scanner in, Player player) throws InterruptedException {
    displayStories("smellIt");
    String choice = playerChoice();

    if (choice.equals("0")) {
      sneeze(in, player);
    } else {
      displayStories("askDirection");
    }
  }

  private void sneeze(Scanner in, Player player) throws InterruptedException {

    displayStories("sneeze");
    String choice = playerChoice();

    if (choice.equals("0")) {
      findBlade(in, player);
    } else {
      // go to the next Tree class
      displayStories("askDirection");
      //      choice = playerChoice();
      //      changeScene(choice);
    }
  }

  private void footCut(Scanner in, Player player) throws InterruptedException {
    displayStories("footCut");
    String choice = playerChoice();
    if (choice.equals("0")) {
      findBlade(in, player);
    } else {
      sneeze(in, player);
    }
  }

  private void findBlade(Scanner in, Player player) throws InterruptedException {

    displayStories("findBlade");
    String choice = playerChoice();

    if (choice.equals("0")) {
      player.addItemToInventory(Blade);
      System.out.println(bundle.getString("findBladeItem"));
      getItemsInScene().remove(Blade);
    }

    displayStories("findBladeChoiceWay");
    choice = playerChoice();

    if (choice.equals("0")) {
      sneeze(in, player);
    } else {
      displayStories("askDirection");
    }
  }

  private String playerChoice() {
    return scanner.nextLine();
  }

  /**
   * Coloring the fonts
   *
   * {0} : Scene.ANSI_GREEN {1} : Scene.ANSI_BLUE {2} : Scene.ANSI_RED {3} : Scene.ANSI_BLACK {4}
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
        System.out.println(textPainter(bundle.getString(key + "[" + i + "]")));
      } catch (MissingResourceException e) {
        _max_iteration_not_reached = true;
        break;
      }
    }
  }


  @Override
  public String toString() {
    return "Field{" +
      "FILE_BASE_NAME='" + FILE_BASE_NAME + '\'' +
      ", PATH='" + PATH + '\'' +
      ", rbc=" + rbc +
      ", bundle=" + bundle +
      ", _max_iteration_not_reached=" + _max_iteration_not_reached +
      ", MAX_ITERATION_DISPLAY_STORIES=" + MAX_ITERATION_DISPLAY_STORIES +
      ", scanner=" + scanner +
      ", player=" + player +
      ", itemsInThisScene=" + itemsInThisScene +
      ", Blade=" + Blade +
      "} " + super.toString();
  }
}
