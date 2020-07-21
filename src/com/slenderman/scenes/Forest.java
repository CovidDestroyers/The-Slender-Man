package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.*;

public class Forest extends Scene{
  //default constructor
  public Forest(){
    //setDescription("You are in a dark forest, you see an Abandoned Car to the EAST and a Shed to the SOUTH");
  }

  public Forest(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    //setDescription("Welcome to the forest");

  }


  @Override
  public void enter(Scanner in, Player player) {
    System.out.println(Scene.ANSI_GREEN +
      "               ,@@@@@@@,\n" +
      "       ,,,.   ,@@@@@@/@@,  .oo8888o.\n" +
      "    ,&%%&%&&%,@@@@@/@@@@@@,8888\\88/8o\n" +
      "   ,%&\\%&&%&&%,@@@\\@@@/@@@88\\88888/88'\n" +
      "   %&&%&%&/%&&%@@\\@@/ /@@@88888\\88888'\n" +
      "   %&&%/ %&%%&&@@\\ V /@@' `88\\8 `/88'\n" +
      "   `&%\\ ` /%&'    |.|        \\ '|8'\n" +
      "       |o|        | |         | |\n" +
      "       |.|        | |         | |\n" +
      "jgs \\\\/ ._\\//_/__/  ,\\_//__\\\\/.  \\_//__/_\n" +
      "\n" +
      "------------------------------------------------\n");
    System.out.println(Scene.ANSI_WHITE + "You are in a dark Forest. You see an Abandoned Car to the EAST and a Shed to the SOUTH.");
    System.out.println(Scene.ANSI_WHITE + "You see a sign that reads: " + Scene.ANSI_GREEN + "'go south' " + Scene.ANSI_WHITE + "to go to the Shed, and " + Scene.ANSI_GREEN + "'go east' " + Scene.ANSI_WHITE + "to go to the Abandoned Car.");

  }


}
