package com.slenderman.game;

import com.slenderman.scenes.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameMapTest {
  GameMap gm = new GameMap();

  @Test
  public void makeMapPositive_SceneNameUpdated() {
    gm.makeMap("pond");
    String actual = gm.getSceneName();
    assertEquals("pond",actual);
  }
  @Test
  public void makeMapPositive_AddedToHashMap() {
    gm.makeMap("pond");
    String actual = gm.getLoc().get(gm.getSceneName());
    assertEquals("(Player)", actual);
  }
  @Test
  public void makeMapPositive_LoseGameNotAddedToHashMap() {
    gm.makeMap("LoseGame");
    boolean actual = gm.getLoc().containsKey(gm.getSceneName());
    String actualScene = gm.getSceneName();
    assertEquals(false, actual);
    assertEquals("LoseGame", actualScene);
  }
}
