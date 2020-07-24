package com.slenderman.inventory;

public class Item {
  private String itemName;
  private String homeScene;
  private String purpose;
  private Boolean otherItemNeeded = false;
  private String otherItem = "none";
  private String whatDoesOtherItemDo = "n/a";
  private String itemRevealed = "none";

  private String asciiArt = "none";
  private String currentScene;


  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Item() {

  }

  public Item(String itemName) {
    setItemName(itemName);
  }

  public Item(String itemName, String homeScene) {
    this(itemName);
    setHomeScene(homeScene);
  }

  public Item(String itemName, String homeScene, String purpose) {
    setItemName(itemName);
    setHomeScene(homeScene);
    setPurpose(purpose);
  }

  public Item(String itemName, String homeScene, String purpose, String currentScene) {
    this(itemName, homeScene, purpose);
    setCurrentScene(currentScene);
  }

  public Item(String itemName, String homeScene, String purpose,
    String currentScene, Boolean otherItemNeeded, String otherItem,
    String whatDoesOtherItemDo) {

    this(itemName, homeScene, purpose, currentScene);
    setOtherItemNeeded(otherItemNeeded);
    setOtherItem(otherItem);
    setWhatDoesOtherItemDo(whatDoesOtherItemDo);
  }

  public Item(String itemName, String homeScene, String purpose,
    String currentScene, Boolean otherItemNeeded, String otherItem,
    String whatDoesOtherItemDo, String itemRevealed) {

    this(itemName, homeScene, purpose, currentScene, otherItemNeeded,
      otherItem, whatDoesOtherItemDo);
    setItemRevealed(itemRevealed);
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

  public void setHomeScene(String homeScene) {
    this.homeScene = homeScene;
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

  public void setCurrentScene(String currentScene) {
    this.currentScene = currentScene;
  }

  // GET METHODS

  public String getHomeScene() {
    return homeScene;
  }

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

  public String getAsciiArt() {
    return asciiArt;
  }

  public String getCurrentScene() {
    return currentScene;
  }


  @Override
  public String toString() {
    return "Item{" +
           "itemName='" + itemName + '\'' +
           ", homeScene='" + homeScene + '\'' +
           ", purpose='" + purpose + '\'' +
           ", otherItemNeeded=" + otherItemNeeded +
           ", otherItem='" + otherItem + '\'' +
           ", whatDoesOtherItemDo='" + whatDoesOtherItemDo + '\'' +
           ", itemRevealed='" + itemRevealed + '\'' +
           ", asciiArt='" + asciiArt + '\'' +
           ", currentScene='" + currentScene + '\'' +
           '}';
  }
}
