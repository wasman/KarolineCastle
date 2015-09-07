package com.dowell.castle.game;

import com.dowell.castle.ActionCell;
import com.dowell.castle.CellType;
import com.dowell.castle.Character;
import com.dowell.castle.Position;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GameHelperImplTest {

    @Test
    public void testProcessKillActionCell() throws Exception {
        // initialize variable inputs
        ActionCell ork = new ActionCell.Builder()
                .cellType(CellType.ENEMY)
                .title("Ork")
                .build();
        Map<Position, ActionCell> currentWordMap = new HashMap<>();

        currentWordMap.put(new Position(5, 6), ork);

        WordMap currentWord = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 5))
                .wordMap(currentWordMap)
                .build();

        WordMap updateCurrentWordMap = new WordMapImpl.Builder(currentWord)
                .characterLocation(new Position(5, 6))
                .build();

        WordMap expectedCurrentWordMap = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 6))
                .build();

        Character updatedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(updateCurrentWordMap)
                .build();

        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(1)
                .currentWord(expectedCurrentWordMap)
                .build();

        // initialize mocks

        // initialize class to test
        GameHelper testClass = new GameHelperImpl();

        // invoke method on class to test
        Character processedCharacter = testClass.processActionCell(updatedCharacter);

        // assert return value
        assertEquals(expectedCharacter, processedCharacter);

        // verify mock expectations
    }

    @Test
    public void testProcessActionCell() throws Exception {
        // initialize variable inputs
        ActionCell ork = new ActionCell.Builder()
                .cellType(CellType.ENEMY)
                .title("Ork")
                .build();
        Map<Position, ActionCell> currentWordMap = new HashMap<>();

        currentWordMap.put(new Position(5, 6), ork);

        WordMap currentWord = new WordMapImpl.Builder()
                .characterLocation(new Position(5, 8))
                .wordMap(currentWordMap)
                .build();

        Character updatedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(currentWord)
                .build();

        Character expectedCharacter = new Character.Builder()
                .name("doom")
                .experience(0)
                .currentWord(currentWord)
                .build();

        // initialize mocks

        // initialize class to test
        GameHelper testClass = new GameHelperImpl();

        // invoke method on class to test
        Character processedCharacter = testClass.processActionCell(updatedCharacter);

        // assert return value
        assertEquals(expectedCharacter, processedCharacter);

        // verify mock expectations
    }
}