package com.slenderman.actors;

/**
 *  The Actor Interface is used to ensure classes such as Player and
 *  SlenderMan, implement common methods where the details of each
 *  implementation is only relevant to the implementing class.
 *
 *  If a method needs to have a common implementation across classes then you
 *  can either change Actor to an abstract class or create a new abstract
 *  class that implements Actor.
 *
 */
public interface Actor {

  public void goEast();
  public void goWest();
  public void goNorth();
  public void goSouth();


  public void setPreviousScene(String previousScene);
  public String getNextScene();
  public void resetNextSceneField();
  public int getCurrentPlace();
  public String toString();

}
