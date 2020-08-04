package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;
import jdk.jshell.spi.SPIResolutionException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Shed extends Scene {

  // For Resource Bundle //
  final String FILE_BASE_NAME = "storyShedNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  public int visitCount = 0;
  public String previousChoice = "n";
  public int sleep = 2000;

  ResourceBundle.Control rbc =
    ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  // Unit testing purpose //
  private boolean _max_iteration_not_reached;

  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  private Scanner choice;
  private Player player;

  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("shed");
  private final Item Key = ItemDirector.findThisItem("key", itemsInThisScene);

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Shed() {
    setSceneName("shed");
    setItemsInScene(itemsInThisScene);
  }

  public Shed(
    Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setSceneName("shed");
    setItemsInScene(itemsInThisScene);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    this.player = player;

    choice = in;
    inFrontOfShed();
  }


  private void inFrontOfShed() throws InterruptedException {
    String choice;

    displayStories("inFrontShed");
    choice = playerChoice();
    if (choice.equals("0")) {
      stepIntoTheShed();
    } else if (choice.equals("1")) {
      goSomewhereElse();

    } else {
      displayStories("inFrontShed_WrongInput");

      inFrontOfShed();
    }
  }

  private void goSomewhereElse() {

    displayStories("goSomewhereElse");
  }

  private void stepIntoTheShed() throws InterruptedException {
    if (visitCount == 0) {
      displayStories("stepIntoTheShed");

      if (previousChoice.equals("y")) {
        System.out.println("You have already found all there is to find here.");
        Thread.sleep(sleep);
        goSomewhereElse();
      } else if (previousChoice.equals("n")) {
        takeShinyThingChoice();
      }

    } else if (visitCount >= 1) {
      System.out.println("You are back in the old shed... You feel a shiver run down your spine.");
      Thread.sleep(sleep);
      System.out.println("You check the corpse again for anything missed...");
      Thread.sleep(sleep);

      System.out.println("Nothing... Better look somewhere else to stop this nightmare...");
      Thread.sleep(sleep);
      goSomewhereElse();
    }
  }

  private void takeShinyThingChoice() throws InterruptedException {

    displayStories("takeShinyThingChoice");

    String choice = playerChoice().toUpperCase();
    if (choice.equals("Y")) {
      grabShinyThingYes();

    } else if (choice.equals("N")) {
      visitCount = 0;
      inFrontOfShed();

    } else {
      displayStories("takeShinyThingChoice_WrongInput");
      takeShinyThingChoice();
    }
  }

  private void grabShinyThingYes() throws InterruptedException {
    System.out.println(textPainter(bundle.getString("grabShinyThingYes_0")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("grabShinyThingYes_1")));
    System.out.println(textPainter(bundle.getString("grabShinyThingYes_2")));
    Thread.sleep(sleep);
    displayStories("grabShinyThingYes_Note");

    exitShed();
  }

  private void exitShed() throws InterruptedException {

    player.addItemToInventory(Key);
    getItemsInScene().remove(Key);

    Thread.sleep(10000);
    System.out.println(textPainter(bundle.getString("exitShed_0")));
    Thread.sleep(sleep);
    System.out.println(textPainter(bundle.getString("exitShed_1")));

    goSomewhereElse();

    visitCount = visitCount + 1;
  }

  private String playerChoice() {
    return choice.nextLine();
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

  /**
   * For accessing and displaying stories in Resource Bundle file
   */
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
    return "Shed{" +
      "FILE_BASE_NAME='" + FILE_BASE_NAME + '\'' +
      ", PATH='" + PATH + '\'' +
      ", rbc=" + rbc +
      ", bundle=" + bundle +
      ", _max_iteration_not_reached=" + _max_iteration_not_reached +
      ", MAX_ITERATION_DISPLAY_STORIES=" + MAX_ITERATION_DISPLAY_STORIES +
      ", choice=" + choice +
      ", player=" + player +
      ", itemsInThisScene=" + itemsInThisScene +
      ", Key=" + Key +
      "} " + super.toString();
  }
}
