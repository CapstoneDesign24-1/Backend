package com.boj.guidance.util;

import java.util.HashMap;
import java.util.Map;

public class TierUtil {

    private static final Map<Long, String> tierMap = new HashMap<>();

    static {
        tierMap.put(1L, "Bronze V");
        tierMap.put(2L, "Bronze IV");
        tierMap.put(3L, "Bronze III");
        tierMap.put(4L, "Bronze II");
        tierMap.put(5L, "Bronze I");
        tierMap.put(6L, "Silver V");
        tierMap.put(7L, "Silver IV");
        tierMap.put(8L, "Silver III");
        tierMap.put(9L, "Silver II");
        tierMap.put(10L, "Silver I");
        tierMap.put(11L, "Gold V");
        tierMap.put(12L, "Gold IV");
        tierMap.put(13L, "Gold III");
        tierMap.put(14L, "Gold II");
        tierMap.put(15L, "Gold I");
        tierMap.put(16L, "Platinum V");
        tierMap.put(17L, "Platinum IV");
        tierMap.put(18L, "Platinum III");
        tierMap.put(19L, "Platinum II");
        tierMap.put(20L, "Platinum I");
        tierMap.put(21L, "Diamond V");
        tierMap.put(22L, "Diamond IV");
        tierMap.put(23L, "Diamond III");
        tierMap.put(24L, "Diamond II");
        tierMap.put(25L, "Diamond I");
        tierMap.put(26L, "Ruby V");
        tierMap.put(27L, "Ruby IV");
        tierMap.put(28L, "Ruby III");
        tierMap.put(29L, "Ruby II");
        tierMap.put(30L, "Ruby I");
        tierMap.put(31L, "Master");
    }

    public static String checkTier(Long tier) {
        return tierMap.getOrDefault(tier, "None");
    }

}
