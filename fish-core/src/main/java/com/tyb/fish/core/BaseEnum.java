package com.tyb.fish.core;

public interface BaseEnum<E extends Enum<?>, T> {
    public T getValue();

    public String getDisplayName();
}
