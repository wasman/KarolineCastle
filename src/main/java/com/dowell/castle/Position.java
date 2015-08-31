package com.dowell.castle;

import java.io.Serializable;

public class Position implements Serializable {

    private final int xaix;
    private final int yaix;

    public Position(int xaix, int yaix) {

        this.xaix = xaix;
        this.yaix = yaix;
    }

    public int getXaix() {
        return xaix;
    }

    public int getYaix() {
        return yaix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }

        Position position = (Position) o;

        if (xaix != position.xaix) {
            return false;
        }
        return yaix == position.yaix;

    }

    @Override
    public int hashCode() {
        int result = xaix;
        result = 31 * result + yaix;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Position{");
        sb.append("xaix=").append(xaix);
        sb.append(", yaix=").append(yaix);
        sb.append('}');
        return sb.toString();
    }
}
