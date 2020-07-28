package com.slenderman.scenes;

import com.slenderman.actors.Item;
import com.slenderman.actors.ItemDirector;
import com.slenderman.actors.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class OutHouse extends Scene {
  private final ArrayList<Item> itemsInThisScene = ItemDirector.getItemsForScene("outhouse");

  private final Item torch = ItemDirector.findThisItem("torch", itemsInThisScene);

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public OutHouse() {
    setSceneName("outhouse");
    setItemsInScene(itemsInThisScene);
  }

  public OutHouse(Scene sceneToTheNorth, Scene sceneToTheSouth, Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);

    setSceneName("outhouse");
    setItemsInScene(itemsInThisScene);
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {}
}
