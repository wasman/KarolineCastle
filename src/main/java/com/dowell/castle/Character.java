package com.dowell.castle;

import java.io.Serializable;

public class Character implements Serializable {

    private static final long serialVersionUID = 714018303586908077L;

    private final WordMap currentWord;
    private final String name;
    private final CharacterType characterType;
    private final Integer experience;

    private Character(Builder builder) {
        this.currentWord = builder.currentWord;
        this.name = builder.name;
        this.characterType = builder.characterType;
        this.experience = builder.experience;

    }

    public WordMap getCurrentWord() {
        return currentWord;
    }

    public String getName() {
        return name;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public Integer getExperience() {
        return experience;
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

        if (currentWord != null ? !currentWord.equals(character.currentWord) : character.currentWord != null) {
            return false;
        }
        if (name != null ? !name.equals(character.name) : character.name != null) {
            return false;
        }
        if (characterType != character.characterType) {
            return false;
        }
        return !(experience != null ? !experience.equals(character.experience) : character.experience != null);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Character{");
        sb.append("currentWord=").append(currentWord);
        sb.append(", name='").append(name).append('\'');
        sb.append(", characterType=").append(characterType);
        sb.append(", experience=").append(experience);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = currentWord != null ? currentWord.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (characterType != null ? characterType.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        return result;
    }

    public static class Builder {

        private WordMap currentWord;
        private String name;
        private CharacterType characterType;
        private Integer experience;

        public Builder() {
        }

        public Builder(Character original) {
            this.currentWord = new WordMapImpl.Builder(original.currentWord).build();
            this.name = original.name;
            this.characterType = original.characterType;
            this.experience = original.experience;

        }

        public Builder experience(Integer experience) {
            this.experience = experience;
            return this;
        }

        public Builder currentWord(WordMap currentWordMap) {
            this.currentWord = currentWordMap;
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
