package com.slenderman.scenes;

import java.util.*;

/**
 * Things needs for this class : Lighter and torch
 * Thing a player needs to get in this class : boat
 *
 * When instantiate this class, create a Map registering scenes around
 * Map<direction, name of the scene>
 * e.g.
 **/



public class Cave extends Scene{

    private HashMap<String, String> scenesAround = new HashMap<>();



    private List<String> localItems = new ArrayList<>();

    public Cave(HashMap<String, String> ScenesAround){


        this.scenesAround = ScenesAround;

        scenesAround.put("WEST", "SHED");
        scenesAround.put("EAST", "TREE");
        scenesAround.put("NORTH", "HUT_CAR");
        //scenesAround = {"WEST", "SHED", "EAST", "POND", "NORTH", "HUT_CAR");
        inFrontOfCave();
    }
    public Cave(){}

    public void inFrontOfCave(){
        String choice;
        System.out.println("\nThere is a cave in front of you.");
        System.out.println("What would you like to do?");
        System.out.println(" Type \"0\" : \"Go into the cave\" " +
                "\n Type \"1\" : \"Walk around\"");

        choice = playerChoice();
        if (choice.equals("0")){
            stepIntoTheCave();
        }
        else if(choice.equals("1")) {
            walkAroundInFrontOfCave();
        }
    }

    private void stepIntoTheCave(){
        System.out.println("\nYou are stepping into the dark and chilly cave");
        System.out.println("\"RUN RUN RUN!\" Something is attacking you!");
        System.out.println("There are many bats suddenly coming out from the darkness");
        System.out.println("You just ran out from the cave");
        System.out.println("You look into the collection of items");
        //TODO
        // System accesses to the item and check if the player has "Lighter" and "Torch"
        // System found "Lighter" and "Torch" in the player's collection, do a little quiz
        // If the player pick "Lighter" and "Torch", the story can continue
        System.out.println("//// Temporary ///// You can go into the cave");
        exploreCave();
    }

