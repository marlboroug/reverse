package zbishi;

public class Toutiao {

}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<String> resu = getTympe(s);
		for(String s1 : resu) {
			System.out.println(s1);
		}
	}
	public static List<String> getTympe(String s) {
		List<String> resu = new ArrayList<String>();
		int num = -1;
		int max = -5;
		int level = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				num += 2;
				max = Math.max(num, max) + 2;
			} else {
				num -= 2;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '[') {
				num += 2;
				level++;
			} else {
				resu.add("+" + getNnum(max - 2) + "+");
				if (num > 1) {
					num -= 2;
					int left = 0;
					while (num > 0) {
						num -= 2;
						left++;
						resu.add(getleft(left) +"|+" + getNnum(num) +  "+|");
					}
					resu.add(getleft(++left) + "| |");
					resu.add(" ");
					// 反向++
					int temp = level + 1;
					int size = resu.size();
					for (int j = 0; j < temp; j++) {
						resu.add(resu.get(size - 2 - j));
					}
				} else {
					resu.add("|+" + getleft(max -2) +  "+|");
					resu.add(" ");
					resu.add("|+" + getleft(max -2) +  "+|");
				}
				num = -1;
				level = 0;
			}
		}
		return resu;
	}
	public  static String getNnum(int i) {
		String temp = "";
		for (int j = 0; j < i; j++) {
			temp += "-";
		}
		return temp;
	}
	public  static String getleft(int i) {
		String temp = "";
		for (int j = 0; j < i; j++) {
			temp += " ";
		}
		return temp;
	}
}
	
	
/*	private static Reader reader = null;  
	private static Writer writer = null;  
    public static void main(String[] args) {
    	  reader = new InputStreamReader(System.in);  
          writer = new OutputStreamWriter(System.out);  
    	 int n = getInt();
         int m = getInt();
         pair[] pairs = new pair[n];
         int[] A = new int[n];
         int[] B = new int[n];
         for (int i = 0; i < n; i++) {
         	pairs[i] = new pair(0, 0);
         	pairs[i].a = getInt();
         }
         for (int i = 0; i < n; i++) {
         	pairs[i].b = getInt();
         }
        Arrays.sort(pairs, new Comparator<pair> () {
        	 @Override
        	public int compare(pair a, pair b) {
        		return a.a - b.a;
        	}
        });
        for (int i = 0; i < m; i++) {
        	int tar1 = getInt();
        	int tar2 = getInt();
        	System.out.println(getNum(pairs, tar1, tar2));
        }
    }

    public static int getInt() {  
        int read;  
        int res = 0;  
        boolean isNegative = false;// 是不是负数  
        try {  
            while ((read = reader.read()) != -1) {  
                if ((char) read == '-') {  
                    res = 0;  
                    isNegative = true;  
                    break;  
                } else if (isNumber((char) read)) {  
                    res = read - '0';  
                    break;  
                }  
            }  
            while ((read = reader.read()) != -1) {  
                char ch = (char) read;  
                if (isNumber(ch)) {  
                    res = res * 10 + (read - '0');  
                } else {  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        if (isNegative == true) {  
            res = -1 * res;  
        }  
        return res;  
    }  
    public static boolean isBlank(char ch) {  
        if (ch == '\r' || ch == '\n' || ch == ' ') {  
            return true;  
        }  
        return false;  
    }  
   
    public static boolean isNumber(char ch) {  
        if (ch <= '9' && ch >= '0') {  
            return true;  
        }  
        return false;  
    } 
    public static int getNum(pair[] pairs, int tar1, int tar2) {
    	int resu = 0;
    	int left = 0, right = pairs.length - 1;
    	while (left < right) {
    		int mid = left + (right - left) /2 ;
    		if (pairs[mid].a < tar1) {
    			left  = mid + 1;
    		} else {
    			right = mid;
    		}
    	}
    	int beg = 0;
    	if (pairs[left].a >= tar1) {
    		beg = left;
    	} else if (pairs[right].a >= tar1) {
    		beg = right;
    	} else {
    		beg = right + 1;
    	}
    	for (int i = beg; i < pairs.length; i++ ) {
    		if (pairs[i].b >= tar2 ){
    			resu++;
    		}
    	}
    	return resu;
    }
}
class pair {
	int a;
	int b;
	public pair(int numa, int numb){
		a = numa;
		b = numb;
	}*/