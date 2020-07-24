package com.slenderman.actors;

import com.slenderman.actors.Item;

public class ItemCreator {

  private ItemCreator() {};

  public static Item createItem(String itemName,  String homeScene) {
      return new Item(itemName);
  };
}
