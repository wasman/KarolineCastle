package com.dowell.castle;

public class GameWordServiceImpl implements GameWordService {

    @Override
    public WordMap getStartGame() {
        WordMap world = new WordMapImpl.Builder()
                .addCell(new Position(1, 3), new ActionCell.Builder().build())
                .addCell(new Position(2, 3), new ActionCell.Builder().build())
                .addCell(new Position(3, 3), new ActionCell.Builder().build())
                .addCell(new Position(4, 3), new ActionCell.Builder().build())
                .addCell(new Position(1, 2), new ActionCell.Builder().build())
                .characterLocation(new Position(5, 5))
                .name("StartGame")
                .build();
        return world;
    }
}
