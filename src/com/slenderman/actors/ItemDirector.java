package com.slenderman.actors;

import java.util.ArrayList;
import java.util.List;

public class ItemDirector {

  private static final ItemBuilder itemBuilder = new ItemBuilder();

  private static final List<Item> allItems = itemBuilder.buildAllItems();

  private ItemDirector() {}

  /**
   * @param sceneName the name of the Scene
   * @return ArrayList of Item objects that belong to that scene
   */
  public static ArrayList<Item> getItemsForScene(String sceneName) {
    ArrayList<Item> itemsInScene = new ArrayList<>();

    for (Item item : allItems) {
      String itemSceneName = item.getCurrentScene();

      if (itemSceneName.equals(sceneName)) {
        itemsInScene.add(item);
      }
    }

    return itemsInScene;
  }
}
