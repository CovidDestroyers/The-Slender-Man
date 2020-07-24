package com.slenderman.inventory;

public class ItemCreator {

  private ItemCreator() {};

  public static Item createItem(String itemName) {
      return new Item(itemName);
  };
}
