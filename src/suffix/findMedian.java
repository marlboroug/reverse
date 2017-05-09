package suffix;

import java.util.Arrays;

public class findMedian {
	//正则表达式
	   public static boolean isMatch1(String s, String p) {
	        if (s == null || p == null) {
	            return false;
	        }
	        boolean [][] dp = new boolean[s.length() + 1][p.length() + 1];
	        dp[0][0] = true;
	        for (int i = 1; i < p.length(); i++) {
	            if (p.charAt(i) == '*' && dp[0][i - 1]) {
	                dp[0][i + 1] = true;
	            }
	        }
	        System.out.println(Arrays.toString(dp[0]));
	        for (int i= 0; i < s.length(); i++) {
	            for (int j = 0; j < p.length(); j++) {
	                if (p.charAt(j) == '.') {
	                    dp[i + 1][j + 1] = dp[i][j];
	                }
	                if (s.charAt(i) == p.charAt(j)) {
	                    dp[i + 1][j + 1] = dp[i][j];
	                }
	                if (p.charAt(j) == '*') {
	                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
	                    } else {// double       single       empty
	                        dp[i + 1][j + 1] = (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1]);
	                    }
	                }

	            }
	        }
	        return dp[s.length()][p.length()];
	    }
	//正则化
	 public static boolean isMatch(String str, String pattern) {
	        int s = 0, p = 0, match = 0, starIdx = -1;            
	        while (s < str.length()){
	            // advancing both pointers
	            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
	                s++;
	                p++;
	            }
	            // * found, only advancing pattern pointer
	            else if (p < pattern.length() && pattern.charAt(p) == '*'){
	                starIdx = p;//记录
	                match = s;
	                p++;
	            }
	           // last pattern pointer was *, advancing string pointer
	            else if (starIdx != -1){
	                p = starIdx + 1;
	                match++;
	                s = match;
	            }
	           //current pattern pointer is not star, last patter pointer was not *
	          //characters do not match
	            else return false;
	        }
	        //check for remaining characters in pattern
	        while (p < pattern.length() && pattern.charAt(p) == '*')
	            p++;
	        return p == pattern.length();
	    }
	 //两个数组找出其中的中位数
	   public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        if ((null == nums1 && null == nums2) || (nums1.length < 1 && nums2.length < 1)) {
	            return (double)0;
	        }
	        if (nums1.length > nums2.length) {
	            return findMedianSortedArrays(nums2, nums1);
	        }
	        int m = nums1.length;
	        int n = nums2.length;
	        int i = 0, j = 0, ileft = 0, iright = m;
	        while (ileft <= iright) {
	            i = ileft + ((iright - ileft) >> 1);
	            j = (m + n + 1) / 2 - i;
	            if (i < m && nums2[j - 1] > nums1[i]) {
	                ileft = i + 1;
	            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
	                iright = i - 1;
	            } else {
	                int max_left = 0;
	                if (i == 0) {
	                    max_left = nums2[j - 1];
	                } else if (j == 0) {
	                    max_left = nums1[i - 1];
	                } else {
	                    max_left = Math.max(nums1[i - 1], nums2[j - 1]);
	                }
	                if (((m + n) & 0x01) == 1) {
	                    return (double)max_left;
	                }  
	                int min_right = 0;
	                if (i == m) {
	                    min_right = nums2[j]; 
	                } else if (j == n) {
	                    min_right = nums1[i];
	                } else {
	                    min_right = Math.min(nums1[i], nums2[j]);
	                }
	                return (double) (max_left + min_right) / 2.0;
	            }
	        } 
	        return (double)-1;
	    }
}
