package com.slendermand.inputcommands;

import java.util.ArrayList;

public class InputCommands {

  private static final ArrayList<String> direction = new ArrayList<>();
  private static final ArrayList<String> movement = new ArrayList<>();
  private static final ArrayList<String> quitGame = new ArrayList<>();




  public static ArrayList<String> getPlayerMovement(){
    movement.add("go");
    movement.add("run");
    movement.add("walk");
    movement.add("jog");
    movement.add("move");
    movement.add("travel");
    movement.add("proceed");
    movement.add("advance");

    return movement;
  }

  public static ArrayList<String> getPlayerDirection(){
    direction.add("north");
    direction.add("east");
    direction.add("south");
    direction.add("west");

    return direction;
  }

  public static ArrayList<String> getQuitGameCommands(){
    quitGame.add("quit");
    quitGame.add("retire");
    quitGame.add("exit");
    quitGame.add("goodbye");
    quitGame.add("bye");
    quitGame.add("leave");
    quitGame.add("vacate");
    quitGame.add("abandon");
    quitGame.add("desert");

    return quitGame;
  }




}
