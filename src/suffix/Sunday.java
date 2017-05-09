package suffix;

import java.util.Arrays;

public class Sunday {
	private static final int[] _next = null;
	public static int  SundaySearch(){
		GetNext();
		System.out.println(Arrays.toString(_next));
		int destLen = dest.length();
		int patternLen = pattern.length();
		if (destLen == 0) return -1;
		for (int i = 0; i <= destLen - patternLen;){
			int j = i;//dest[j]
			int k = 0;//pattern[k]
			for (; k < patternLen && j < destLen && dest.charAt(j) == pattern.charAt(k); j++, k++)
				;//do nothing
			if (k == patternLen)//great! find it!
				return i;
			else{
				if (i + patternLen < destLen) {
					i += (patternLen - _next[dest.charAt(i + patternLen)]);
				}
				else
					return -1;
			}
		}
		return -1;
	}
	public static void GetNext(){
		int len = pattern.length();//get the length
		for (int i = 0; i < 256; i++)
			_next[i] = -1;
		for (int i = 0; i < len; i++)
			_next[pattern.charAt(i)] = i;
	}
}
