package com.pefier.MyFirstMod.utility;

import javafx.beans.NamedArg;
import javafx.util.Pair;

/**
 * Created by New Profile on 09.04.2016.
 */
public class ItemStackPair extends Pair {
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public ItemStackPair(@NamedArg("key") Object key, @NamedArg("value") Object value) {
        super(key, value);
    }

}
