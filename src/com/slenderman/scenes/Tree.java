package com.slenderman.scenes;

import com.slenderman.actors.Player;
import com.slenderman.game.Game;

import java.util.Scanner;

public class Tree extends Scene {

  Player player;
  Game topGame;

  public Tree(Player p){
    setDescription("You have reached a Tree.");
    setSceneName("tree");
    this.player =p;

    System.out.println(player.getInventory());
  }


  @Override
  public void enter() throws Exception {
    end();
  }



  public void end() throws Exception{
    Game.winMessage();

  }

}