    private void walkAroundInFrontOfCave(){
        System.out.println("\nYou are walking in front of the cave");
        System.out.println("You hear noises from the bushes");
        System.out.println("- Type \"0\" : \"investigate\""
                +"\n- Type \"1\" : \"go back to the front of the cave\""
                +"\n- Type \"2\" : \"go to different scene\"");
        String choice = playerChoice();
        if (choice.equals("0")){
            investigateTheBushes();
        }
        else if(choice.equals("1")){
            inFrontOfCave();
        }
        else if(choice.equals("2")){
            if (goToDifferentScene().equals(scenesAround.get("EAST"))){
                System.out.println("You cannot go");
                walkAroundInFrontOfCave();
            }
            else{
                //TODO Call a method to go to a next scene
            }
        }
    }
    private void investigateTheBushes(){
        if (localItems.contains("NOTEBOOK")){
            System.out.println("You did not find anything in the bushes");
        }
        else {
            System.out.println("\nYou found a notebook. This must be a notebook of somebody who was exploring around this area.");
            System.out.println("When you are flipping though the notebook, you caught something about the cave");
            System.out.println("\"Cave.... you must have \"a lighter\" and \"a torch\".");
            System.out.println("Ok... a lighter and a torch.");
            System.out.println("You are not sure why you need \"a lighter\" and \"a torch\".");
            System.out.println("\nWould you like to keep this notebook?");
            System.out.println("- Type \"Y\" : \"Yes\"");
            System.out.println("- Type \"N\" : \"No\"");
            String choice = playerChoice();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Now, you got a notebook");
                localItems.add("NOTEBOOK");
            } else {
                System.out.println("You put it down where you found");
            }
        }
        System.out.println("\nYou are going back to the front of the cave");
        inFrontOfCave();
    }

    private void exploreCave() {
        System.out.println("You have the torch in one hand and the lighter in the other hand.");
        System.out.println("Surprisingly, bats did not come and attack this time.");
        System.out.println("You caught the smell of something burning.");
        System.out.println("You found the left over of bonfire. You suspected that somebody was here not so long time ago.");
        System.out.println("\nYou are looking around the cave.");
        exploreCaveChoice();
    }
    private void exploreCaveChoice(){
        System.out.println("- Type \"R\": to look right");
        System.out.println("- Type \"L\": to look left");
        System.out.println("- Type \"X\": to go back to the entrance of the cave.");
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
    private void exploreCave_LookLeft(){
        System.out.println("When you look up, you see water dropping down from the ceiling");
        System.out.println("The ceiling is so high that you cannot see the ceiling itself");
        System.out.println("When you look down, you noticed there is a puddle");
        System.out.println("It looks like it is connected to the outside of the cave");
        System.out.println("//////// TEMPORARY ////////");
        // Check if the player has a boat, if he has, following option will be shown
        System.out.println("Would you like to explore the POND connected to this puddle");
        System.out.println("- Type \"Y\" : \"Yes\"");
        System.out.println("- Type \"N\" : \"No\"");
        String choice = playerChoice().toUpperCase();
        if (choice.equals("Y")){
            System.out.println("You take a boat out and explore the POND");
            //TODO change to scene POND
        }
        else{
            exploreCaveChoice();
        }
    }

    private void exploreCave_LookRight(){

        //TODO code needs to be added here

        // Story below is when the player do not have combination or boat -> only executed one time
        System.out.println("You see the colony of bats.");
        System.out.println("They are unbelievably quite and they do not move at all as if they are stones.");
        System.out.println("You noticed something. Even though the cave is so big, thousands of bats are hanging at one particular place.");
        System.out.println("You felt suspicious.");
        System.out.println("Would you like to investigate?");
        System.out.println("- Type \"Y\": \"Yes\"");
        System.out.println("- Type \"N\": \"No\"");
        String choice = playerChoice().toUpperCase();
        if (choice.equals("Y")){
            exploreCave_UnlockCode();
        }
        else{
            exploreCaveChoice();
        }
    }
    private void exploreCave_UnlockCode(){
        System.out.println("\nWhen you approached the colony of bats, the bats flied away with the high pitch screams you had never heard before.");
        System.out.println("You were so scared that you close your eyes.");
        System.out.println("When you opened your eyes, the bats were gone, but the Screams were lingering in the ears.");
        System.out.println("You see a small door on the wall of the cave where bats were");
        System.out.println("You tried to open the door, but there was a lock. You need to know the combination.");
        if (localItems.contains("NOTEBOOK")){
            System.out.println("\nYou opened the notebook you found outside of the cave.");
            System.out.println("When you were flipping the pages, you remember you saw some combinations of numbers");
            exploreCave_UnlockCodeByBook();
        }
        exploreCave_TryCombination();
    }

    private void exploreCave_TryCombination(){
        System.out.println("\nYou decided to try the combination.");
        System.out.println("Type the combination.");
        String result = playerChoice();
        if (result.equals("624")){
            exploreCave_TryCombination_Successful();
            localItems.add("UNLOCK_BOAT_DOOR");
        }
        else{
            System.out.println("\nThe combination you entered was not right. The lock was not unlocked.");
            if (localItems.contains("NOTEBOOK")) {
                exploreCave_UnlockCodeByBook();
                exploreCave_TryCombination();
            }
            else{
                System.out.println("Would you like to go back to the entrance of the cave and look for a clue?");
                System.out.println("- Type \"Y\": \"Yes\"");
                System.out.println("- Type \"N\": \"No\"");
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

    private void exploreCave_UnlockCodeByBook(){
        System.out.println("\nWould you like to flip the page?");
        System.out.println("- Type \"Y\": \"Yes\"");
        System.out.println("- Type \"N\": \"No\"");
        String choice = playerChoice().toUpperCase();
        if (choice.equals("Y")) {
            exploreCave_UnlockCodeByBookFlip();
        }
        else{
            exploreCave_TryCombination();
        }
    }
    private void exploreCave_UnlockCodeByBookFlip(){
        System.out.println("\nWhich page would you like to open\n");
        System.out.println("- Type \"12\": \"Page 12\"");
        System.out.println("- Type \"23\": \"Page 23\"");
        System.out.println("- Type \"35\": \"Page 35\"");
        String pageChoice = playerChoice();
        switch (pageChoice){
            case "12": System.out.println("You found a code \"143\""); break;
            case "23": System.out.println("You found a code \"354\""); break;
            case "35": System.out.println("You found a code \"624\""); break;
            default:
                System.out.println("Page you typed do not have combinations");
        }
    }

    private void exploreCave_TryCombination_Successful(){
        System.out.println("\nYou were able to unlock the door.");
        System.out.println("It looks like a storage.");
        System.out.println("You found a boat inside.");
        System.out.println("\nWould you like to add this to your collection?");
        System.out.println("- Type \"Y\": \"Yes\"");
        System.out.println("- Type \"N\": \"No\"");
        String choice = playerChoice().toUpperCase();
        if (choice.equals("Y")){
            //TODO Program needs to be added
            System.out.println("The boat was added to your collection");
        }
        exploreCaveChoice();
    }

    private String goToDifferentScene(){
        System.out.print("\nYou see ");
        System.out.print(scenesAround.get("NORTH") + " in North direction and ");
        System.out.print(scenesAround.get("WEST") + " in West direction and ");
        //System.out.println(scenesAround.get("EAST") + " in East direction.");
        System.out.println("Which direction would you like to go to?");
        System.out.println("- Type \"N\" : go to " + scenesAround.get("NORTH"));
        System.out.println("- Type \"W\" : go to " + scenesAround.get("WEST"));
        //System.out.println("- Type \"E\" : go to " + scenesAround.get("EAST"));

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
//                case "E":
//                    result = scenesAround.get("EAST");
//                    askAgain = false;
//                    break;
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

    public Map<String, String> getScenesAround() {
        return scenesAround;
    }

}
