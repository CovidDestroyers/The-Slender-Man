package com.slenderman.actors;

import com.slenderman.scenes.Scene;

public class Item {
  private String itemName;
  private String purpose;
  private Boolean otherItemNeeded = false;
  private String otherItem = "none";
  private String whatDoesOtherItemDo = "n/a";
  private String itemRevealed = "none";

  private String asciiArt = "none";
  private Boolean inPlayerInventory = false;
  private Scene itemScene;



  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */

  public Item(String itemName) {
    this.itemName = itemName;
    //setItemName(itemName);
  }

  public Item(String itemName, Scene itemScene) {
    this(itemName);
  }

  public Item(String itemName, Scene inputScene, String purpose) {
    setItemName(itemName);
    setPurpose(purpose);
    setItemScene(inputScene);
  }


  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  public void printAsciiArt() {
    String asciiArt = getAsciiArt();
    System.out.printf("%s", asciiArt);
  }

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS

  public void setInPlayerInventory(Boolean inPlayerInventory) {
    this.inPlayerInventory = inPlayerInventory;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public void setOtherItemNeeded(Boolean otherItemNeeded) {
    this.otherItemNeeded = otherItemNeeded;
  }

  public void setOtherItem(String otherItem) {
    this.otherItem = otherItem;
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

  public void setItemScene(Scene scene) {
    this.itemScene = scene;
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

  public String getOtherItem() {
    return otherItem;
  }

  public String getPurpose() {
    return purpose;
  }

  public Boolean getOtherItemNeeded() {
    return otherItemNeeded;
  }

  public Boolean isInPlayerInventory() {
    return inPlayerInventory;
  }

  public String getAsciiArt() {
    return asciiArt;
  }

  public Scene getItemScene() {
    return itemScene;
  }


  @Override
  public String toString() {
    return "Item{" + "itemName='" + itemName + '\'' + ", homeScene='" +
           itemScene + '\'' + ", purpose='" + purpose + '\'' +
           ", otherItemNeeded=" + otherItemNeeded + ", otherItem='" +
           otherItem + '\'' + ", whatDoesOtherItemDo='" + whatDoesOtherItemDo +
           '\'' + ", itemRevealed='" + itemRevealed + '\'' + ", asciiArt='" +
           asciiArt + '\'' + ", inPlayerInventory=" + inPlayerInventory + '}';
  }
}
