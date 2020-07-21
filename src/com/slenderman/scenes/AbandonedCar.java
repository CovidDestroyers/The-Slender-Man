package com.slenderman.scenes;

public class AbandonedCar extends Scene {

  //default constructor
  public AbandonedCar(){
    setDescription("You see an abandoned car");
  }

  public AbandonedCar(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setDescription("You see an abandoned car");
  }

  @Override
  public void enter() {

  }
}
