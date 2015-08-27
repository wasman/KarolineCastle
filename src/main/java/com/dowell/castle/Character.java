package com.dowell.castle;

public class Character {

    private final WordMap currentWordMap;
    private final String name;
    private final CharacterType characterType;

    private Character(Builder builder) {
        this.currentWordMap = builder.currentWordMap;
        this.name = builder.name;
        this.characterType = builder.characterType;

    }

    public WordMap getCurrentWordMap() {
        return currentWordMap;
    }

    public String getName() {
        return name;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Character)) {
            return false;
        }

        Character character = (Character) o;

        if (currentWordMap != null ? !currentWordMap.equals(character.currentWordMap) : character.currentWordMap != null) {
            return false;
        }
        if (name != null ? !name.equals(character.name) : character.name != null) {
            return false;
        }
        return characterType == character.characterType;

    }

    @Override
    public int hashCode() {
        int result = currentWordMap != null ? currentWordMap.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (characterType != null ? characterType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("currentWordMap=").append(currentWordMap);
        sb.append(", name='").append(name).append('\'');
        sb.append(", characterType=").append(characterType);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private WordMap currentWordMap;
        private String name;
        private CharacterType characterType;

        public Builder currentWordMap(WordMap currentWordMap) {
            this.currentWordMap = currentWordMap;
            this.name = name;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder characterType(CharacterType characterType) {
            this.characterType = characterType;
            return this;
        }
        public Character build() {
            return new Character(this);
        }
    }

}
