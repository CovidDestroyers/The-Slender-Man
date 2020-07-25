package com.slenderman.actors;

import java.util.ArrayList;
import java.util.List;

public class ItemDirector {

  private static ItemBuilder itemBuilder = new ItemBuilder();

  private static List<Item> allItems = itemBuilder.buildAllItems();

  private ItemDirector() {

  }

  public static ArrayList<Item> getItemsForScene(String sceneName) {
    ArrayList<Item> itemsInScene = new ArrayList<>();

    for (Item item : allItems) {
      String itemSceneName = item.getCurrentScene();

      if (itemSceneName.equals(sceneName)) {
        itemsInScene.add(item);
      }
    }

    return itemsInScene;
  };
}
