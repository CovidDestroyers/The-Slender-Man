package com.slenderman.scenes;

import java.util.*;

/**
 * Things need in this scene : boat
 *
 * East : Field
 * West : Cave
 * North : Outhouse
 *
 * */

public class Pond extends Scene{

    private int countCheckBackPack = 0; // Count how many times the player check the backpack
    private boolean memoOnStones = false; // If memo between stones are read
    private boolean wearingFogGlasses = false; // If the player is wearing wog glasses
    private boolean crossVisited = false; // On island, if the player visited the cross
    private boolean islandTreeLookDown = false; // On island, if the player looked down the tree
    private boolean isFogClear = false; // On island, if the fog is cleared

    private Map<String, String> scenesAround = new HashMap<>();
    private List<String> localItems = new ArrayList<>();

    public Pond(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
      super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

      // Temporary
      this.scenesAround.put("WEST", "FIELD");
      this.scenesAround.put("EAST", "CAVE");
      this.scenesAround.put("NORTH", "OUT_HOUSE");
    }

    public void enter(){
      //System.out.println("Pond is working");
      inFrontOfPond();
    }

    private void inFrontOfPond() {
      System.out.println("\nYou are standing in front of the pond.");
      System.out.println("It is so foggy that you can barely see what's on the other side of the pond");
      System.out.println("You see a cave in the west side and an outhouse in the north direction");
      inFrontOfPondChoice();
    }

    private void inFrontOfPondChoice(){

      System.out.println("\nWhat would you like to do?");

      if (isFogClear){
        System.out.println(" -Type \"0\" : Walk around" +
          "\n -Type \"1\" : Swim" +
          "\n -Type \"3\" : Go to a different scene");
      }
      else {
        System.out.println(" -Type \"0\" : Walk around" +
          "\n -Type \"1\" : Swim" +
          "\n -Type \"2\" : Use items" +
          "\n -Type \"3\" : Go to a different scene");
      }
      String choice = playerChoice();
      if (choice.equals("0")){
        //Walk around
        inFrontOfPondChoice_WalkAround();
      }
      else if(choice.equals("1")){
        // Swim
        System.out.println("\nYou touched the water. It is freezing.");
        System.out.println("Also, you see ripples and something moving below the surface of the pond");
        System.out.println("You got scared. Decided not to swim");
        inFrontOfPondChoice();
      }
      else if(choice.equals("2") && (!isFogClear)){
        inFrontOfPondChoice_UseItems();
      }
      else if(choice.equals("3")){
        // Go to different Scenes
        if (!isFogClear) {
          System.out.println("\nWhich direction would you like to go to? " +
            "\n- Type \"N\": North" +
            "\n- Type \"W\": West");
        }
        else{
          System.out.println("\nWhich direction would you like to go to? " +
            "\n- Type \"N\": North" +
            "\n- Type \"W\": West" +
            "\n- Type \"E\": East");
        }
        String choiceDirection = goToDifferentScene();
        if (choiceDirection.equals("E")){
          if (!isFogClear){
              System.out.println("You cannot go to the direction");
              inFrontOfPondChoice();
          }
          else{
              getSceneToTheEast().enter();
          }
        }
        else if (choiceDirection.equals("W")){
            getSceneToTheWest().enter();
        }
        else if (choiceDirection.equals("N")){
            getSceneToTheNorth().enter();
        }
      }
      else{
        inFrontOfPondChoice();
      }
    }

