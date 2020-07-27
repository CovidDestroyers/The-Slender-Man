package com.slenderman.scenes;

import com.slenderman.actors.Player;
import com.slenderman.game.Game;

import java.text.MessageFormat;
import java.util.*;

/**
 * Things needs for this class : Lighter and torch
 * Thing the player needs to get in this class : boat
 *
 * East : POND
 * West : SHED
 * North : HUT_CAR
 *
 **/

public class Cave extends Scene {

    // For Resource Bundle //
    final String FILE_BASE_NAME = "storyCaveNoColor";
    final String PATH = "com.slenderman.scenes.files.";

    ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);
    /////////////////////////

    // Unit testing purpose //
    private boolean _max_iteration_not_reached;
    //////////////////////////

    public final int MAX_ITERATION_DISPLAY_STORIES = 10;
    private boolean isPlayerWithTorch = false;
    private boolean isPlayerWithLighter = false;
    private boolean isPlayerWithBoat = false;

    // TODO: Change this to use sceneItems
    private List<String> localItems = new ArrayList<>();

    //default constructor
    public Cave(Player p){
      setSceneName("cave");
    }

    public Cave(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest){
      super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
      setSceneName("cave");
    }

    public void enter() throws InterruptedException {
        Scanner in = Game.getScanner();
        String choice = Game.playerChoice(in);

        displayStories("inFront");

        if (choice.equals("0")) {
          stepIntoTheCave(in);
        }
        else{
          walkAroundInFrontOfCave(in);
        }
    }

    private void stepIntoTheCave(Scanner in) throws InterruptedException {
        if (isPlayerWithBoat) {
          System.out.println(textPainter(bundle.getString("stepIntoTheCave_withBoat")));
          exploreCaveChoice(in);
        }
        else{
          displayStories("stepIntoTheCave");

          if (checkItems()) {
            quizChoosingRightItems(in);
          }
          else{
            System.out.println(textPainter(bundle.getString("stepIntoTheCave_notEnoughItem")));
            enter();
          }
        }
    }

    //TODO access to the global item collection
    private boolean checkItems(){
        if (true) {
          isPlayerWithTorch = true;
        }
        if (true){
          isPlayerWithLighter = true;
        }
        return isPlayerWithTorch && isPlayerWithLighter;
    }

    private void quizChoosingRightItems(Scanner in) throws InterruptedException {
        System.out.println(textPainter(bundle.getString("quizChoosingRightItems_intro")));
        String input = Game.playerChoice(in).toUpperCase();
        String[] objectInput = input.split(" ");

        if ((objectInput[0].equals("TORCH") && objectInput[1].equals("LIGHTER")) || (objectInput[1].equals("TORCH") && objectInput[0].equals("LIGHTER"))) {
          exploreCave(in);
        }
        else {
          System.out.println(textPainter(bundle.getString("quizChoosingRightItems_incorrect")));
          enter();
        }
    }

    private void walkAroundInFrontOfCave(Scanner in) throws InterruptedException {
        displayStories("walkAroundInFrontOfCave");
      String choice = Game.playerChoice(in);
        switch (choice) {
          case "0": investigateTheBushes(in); break;
          case "1": enter(); break;
          case "2": displayStories("walkAroundInFrontOfCave_option2"); break;
          default: walkAroundInFrontOfCave(in);
        }
    }

    private void investigateTheBushes(Scanner in) throws InterruptedException {
        if (localItems.contains("NOTEBOOK")){
          System.out.println(textPainter(bundle.getString("investigateTheBushes_withNoteBook")));
        }
        else {
          displayStories("investigateTheBushes");
          String choice = Game.playerChoice(in);
          if (choice.equalsIgnoreCase("y")) {
            System.out.println(textPainter(bundle.getString("investigateTheBushes_y")));
            localItems.add("NOTEBOOK");
          }
          else {
            System.out.println(textPainter(bundle.getString("investigateTheBushes_n")));
          }
        }
        System.out.println(textPainter(bundle.getString("investigateTheBushes_goBack")));
        enter();
    }
    private void exploreCave(Scanner in) throws InterruptedException {
        displayStories("exploreCave");
        exploreCaveChoice(in);
    }

    private void exploreCaveChoice(Scanner in) throws InterruptedException {
        displayStories("exploreCaveChoice");
        String choice = Game.playerChoice(in).toUpperCase();
        if (choice.equals("R")){
          exploreCave_LookRight(in);
        }
        else if(choice.equals("L")){
          exploreCave_LookLeft(in);
        }
        else{
          enter();
        }
    }

    /**
     * Change Scene to Pond
     * */
    private void exploreCave_LookLeft(Scanner in) throws InterruptedException {
        displayStories("exploreCave_LookLeft_intro");
        if (isPlayerWithBoat){
          displayStories("exploreCave_LookLeft_withBoat");
          String choice = Game.playerChoice(in).toUpperCase();
          if (choice.equals("Y")) {
            displayStories("exploreCave_LookLeft_withBoat_y");

          }
          else {
            sendToExploreCaveChoice(in);
          }
        }
        else{
          sendToExploreCaveChoice(in);
        }
    }

    private void sendToExploreCaveChoice(Scanner in) throws InterruptedException {
        System.out.println(textPainter(bundle.getString("sendToExploreCaveChoice")));
        exploreCaveChoice(in);
    }

    private void exploreCave_LookRight(Scanner in) throws InterruptedException {
        if (isPlayerWithBoat){
          System.out.println(textPainter(bundle.getString("exploreCave_LookRight_withBoat")));
          exploreCaveChoice(in);
        }
        else {
          displayStories("exploreCave_LookRight");
          String choice = Game.playerChoice(in).toUpperCase();
          if (choice.equals("Y")) {
            exploreCave_UnlockCode(in);
          }
          else {
            exploreCaveChoice(in);
          }
        }
    }
    private void exploreCave_UnlockCode(Scanner in) throws InterruptedException {
        displayStories("exploreCave_UnlockCode");
        if (localItems.contains("NOTEBOOK")) {
          displayStories("exploreCave_UnlockCode_withNoteBook");
        }
        exploreCave_TryCombination(in);
    }

    private void exploreCave_TryCombination(Scanner in) throws InterruptedException {
        displayStories("exploreCave_TryCombination");
        String result = Game.playerChoice(in);
        if (result.equals("624")){
          localItems.add("UNLOCK_BOAT_DOOR");
          exploreCave_TryCombination_Successful(in);
        }
        else{
          System.out.println(textPainter(bundle.getString("exploreCave_TryCombination_incorrect")));

          if (localItems.contains("NOTEBOOK")) {
            exploreCave_UnlockCodeByBook(in);
          }
          else{
            displayStories("exploreCave_TryCombination_goBack");
            String choice = Game.playerChoice(in).toUpperCase();
            if (choice.equals("Y")){
              enter();
            }
            else{
              exploreCave_TryCombination(in);
            }
          }
        }
    }

    private void exploreCave_UnlockCodeByBook(Scanner in) throws InterruptedException {
        displayStories("exploreCave_UnlockCodeByBook");
        String choice = Game.playerChoice(in).toUpperCase();
        if (choice.equals("Y")) {
          exploreCave_UnlockCodeByBookFlip(in);
        }
        exploreCave_TryCombination(in);
    }

    private void exploreCave_UnlockCodeByBookFlip(Scanner in) throws InterruptedException {
        displayStories("exploreCave_UnlockCodeByBookFlip");
        String pageChoice = Game.playerChoice(in);
        switch (pageChoice){
          case "12": System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption1")));break;
          case "23": System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption2")));break;
          case "35": System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption3")));break;
          default: System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOptionX")));
        }
    }

    private void exploreCave_TryCombination_Successful(Scanner in) throws InterruptedException {
        String choice = Game.playerChoice(in).toUpperCase();
        displayStories("exploreCave_TryCombination_Successful");

        if (choice.equals("Y")){
          //DONE Program needs to be added
          System.out.println(textPainter(bundle.getString("exploreCave_TryCombination_Successful_registerBoat")));
          isPlayerWithBoat = true;
        }
        exploreCaveChoice(in);
    }

    /**
     * Coloring the fonts
     *
     * {0} : Scene.ANSI_GREEN
     * {1} : Scene.ANSI_BLUE
     * {2} : Scene.ANSI_RED
     * {3} : Scene.ANSI_BLACK
     * {4} : Scene.ANSI_WHITE
     * */
    private String textPainter(String text){
      return MessageFormat.format(text, Scene.ANSI_GREEN, Scene.ANSI_BLUE, Scene.ANSI_RED, Scene.ANSI_BLACK, Scene.ANSI_WHITE);
    }

    /**
     * For accessing and displaying stories in Resource Bundle file
     * */
    private void displayStories(String key){
      _max_iteration_not_reached = false;
      for (int i = 0; i <MAX_ITERATION_DISPLAY_STORIES; i++){
        try {
          System.out.println(textPainter(bundle.getString(key + "[" + Integer.toString(i) + "]")));
        }
        catch(MissingResourceException e){
          _max_iteration_not_reached = true;
          break;
        }
      }
    }

    public boolean is_max_iteration_not_reached(){
      return _max_iteration_not_reached;
    }

    public List<String> getLocalItems() {
      return localItems;
    }

    public boolean getIsPlayerWithBoat(){
      return isPlayerWithBoat;
    }

}
