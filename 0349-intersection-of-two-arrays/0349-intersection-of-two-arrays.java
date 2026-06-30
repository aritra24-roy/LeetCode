import java.util.*;

class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Store nums1
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        // Find common elements
        for (int i = 0; i < nums2.length; i++) {

            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        // Convert HashSet to array
        int[] ans = new int[set2.size()];

        int index = 0;

        for (int num : set2) {
            ans[index] = num;
            index++;
        }

        return ans;
    }
}