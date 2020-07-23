package com.slenderman.scenes;

import com.slenderman.actors.Player;

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
    final String PATH = "com.slenderman.scenes.files.";
    ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
    ResourceBundle bundle = ResourceBundle.getBundle(PATH + "storyCave", Locale.US, rbc);
    /////////////////////////

    // Unit testing purpose //
    private boolean _max_iteration_not_reached;
    //////////////////////////

    public final int MAX_ITERATION_DISPLAY_STORIES = 10;
    private boolean isPlayerWithTorch = false;
    private boolean isPlayerWithLighter = false;
    private boolean isPlayerWithBoat = false;

    private List<String> localItems = new ArrayList<>();
    private Scanner choice; // Added this variable to store

    //default constructor
    public Cave(){
      setSceneName("cave");
    }

    public Cave(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest){
      super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
      setSceneName("cave");
    }

    @Override
    public void enter(Scanner in, Player player) throws InterruptedException {
        player.setCurrentSceneName(this.getSceneName());
        choice = in;
        inFrontOfCave();
    }

    private void inFrontOfCave() throws InterruptedException {
        displayStories("inFront");
        String choice = playerChoice();
        if (choice.equals("0")) {
          stepIntoTheCave();
        }
        else{
          walkAroundInFrontOfCave();
        }
    }

    private void stepIntoTheCave() throws InterruptedException {
        if (isPlayerWithBoat) {
          System.out.println(textPainter(bundle.getString("stepIntoTheCave_withBoat")));
          exploreCaveChoice();
        }
        else{
          displayStories("stepIntoTheCave");

          if (checkItems()) {
            quizChoosingRightItems();
          }
          else{
            System.out.println(textPainter(bundle.getString("stepIntoTheCave_notEnoughItem")));
            inFrontOfCave();
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

    private void quizChoosingRightItems() throws InterruptedException {
        System.out.println(textPainter(bundle.getString("quizChoosingRightItems_intro")));
        String input = playerChoice().toUpperCase();
        String[] objectInput = input.split(" ");

        if ((objectInput[0].equals("TORCH") && objectInput[1].equals("LIGHTER"))
          || (objectInput[1].equals("TORCH") && objectInput[0].equals("LIGHTER"))) {
          exploreCave();
        }
        else{
          System.out.println(textPainter(bundle.getString("quizChoosingRightItems_incorrect")));
          inFrontOfCave();
        }
    }

    private void walkAroundInFrontOfCave() throws InterruptedException {
        displayStories("walkAroundInFrontOfCave");
        String choice = playerChoice();
        switch (choice) {
          case "0": investigateTheBushes(); break;
          case "1": inFrontOfCave(); break;
          case "2": displayStories("walkAroundInFrontOfCave_option2"); break;
          default: walkAroundInFrontOfCave();
        }
    }

    private void investigateTheBushes() throws InterruptedException {
        if (localItems.contains("NOTEBOOK")){
          System.out.println(textPainter(bundle.getString("investigateTheBushes_withNoteBook")));
        }
        else {
          displayStories("investigateTheBushes");
          String choice = playerChoice();
          if (choice.equalsIgnoreCase("y")) {
            System.out.println(textPainter(bundle.getString("investigateTheBushes_y")));
            localItems.add("NOTEBOOK");
          }
          else {
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
        if (choice.equals("R")){
          exploreCave_LookRight();
        }
        else if(choice.equals("L")){
          exploreCave_LookLeft();
        }
        else{
          inFrontOfCave();
        }
    }

    /**
     * Change Scene to Pond
     * */
    private void exploreCave_LookLeft() throws InterruptedException {
        displayStories("exploreCave_LookLeft_intro");
        if (isPlayerWithBoat){
          displayStories("exploreCave_LookLeft_withBoat");
          String choice = playerChoice().toUpperCase();
          if (choice.equals("Y")) {
            displayStories("exploreCave_LookLeft_withBoat_y");

          }
          else {
            sendToExploreCaveChoice();
          }
        }
        else{
          sendToExploreCaveChoice();
        }
    }

    private void sendToExploreCaveChoice() throws InterruptedException {
        System.out.println(textPainter(bundle.getString("sendToExploreCaveChoice")));
        exploreCaveChoice();
    }

    private void exploreCave_LookRight() throws InterruptedException {
        if (isPlayerWithBoat){
          System.out.println(textPainter(bundle.getString("exploreCave_LookRight_withBoat")));
          exploreCaveChoice();
        }
        else {
          displayStories("exploreCave_LookRight");
          String choice = playerChoice().toUpperCase();
          if (choice.equals("Y")) {
            exploreCave_UnlockCode();
          }
          else {
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
        if (result.equals("624")){
          localItems.add("UNLOCK_BOAT_DOOR");
          exploreCave_TryCombination_Successful();
        }
        else{
          System.out.println(textPainter(bundle.getString("exploreCave_TryCombination_incorrect")));

          if (localItems.contains("NOTEBOOK")) {
            exploreCave_UnlockCodeByBook();
          }
          else{
            displayStories("exploreCave_TryCombination_goBack");
            String choice = playerChoice().toUpperCase();
            if (choice.equals("Y")){
              inFrontOfCave();
            }
            else{
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
        switch (pageChoice){
          case "12": System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption1")));break;
          case "23": System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption2")));break;
          case "35": System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOption3")));break;
          default: System.out.println(textPainter(bundle.getString("exploreCave_UnlockCodeByBookFlip_pageOptionX")));
        }
    }

    private void exploreCave_TryCombination_Successful() throws InterruptedException {
        displayStories("exploreCave_TryCombination_Successful");
        String choice = playerChoice().toUpperCase();
        if (choice.equals("Y")){
          //DONE Program needs to be added
          System.out.println(textPainter(bundle.getString("exploreCave_TryCombination_Successful_registerBoat")));
          isPlayerWithBoat = true;
        }
        exploreCaveChoice();
    }

    private String playerChoice(){
      return choice.nextLine();
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
