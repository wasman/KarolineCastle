package com.dowell.castle;

import java.io.Serializable;

public class ActionCell implements Serializable {

    private final CellType cellType;
    private final String title;
    private final boolean isEnabled;

    private ActionCell(Builder builder) {
        this.cellType = builder.cellType;
        this.title = builder.title;
        this.isEnabled = builder.isEnabled;
    }

    public CellType getCellType() {
        return cellType;
    }

    public String getTitle() {
        return title;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ActionCell)) {
            return false;
        }

        ActionCell that = (ActionCell) o;

        if (isEnabled != that.isEnabled) {
            return false;
        }
        if (cellType != that.cellType) {
            return false;
        }
        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActionCell{");
        sb.append("cellType=").append(cellType);
        sb.append(", title='").append(title).append('\'');
        sb.append(", isEnabled=").append(isEnabled);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = cellType != null ? cellType.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        return result;
    }

    public static class Builder {

        private CellType cellType;
        private String title;
        private boolean isEnabled = true;

        public ActionCell build() {
            return new ActionCell(this);
        }

        public Builder cellType(CellType cellType) {
            this.cellType = cellType;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder isEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
            return this;
        }
    }
}
