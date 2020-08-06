package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;
import com.slenderman.game.Console;
import com.slenderman.tools.Sound;

import java.io.File;
import java.text.MessageFormat;
import java.util.*;

/**
 * Things needs for this class : Lighter and torch Thing the player needs to get in this class :
 * boat
 *
 * <p>East : POND West : SHED North : HUT_CAR
 */
public class Cave extends Scene {
  private boolean _max_iteration_not_reached;
  private boolean isPlayerWithTorch = false;
  private boolean isPlayerWithLighter = false;
  private boolean isPlayerWithBoat = false;
  private final List<String> localItems = new ArrayList<>();
  private Scanner choice;
  private Player thePlayer;
  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("cave");
  private final Item boat = ItemDirector.findThisItem("boat", itemsInThisScene);

  public final int MAX_ITERATION_DISPLAY_STORIES = 10;
  public final String FILE_BASE_NAME = "storyCaveNoColor";
  public final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc =
      ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  public Cave() {
    setSceneName("cave");
    setItemsInScene(itemsInThisScene);
  }

  public Cave(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) throws Exception {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setSceneName("cave");

  }

  @Override
  public void enter(Scanner in, Player player) throws Exception {
    thePlayer = player;
    choice = in;
    Console.updateMap(this.getSceneName());
    Console.clearScreen();

    inFrontOfCave();

  }

  private void inFrontOfCave() throws InterruptedException {

    String cave =
      "<pre color='green'><small>     \\__,.   /              \\    /           \\/.,   _|  _/ \\                    </small></pre>"+
        "<pre color='green'><small>          \\_/                \\  /',.,''\\      \\_ \\_/  \\/    \\                   </small></pre>"+
        "<pre color='green'><small>                           _  \\/   /    ',../',.\\    _/      \\                  </small></pre>"+
        "<pre color='gray'><small>             /           _/m\\  \\  /    |         \\  /.,/'\\   _\\                 </small></pre>"+
        "<pre color='gray'><small>           _/           /MMmm\\  \\_     |          \\/      \\_/  \\                </small></pre>"+
        "<pre color='gray'><small>          /      \\     |MMMMmm|   \\__   \\          \\_       \\   \\_              </small></pre>"+
        "<pre color='gray'><small>                  \\   /MMMMMMm|      \\   \\           \\       \\    \\             </small></pre>"+
        "<pre color='gray'><small>                   \\  |MMMMMMmm\\      \\___            \\_      \\_   \\            </small></pre>"+
        "<pre color='gray'><small>                    \\|MMMMMMMMmm|____.'  /\\_            \\       \\   \\_          </small></pre>"+
        "<pre color='green'><small>                    /'.,___________...,,'   \\            \\   \\        \\         </small></pre>"+
        "<pre color='green'><small>                   /       \\          |      \\    |__     \\   \\_       \\        </small></pre>"+
        "<pre color='green'><small>                 _/        |           \\      \\_     \\     \\    \\\\       \\_      </small></pre>";




    Console.updateImage(cave);
    displayStories("inFront");
    String choice = playerChoice();
    if (choice.equals("0")) {
      stepIntoTheCave();
    } else {
      walkAroundInFrontOfCave();
    }
  }

  private void stepIntoTheCave() throws InterruptedException {
    if (isPlayerWithBoat) {
      System.out.println(textPainter(bundle.getString("stepIntoTheCave_withBoat")));
      exploreCaveChoice();
    } else {
      displayStories("stepIntoTheCave");

      if (checkItems()) {
        quizChoosingRightItems();
      } else {
        System.out.println(textPainter(bundle.getString("stepIntoTheCave_notEnoughItem")));
        Sound.play(new File("./Speech/Cave/Run.mp3"));
        inFrontOfCave();
      }
    }
  }

  private boolean checkItems() {
    Boolean doesPlayerHaveTorch = playerHasItem(thePlayer, "torch");
    Boolean doesPlayerHaveLighter = playerHasItem(thePlayer, "lighter");

    if (doesPlayerHaveTorch) {
      isPlayerWithTorch = true;
    }
    if (doesPlayerHaveLighter) {
      isPlayerWithLighter = true;
    }
    return isPlayerWithTorch && isPlayerWithLighter;
  }

  private void quizChoosingRightItems() throws InterruptedException {
    System.out.println(textPainter(bundle.getString("quizChoosingRightItems_intro")));
    String input = playerChoice().toUpperCase();
    String[] objectInput = input.split(" ");

    // Added code here for checking number of items typed
    if (objectInput.length != 2) {
      System.out.println("-> You typed " + objectInput.length + " items. Please try again.");
      Arrays.fill(objectInput, null);
      inFrontOfCave();
    }
    else {
      if ((objectInput[0].equals("TORCH") && objectInput[1].equals("LIGHTER"))
        || (objectInput[1].equals("TORCH") && objectInput[0].equals("LIGHTER"))) {
        exploreCave();
      } else {
        System.out.println(textPainter(bundle.getString("quizChoosingRightItems_incorrect")));
        inFrontOfCave();
      }
    }
  }

  private void walkAroundInFrontOfCave() throws InterruptedException {
    displayStories("walkAroundInFrontOfCave");
    String choice = playerChoice();
    switch (choice) {
      case "0":
        investigateTheBushes();
        break;
      case "1":
        inFrontOfCave();
        break;
      case "2":
        displayStories("walkAroundInFrontOfCave_option2");
        break;
      default:
        walkAroundInFrontOfCave();
    }
  }

