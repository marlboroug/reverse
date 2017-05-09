package reseversting;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DiGui {
	public int upStairs(int n){
		int a = 1;
		int b = 2;
		int c = 4;
		if (n <= 3){
			if (n == 1){
				return 1;
			} else if (n == 2){
				return 2;
			} else {
				return 4;
			}
		}
		int sum = 0;
		for (int i = 4; i <= n; i++){
			sum = a + b + c;
			a = b;
			b = c;
			c = sum;
		}
		return sum;
	}
	//如果需要，可以设计出一个对象，包含boolean 和 LinkedlList
	public boolean getPath(int x, int y, LinkedList<Point> path, Map<Point, Boolean> cache){
		Point temp = new Point(x, y);
		if (cache.containsKey(temp)){
			return cache.get(temp);
		}
		if (x == 0 && y == 0){
			for (Point p : path ){
				System.out.print(" (" + p.x +"," + p.y + ")");
			}
			return true;
		}
		path.add(temp);
		System.out.print(" 访问节点 (" + temp.x +"," + temp.y + ")");
		boolean success = false;
		if (!success && isFree(x, y - 1)){
			success = getPath(x, y-1, path, cache);
		}
		if (x >=1 && isFree(x - 1, y) ){
			success = getPath(x - 1, y, path, cache);
		}
		if (!success){
			path.remove(temp);
		}
		return success;
	}
	public boolean isFree(int x, int y){
		if (x < 0 || y < 0){
			return false;
		}
		if (x == 1 && y == 0 ){
			return false;
		}
		if (x == 1 && y == 1 ){
			return false;
		}
		if (x == 2 && y == 0 ){
			return false;
		}
		return true;
	}
	public ArrayList<ArrayList<Integer>> getAll(ArrayList<Integer> list){
		if (null == list){ return null; }
		int len = list.size();
		ArrayList<ArrayList<Integer>> resu = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		resu.add(temp);
		for (int i = 0; i < len; i++){
			ArrayList<ArrayList<Integer>> newresu = new ArrayList<ArrayList<Integer>>();
			newresu.addAll(resu);
			for (ArrayList<Integer> single : resu){
				ArrayList<Integer> singletemp = new ArrayList<Integer>();
				singletemp.addAll(single);
				singletemp.add(list.get(i));
				newresu.add(singletemp);
			}
			resu = newresu;
		}
		return resu;
	}
	public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> list){
		ArrayList<ArrayList<Integer>> newresu = new ArrayList<ArrayList<Integer>>();
		int max = 1 << list.size();
		for (int k = 0; k < max; k++){
			newresu.add(coverIntToList(k, list));
		}
		return newresu;
	}
	public ArrayList<Integer> coverIntToList(int num, ArrayList<Integer> list){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int index = 0;
		for (int k = num; k > 0; k >>= 1){
			if ((k & 1) != 0){
				temp.add(list.get(index));
			}
			index++;
		}
		return temp;
	}
	public Set<String>  getSubStrings(String str){
		return getSubHelp(str, str.length() - 1); 
	}
	public Set<String> getSubHelp(String str, int index){
		if (null == str){
			return null;
		}
		if (index == 0){
			Set<String> set = new HashSet<String>();
			set.add(str.substring(0, 1));
			return set;
		}
		Set<String> set = getSubHelp(str, index - 1);
		Set<String> resu = new HashSet<String>();
		for (String single : set){
			for (int i = 0; i <= single.length(); i++){
				resu.add(addChar(single, str.charAt(index), i));
			}
		}
		return resu;
	} 
	public String addChar(String str, char c, int pox){
		return str.substring(0, pox) + c + str.substring(pox, str.length());
	}
	public void makeChange(ArrayList<ArrayList<Integer>> list, int count, ArrayList<Integer> single){
		if (count < 0){
			return;
		}
		if (count == 0){
			list.add(single);
		}
		if (count >= 25){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(single);
			temp.add(25);
			makeChange(list, count - 25, temp);
		}
		if (count >= 10){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(single);
			temp.add(10);
			makeChange(list, count - 10, temp);
		}
		if (count >= 5){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(single);
			temp.add(5);
			makeChange(list, count - 5, temp);
		}
		if (count >= 1){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(single);
			temp.add(1);
			makeChange(list, count - 1, temp);
		}
	}
	public ArrayList<ArrayList<Integer>> getChange(int count){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> single = new ArrayList<Integer>();
		makeChange(result, count, single);
		return result;
	}
	public ArrayList<>
	
	public class Box{
		public x
	}
	
}
