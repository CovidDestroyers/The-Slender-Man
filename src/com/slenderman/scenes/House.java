package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;
import com.slenderman.game.Game;

import java.util.*;

public class House extends Scene {
  private String introduction;

  private ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene(
    "house");

  private Item Lockbox = (itemsInThisScene.get(0).getItemName().equals(
    "lockbox")) ? itemsInThisScene.get(0) : itemsInThisScene.get(1);

  private Item Lighter = (itemsInThisScene.get(0).getItemName().equals(
    "lighter")) ? itemsInThisScene.get(0) : itemsInThisScene.get(1);






  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public House(Player p) {
    setItemsInScene(itemsInThisScene);
    setSceneName("house");

  };

  public House(Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {

    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setItemsInScene(itemsInThisScene);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  @Override
  public void enter() throws InterruptedException {
    try {
      Scanner in = Game.getScanner();

      introToHouse();
      Thread.sleep(1000);

      houseInView();
      Thread.sleep(1000);
      inHouse();
      Thread.sleep(1000);
      atTable();
      openingLockbox(in);
      leaveHouse();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void introToHouse() throws InterruptedException {
    try {
      System.out.println(ANSI_WHITE + "You are walking towards the house, " +
                         "when your flashlight begins to flicker.\n");
      Thread.sleep(1000);
      System.out.println("You hit it hard against your hand as all rational " +
                         "people do.");
      Thread.sleep(2000);
      System.out.println("");
      System.out.println("It goes black.");
      Thread.sleep(2000);
      System.out.println("");
      System.out.println("You see nothing.");
      Thread.sleep(2000);
      System.out.println("");
      System.out.println("Your heart beat quickens.");
      Thread.sleep(1500);
      System.out.println("");
      System.out.println("Sweat forms on your brow.");
      Thread.sleep(1250);
      System.out.println("");
      System.out.println("Hands tremor.");
      Thread.sleep(1000);
      System.out.println("");
      System.out.println("WHAT'S THAT SOUND?!?!");
      Thread.sleep(1000);
      System.out.println("");
      System.out.println("WHO'S BEHIND YOU?!?!");
      Thread.sleep(1500);
      System.out.println("");
      System.out.println(ANSI_RED+ "HE'S WATCHING!");
      System.out.println("");
      Thread.sleep(2000);
      System.out.println(ANSI_WHITE + "Panic sets in.");
      System.out.println("");

    }
    catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }

  }

  public void houseInView() throws InterruptedException {
    try {
      System.out.println(ANSI_WHITE + "House in full view: ");
      Thread.sleep(1000);
      System.out.println(
          ANSI_GREEN
              + "\n"
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
      System.out.println(ANSI_WHITE + "There’s a light in the window!\n");

      Thread.sleep(1000);
      System.out.println("Legs launch you towards the grim house!\n");

      Thread.sleep(1000);
      System.out.println("You are in the yard!\n");

      Thread.sleep(1000);
      System.out.println("Almost there!\n");

      Thread.sleep(1500);
      System.out.println("You drive your left shoulder hard into the door.\n");

      Thread.sleep(1000);
      System.out.println("It gives easily as you tumble into the now " +
                         "dark house.\n");
    }
    catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }
  }


  public void inHouse() throws InterruptedException {
    try {
      Thread.sleep(1000);
      System.out.println("Nothing greets you, but spiders and dust\n");
      Thread.sleep(1000);
      System.out.println(
          "You stand to brush the dust off your clothes, and notice a " +
          "bookshelf near the window to your left.\n");
      Thread.sleep(1000);
      System.out.println(
          ANSI_GREEN
              + " _________________________________________________________\n"
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
      System.out.println(ANSI_WHITE + "There is a small kitchen, a small " +
                         "dining table, and one chair to your right.\n");
      Thread.sleep(1000);
      System.out.println("No human lives here.\n");
      Thread.sleep(1000);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void atTable() throws InterruptedException {
    try {
      System.out.println("You approach the table:\n");
      Thread.sleep(750);
      System.out.println(
          Scene.ANSI_GREEN
              + "          _________________________________________________\n"
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
      System.out.println("You find a note underneath a locked box:\n");
      Thread.sleep(1000);
      System.out.println(
          ANSI_WHITE
              + "Will any one read these warnings? I’ve been here long " +
          "enough—alone, except for him—to lose all semblance of sanity.\n" +
          "Alas, these are the ramblings of a madman! But I must continue " +
          "lest others finds themselves trapped in this dreadful place—long " +
          "after I’ve gone I’m sure. Very well then, let us carry on. \n" +
          "To all unfortunate souls who finds themselves here, take heed to " +
          "my words and read carefully.\n For this box guards an item that " +
          "may be the key to your freedom:\n" + ANSI_GREEN +
          "     ‘Give me a stroke and I just might come alive.\n" +
          "      The element I emit needs oxygen to survive.\n" +
          "      I have many uses. Forms. Even sizes too.\n" +
          "      With me fun and entertainment can ensue.\n" +
          "      I am often stolen and sometimes lost.\n" +
          "      Although this comes at almost no cost.\n" +
          "      Disposable I am. Dangerous I can be.\n" +
          "      I burn just as hot as your cup of tea.\n" +
          "      In darkness I can be a source of light.\n" +
          "      Wrongfully take me and there might be a fight.’\n");

      Thread.sleep(6000);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openingLockbox(Scanner in) throws InterruptedException {
    String playerChoice = Game.playerChoice(in);

    try {
      System.out.println(ANSI_WHITE + "You notice the box is locked.");
      lockBoxChoices();

      while (!playerChoice.equals("4")) {
        playerChoice = in.nextLine().toLowerCase().trim();

        if (playerChoice.equals("1")) {
          System.out.println("Hmmmm... that did nothing.");
          System.out.println("Try again.\n");
          lockBoxChoices();
        }

        if (playerChoice.equals("2")) {
          System.out.println("Did that make you feel big?");
          Thread.sleep(1000);
          System.out.println("Cause nothing happened...");
          System.out.println("Try again.\n");

          lockBoxChoices();
        }

        if (playerChoice.equals("3")) {
          unlockLockBox(in);
          break;
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void leaveHouse() {
    System.out.println(ANSI_WHITE + "You turn around and step out of the " +
                       "House.\n");
    System.out.println("You see an Abandoned Car to the East and a Cave to " +
                       "the South.\n");
    System.out.println("Which direction would you like to go?");

    System.out.println(ANSI_WHITE + "-Type" + ANSI_GREEN + "\"go east\"" +
                       ANSI_WHITE + "or " + ANSI_GREEN + "\"go south\"" +
                       ANSI_WHITE + ".");
  }



  public void unlockLockBox(Scanner in) {
    /**
    if (playerHasItem(player, "key")) {

      player.addItemToInventory(Lighter);
      getItemsInScene().remove(Lighter);

      System.out.println(ANSI_BLUE + "You have opened the lockbox! You are " +
                         "awarded a lighter.\nMay it light your path in times" +
                         " of darkness.\n");
    }
    else {
      System.out.println(ANSI_RED + "You need a key to open this box you half" +
                         " wit!");
    }
     */
  }


  public void lockBoxChoices() {
    System.out.println(ANSI_WHITE + "What do you do?");
    System.out.println(" -Type \"1\" : Shake it." +
                       "\n -Type \"2\" : Kick it." +
                       "\n -Type \"3\" : Try to open it." +
                       "\n -Type \"4\" : Leave the table.");
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
