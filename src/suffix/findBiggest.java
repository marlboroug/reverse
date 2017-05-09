package suffix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class findBiggest {
	private static String findBestSplit(String s1,String s2){
		System.out.println("s1 s2 :" + s1 + " ," + s2);
		int max = -1;
		int a = 0;
		for (int i = 0; i < s1.length(); i++) {
			a = s1.charAt(i) - '0';
			if (a > max) {
				max = a;
			}
		}
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < s1.length(); i++) {
			a = s1.charAt(i) - '0';
			if (a == max) {
				list.add(i);
			}
		}
    	String res="";
    	for(int i : list){
    		String left = s1.substring(0,i);
    		String tmp = s1.substring(i, s1.length())+ s2 + left;
    		if(res.compareTo(tmp)<0)
    			res = tmp;
    	}
    	return res;
    }
    private static boolean biggerAtFirst(String s1,String s2){
    	String tmp = "";
    	String res1 = findBestSplit(s1,s2);
    	tmp = findBestSplit(new StringBuilder(s1).reverse().toString(),s2);
    	if(res1.compareTo(tmp) < 0) res1 = tmp;
    	String res2 = findBestSplit(s2,s1);
    	tmp = findBestSplit(new StringBuilder(s2).reverse().toString(),s1);
    	if(res2.compareTo(tmp) < 0) res2 = tmp;
    	if(res1.compareTo(res2) < 0) return false;
    	else return true;
    	
    }
    public static String buildLargestNumber(int []nums){
    	String []strs = new String[nums.length];
    	for(int i = 0;i < nums.length; i++){
    		 int n = nums[i];
    		 String s1 = String.valueOf(n);
    		 String s2 = new StringBuilder(s1).reverse().toString();
    		 if(s1.compareTo(s2) < 0) 
    			 strs[i]=s2;
    		 else 
    			 strs[i]=s1;
    	}
    	Arrays.sort(strs, new Comparator<String>(){
    		public int compare(String x, String y){
    			return y.compareTo(x);
    		}
    	});
    	int first_idx = 0;
    	for(int i = 1; i < nums.length; i++){
    		if( biggerAtFirst(strs[i], strs[first_idx]))
    			first_idx=i;
    	}
    	String part2 = "";
    	for(int i = 0;i < nums.length; i++){
    		if(i != first_idx)
    			part2 += strs[i];
    	}
    	String res1 = findBestSplit(strs[first_idx],part2);
    	String res2 = findBestSplit(new StringBuilder(strs[first_idx]).reverse().toString(), part2);
    	if(res1.compareTo(res2) < 0) return res2;
    	else return res1;
    }
}
