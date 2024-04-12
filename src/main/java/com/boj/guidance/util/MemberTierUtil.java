package com.boj.guidance.util;

import java.util.HashMap;
import java.util.Map;

public class MemberTierUtil {

    private static final Map<Long, String> tierMap = new HashMap<>();

    static {
        tierMap.put(1L, "Bronze 5");
        tierMap.put(2L, "Bronze 4");
        tierMap.put(3L, "Bronze 3");
        tierMap.put(4L, "Bronze 2");
        tierMap.put(5L, "Bronze 1");
        tierMap.put(6L, "Silver 5");
        tierMap.put(7L, "Silver 4");
        tierMap.put(8L, "Silver 3");
        tierMap.put(9L, "Silver 2");
        tierMap.put(10L, "Silver 1");
        tierMap.put(11L, "Gold 5");
        tierMap.put(12L, "Gold 4");
        tierMap.put(13L, "Gold 3");
        tierMap.put(14L, "Gold 2");
        tierMap.put(15L, "Gold 1");
        tierMap.put(16L, "Platinum 5");
        tierMap.put(17L, "Platinum 4");
        tierMap.put(18L, "Platinum 3");
        tierMap.put(19L, "Platinum 2");
        tierMap.put(20L, "Platinum 1");
        tierMap.put(21L, "Diamond 5");
        tierMap.put(22L, "Diamond 4");
        tierMap.put(23L, "Diamond 3");
        tierMap.put(24L, "Diamond 2");
        tierMap.put(25L, "Diamond 1");
        tierMap.put(26L, "Ruby 5");
        tierMap.put(27L, "Ruby 4");
        tierMap.put(28L, "Ruby 3");
        tierMap.put(29L, "Ruby 2");
        tierMap.put(30L, "Ruby 1");
        tierMap.put(31L, "Master");
    }

    public static String checkTier(Long tier) {
        return tierMap.getOrDefault(tier, "None");
    }

}
