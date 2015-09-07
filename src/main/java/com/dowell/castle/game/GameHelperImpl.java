package com.dowell.castle.game;

import com.dowell.castle.ActionCell;
import com.dowell.castle.CellType;
import com.dowell.castle.Character;
import com.dowell.castle.Position;
import com.dowell.castle.WordMap;
import com.dowell.castle.WordMapImpl;

import java.util.HashMap;
import java.util.Map;

public class GameHelperImpl implements GameHelper {

    @Override
    public Character processActionCell(Character character) {
        WordMap currentWord = character.getCurrentWord();

        Position characterLocation = currentWord.getCharacterLocation();

        ActionCell actionCell = currentWord.getWordMap().get(characterLocation);

        if (actionCell != null && (CellType.ENEMY == actionCell.getCellType())) {
            //kill enemy
            Integer newExperience = character.getExperience()+1;

            Map<Position, ActionCell> newWordMap = new HashMap<>(currentWord.getWordMap());
            newWordMap.remove(characterLocation);

            WordMap newWord = new WordMapImpl.Builder(currentWord)
                                   .wordMap(newWordMap)
                                   .build();

            Character updatedCharacter = new Character.Builder(character)
                    .experience(newExperience)
                    .currentWord(newWord)
                    .build();

            return  updatedCharacter;

        }
        return character;
    }
}
