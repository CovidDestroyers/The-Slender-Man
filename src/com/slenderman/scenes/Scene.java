package com.slenderman.scenes;

/**
 *  The Scene Interface is used to ensure classes such as Hut and
 *  Cave, implement common methods where the details of each
 *  implementation is only relevant to the implementing class.
 *
 *  If a method needs to have a common implementation across classes then you
 *  can either change Scene to an abstract class or create a new abstract
 *  class that implements Scene.
 */
public interface Scene {

    public void goNorth();
    public void goSouth();
    public void grab();
    public void setPreviousScene(String previousScene);
    public String getNextScene();
    public void resetNextSceneField();
    public int getCurrentPlace();
    public String toString();
}
