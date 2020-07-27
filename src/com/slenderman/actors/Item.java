package com.slenderman.actors;

import com.slenderman.scenes.Scene;

public class Item {
  private String itemName;
  private Scene currentScene;
  private String purpose;


  private Boolean isAnotherItemNeeded = false;
  private String nameOfOtherItem = "none";
  private String whatDoesOtherItemDo = "n/a";
  private String itemRevealed = "none";

  private String asciiArt = "none";


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  private Item() {

  }

  private Item(String itemName) {
    setItemName(itemName);
  }

  public Item(String itemName, Scene currentScene) {
    this(itemName);
    setCurrentScene(currentScene);

  }

  public Item(String itemName, Scene currentScene,
    Boolean isAnotherItemNeeded, String nameOfOtherItem) {
    this(itemName, currentScene);
    setAnotherItemNeeded(isAnotherItemNeeded);
    setNameOfOtherItem(nameOfOtherItem);

  }

  public Item(String itemName, Scene currentScene, boolean isAnotherItemNeeded, String nameOfOtherItem) {
  }




  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void printAsciiArt() {
    System.out.printf("%s", getAsciiArt());
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public void setAnotherItemNeeded(Boolean anotherItemNeeded) {
    isAnotherItemNeeded = anotherItemNeeded;
  }

  public void setNameOfOtherItem(String nameOfOtherItem) {
    this.nameOfOtherItem = nameOfOtherItem;
  }

  public void setWhatDoesOtherItemDo(String whatDoesOtherItemDo) {
    this.whatDoesOtherItemDo = whatDoesOtherItemDo;
  }

  public void setItemRevealed(String itemRevealed) {
    this.itemRevealed = itemRevealed;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setAsciiArt(String asciiArt) {
    this.asciiArt = asciiArt;
  }

  public void setCurrentScene(Scene currentScene) {
    this.currentScene = currentScene;
  }

  // GET METHODS

  public String getItemName() {
    return itemName;
  }

  public String getItemRevealed() {
    return itemRevealed;
  }

  public String getWhatDoesOtherItemDo() {
    return whatDoesOtherItemDo;
  }

  public String getNameOfOtherItem() {
    return nameOfOtherItem;
  }

  public String getPurpose() {
    return purpose;
  }

  public String getAsciiArt() {
    return asciiArt;
  }

  public Scene getCurrentScene() {
    return currentScene;
  }

  public Boolean getAnotherItemNeeded() {
    return isAnotherItemNeeded;
  }


  @Override public String toString() {
    return "Item{" +
           "itemName='" + itemName + '\'' +
           ", currentScene='" + currentScene + '\'' +
           ", purpose='" + purpose + '\'' +
           ", isAnotherItemNeeded=" + isAnotherItemNeeded +
           ", nameOfOtherItem='" + nameOfOtherItem + '\'' +
           ", whatDoesOtherItemDo='" + whatDoesOtherItemDo + '\'' +
           ", itemRevealed='" + itemRevealed + '\'' +
           ", asciiArt='" + asciiArt + '\'' +
           ", anotherItemNeeded=" + getAnotherItemNeeded() +
           '}';
  }
}
