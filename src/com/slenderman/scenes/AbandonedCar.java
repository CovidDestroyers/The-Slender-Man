package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.Scanner;

public class AbandonedCar extends Scene {

  //default constructor
  public AbandonedCar(Player p){
    setDescription("You see an abandoned car");
    setSceneName("abandonedcar");
  }

  @Override
  public void enter() throws InterruptedException {

  }

  public AbandonedCar(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setDescription("You see an abandoned car");
  }

}
