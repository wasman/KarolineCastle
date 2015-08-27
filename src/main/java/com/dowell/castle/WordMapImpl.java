package com.dowell.castle;

import java.util.HashMap;
import java.util.Map;

public class WordMapImpl implements WordMap {

    private WordMapImpl(Builder builder) {


    }

    public static class Builder {

        Map<Position, ActionCell> wordMap = new HashMap<>();

        public WordMap build() {
            return new WordMapImpl(this);
        }

        public Builder addCell(Position position, ActionCell cell) {
            wordMap.put(position, cell);
            return this;
        }
    }
}
