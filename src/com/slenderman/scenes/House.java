package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;

import java.text.MessageFormat;
import java.util.*;

public class House extends Scene {
  // For Resource Bundle //
  final String FILE_BASE_NAME = "storyHouseNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
  /////////////////////////

  // Unit testing purpose //
  private boolean _max_iteration_not_reached;
  //////////////////////////
  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  private String introduction;

  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("house");

  private Item Lockbox =
      ("lockbox".equals(itemsInThisScene.get(0).getItemName()))
          ? itemsInThisScene.get(0)
          : itemsInThisScene.get(1);

  private Item Lighter =
      ("lighter".equals(itemsInThisScene.get(0).getItemName()))
          ? itemsInThisScene.get(0)
          : itemsInThisScene.get(1);

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public House() {
    setItemsInScene(itemsInThisScene);
    setSceneName("house");
  }

  public House(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {

    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setItemsInScene(itemsInThisScene);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    try {

      introToHouse();
      Thread.sleep(1000);

      houseInView();
      Thread.sleep(1000);
      inHouse();
      Thread.sleep(1000);
      atTable();
      openingLockbox(in, player);
      leaveHouse();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void introToHouse() throws InterruptedException {
    try {
      System.out.println(textPainter(bundle.getString("introToHouse_0")));
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("introToHouse_1")));
      Thread.sleep(2000);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_2")));
      Thread.sleep(2000);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_3")));
      Thread.sleep(2000);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_4")));
      Thread.sleep(1500);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_5")));
      Thread.sleep(1250);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_6")));
      Thread.sleep(1000);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_7")));
      Thread.sleep(1000);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_8")));
      Thread.sleep(1500);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_9")));
      System.out.println();
      Thread.sleep(2000);
      System.out.println(textPainter(bundle.getString("introToHouse_10")));
      System.out.println();

    } catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }
  }

