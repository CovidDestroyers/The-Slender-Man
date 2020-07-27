package com.slenderman.scenes;

import com.slenderman.actors.Player;
import com.slenderman.game.Game;

import java.util.Scanner;

public class OutHouse extends Scene {

  //default constructor
  public OutHouse(Player p){
    setSceneName("outhouse");
  }

  @Override
  public void enter() throws InterruptedException {
    Scanner in = Game.getScanner();

  }

  public OutHouse(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

}
