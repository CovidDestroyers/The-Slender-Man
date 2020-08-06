package com.slenderman.scenes;

import com.slenderman.actors.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForestTest {

  @Before
  public void init(){
//    Player Player = new Player();
//    Scene aShed = new Shed();
//    Scene aTree = new Tree();
//    Scene aPond = new Pond();
//    Scene aCave = new Cave();
//    Scene aField = new Field();
//    Scene aHouse = new House();
//    Scene aForest = new Forest();
//
//    aForest.connectSouth(aShed);
//    aForest.connectEast(aHouse);
//    aHouse.connectSouth(aCave);
//    aShed.connectEast(aCave);
//    aCave.connectEast(aPond);
//    aPond.connectEast(aField);
//    aField.connectEast(aTree);
  }

  @Test
  public void testGetSceneName(){
    Forest forest = new Forest();
    assertEquals("forest", forest.getSceneName());
  }

  @Test
  public void testGetNeighbors(){
    Player player = new Player();
    Scene aShed = new Shed();
    Scene aTree = new Tree();
    Scene aPond = new Pond();
    Scene aCave = new Cave();
    Scene aField = new Field();
    Scene aHouse = new House();
    Scene aForest = new Forest();

    aForest.connectSouth(aShed);
    aForest.connectEast(aHouse);
    aHouse.connectSouth(aCave);
    aShed.connectEast(aCave);
    aCave.connectEast(aPond);
    aPond.connectEast(aField);
    aField.connectEast(aTree);

    player.setCurrentSceneName(aForest.getSceneName());

    assertEquals("forest", player.getCurrentSceneName());
//    assertEquals(aShed.getSceneName(), aForest.getSceneToTheSouth());
//    assertEquals(aHouse.getSceneName(), aForest.getSceneToTheEast());
  }
}
