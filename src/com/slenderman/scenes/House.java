package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class House extends Scene {
  final String FILE_BASE_NAME = "storyHouseNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  public int visitCount = 0;

  ResourceBundle.Control rbc =
    ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  // Unit testing purpose
  private boolean _max_iteration_not_reached;
  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  //TODO changed from 1000ms and in some places a little more time. Felt necessary to change the 2000's and 1500's to shorter time as well for simplicity.

  private String introduction;

  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("house");

  private Item Lockbox = ItemDirector.findThisItem("lockbox", itemsInThisScene);

  private Item Lighter = ItemDirector.findThisItem("lighter", itemsInThisScene);

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
    if (visitCount == 0) {
      try {
        introToHouse();
        Thread.sleep(sleep);

        houseInView();
        Thread.sleep(sleep);

        inHouse();
        Thread.sleep(sleep);

        atTable();
        openingLockbox(in, player);

        leaveHouse();
        visitCount += 1;

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else if (visitCount >= 1) {
      System.out.println("You are back in the house...");
      Thread.sleep(sleep);
      openingLockbox(in, player);

      leaveHouse();
      visitCount +=1;
    }
  }

  public void introToHouse() throws InterruptedException {
    try {
      System.out.println(textPainter(bundle.getString("introToHouse_0")));
      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("introToHouse_1")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_2")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_3")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_4")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_5")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_6")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_7")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_8")));
      Thread.sleep(sleep);
      System.out.println();
      System.out.println(textPainter(bundle.getString("introToHouse_9")));
      System.out.println();
      Thread.sleep(sleep);
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
      Thread.sleep(sleep);
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

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("houseInView_2")));

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("houseInView_3")));

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("houseInView_4")));

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("houseInView_5")));

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("houseInView_6")));

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("houseInView_7")));
    } catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }
  }

  public void inHouse() throws InterruptedException {
    try {
      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("inHouse_0")));
      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("inHouse_1")));
      Thread.sleep(sleep);
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

      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("inHouse_3")));
      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("inHouse_4")));
      Thread.sleep(sleep);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void atTable() throws InterruptedException {
    try {
      System.out.println(textPainter(bundle.getString("atTable_0")));
      Thread.sleep(sleep);
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
      Thread.sleep(sleep);
      System.out.println(textPainter(bundle.getString("atTable_1")));
      Thread.sleep(sleep);
      displayStories("atTable_2");
      displayStories("atTable_3");
      Thread.sleep(sleep + 2000);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openingLockbox(Scanner in, Player player) throws InterruptedException {
    String playerChoice = "";

    if (visitCount == 0) {

      try {
        System.out.println(textPainter(bundle.getString("openingLockBox_0")));
        lockBoxChoices();

        while (!playerChoice.equals("4")) {
          playerChoice = in.nextLine().toLowerCase().trim();

          if (playerChoice.equals("1")) {
            System.out.println("There is definitely something in there...\n");
            lockBoxChoices();
          }

          if (playerChoice.equals("2")) {
            System.out.println(textPainter(bundle.getString("openingLockBox_2_0")));
            Thread.sleep(sleep);
            displayStories("openingLockBox_2");
            visitCount = visitCount +1;

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
    } else if (visitCount >= 1) {
      try {
        System.out.println("You look back at the lockbox...");
        Thread.sleep(sleep);
        lockBoxChoices();

        while (!playerChoice.equals("4")) {
          playerChoice = in.nextLine().toLowerCase().trim();

          if (playerChoice.equals("1")) {
            System.out.println("There is definitely something in there...\n");
            Thread.sleep(sleep);
            lockBoxChoices();
          }

          if (playerChoice.equals("2")) {
            System.out.println("It didn't work the first time you did it, why on earth would you kick it again.");
            System.out.println("Try again.\n");
            Thread.sleep(sleep);

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
  }

  public void leaveHouse() {
    displayStories("leaveHouse");
  }

  public void unlockLockBox(Player player) {
    if (playerHasItem(player, "key")) {

      player.addItemToInventory(Lighter);
      getItemsInScene().remove(Lighter);

      displayStories("unlockLockBox");
    } else {
      displayStories("unlockLockBox_needKey");
    }
  }

  public void lockBoxChoices() {
    displayStories("lockBoxChoices");
  }

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


  @Override
  public String toString() {
    return "House{" +
      "FILE_BASE_NAME='" + FILE_BASE_NAME + '\'' +
      ", PATH='" + PATH + '\'' +
      ", rbc=" + rbc +
      ", bundle=" + bundle +
      ", _max_iteration_not_reached=" + _max_iteration_not_reached +
      ", MAX_ITERATION_DISPLAY_STORIES=" + MAX_ITERATION_DISPLAY_STORIES +
      ", introduction='" + introduction + '\'' +
      ", itemsInThisScene=" + itemsInThisScene +
      ", Lockbox=" + Lockbox +
      ", Lighter=" + Lighter +
      ", lighter=" + getLighter() +
      ", lockbox=" + getLockbox() +
      "} " + super.toString();
  }
}
