package com.dowell.castle.profile;

public class AuthenticationException  extends Exception{

    private final String message;

    public AuthenticationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthenticationException{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthenticationException)) {
            return false;
        }

        AuthenticationException that = (AuthenticationException) o;

        return !(message != null ? !message.equals(that.message) : that.message != null);

    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }
}
