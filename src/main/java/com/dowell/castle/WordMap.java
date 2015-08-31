package com.dowell.castle;

import java.io.Serializable;
import java.util.Map;

public interface WordMap extends Serializable {

    String getName();

    Map<Position, ActionCell> getWordMap();
}
