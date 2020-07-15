package com.slenderman.scenes;

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
