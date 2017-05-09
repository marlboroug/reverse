package reseversting;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Caculator {
	public static Map pro = new HashMap();
	public static double fun1(String str) {
		System.out.println(str);
		Stack st1 = new Stack();
		Stack st2 = new Stack();
		while (str.length() != 0) {
			int index = getIndex(str);
			if (index != str.length()) {
				st1.push(Double.valueOf(str.substring(0, index)));
				char co = str.charAt(index);
				if (co == '+' || co == '-') {
					st2.push(co);
					str = str.substring(index + 1);
				} else {
					str = str.substring(index + 1);
					int index2 = getIndex(str);
					double num2 = 0;
					if (index2 != str.length()) {
						num2 = Double.valueOf(str.substring(0, index2));
						str = str.substring(index2 + 1);
					} else {
						num2 = Double.valueOf(str);
						str="";
					}
					double num1 = (double)st1.pop();
					double resu = cal(co, num1, num2);
					st1.push(resu);
				}
			} else {
				st1.push(Double.valueOf(str));
				break;
			}
		}
		while (st2.size() != 0) {
			double num2 = (double)st1.pop();
			double num1 = (double)st1.pop();
			char co = (char)st2.pop();
			double resu = cal(co, num1, num2);
			st1.push(resu);
		}
		return (double)st1.pop();
	}

	public static double fun2(String str) {
		while (str.indexOf('(') != -1) {
			int left = 0;
			int right = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					left = i;
				}
				if (str.charAt(i) == ')'){
					right = i;
					break;
				}
			}
			str = str.substring(0, left) + fun1(str.substring(left + 1, right)) + str.substring(right+1);
		}
		return fun1(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1+2*((3+8)+5)";
		String str1 = " ";
		double result = fun2(str);
		System.out.println(result);

	}
	public static int getIndex(String str) {
		int n = str.length();
		int index1 = str.indexOf('+') == -1 ? n : str.indexOf('+');
		int index2 = str.indexOf('-') == -1 ? n : str.indexOf('-');
		int index3 = str.indexOf('*') == -1 ? n : str.indexOf('*');
		int index4 = str.indexOf('/') == -1 ? n : str.indexOf('/');
		int index = index1 < index2 ? index1:index2;
		index = index < index3 ? index:index3;
		index = index < index4 ? index:index4;
		return index;
		
	}
	public static double cal(char op, double num1, double num2) {
		switch (op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		default:
			return num1 / num2;
		}
	}
}
