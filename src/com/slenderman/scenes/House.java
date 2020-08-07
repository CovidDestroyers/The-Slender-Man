package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;
import com.slenderman.game.Console;
import com.slenderman.tools.Sound;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class House extends Scene {
  private boolean _max_iteration_not_reached;
  private String introduction;
  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("house");
  private Item Lockbox = ItemDirector.findThisItem("lockbox", itemsInThisScene);
  private Item Lighter = ItemDirector.findThisItem("lighter", itemsInThisScene);

  public final int MAX_ITERATION_DISPLAY_STORIES = 10;
  public final String FILE_BASE_NAME = "storyHouseNoColor";
  public final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc =
      ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  public House() {
    setItemsInScene(itemsInThisScene);
    setSceneName("house");
  }

  public House(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setItemsInScene(itemsInThisScene);
  }

  @Override
  public void enter(Scanner in, Player player) {
    try {
      introToHouse();
      Thread.sleep(2000);
      Console.clearScreen();
      houseInView();
      Thread.sleep(2000);
      Console.clearScreen();
      inHouse();
      Thread.sleep(2000);
      Console.clearScreen();
      atTable();
      Console.clearScreen();
      openingLockbox(in, player);
      leaveHouse();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void introToHouse() {
    try {
      Console.updateMap(this.getSceneName());
      Console.clearScreen();
      String houseFirst =
          "<pre color='blue'>          /\\</pre>"+
          "<pre color='blue'>         / ^\\    /\\</pre>"+
          "<pre color='blue'>        /^   \\  / ^\\                                            *</pre>"+
          "<pre color='blue'>       /  ^ ^ \\/^  ^\\                    ____                  /|\\</pre>"+
          "<pre color='blue'>      / ^ ^  ^ \\ ^  _\\___________________|  |_____            /||o\\</pre>"+
          "<pre color='blue'>     / ^^  ^ ^ ^\\  /______________________________\\          /|o|||\\</pre>"+
          "<pre color='blue'>    /  ^  ^^ ^ ^  /________________________________\\        /|||||o|\\</pre>"+
          "<pre color='blue'>   /^ ^  ^ ^^  ^    ||___|___||||||||||||___|__|||         /||o||||||\\</pre>"+
          "<pre color='blue'>  / ^   ^   ^    ^  ||___|___||||||||||||___|__|||             | |</pre>"+
          "<pre color='blue'> / ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||ooooooooooooo| |oooo</pre>";


      Console.updateImage(houseFirst);
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

  public void houseInView() {
    try {
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("houseInView_0")));



      String houseSecond =
          "<pre color='green'>          /\\</pre>"+
          "<pre color='green'>         / ^\\    /\\</pre>"+
          "<pre color='green'>        /^   \\  / ^\\                                            *</pre>"+
          "<pre color='green'>       /  ^ ^ \\/^  ^\\                    ____                  /|\\</pre>"+
          "<pre color='green'>      / ^ ^  ^ \\ ^  _\\___________________|  |_____            /||o\\</pre>"+
          "<pre color='green'>     / ^^  ^ ^ ^\\  /______________________________\\          /|o|||\\</pre>"+
          "<pre color='green'>    /  ^  ^^ ^ ^  /________________________________\\        /|||||o|\\</pre>"+
          "<pre color='green'>   /^ ^  ^ ^^  ^    ||<em color='yellow'>___</em>|___||||||||||||___|__|||         /||o||||||\\</pre>"+
          "<pre color='green'>  / ^   ^   ^    ^  |<em color='yellow'>|___|</em>___||||||||||||___|__|||             | |</pre>"+
          "<pre color='green'> / ^ ^ ^  ^  ^  ^   ||||||||||||||||||||||||||||||ooooooooooooo| |oooo</pre>";

      Console.updateImage(houseSecond);

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

  public void inHouse() {
    try {
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_0")));
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_1")));
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_3")));
      Thread.sleep(1000);
      System.out.println(textPainter(bundle.getString("inHouse_4")));
      Thread.sleep(1000);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void atTable() {
    try {
      System.out.println(textPainter(bundle.getString("atTable_0")));
      Thread.sleep(1000);
      String table =
        "<pre color='gray'><small>    _____                                                 </small></pre>"+
          "<pre color='gray'><small>   / <em color='white'>ev</em>  /|_ ___________________________________________</small></pre>"+
          "<pre color='gray'><small>  / <em color='white'>il</em>  // /                                          /|</small></pre>"+
          "<pre color='gray'><small> (====|/ //    <em color='red'>TAKE</em>                                  / |</small></pre>"+
          "<pre color='gray'><small>  (=====|/         <em color='red'>THIS</em>                             / .|</small></pre>"+
          "<pre color='gray'><small> (====|/               <em color='red'>CHILD!</em>                      / /||</small></pre>"+
          "<pre color='gray'><small>/_________________________________________________/ / ||</small></pre>"+
          "<pre color='gray'><small>|  _______________________________________________||  ||</small></pre>"+
          "<pre color='gray'><small>| ||                                            | ||</small></pre>"+
          "<pre color='gray'><small>| ||                                            | ||</small></pre>"+
          "<pre color='gray'><small>| ||                                            | ||</small></pre>";
      Console.updateImage(table);
      Thread.sleep(1500);
      System.out.println(textPainter(bundle.getString("atTable_1")));
      Thread.sleep(1000);
      displayStories("atTable_2");
      Sound.play(new File("./Speech/House/BoxNote1.mp3"));
      displayStories("atTable_3");
      Sound.play(new File("./Speech/House/BoxNote2.mp3"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void openingLockbox(Scanner in, Player player) {
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

  public void setLighter(Item lighter) {
    Lighter = lighter;
  }

  public Item getLighter() {
    return Lighter;
  }

  public Item getLockbox() {
    return Lockbox;
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
