package reseversting;

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
	    private List<List<String>> list;
	    private List<String> currLst;
	    public List<List<String>> partition(String s) {
	        list = new ArrayList<List<String>>();
	        currLst = new ArrayList<String>();
	        backTrack(s, 0);
	        return list;
	    }
	    public void backTrack(String s, int l){
	        if(currLst.size()>0 //the initial str could be palindrome
	            && l >= s.length()){
	            List<String> r = new ArrayList<String>();
	            for (String single : currLst) {
	                r.add(single);
	            }
	            list.add(r);
	        }
	        for(int i = l; i < s.length(); i++){
	          
	            	System.out.println("l yu i: " + l + " ," + i);
	                if(l == i){
	                	System.out.println("dange: " + s.charAt(i));
	                    currLst.add(Character.toString(s.charAt(i)));
	                } else {
	                	System.out.println("dange: " + s.substring(l, i+1));
	                	currLst.add(s.substring(l, i+1));
	                }
	                backTrack(s, i+1);
	                System.out.println("all: " + currLst.toString());
	                currLst.remove(currLst.size() - 1);
	        }
		}
	    public boolean isPalindrome (String s, int i, int j) {
	        if (i == j) {
	            return true;
	        }
	        while (i < j) {
	            if (s.charAt(i) != s.charAt(j)) {
	                return false;
	            }
	            i++;
	            j--;
	        }
	        return true;
	    }
}
