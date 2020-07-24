package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.*;

public class Forest extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Forest(){
    setSceneName("forest");
  }

  public Forest(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

  }


  @Override
  public void enter(Scanner in, Player player) {

    System.out.println("               ,@@@@@@@,\n" +
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
    System.out.println("You are in a dark Forest. You see an Abandoned Car to the EAST and a Shed to the SOUTH.");
    System.out.println("You see a sign that reads: 'go south' to go to the Shed, and 'go east' to go to the House.");

  }

}
