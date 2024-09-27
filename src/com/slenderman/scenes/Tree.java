package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.Player;

import java.text.MessageFormat;
import java.util.*;

public class Tree extends Scene {

  // For Resource Bundle //
  final String FILE_BASE_NAME = "storyTreeNoColor";
  final String PATH = "com.slenderman.scenes.files.";

  ResourceBundle.Control rbc = ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);
  ResourceBundle bundle = ResourceBundle.getBundle(PATH + FILE_BASE_NAME, Locale.US, rbc);

  // Unit testing purpose //
  private boolean _max_iteration_not_reached;

  public final int MAX_ITERATION_DISPLAY_STORIES = 10;

  public Tree(){
    setDescription("You have reached a Tree.");
    setSceneName("tree");
  }

  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {
    //System.out.println("You have escaped Slenderman's forest.");

    if (player.getNumItemsPlayerHas() < player.TOTAL_NUM_ITEMS_TO_FINISH_GAME){
      System.out.println(bundle.getString("enter_0"));
      System.out.println(bundle.getString("enter_1") + " " + player.TOTAL_NUM_ITEMS_TO_FINISH_GAME);
      System.out.println(bundle.getString("enter_2") + " " + player.getNumItemsPlayerHas() + " "+ bundle.getString("enter_3"));
    }
  }
}
