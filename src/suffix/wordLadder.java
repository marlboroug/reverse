package suffix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordLadder {
	  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	     	if (!wordList.contains(endWord)) {
	     	    return 0;
	     	}
	     	Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
	    	int len = 1;
	    	HashSet<String> visited = new HashSet<String>();
	    	beginSet.add(beginWord);
	    	endSet.add(endWord);
	    	Map<String,  Boolean> map = new HashMap<String, Boolean>();
	    	for (int i = 0; i < wordList.size(); i++) {
	    	    for (int j = i ; j < wordList.size(); j++) {
	    	        String si = wordList.get(i);
	    	        String sj = wordList.get(j);
	                boolean re = getEqual1(si, sj);
	                map.put(si + "#" + sj, re);
	                map.put(sj + "#" + si, re);
	    	    }
	    	}
	    	System.out.println(map);
	    	while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	    		if (beginSet.size() > endSet.size()) {
	    			Set<String> set = beginSet;
	    			beginSet = endSet;
	    			endSet = set;
	    		}
	    		Set<String> temp = new HashSet<String>();
	    		for (String word : beginSet) {
					if (endSet.contains(word)) {
						return len + 1;
					}
					for (String targe : wordList) {
						System.out.println(word + "#" + targe);
					    if (!visited.contains(targe) && !word.equals(targe) && map.get(word + "#" + targe))			
						    if (endSet.contains(targe)) {
						        return len + 1;
						    }
						    temp.add(targe);
						    visited.add(targe);
					}
	    		}
	    		beginSet = temp;
	    		len++;
	    	}
		    return 0;
	    }
	    public boolean getEqual1 (String s1, String s2) {
	        int temp = 0;
	        for (int i = 0; i < s1.length(); i++) {
	            if (s1.charAt(i) != s2.charAt(i)) {
	                temp++;
	                if (temp > 1) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
}
