package com.zelgath.dogshotel.utils;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IdsTest {

    @Test
    public void testEmptySet() {
        int result = Ids.generateNewId(Collections.emptySet());
        assertEquals(0, result);
    }

    @Test
    public void testGenerateNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);
        int result = Ids.generateNewId(sample);
        assertEquals(7,result);
    }
}
