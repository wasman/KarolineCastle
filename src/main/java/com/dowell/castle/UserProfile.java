package com.dowell.castle;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private static final long serialVersionUID = 4925562223965564561L;
    private final String userName;
    private final String password;
    private final Character character;

    private UserProfile(Builder builder) {
        this.userName = builder.userName;
        this.character = builder.character;
        this.password = builder.password;

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Character getCharacter() {
        return character;
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
        if (password != null ? !password.equals(that.password) : that.password != null) {
            return false;
        }
        return !(character != null ? !character.equals(that.character) : that.character != null);

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (character != null ? character.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserProfile{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", character=").append(character);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private String userName;
        private String password;

        private Character character;

        public Builder() {
        }

        public Builder(UserProfile original) {
            this.userName = original.userName;
            this.character = original.character;
            this.password = original.password;

        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
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
