package suffix;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Main3 {
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int num;
	        num = in.nextInt();
	        int count = 0;
	        for(int i = 2; i <= num/2; i++){
	            if(isPrimenum(i) && isPrimenum(num-i)){
	                count++;
	            }
	        }
	        System.out.print(count);
	    }


	    public static boolean isPrimenum(int num){
	        int numsqrt = (int)Math.sqrt((double)num);
	        for(int i = 2; i <= numsqrt;i++){
	            if(num%i == 0)
	                return false;
	        }
	        return true;
	    }
}
