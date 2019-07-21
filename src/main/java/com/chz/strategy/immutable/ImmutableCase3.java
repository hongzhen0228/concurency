package com.chz.strategy.immutable;

import com.chz.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableCase3 {

    private static final ImmutableList list = ImmutableList.of("1","2","3");

    private static final ImmutableSet set = ImmutableSet.copyOf(list);

    private static final ImmutableMap map = ImmutableMap.of("1","2");

    public static void main(String[] args) {
        list.set(1,"2");

    }
}
