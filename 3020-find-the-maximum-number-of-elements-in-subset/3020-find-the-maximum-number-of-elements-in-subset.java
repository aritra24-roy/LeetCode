import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            if (cnt % 2 == 0) cnt--;
            ans = Math.max(ans, cnt);
        }

        for (long start : freq.keySet()) {

            if (start == 1L) continue;

            long cur = start;
            int len = 0;

            while (true) {

                int cnt = freq.getOrDefault(cur, 0);

                if (cnt < 2) {
                    if (cnt == 1)
                        len++;
                    else
                        len--;
                    break;
                }

                // If this is the last possible square, make it the center
                if (cur > 1000000000L / cur || !freq.containsKey(cur * cur)) {
                    len++;
                    break;
                }

                len += 2;
                cur = cur * cur;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}