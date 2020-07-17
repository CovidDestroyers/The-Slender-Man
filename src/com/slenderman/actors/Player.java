package com.slenderman.actors;

public class Player {
  public String state = "alive";

  /*
   * =============================================
   * ============= Constructors ==================
   * =============================================
   */
  public Player() {
  }

  /*
   * =============================================
   * =========== Business Methods ================
   * =============================================
   */

  //TODO: write an inventory method

  /*
   * =============================================
   * =========== Accessor Methods ================
   * =============================================
   */

  // SET METHODS
  public void setState(String state) {
    this.state = state;
  }

  // GET METHODS
  public String getState() {
    return state;
  }
}
