package com.slenderman.scenes;

import com.slenderman.actors.Player;

import java.util.Scanner;

public class OutHouse extends Scene {

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public OutHouse() {
    setSceneName("outhouse");
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */
  @Override
  public void enter(Scanner in, Player player) throws InterruptedException {}

  public OutHouse(

    Scene sceneToTheNorth, Scene sceneToTheSouth,
    Scene sceneToTheEast, Scene sceneToTheWest) {
    super(sceneToTheNorth, sceneToTheSouth, sceneToTheEast, sceneToTheWest);
  }

}
