package com.slenderman.scenes;

import com.slenderman.actors.Player;
import com.slenderman.game.Console;
import com.slenderman.music.Music;
import com.slenderman.tools.Sound;

import java.io.File;
import java.text.MessageFormat;
import java.util.*;

/**
 * Things need in this scene : boat
 *
 * <p>East : Field West : Cave North : Outhouse
 */
public class Pond extends Scene {

  private int countCheckBackPack = 0; // Count how many times the player check the backpack
  private boolean memoOnStones = false; // If memo between stones are read
  private boolean wearingFogGlasses = false; // If the player is wearing wog glasses
  private boolean crossVisited = false; // On island, if the player visited the cross
  private boolean islandTreeLookDown = false; // On island, if the player looked down the tree
  private boolean isFogClear = false; // On island, if the fog is cleared

  // For Resource Bundle //
  final String FILE_BASE_NAME = "storyPondNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc =
      ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
  /////////////////////////

  // Unit testing purpose //
  private boolean _max_iteration_not_reached;
  //////////////////////////
  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  private final List<String> localItems = new ArrayList<>();
  private Player player;

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Pond() {
    setSceneName("pond");
  }

  public Pond(
      Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {

    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setSceneName("pond");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    this.player = player;
    Console.updateMap(this.getSceneName());
    Console.clearScreen();
    inFrontOfPond(in);
  }

//  @Override
//  public void enter(Scanner in, Player player, Music music) throws Exception {
//    this.player = player;
//    Console.updateMap(this.getSceneName());
//    Console.clearScreen();
//    inFrontOfPond(in);
//    this.Music= music;
//
//  }

  private void inFrontOfPond(Scanner in) throws InterruptedException {
    displayStories("inFront");
    inFrontOfPondChoice(in);
  }

  private void inFrontOfPondChoice(Scanner in) throws InterruptedException {

    if (isFogClear) {
      displayStories("inFrontChoice_FogClear");
    } else {
      displayStories("inFrontChoice");
    }
    String choice = playerChoice(in);
    if (choice.equals("0")) {
      // Walk around
      inFrontOfPondChoice_WalkAround(in);
    } else if (choice.equals("1")) {
      // Swim
      displayStories("inFrontChoice_ChoiceSwim");
      inFrontOfPondChoice(in);
    } else if (choice.equals("2") && (!isFogClear)) {
      inFrontOfPondChoice_UseItems(in);
    } else if (choice.equals("3")) {
      // Change scene
      if (!isFogClear) {
        displayStories("inFrontChoice_ChoiceDifferentScene");
      } else {
        displayStories("inFrontChoice_ChoiceDifferentScene_FogClear");
      }
    } else {
      inFrontOfPondChoice(in);
    }
  }

  private void inFrontOfPondChoice_UseItems(Scanner in) throws InterruptedException {

    displayStories("inFrontChoice_ChoiceUseItems_Intro");
    String choice = playerChoice(in).toUpperCase();
    if (choice.equals("Y")) {
      StringBuilder buildChoices = new StringBuilder();

      Boolean doesPlayerHaveBoat = playerHasItem(player, "boat");

      if ((localItems.contains("FOG_GLASSES"))
          || (localItems.contains("RING_BOX_KEY"))
          || doesPlayerHaveBoat) {

        System.out.println(bundle.getString("itemChoice_Title"));
        System.out.println(bundle.getString("itemChoiceBoat_Print"));
        buildChoices.append(bundle.getString("itemChoiceBoat_Register"));

        if (localItems.contains("FOG_GLASSES")) {
          System.out.println(bundle.getString("itemChoiceGlasses_Print"));
          buildChoices.append(
              bundle.getString("itemChoiceGlasses_Register"));
        }

        if (localItems.contains("RING_BOX_KEY")) {
          System.out.println(bundle.getString("itemChoiceKey_Print"));
          buildChoices.append(bundle.getString("itemChoiceKey_Register"));
        }

        buildChoices.append(
            bundle.getString("itemChoice_ExitToGoBack_Register"));

        do {
          System.out.println(bundle.getString("itemChoice_AskUseItem") + buildChoices);
          choice = playerChoice(in).toUpperCase();

          if ((choice.equals("K")) && localItems.contains("RING_BOX_KEY")) {
            System.out.println(bundle.getString("itemChoice_AskUseItem_AnswerKey"));

          }
          else if ((choice.equals("G")) && localItems.contains("FOG_GLASSES")) {
            displayStories("itemChoice_AskUseItem_AnswerGlasses");
            choice = playerChoice(in).toUpperCase();

            switch (choice) {
              case "0":
                displayStories("itemChoice_AskUseItem_AnswerGlassesUp");
                break;
              case "1":
                displayStories("itemChoice_AskUseItem_AnswerGlassesDown");
                break;
              case "2":
                displayStories("itemChoice_AskUseItem_AnswerGlassesStraight");
                wearingFogGlasses = true;
                break;
            }

          }
          else if (choice.equals("B") /*Boat*/) {
            displayStories("itemChoice_UseBoat");
            choice = playerChoice(in).toUpperCase();
            if (choice.equals("Y")) {
              if (!wearingFogGlasses) {
                displayStories("itemChoice_UseBoat_GlassesOnNot");
              }
              else if (!localItems.contains("RING_BOX_KEY")){
                System.out.println("\nYou do not have a key.");
              }
              else {

                displayStories("itemChoice_UseBoat_GlassesOn");
                inFontOfIsland(in);
                break;
              }
            }
          }
          else {
            inFrontOfPondChoice(in);
            break;
          }
        }
        while (true);

      }
      else {
        displayStories("itemChoice_noItem");
        inFrontOfPondChoice(in);
      }
    }
    else {
      displayStories("itemChoice_notSelectedToList");
      inFrontOfPondChoice(in);
    }
  }

  public void inFrontOfPondChoice_WalkAround(Scanner in) throws InterruptedException {
    // Try to find a special glass which you can see though the the fog
    displayStories("WalkAround");
    String choice = playerChoice(in).toUpperCase();

    if (choice.equals("L")) {
      displayStories("WalkAround_Left");
      choice = playerChoice(in).toUpperCase();

      if (choice.equals("Y")) {
        if (countCheckBackPack == 0) {
          countCheckBackPack += 1;
          displayStories("CheckBackpack_FirstTime");
        } else if (countCheckBackPack > 0) {
          if (!localItems.contains("FOG_GLASSES")) {

            displayStories("CheckBackpack_NotHavingGlasses");
            choice = playerChoice(in).toUpperCase();
            if (choice.equals("0")) {

              displayStories("CheckBackpack_UnwrapObject");
              localItems.add("FOG_GLASSES");
            } else {
              displayStories("CheckBackpack_PutItBack");
            }
          } else {
            displayStories("CheckBackpack_HavingGlasses");
          }
        }
      } else {
        displayStories("CheckBackpack_NotInvestigate");
      }

      displayStories("CheckBackpack_WentBack");
      inFrontOfPondChoice(in);
    } else if (choice.equals("R")) {
      inFrontOfPondChoice_WalkAround_Right(in);
    } else {
      inFrontOfPondChoice_WalkAround(in);
    }
  }

  private void inFrontOfPondChoice_WalkAround_Right(Scanner in) throws InterruptedException {
    displayStories("WalkAround_Right");
    String choice = playerChoice(in).toUpperCase();

    if (choice.equals("0")) {
      displayStories("WalkAround_Right_LookUp");
      Sound.play(new File("./Speech/Pond/stars.mp3"));
      inFrontOfPondChoice_WalkAround_Right(in);
    } else {
      if (!localItems.contains("RING_BOX_KEY")) {
        displayStories("WalkAround_Right_LookDown_FindingRingBox");
        choice = playerChoice(in).toUpperCase();

        if (choice.equals("Y")) {
          displayStories("WalkAround_Right_LookDown_InvestigateRingBox");
          choice = playerChoice(in).toUpperCase();

          if (choice.equals("Y")) {
            displayStories("WalkAround_Right_LookDown_AddRingBoxKey");
            localItems.add("RING_BOX_KEY");
          } else {
            displayStories("WalkAround_Right_LookDown_AddRingBoxKeyNot");
          }
        } else {
          displayStories("WalkAround_Right_LookDown_InvestigateRingBoxNot");
        }
        inFrontOfPondChoice_WalkAround_Right(in);
      } else if (!memoOnStones) {
        memoOnStones = true;
        displayStories("WalkAround_Right_LookDown_MemoOnStones");
        inFrontOfPondChoice(in);
      } else {
        displayStories("WalkAround_Right_LookDown_Nothing");
        inFrontOfPondChoice(in);
      }
    }
  }

  /************** Island **************/
  private void inFontOfIsland(Scanner in) throws InterruptedException {
    displayStories("InFront_Island");
    inFrontOfIsland_Question(in);
  }

  private void inFrontOfIsland_Question(Scanner in) throws InterruptedException {
    displayStories("InFront_Island_AskAction");
    String choice = playerChoice(in).toUpperCase();
    if (choice.equals("0")) {
      displayStories("IsFront_Island_StayInBoat");
      inFrontOfIsland_Question(in);
    } else {
      displayStories("IsFront_IsLand_GoAshore");
      onIsland(in);
    }
  }

  private void onIsland(Scanner in) throws InterruptedException {
    displayStories("OnIsland");
    String choice = playerChoice(in).toUpperCase();

    if (choice.equals("0")) {
      displayStories("OnIsland_Cross");
      crossVisited = true;
      onIsland(in);
    } else {
      if (!crossVisited) {
        displayStories("OnIsland_Tree_CrossNotVisited");
        onIsland(in);
      } else {
        onIsland_lookUpDown(in);
      }
    }
  }

  /** Change scene */
  private void onIsland_lookUpDown(Scanner in) throws InterruptedException {
    displayStories("OnIsland_Tree");
    String choice = playerChoice(in).toUpperCase();

    if (choice.equals("0")) {
      if (!islandTreeLookDown) {
        displayStories("OnIsland_Tree_LookUp_NeverLookedDown");
        onIsland_lookUpDown(in);
      } else {

        displayStories("OnIsland_Tree_LookUp");
      }
    } else {
      if (!isFogClear) {
        isFogClear = true;
        displayStories("OnIsland_Tree_LookDown");
        islandTreeLookDown = true;
      } else {
        displayStories("OnIsland_Tree_LookDown_FogCleared");
      }
      onIsland_lookUpDown(in);
    }
  }

  // private String playerChoice(){
  //   return new Scanner(System.in);
  // }

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
        System.out.println(textPainter(bundle.getString(key + "[" + i + "]")));
      } catch (MissingResourceException e) {
        _max_iteration_not_reached = true;
        break;
      }
    }
  }

  /*** Testing purpose ***/
  // Controlling "isFogClear"
  public void setIsFogClear(boolean isFogClear) {
    this.isFogClear = isFogClear;
  }
  // Getting the status of "isFogClear"
  public boolean getIsFogClear() {
    return isFogClear;
  }
}
