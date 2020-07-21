package com.slenderman.actors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class ItemTest2 {
    Item item= new Item("itemName", "homeScene", "purpose", "house", false,
      "otherItem", "whatDoesOtherItemDo", "itemRevealed");

    @Test
    void testPrintAsciiArt(){
        item.printAsciiArt();
    }

    @Test
    void testIsInPlayerInventory(){
       // Boolean result = item.isInPlayerInventory();
        // Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testToString(){
        String result = item.toString();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
