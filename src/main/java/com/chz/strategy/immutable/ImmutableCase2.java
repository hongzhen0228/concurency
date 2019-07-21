package com.chz.strategy.immutable;

import com.chz.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableCase2 {

    private static  Map<String,Object> map = new HashMap<>();


    static {
        map.put("1","1");

        map.put("2","2");

        map.put("3","3");

        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put("1","3");


    }
}
