package com.slenderman.actors;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
* Player Tester.
*
* @author <Authors name>
* @since <pre>Jul 27, 2020</pre>
* @version 1.0
*/
public class PlayerTest {
  private Player player;

@Before
public void before() {
  player= new Player();
  player.addItemToInventory(new Item("Protein Bar"));
}

@After
public void after() {
}

/**
*
* Method: addItemToInventory(Item... items)
*
*/
@Test
public void testAddItemToInventoryItemsPositive(){
  assertEquals(4,player.getNumItemsPlayerHas());
}

  @Test
  public void testAddItemToInventoryItemsNegative() {
    assertNotEquals(3,player.getNumItemsPlayerHas());
  }

/**
*
* Method: dropItemFromInventory(Item item)
*
*/
@Test
public void testDropItemFromInventoryPositive() {
  System.out.println(player.getInventory());
  player.dropItemFromInventory(new Item("Protein Bar"));
  assertEquals(3,player.getNumItemsPlayerHas());
}

@Test
public void testDropItemFromInventoryNegative() {
  System.out.println(player.getInventory());
  player.dropItemFromInventory(new Item("Protein Bar"));
  assertNotEquals(4,player.getNumItemsPlayerHas());
}


/**
*
* Method: changeInvItemsLocation()
*
*/
@Test
public void testChangeInvItemsLocation() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: changeInvItemsLocation(String sceneName)
*
*/
@Test
public void testChangeInvItemsLocationSceneName() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: setState(String state)
*
*/
@Test
public void testGetSetState() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: setInventory(List<Item> inventory)
*
*/
@Test
public void testGetSetInventory() throws Exception {
//TODO: Test goes here...
}

/**
*
* Method: setCurrentSceneName(String currentSceneName)
*
*/
@Test
public void testGetSetCurrentSceneName() throws Exception {
//TODO: Test goes here...
}


}
