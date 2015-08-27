package com.dowell.castle;

import java.util.HashMap;
import java.util.Map;

public class WordMapImpl implements WordMap {

    private final String name;
    private final Map<Position, ActionCell> wordMap;

    private WordMapImpl(Builder builder) {
        this.name = builder.name;
        this.wordMap = builder.wordMap;

    }

    public String getName() {
        return name;
    }

    public Map<Position, ActionCell> getWordMap() {
        return wordMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WordMapImpl)) {
            return false;
        }

        WordMapImpl wordMap1 = (WordMapImpl) o;

        if (name != null ? !name.equals(wordMap1.name) : wordMap1.name != null) {
            return false;
        }
        return !(wordMap != null ? !wordMap.equals(wordMap1.wordMap) : wordMap1.wordMap != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (wordMap != null ? wordMap.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WordMapImpl{");
        sb.append("name='").append(name).append('\'');
        sb.append(", wordMap=").append(wordMap);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private Map<Position, ActionCell> wordMap = new HashMap<>();
        private String name;

        public WordMap build() {
            return new WordMapImpl(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder addCell(Position position, ActionCell cell) {
            wordMap.put(position, cell);
            return this;
        }
    }
}
