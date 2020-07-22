package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.Scanner;

public class AbandonedCar extends Scene {

  //default constructor
  public AbandonedCar(){
    setDescription("You see an abandoned car");
    setSceneName("abandonedcar");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    player.setCurrentSceneName(this.getSceneName());
  }

  public AbandonedCar(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
    setDescription("You see an abandoned car");
  }

}
