package reseversting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    Index[] memo;
    public class TrieNode {
    	char c;
    	TrieNode[] chirld;
    	String word;
    	public TrieNode(char c) {
    		this.c = c;
    	}
    }
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
        	System.out.println(Arrays.toString(memo));
        	if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public   boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        // 采用map作为滑动窗口，
        List<Integer> list = new LinkedList<Integer>();
        if (s.length() < 1 || words.length < 1) {
            return list;
        }
        Map<String, Integer> slide = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            slide.put(words[i], slide.getOrDefault(words[i], 0) + 1);
        }
        int n = s.length();
        int m = words[0].length();
        int num = words.length;
        for (int i = 0; i < m; i++) {
            int count = 0, left = i;
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int j = i; j <= n - m; j+= m) {
                String str = s.substring(j, j + m);
                System.out.println("j " + j);
                System.out.println("left " + left);
                System.out.println("str " + str);
                System.out.println(map);
                if (slide.containsKey(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                    if (map.get(str) <= slide.get(str)) {
                        count++;
                    } else {
                        while (map.get(str) > slide.get(str)) {
                            String str1 = s.substring(left, left + m);
                            map.put(str1, map.get(str1) - 1);
                            if (map.get(str1) < slide.get(str1)) 
                                count--;
                            left += m;
                        }
                    }
                    System.out.println(map);
                    if (count == num) {
                        list.add(left);
                        String temp = s.substring(left, left + m);
                        map.put(temp, map.get(temp) - 1);
                        count--;
                        left += m;
                        System.out.println("count1 : " + count);
                        System.out.println("left1 : " + left);
                    }
                } else {
                    map.clear();
                    left = j + m;
                    count = 0;
                }
            }
        }
        return list; 
    }
    
        int[] parent;
        int[] size;
        public int longestConsecutive(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            parent = new int[nums.length];
            size = new int[nums.length];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    continue;
                }
                map.put(nums[i], i);
                parent[i] = i;
                size[i] = 1;
                if (map.containsKey(map.get(nums[i] - 1))) {
                    union(map.get(nums[i] - 1), i);
                }
                if (map.containsKey(map.get(nums[i] + 1))) {
                    union(i, map.get(nums[i] + 1));
                }
            }
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, size[i]);
            }
            System.out.println(Arrays.toString(parent));
            System.out.println(Arrays.toString(size));
            return max;
        }
        public int find (int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union (int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                if (size[pa] > size[pb]) {
                    parent[pb] = pa;
                    size[pa] += size[pb];
                } else {
                    parent[pa] = pb;
                    size[pb] += size[pa];
                }
            }
            
        }
        
        public int removeBoxes(int[] boxes) {
            int n = boxes.length;
            int[][][] dp = new int[n][n][n];
            return removeBoxesSub(boxes, 0, n - 1, 0, dp);
        }
            
        private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
            if (i > j) return 0;
            if (dp[i][j][k] > 0) return dp[i][j][k];
                
            int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);
                
            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m]) {
                    res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
                }
            }
                
            dp[i][j][k] = res;
            return res;
        }
        private int[] kmp(String s){
            int len = s.length();
            int[] res = new int[len];
            char[] ch = s.toCharArray();
            int i = 0, j = 1;
            res[0] = 0;
            while(i < ch.length && j < ch.length){
                if(ch[j] == ch[i]){
                    res[j] = i+1;
                    i++;
                    j++;
                }else{
                    if(i == 0){
                        res[j] = 0;
                        j++;
                    }else{
                        i = res[i-1];
                    }
                }
            }
            return res;
        }
}
