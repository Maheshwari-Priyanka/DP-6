// Ugly Number II
// Time Complexity: O(n * log n)
// Space Complexity: O(n)

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> hs = new HashSet<>();
        int[] arr = {2,3,5};
        
        Long result = Long.valueOf(1);
        pq.offer(result);
        // loop n times
        for (int i=0; i<n; i++) {
            // get minimum from the priority queue
            result = pq.remove();
            // get ugly number for all 3 factors
            for (int num : arr) {
                Long ugly = num * result;
                // if hashset doesn't contain the ugly number, then add it to hashset and queue
                if (!hs.contains(ugly)) {
                    hs.add(ugly);
                    pq.offer(ugly);
                    System.out.println(ugly);
                }
            }
        }
        // return the nth ugly number
        return result.intValue();
    }
}

// Longest Palindromic Substring
// Time Complexity: O(n * n)
// Space Complexity: O(1)

class Solution {
    private int start;
    private int end;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        start = 0;
        end = 0;
        // loop over string
        for (int i=0; i<s.length(); i++) {
            // call helper for odd palindrome string
            helper(s, i, i);
            // for even palindrome string
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                helper(s, i, i+1);
            }
        }
        
        return s.substring(start, end + 1);
    }
    // to get palindrome string
    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        
        left += 1;
        right -= 1;
        
        if (end - start < right - left) {
            start = left;
            end = right;
        }
    }
}