  public void houseInView() throws InterruptedException {
    try {
      System.out.println(textPainter(bundle.getString("houseInView_0")));
      Thread.sleep(1000);
      System.out.println(
              "\n"
              + "                                   /\\\n"
              + "                              /\\  //\\\\\n"
              + "                       /\\    //\\\\///\\\\\\        /\\\n"
              + "                      //\\\\  ///\\////\\\\\\\\  /\\  //\\\\\n"
              + "         /\\          /  ^ \\/^ ^/^  ^  ^ \\/^ \\/  ^ \\\n"
              + "        / ^\\    /\\  / ^   /  ^/ ^ ^ ^   ^\\ ^/  ^^  \\\n"
              + "       /^   \\  / ^\\/ ^ ^   ^ / ^  ^    ^  \\/ ^   ^  \\       *\n"
              + "      /  ^ ^ \\/^  ^\\ ^ ^ ^   ^  ^   ^   ____  ^   ^  \\     /|\\\n"
              + "     / ^ ^  ^ \\ ^  _\\___________________|  |_____^ ^  \\   /||o\\\n"
              + "    / ^^  ^ ^ ^\\  /______________________________\\ ^ ^ \\ /|o|||\\\n"
              + "   /  ^  ^^ ^ ^  /________________________________\\  ^  /|||||o|\\\n"
              + "  /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||      /||o||||||\\\n"
              + " / ^   ^   ^    ^  ||___|___||||||||||||___|__|||          | |\n"
              + "/ ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||oooooooooo| |ooooooo\n"
              + "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("houseInView_2")));

      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("houseInView_3")));

      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("houseInView_4")));

      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("houseInView_5")));

      Thread.sleep(1500);
      System.out.println(textPainter(bundle.getString("houseInView_6")));

      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("houseInView_7")));
    } catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }
  }

  public void inHouse() throws InterruptedException {
    try {
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_0")));
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_1")));
      Thread.sleep(1000);
      System.out.println(
              " _________________________________________________________\n"
              + "||-------------------------------------------------------||\n"
              + "||.--.    .-._                        .----.             ||\n"
              + "|||==|____| |H|___            .---.___|\"\"\"\"|_____.--.___ ||\n"
              + "|||  |====| | |xxx|_          |+++|=-=|_  _|-=+=-|==|---|||\n"
              + "|||==|    | | |   | \\         |   |   |_\\/_|Black|  | ^ |||\n"
              + "|||  |    | | |   |\\ \\   .--. |   |=-=|_/\\_|-=+=-|  | ^ |||\n"
              + "|||  |    | | |   |_\\ \\_( oo )|   |   |    |Magus|  | ^ |||\n"
              + "|||==|====| |H|xxx|  \\ \\ |''| |+++|=-=|\"\"\"\"|-=+=-|==|---|||\n"
              + "||`--^----'-^-^---'   `-' \"\"  '---^---^----^-----^--^---^||\n"
              + "||-------------------------------------------------------||\n"
              + "||-------------------------------------------------------||\n"
              + "||               ___                   .-.__.-----. .---.||\n"
              + "||              |===| .---.   __   .---| |XX|<(*)>|_|^^^|||\n"
              + "||         ,  /(|   |_|III|__|''|__|:x:|=|  |     |=| Q |||\n"
              + "||      _a'{ / (|===|+|   |++|  |==|   | |  |Illum| | R |||\n"
              + "||      '/\\\\/ _(|===|-|   |  |''|  |:x:|=|  |inati| | Y |||\n"
              + "||_____  -\\{___(|   |-|   |  |  |  |   | |  |     | | Z |||\n"
              + "||       _(____)|===|+|[I]|DK|''|==|:x:|=|XX|<(*)>|=|^^^|||\n"
              + "||              `---^-^---^--^--'--^---^-^--^-----^-^---^||\n"
              + "||-------------------------------------------------------||\n"
              + "||_______________________________________________________||\n"
              + "\n");

      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_3")));
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_4")));
      Thread.sleep(1000);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void atTable() throws InterruptedException {
    try {
      System.out.println(textPainter(bundle.getString("atTable_0")));
      Thread.sleep(750);
      System.out.println(
          "          _________________________________________________\n"
              + "        .' ____________________________________________ _.'|\n"
              + "      .' .'____________________________________________|_| |\n"
              + "    .' .'.'                                           .'.' |\n"
              + "  .' .'.'                                           .'.'  .'\n"
              + " __.'.'___________________________________________.'.'  .'|\n"
              + "|  |'______.-.__________________________.-.____ __.'  .'| |\n"
              + "|  |    o--[]--o                     o--[]--o  |  | .'  | |\n"
              + "|__|____[.|  |.]____ ________ _______[.|  |.]__|__|' |  | |\n"
              + "  |  | |  \\__/ _____|  ====  |  .'_____\\__/|  | |____|  | |\n"
              + "  |  | |.'          |        |.'           |  | |   . . | |\n"
              + "  |  | |            '--------'             |  | | .'.'__|.'\n"
              + "  |  | ____________________________________|  | |'.'\n"
              + "  |  ||____________________________________|  | |'\n"
              + "  |  | |                                   |  | |\n"
              + "  |__|.'                                   |__|.'");
      Thread.sleep(1500);
      System.out.println(textPainter(bundle.getString("atTable_1")));
      Thread.sleep(1000);
      displayStories("atTable_2");
      displayStories("atTable_3");

      Thread.sleep(6000);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openingLockbox(Scanner in, Player player) throws InterruptedException {
    String playerChoice = "";

    try {
      System.out.println(textPainter(bundle.getString("openingLockBox_0")));
      lockBoxChoices();

      while (!playerChoice.equals("4")) {
        playerChoice = in.nextLine().toLowerCase().trim();

        if (playerChoice.equals("1")) {
          displayStories("openingLockBox_1");
          lockBoxChoices();
        }

        if (playerChoice.equals("2")) {
          System.out.println(textPainter(bundle.getString("openingLockBox_2_0")));
          Thread.sleep(1000);
          displayStories("openingLockBox_2");

          lockBoxChoices();
        }

        if (playerChoice.equals("3")) {
          unlockLockBox(player);
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void leaveHouse() {
    displayStories("leaveHouse");
  }

  public void unlockLockBox(Player player) {
    if (playerHasItem(player, "key")) {

      player.addItemToInventory(Lighter);
      getItemsInScene().remove(Lighter);
      displayStories("unlockLockBox");
    }
    else {
      displayStories("unlockLockBox_needKey");
    }
  }

  public void lockBoxChoices() {
    displayStories("lockBoxChoices");
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


  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public void setLockbox(Item lockbox) {
    Lockbox = lockbox;
  }

  public void setLighter(Item lighter) {
    Lighter = lighter;
  }

  // GET METHODS
  public Item getLighter() {
    return Lighter;
  }

  public Item getLockbox() {
    return Lockbox;
  }

  public String getIntroduction() {
    return introduction;
  }
}
