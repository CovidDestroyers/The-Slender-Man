package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.Scanner;

public class OutHouse extends Scene {

  //default constructor
  public OutHouse(){
    setSceneName("outhouse");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    player.setCurrentSceneName(this.getSceneName());
  }

  public OutHouse(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

}
