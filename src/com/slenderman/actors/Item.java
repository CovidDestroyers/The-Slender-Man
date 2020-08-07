package com.slenderman.actors;

import java.util.Objects;

public class Item {
  private String itemName;
  private String currentScene;
  private String purpose = "none";
  private String nameOfOtherItem = "none";
  private Boolean isAnotherItemNeeded = false;

  private Item() {}

  public Item(String itemName) {
    setItemName(itemName);
  }

  public Item(String itemName, String currentScene) {
    this(itemName);
    setCurrentScene(currentScene);
  }

  public Item(
    String itemName, String currentScene, Boolean isAnotherItemNeeded, String nameOfOtherItem) {
    this(itemName, currentScene);
    setAnotherItemNeeded(isAnotherItemNeeded);
    setNameOfOtherItem(nameOfOtherItem);
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public void setAnotherItemNeeded(Boolean anotherItemNeeded) {
    isAnotherItemNeeded = anotherItemNeeded;
  }

  public void setNameOfOtherItem(String nameOfOtherItem) {
    this.nameOfOtherItem = nameOfOtherItem;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setCurrentScene(String currentScene) {
    this.currentScene = currentScene;
  }

  public String getItemName() {
    return itemName;
  }

  public String getPurpose() {
    return purpose;
  }

  public String getCurrentScene() {
    return currentScene;
  }

  public Boolean getAnotherItemNeeded() {
    return isAnotherItemNeeded;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Item)) return false;
    Item item = (Item) o;
    return getItemName().equals(item.getItemName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getItemName());
  }

  @Override
  public String toString() {
    return "Item{" +
      "itemName='" + itemName + '\'' +
      ", currentScene='" + currentScene + '\'' +
      ", purpose='" + purpose + '\'' +
      ", isAnotherItemNeeded=" + isAnotherItemNeeded +
      ", nameOfOtherItem='" + nameOfOtherItem + '\'' +
      ", anotherItemNeeded=" + getAnotherItemNeeded() +
      '}';
  }
}
