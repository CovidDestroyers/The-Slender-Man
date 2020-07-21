package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;

import java.util.*;

public class House extends Scene {
  private String introduction;

  private Item Lockbox = new Item("lockbox", "house", "hold lighter", "house"
    , true, "key", "unlocks lockbox", "lighter");

  private Item Lighter = new Item("lighter", "house", "light torch", "house",
    true, "lockbox", "holds lighter", "none");

  private ArrayList<Item> defaultItems = new ArrayList<>(Arrays.asList(
    Lockbox, Lighter));



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public House(Scene sceneToTheNorth, Scene sceneToTheSouth,
               Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

  }


  public House(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast,
    Scene sceneToTheWest, boolean useDefaultItems) {
    this(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    if (useDefaultItems) {
      setDefaultItems(defaultItems);
    }
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
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void introToHouse() throws InterruptedException {
    try {
      System.out.println("You are walking towards the house, when your " +
                         "flashlight begins to flicker.\n");
      System.out.println("You hit it against your hand as all rational people do.");
      Thread.sleep(3000);
      System.out.println("It goes black.");
      Thread.sleep(1000);
      System.out.println("You see nothing.");
      Thread.sleep(500);
      System.out.println("Your heart quickens.");
      Thread.sleep(350);
      System.out.println("Sweat forms on your brow.");
      Thread.sleep(250);
      System.out.println("Hands tremor.");
      Thread.sleep(150);
      System.out.println("What's that sound?!?!");
      Thread.sleep(75);
      System.out.println("Who's behind you?");
      Thread.sleep(25);
      System.out.println("ITS COMING");

      Thread.sleep(1000);
      System.out.println("Panic sets in.");


    }
    catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }

  }

  public void houseInView() throws InterruptedException {
    try {
      System.out.println("House in full view: ");
      System.out.println(
          Scene.ANSI_GREEN
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
      Thread.sleep(500);
      System.out.println("There’s a light in the window!");

      Thread.sleep(500);
      System.out.println("Legs launch you forward towards the grim house");

      Thread.sleep(400);
      System.out.println("You are in the yeard");

      Thread.sleep(300);
      System.out.println("Door is within reach.");

      Thread.sleep(200);
      System.out.println("You drive your left shoulder hard into the door");

      Thread.sleep(100);
      System.out.println("It gives too easily.");
    }
    catch (InterruptedException e) {
      System.out.println("Awe you broke it :(");
      e.printStackTrace();
    }
  }


  public void inHouse() throws InterruptedException {
    try {
      System.out.println("You’re in the house.");
      Thread.sleep(500);
      System.out.println("Nothing greets you, but spiders and dust");
      Thread.sleep(500);
      System.out.println(
          "You stand to brush the dust off your clothes, and notice a " +
          "bookshelf near the window to your left.");
      System.out.println(
          Scene.ANSI_GREEN
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
      System.out.println("There is a small kitchen, a small dining " +
                         "table, and one chair to your right.");
      System.out.println("No human has lived here for a long time. ");
      Thread.sleep(1000);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void atTable() throws InterruptedException {
    try {
      System.out.println("You approach the table:");
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
            Thread.sleep(800);
      System.out.println("You find a note underneath a locked box: ");
      System.out.println("");
      System.out.println(
          ANSI_WHITE
              + "Will any one read these warnings? I’ve been here long " +
          "enough—alone, except for him—to lose all semblance of sanity. " +
          "Alas, these are the ramblings of a madman! But I must continue " +
          "lest others finds themselves trapped in this dreadful place—long " +
          "after I’ve gone I’m sure. Very well then, let us carry on. \n" +
          "To all unfortunate souls who finds themselves here, take heed to " +
          "my words and read carefully. For this box guards an item that may " +
          "be the key to your freedom: \n" + ANSI_GREEN
              + "‘Give me a stroke and I just might come alive. The element I emit needs oxygen to survive. I have many uses. Forms. Even sizes too. With me fun and entertainment can ensue. I am often stolen and sometimes lost. Although this comes at almost no cost. Disposable I am. Dangerous I can be. I burn just as hot as your cup of tea. In darkness I can be a source of light. Wrongfully take me and there might be a fight.’");

      Thread.sleep(1000);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openingLockbox(Scanner in, Player player) throws InterruptedException {
    String playerChoice = "";

    try {
      System.out.println("You notice the box is locked.");

      while (!playerChoice.equals("4")) {
        lockBoxChoices();

        playerChoice = in.nextLine().toLowerCase().trim();

        if (playerChoice.equals("1")) {
          System.out.println("Hmmmm... that did nothing.");
          System.out.println("Try again...");
          break;
        }

        if (playerChoice.equals("2")) {
          System.out.println("Did that make you feel big?");
          Thread.sleep(300);
          System.out.println("Cause nothing happened...");
          System.out.println("Try again.");
          break;
        }

        if (playerChoice.equals("3")) {
          unlockLockBox(player);
          break;
        }
      }

    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }




  public void unlockLockBox(Player player) {
    if (playerHasKey(player)) {
      System.out.println("You have opened the lockbox! You are awarded a " +
                         "lighter. May it light your path in times of " +
                         "darkness.\n");
    } else {
      System.out.println("You need a key to open this box");
    }
  }


  // TODO: search through player's inventory and see if they have the correct
  //  item
  public Boolean playerHasKey(Player player) {
    Collection<Item> playerInventory = player.getInventory();

    boolean hasItem = false;
    for (Item item : playerInventory) {
      if (item.getItemName().equals("key")) {
        hasItem = true;
        break;
      }
    }

    return hasItem;
  }

  public void lockBoxChoices() {
    System.out.println("What do you do?");
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

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public Item getLockbox() {
    return Lockbox;
  }

  public void setLockbox(Item lockbox) {
    Lockbox = lockbox;
  }

  public Item getLighter() {
    return Lighter;
  }

  public void setLighter(Item lighter) {
    Lighter = lighter;
  }

  public ArrayList<Item> getDefaultItems() {
    return defaultItems;
  }

  public void setDefaultItems(ArrayList<Item> defaultItems) {
    this.defaultItems = defaultItems;
  }



  @Override
  public String toString() {
    return "House{" + "introduction='" + introduction + '\'' +
           ", defaultItems=" + defaultItems + ", Lockbox=" + Lockbox +
           ", Lighter=" + Lighter + "} " + super.toString();
  }


}
