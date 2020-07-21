package com.slenderman.scenes;

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
  public void enter() {
    System.out.println("You are in a dark Forest. You see an Abandoned Car to the EAST and a Shed to the SOUTH.");
    System.out.println("You see a sign that reads 'go south' to go to the Shed, and 'go east' to go to the Abandoned Car.");

  }


}