  private void investigateTheBushes() throws InterruptedException {
    if (localItems.contains("NOTEBOOK")) {
      System.out.println(textPainter(bundle.getString("investigateTheBushes_withNoteBook")));
    } else {
      displayStories("investigateTheBushes");
      String choice = playerChoice();
      if (choice.equalsIgnoreCase("y")) {
        System.out.println(textPainter(bundle.getString("investigateTheBushes_y")));
        localItems.add("NOTEBOOK");
      } else {
        System.out.println(textPainter(bundle.getString("investigateTheBushes_n")));
      }
    }
    System.out.println(textPainter(bundle.getString("investigateTheBushes_goBack")));
    inFrontOfCave();
  }

  private void exploreCave() throws InterruptedException {
    displayStories("exploreCave");
    exploreCaveChoice();
  }

  private void exploreCaveChoice() throws InterruptedException {
    displayStories("exploreCaveChoice");
    String choice = playerChoice().toUpperCase();
    if (choice.equals("R")) {
      exploreCave_LookRight();
    } else if (choice.equals("L")) {
      exploreCave_LookLeft();
    } else {
      inFrontOfCave();
    }
  }

  /** Change Scene to Pond */
  private void exploreCave_LookLeft() throws InterruptedException {
    displayStories("exploreCave_LookLeft_intro");
    if (isPlayerWithBoat) {
      displayStories("exploreCave_LookLeft_withBoat");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("Y")) {
        displayStories("exploreCave_LookLeft_withBoat_y");

      } else {
        sendToExploreCaveChoice();
      }
    } else {
      sendToExploreCaveChoice();
    }
  }

  private void sendToExploreCaveChoice() throws InterruptedException {
    System.out.println(textPainter(bundle.getString("sendToExploreCaveChoice")));
    exploreCaveChoice();
  }

  private void exploreCave_LookRight() throws InterruptedException {
    if (isPlayerWithBoat) {
      System.out.println(textPainter(bundle.getString("exploreCave_LookRight_withBoat")));
      exploreCaveChoice();
    } else {
      displayStories("exploreCave_LookRight");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("Y")) {
        exploreCave_UnlockCode();
      } else {
        exploreCaveChoice();
      }
    }
  }

  private void exploreCave_UnlockCode() throws InterruptedException {
    displayStories("exploreCave_UnlockCode");
    if (localItems.contains("NOTEBOOK")) {
      displayStories("exploreCave_UnlockCode_withNoteBook");
    }
    exploreCave_TryCombination();
  }

  private void exploreCave_TryCombination() throws InterruptedException {
    displayStories("exploreCave_TryCombination");
    String result = playerChoice();
    if (result.equals("624")) {
      localItems.add("UNLOCK_BOAT_DOOR");
      exploreCave_TryCombination_Successful();
    } else {
      System.out.println(textPainter(bundle.getString("exploreCave_TryCombination_incorrect")));

      if (localItems.contains("NOTEBOOK")) {
        exploreCave_UnlockCodeByBook();
      } else {
        displayStories("exploreCave_TryCombination_goBack");
        String choice = playerChoice().toUpperCase();
        if (choice.equals("Y")) {
          inFrontOfCave();
        } else {
          exploreCave_TryCombination();
        }
      }
    }
  }

  private void exploreCave_UnlockCodeByBook() throws InterruptedException {
    displayStories("exploreCave_UnlockCodeByBook");
    String choice = playerChoice().toUpperCase();
    if (choice.equals("Y")) {
      exploreCave_UnlockCodeByBookFlip();
    }
    exploreCave_TryCombination();
  }

  private void exploreCave_UnlockCodeByBookFlip() throws InterruptedException {
    displayStories("exploreCave_UnlockCodeByBookFlip");
    String pageChoice = playerChoice();
    switch (pageChoice) {
      case "12":
        System.out.println(
            textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption1")));
        break;
      case "23":
        System.out.println(
            textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption2")));
        break;
      case "35":
        System.out.println(
            textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption3")));
        break;
      default:
        System.out.println(
            textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOptionX")));
    }
  }

  private void exploreCave_TryCombination_Successful() throws InterruptedException {
    displayStories("exploreCave_TryCombination_Successful");
    String choice = playerChoice().toUpperCase();

    if (choice.equals("Y")) {
      thePlayer.addItemToInventory(boat);
      getItemsInScene().remove(boat);

      // DONE Program needs to be added
      System.out.println(
          textPainter(bundle.getString("exploreCave_TryCombination_Successful_registerBoat")));

      isPlayerWithBoat = true;
    }
    exploreCaveChoice();
  }

  private String playerChoice() {
    return choice.nextLine();
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

  public boolean is_max_iteration_not_reached() {
    return _max_iteration_not_reached;
  }

  public List<String> getLocalItems() {
    return localItems;
  }

  public boolean getIsPlayerWithBoat() {
    return isPlayerWithBoat;
  }


  @Override
  public String toString() {
    return "Cave{" +
      "FILE_BASE_NAME='" + FILE_BASE_NAME + '\'' +
      ", PATH='" + PATH + '\'' +
      ", rbc=" + rbc +
      ", bundle=" + bundle +
      ", _max_iteration_not_reached=" + _max_iteration_not_reached +
      ", MAX_ITERATION_DISPLAY_STORIES=" + MAX_ITERATION_DISPLAY_STORIES +
      ", isPlayerWithTorch=" + isPlayerWithTorch +
      ", isPlayerWithLighter=" + isPlayerWithLighter +
      ", isPlayerWithBoat=" + isPlayerWithBoat +
      ", localItems=" + localItems +
      ", choice=" + choice +
      ", thePlayer=" + thePlayer +
      ", itemsInThisScene=" + itemsInThisScene +
      ", boat=" + boat +
      "} " + super.toString();
  }
}
