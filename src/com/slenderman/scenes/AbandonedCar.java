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
  public void enter(Scanner in, Player player) {
    player.setCurrentSceneName(this.getSceneName());
  }
}
