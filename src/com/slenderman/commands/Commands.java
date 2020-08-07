package com.slenderman.commands;

import java.util.ArrayList;

public class Commands {
  private static ArrayList<String> goCommands = new ArrayList<>();
  private static ArrayList<String> quitCommands = new ArrayList<>();
  private static ArrayList<String> pauseCommands = new ArrayList<>();
  private static ArrayList<String> directionCommands = new ArrayList<>();

  public static ArrayList<String> getDirectionCommands() {
    directionCommands.add("north");
    directionCommands.add("south");
    directionCommands.add("east");
    directionCommands.add("west");

    return directionCommands;
  }

  public static ArrayList<String> getPauseCommands() {
    pauseCommands.add("pause");
    pauseCommands.add("stop");
    pauseCommands.add("wait");
    pauseCommands.add("hold");

    return pauseCommands;
  }

  public static ArrayList<String> getQuitCommands() {
    quitCommands.add("depart");
    quitCommands.add("quit");
    quitCommands.add("exit");
    quitCommands.add("end");
    quitCommands.add("retire");
    quitCommands.add("surrender");

    return quitCommands;
  }

  public static ArrayList<String> getGoCommands() {
    goCommands.add("go");
    goCommands.add("flee");
    goCommands.add("fly");
    goCommands.add("move");
    goCommands.add("leave");
    goCommands.add("pass");
    goCommands.add("progress");
    goCommands.add("retire");
    goCommands.add("travel");

    return goCommands;
  }
}
