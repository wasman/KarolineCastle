package com.dowell.castle;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private final String userName;
    private final Character character;

    private UserProfile(Builder builder) {
        this.userName = builder.userName;
        this.character = builder.character;

    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof UserProfile)) {
            return false;
        }

        UserProfile that = (UserProfile) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) {
            return false;
        }
        return !(character != null ? !character.equals(that.character) : that.character != null);

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (character != null ? character.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserProfile{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", character=").append(character);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private String userName;

        private Character character;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }


        public UserProfile build() {
            return new UserProfile(this);
        }

        public Builder character(Character character) {
            this.character = character;
            return this;
        }
    }
}
