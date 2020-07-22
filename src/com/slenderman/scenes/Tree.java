package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.Scanner;

public class Tree extends Scene {
  public Tree(){
    setDescription("You have reached a Tree.");
    setSceneName("tree");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    player.setCurrentSceneName(this.getSceneName());
  }

}
