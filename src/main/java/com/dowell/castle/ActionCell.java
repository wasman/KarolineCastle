package com.dowell.castle;

import java.io.Serializable;

public class ActionCell implements Serializable{

    private ActionCell(Builder builder) {


    }

    public static class Builder {

        public ActionCell build() {
            return new ActionCell(this);
        }
    }
}
