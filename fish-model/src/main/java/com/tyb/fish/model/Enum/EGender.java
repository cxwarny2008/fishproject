package com.tyb.fish.model.Enum;

import com.fasterxml.jackson.annotation.JsonValue;
import com.tyb.fish.core.BaseEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举性别
 *
 * @author garry
 */
public enum EGender implements BaseEnum<EGender, Integer> {

    female(0, "女"),
    male(1, "男");

    private Integer value;
    private String displayName;
    static Map<Integer, EGender> enumMap = new HashMap<Integer, EGender>();

    static {
        for (EGender type : EGender.values()) {
            enumMap.put(type.getValue(), type);
        }
    }

    private EGender(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    @JsonValue
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static EGender getEnum(Integer value) {
        return enumMap.get(value);
    }


}
