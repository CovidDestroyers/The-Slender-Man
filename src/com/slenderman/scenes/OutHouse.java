package com.slenderman.scenes;

public class OutHouse extends Scene {

  //default constructor
  public OutHouse(){}

  public OutHouse(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

  @Override
  public void enter() {

  }

}
