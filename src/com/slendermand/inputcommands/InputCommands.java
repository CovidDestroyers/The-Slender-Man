package com.slendermand.inputcommands;

import java.util.ArrayList;

public class InputCommands {

  private static final ArrayList<String> direction = new ArrayList<>();
  private static final ArrayList<String> movement = new ArrayList<>();




  public static ArrayList<String> getMovement(){
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

  public static ArrayList<String> getDirection(){
    direction.add("north");
    direction.add("east");
    direction.add("south");
    direction.add("west");

    return direction;
  }




}
