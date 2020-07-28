package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Tree extends Scene {
  public Tree(){
    setDescription("You have reached a Tree.");
    setSceneName("tree");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {

    if (player.getNumItemsPlayerHas() < player.TOTAL_NUM_ITEMS_TO_FINISH_GAME){
      System.out.println("Please type \"go west\". You do not have enough items to finish this game.");
      System.out.println("Number of items required to finish this game is " + player.TOTAL_NUM_ITEMS_TO_FINISH_GAME);
      System.out.println("You have currently " + player.getNumItemsPlayerHas() + " items.");
    }
  }
}
