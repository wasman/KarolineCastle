package com.dowell.castle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserProfile implements Serializable {

    private static final long serialVersionUID = 4925562223965564561L;
    private final String userName;
    private final String password;
    private final List<Character> characters;

    private UserProfile(Builder builder) {
        this.userName = builder.userName;
        this.characters = builder.characters;
        this.password = builder.password;

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Character> getCharacters() {
        return characters;
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
        return !(characters != null ? !characters.equals(that.characters) : that.characters != null);

    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (characters != null ? characters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserProfile{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", characters=").append(characters);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private String userName;
        private String password;

        private List<Character> characters;

        public Builder() {
        }

        public Builder(UserProfile original) {
            this.userName = original.userName;
            this.characters = new ArrayList<>();
            this.characters.addAll(original.characters.stream()
                    .collect(Collectors.toList()));
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

        public Builder characters(List<Character> characters) {
            this.characters = characters;
            return this;
        }
    }
}
