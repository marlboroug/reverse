package reseversting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class reservce {

	public static void main(String[] args) {
		
		System.out.println(divide(-2147483648,2));
	
	}
    public static int divide(int dividend, int divisor) {
        if (0 == divisor){
            return Integer.MIN_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
        long dend = Math.abs((long)dividend);
        long sor = Math.abs((long)divisor);
        System.out.println("dend: " + dend);
        System.out.println("sor: " + sor);
        long temp = sor;
        long res = 0;
        while (sor <= dend){
            int multi = 1;
            temp = sor;
            while((temp << 1) <= dend ){
                temp = temp << 1;
                multi = multi << 1;
            }
            dend -= temp;
            res += multi;
        }
        return (int)(sign > 0 ? res : -res);
    }
}
