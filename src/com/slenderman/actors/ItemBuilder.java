package com.slenderman.actors;

import com.slenderman.actors.Item;

import java.util.*;

public class ItemBuilder {

  private static final ArrayList<String> itemsAndScenes = new ArrayList<>(
    Arrays.asList("watch:forest","flashlight:forest", "lockbox:house",
                  "lighter:house", "toilet_paper:abandonedcar",
                  "torch:outhouse", "boat:cave", "blade:field", "key:shed"));

  // which items actually need another item?
  // lockbox -> key
  // torch -> lighter


  public ItemBuilder() {
    List<Item> realItems = buildAllItems();
    System.out.println(realItems);
  };

  public static ArrayList<Item> buildAllItems() {
    String itemName;
    String currentScene;
    boolean isAnotherItemNeeded = false;
    String nameOfOtherItem = "none";

    Item anItem;
    ArrayList<Item> allItems= new ArrayList<>();


    for (String itemAndScene : itemsAndScenes) {
      String[] itemAndSceneNames = itemAndScene.split(":");

      itemName = itemAndSceneNames[0];
      currentScene = itemAndSceneNames[1];

      if (itemName.equals("lockbox")) {
        isAnotherItemNeeded = true;
        nameOfOtherItem = "key";
      }

      if (itemName.equals("torch")) {
        isAnotherItemNeeded = true;
        nameOfOtherItem = "lighter";
      }

      anItem = new Item(itemName, currentScene, isAnotherItemNeeded,nameOfOtherItem);

      allItems.add(anItem);
    }

    return allItems;
  };

  // public void createItemData() {
  //   Map<String, String> itemData;
  //   String itemName;
  //   String currentScene;
  //   String isAnotherItemNeeded = "false";
  //   String nameOfOtherItem = "none";
  //
  //
  //   for (String itemAndScene : itemsAndScenes) {
  //     itemData = new HashMap<>();
  //
  //     String[] itemAndSceneNames = itemAndScene.split(":");
  //
  //     itemName = itemAndSceneNames[0];
  //     currentScene = itemAndSceneNames[1];
  //
  //     if (itemName.equals("lockbox")) {
  //       isAnotherItemNeeded = "true";
  //       nameOfOtherItem = "key";
  //     }
  //
  //     if (itemName.equals("torch")) {
  //       isAnotherItemNeeded = "true";
  //       nameOfOtherItem = "lighter";
  //     }
  //     itemData.put("currentScene", currentScene);
  //     itemData.put("isAnotherItemNeeded", isAnotherItemNeeded);
  //     itemData.put("nameOfOtherItem", nameOfOtherItem);
  //
  //     itemsData.put(itemName, itemData);
  //   }
  //   System.out.println(itemsData);
  // }

}