    private void inFrontOfPondChoice_UseItems(){

      System.out.println("\nYou decided to use items");
      System.out.println("Would you like to list what you have?"+
        "\n- Type \"Y\" : Yes" +
        "\n- Type \"N\" : No");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("Y")){

        // Create choices
        StringBuilder buildChoices = new StringBuilder();

        if ((localItems.contains("FOG_GLASSES"))||(localItems.contains("RING_BOX_KEY"))|| true /* or boat*/) {
          System.out.println("\nThis is a list of what you have:");
          //TODO access to global item collection and if the player has a boat, display the boat
          System.out.println("    - a boat");
          buildChoices.append("\n- Type \"B\": \"Boat\"");

          if (localItems.contains("FOG_GLASSES")) {
            System.out.println("    - a pair of glasses");
            buildChoices.append("\n- Type \"G\": \"Glasses\"");
          }
          if (localItems.contains("RING_BOX_KEY")) {
            System.out.println("    - a key");
            buildChoices.append("\n- Type \"K\": \"Key\"");
          }
          buildChoices.append("\nor Type \"X\": to go back");
          buildChoices.toString();
          do {
            System.out.println("\nWould you like to use any of the items?" + buildChoices);
            choice = playerChoice().toUpperCase();
            if ((choice.equals("K")) && localItems.contains("RING_BOX_KEY")) {
              System.out.println("\nYou chose the key, but you are not sure how to use it");
            } else if ((choice.equals("G")) && localItems.contains("FOG_GLASSES")) {
              System.out.println("\nYou chose the glasses.");
              System.out.println("\nWhat would you like to do?" +
                "\n- Type \"0\" : wear the glasses and look up" +
                "\n- Type \"1\" : wear the glasses and look down" +
                "\n- Type \"2\" : wear the glasses and look straight");
              choice = playerChoice().toUpperCase();
              if (choice.equals("0")) {
                System.out.println("\nYou do not see anything special through the glasses. You see stars in the sky");
              } else if (choice.equals("1")) {
                System.out.println("\nYou do not see anything special through the glasses. You see rocks on the ground");
              } else if (choice.equals("2")) {
                System.out.println("\nYou slowly put the glasses on and looked straight.");
                System.out.println("Before putting them on, you could not see anything above the pond because of the fog");
                System.out.println("However, now you can clearly see through the fog. ");
                System.out.println("You see an island in the middle of the pond");
                System.out.println("You decided to keep them on");
                wearingFogGlasses = true;
              }
            } else if (choice.equals("B") /*Boat*/) {
              System.out.println("\nWould you like to start rowing?" +
                "\n- Type \"Y\" : Yes" +
                "\n- Type \"N\" : No");
              choice = playerChoice().toUpperCase();
              if (choice.equals("Y")) {
                if (!wearingFogGlasses) {
                  System.out.println("\nYou started rowing, but you could not see anything because of the fog.");
                  System.out.println("You decided to go back");
                } else {
                  System.out.println("\nBecause of the special glasses, even the fog is dense, " +
                    "\nyou can see through the fog and navigate the boat");
                  System.out.println("You decided to visit the small island in the middle of the pond");
                  inFontOfIsland();
                  break;
                }
              }
            }
            else{
              inFrontOfPondChoice();
              break;
            }
          }while(true);

        }
        else{
          System.out.println("\nYou do not have anything you can use in this scene");
          inFrontOfPondChoice();
        }
      }
      else{
        System.out.println("\nIt is too dark to see what you have.");
        inFrontOfPondChoice();
      }
    }

    public void inFrontOfPondChoice_WalkAround(){
      // Try to find a special glass which you can see though the the fog
      System.out.println("\nYou decided to walk around");
      System.out.println("Which direction would you like to go to?" +
        "\n- Type \"L\" : Left" +
        "\n- Type \"R\" : Right");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("L")){
        System.out.println("\nYou found a backpack");
        System.out.println("Would you like to investigate?" +
          "\n- Type \"Y\" : Yes" +
          "\n- Type \"N\" : No");
        choice = playerChoice().toUpperCase();
        if (choice.equals("Y")){
          if (countCheckBackPack == 0) {
            countCheckBackPack += 1;
            System.out.println("\nYou open the backpack. You could not find anything inside");
          }
          else if (countCheckBackPack > 0){
            if (!localItems.contains("FOG_GLASSES")){
              System.out.println("\nYou shook the backpack. You heard something inside move");
              System.out.println("You opened the backpack and found a tightly wrapped object");
              System.out.println("What would you like to do?" +
                "\n- Type \"0\" : unwrap the object" +
                "\n- Type \"1\" : put it back");
              choice = playerChoice().toUpperCase();
              if (choice.equals("0")){
                System.out.println("\nYou slowly and carefully unwrapped the object");
                System.out.println("You found a pair of glasses.");
                System.out.println("You decided to keep it");
                localItems.add("FOG_GLASSES");
                System.out.println("You just added the glasses to your collection");
              }
              else{
                System.out.println("\nYou put it back in the backpack");
              }
            }
            else{
              System.out.println("\nYou shook the backpack.");
              System.out.println("You opened the backpack.");
              System.out.println("You could not find anything inside.");
            }
          }
        }
        else{
          System.out.println("\nYou put it back where you found it");
        }
        System.out.println("You went back to where you were");
        inFrontOfPondChoice();
      }
      else if (choice.equals("R")){
        inFrontOfPondChoice_WalkAround_Right();
      }
      else{
        inFrontOfPondChoice_WalkAround();
      }
    }

    private void inFrontOfPondChoice_WalkAround_Right(){
      System.out.println("\nWould you like to look up or down?" +
        "\n- Type \"0\" : Look up" +
        "\n- Type \"1\" : Look down");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("0")){
        System.out.println("\nYou see so many stars, but you are surrounded by darkness.");
        System.out.println("It is as if you were at the bottom of a deep cave and you see sunshine, " +
          "\nbut it is so far away that you cannot reach. Even you shout, nobody at the entrance will " +
          "\nrealize somebody is seeking for help from the bottom of the cave");
        inFrontOfPondChoice_WalkAround_Right();
      }
      else{
        if (!localItems.contains("RING_BOX_KEY")){
          System.out.println("\nYou just realized you kicked something soft and light.");
          System.out.println("You found a small ring box at your feet.");
          System.out.println("\nWould you like to investigate?" +
            "\n- Type \"Y\" : Yes" +
            "\n- Type \"N\" : No");
          choice = playerChoice().toUpperCase();
          if (choice.equals("Y")) {
            System.out.println("\nYou picked it up and opened the box");
            System.out.println("You found a key instead of a ring");
            System.out.println("\nWould you like to keep it?" +
              "\n- Type \"Y\" : Yes" +
              "\n- Type \"N\" : No");
            choice = playerChoice().toUpperCase();
            if(choice.equals("Y")) {
              System.out.println("\nYou now added the key to your collection");
              localItems.add("RING_BOX_KEY");
              inFrontOfPondChoice_WalkAround_Right();
            }
            else{
              System.out.println("\nYou just decided to leave it as it is");
              inFrontOfPondChoice_WalkAround_Right();
            }
          }
          else{
            System.out.println("\nYou just decided to leave it as it is");
            inFrontOfPondChoice_WalkAround_Right();
          }
        }
        else if (!memoOnStones){
          memoOnStones = true;
          System.out.println("\nYou found a sheet of paper between stones");
          System.out.println("You picked it up and realized that there is some writing on the paper");
          System.out.println("\n\"Island..... Tree.... Fog...\"");
          System.out.println("\nAs soon as you read it, it burst into flames.");
          System.out.println("You were not sure what it had just happened.");
          System.out.println("You decided to go back\n");
          inFrontOfPondChoice();
        }
        else{
          System.out.println();
          System.out.println("\nYou just see rocks. You decided to go back");
          inFrontOfPondChoice();
        }
      }
    }

    /************** Island **************/
    private void inFontOfIsland() {
      System.out.println("\nYou rowed the boat for a while. Thanks to the special glasses, " +
        "\nyou know the direction and the distance to the island. The fog is so thick that without the glasses, " +
        "\nyou cannot even see your feet");
      System.out.println("You reached the island");
      inFrontOfIsland_Question();
    }
    private void inFrontOfIsland_Question(){
      System.out.println("\nWhat would you like to do?" +
        "\n- Type \"0\" : stay in the boat." +
        "\n- Type \"1\" : go ashore");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("0")){
        System.out.println("\nYou decided to stay in the boat. What's next?");
        System.out.println("Time is ticking. You are not sure where you should go next.");
        inFrontOfIsland_Question();
      }
      else{
        System.out.println("\nYou decided to go ashore.");
        System.out.println("You see a cross and a tree.");
        onIsland();
      }
    }
    private void onIsland(){
      System.out.println("\nWhich one would you like to visit?" +
        "\n- Type \"0\" : Cross." +
        "\n- Type \"1\" : Tree");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("0")){
        System.out.println("\nYou walked around the cross");
        System.out.println("It must have been built a long time ago. Creepers grow along the cross");
        crossVisited = true;
        onIsland();
      }
      else{
        if (!crossVisited) {
          System.out.println("\nYou walked around the tree. You have no clues about where you should go or what you should do");
          onIsland();
        }
        else{
          onIsland_lookUpDown();
        }
      }
    }
    private void onIsland_lookUpDown(){
      System.out.println("\nWould you like to look up or down?"+
        "\n- Type \"0\" : look up." +
        "\n- Type \"1\" : look down");
      String choice = playerChoice().toUpperCase();
      if (choice.equals("0")){
        if (!islandTreeLookDown) {
          System.out.println("\nYou looked up. You see branches and leaves.");
          onIsland_lookUpDown();
        }
        else{
          System.out.println("\nYou looked up. You see small lights everywhere on the branches. You do not know what they are.");
          System.out.println("Looks like they are moving down slowly and silently towards you.");
          System.out.println("You stepped backward. The lights seem to be crawling along the trunk.");
          System.out.println("You started running, and the millions of lights also started chasing after you.");
          System.out.println("You got to the boat");
          System.out.println("\nYou decided to visit the field across the pond");
          //DONE write a code for change scene
          getSceneToTheEast().enter();
        }
      }
      else{
        if (!isFogClear) {
          isFogClear = true;
          System.out.println("\nYou looked down. You found a keyhole on the trunk.");
          System.out.println("You remember you found a key in a ring box. You took it out, inserted it and rotated.");
          System.out.println("Suddenly, the dense fog over the pond started clearing out.");
          System.out.println("You see the field on the other side.");
          islandTreeLookDown = true;
          onIsland_lookUpDown();
        }
        else{
          System.out.println("\nYou see the keyhole with your key.");
          onIsland_lookUpDown();
        }
      }
    }

    private String goToDifferentScene(){

      boolean askAgain = true;
      String result = null;
      do {
        String choice = playerChoice().toUpperCase();
        switch (choice) {
          case "N":
            result = scenesAround.get("NORTH");
            askAgain = false;
            break;
          case "W":
            result = scenesAround.get("WEST");
            askAgain = false;
            break;
          case "E":
            result = scenesAround.get("EAST");
            askAgain = false;
            break;
          default:
            System.out.println(choice + " is invalid. Try again.");
        }
      }while(askAgain);
      return result;
    }

    private String playerChoice(){
      String result = null;

      Scanner choice = new Scanner(System.in);
      result = choice.nextLine();

      return result;
    }

    
    /*** Testing purpose ***/
    // Controlling "isFogClear"
    public void setIsFogClear(boolean isFogClear){
      this.isFogClear = isFogClear;
    }
    // Getting the status of "isFogClear"
    public boolean getIsFogClear() {
      return isFogClear;
    }
}
