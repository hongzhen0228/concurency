package com.chz.strategy.immutable;

import com.chz.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@NotThreadSafe
public class ImmutableCase {

    private static final Integer count = 1;

    private static final String string = "2";

    private static final Map<String,Object> map = new HashMap<>();


    static {
        map.put("1","1");

        map.put("2","2");

        map.put("3","3");
    }

    public static void main(String[] args) {
        map.put("1","3");

        map.forEach((s,u) -> {
            log.info("{}",map.get(s));
            map.get(s);
        });
    }
}
