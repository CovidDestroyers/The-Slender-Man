package com.slenderman.actors;

import java.util.ArrayList;
import java.util.List;

public class ItemDirector {

  private static final ItemBuilder itemBuilder = new ItemBuilder();

  private static final List<Item> allItems = itemBuilder.buildAllItems();

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  private ItemDirector() {}

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  public static ArrayList<Item> getItemsForScene(String sceneName) {
    String name = sceneName.trim().toLowerCase();
    ArrayList<Item> itemsInScene = new ArrayList<>();

    for (Item item : allItems) {
      String itemSceneName = item.getCurrentScene();

      if (name.equals(itemSceneName)) {
        itemsInScene.add(item);
      }
    }

    return itemsInScene;
  }


  public static Item findThisItem(String itemName, ArrayList<Item> itemsInThisScene) {
    Item foundItem = null;

    for (Item item : itemsInThisScene) {
      if (itemName.equals(item.getItemName())) {
          foundItem = item;
      }
    }

    return foundItem;
  }

}
