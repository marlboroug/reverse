package suffix;

import java.util.ArrayList;
import java.util.Scanner;

public class alin {
	   public static int sum2(){
           ArrayList list = new ArrayList();
           Scanner scanner= new Scanner(System.in);
           int inputData = 0;
           while(scanner.hasNext()){
               inputData =scanner.nextInt();
               if(inputData == 0){
                   break;
               }
               list.add(inputData);
           }
           int resu = 0;
           int[] sarr = new int[15]; // 
           int[] hasvalue = new int[15];
           for (int k = 0; k < 15; k++) {
               hasvalue[k] = -1;
           }
           for (int i = 0; i < list.size(); i++) {
               int temp = (int)list.get(i);
               int lev = (temp / 100) - 1;
               int ind = (temp % 100) / 10 - 1;
               int val = temp % 10;
               int index = (int) (Math.pow(2, lev) + ind - 1);
               if (lev > 0) {
                   int faindex = (int) (Math.pow(2, lev - 1) - 1 + ind / 2);
                   sarr[index] =  sarr[faindex] + val;
                   hasvalue[index] = 1;
               } else {
                   sarr[index] = val;
                   hasvalue[index] = 1;
               }
           }
           int[] fa = new int[15];
           fa[0] = 0;
           int faTemp = 0; 
           for (int j = 1; j < 14; j += 2) {
               fa[j] = faTemp;
               fa[j + 1] = faTemp;
               faTemp++;
           }
           for (int i = 1; i < 14; i += 2) {
               if (hasvalue[i] == -1 && hasvalue[i + 1] == -1) {
                   resu += sarr[fa[i]];
               }
           }
           for (int j = 7; j < 15; j++) {
               if (hasvalue[j] > 0){
                   resu += sarr[j];
               }
           }
           return resu;
       }
	   static long doneTine(int maxQps, String[] rtList, int requestNum, int threadNum) {
		   int allnum = Math.min(rtList.length, threadNum);
		   int oneseconde = maxQps * allnum;
		   int remain = requestNum % oneseconde;
		   int sec = requestNum / oneseconde;
		   if (remain == 0) {
			   return (sec * 1000);
		   } 
		   int [] resu = new int[rtList.length];
		   for (int i = 0; i < resu.length; i++) {
			   resu[i] = Integer.valueOf(rtList[i]);
		   }
		   int[] temp = new int[rtList.length];
		   for (int i = 0; i < rtList.length; i++) {
			   temp[i] = 0;
		   }
		   long time = 0;
		   while(true){
			   time++;
			   for (int j = 0; j < rtList.length; j++) {
				   if (temp[j] == 0) {
					   temp[j] = resu[j];
					   remain--;
					   if (remain == 0) {
						   return  time += sec * 1000;
					   }
				   }
				   temp[j]--;
			   }
		   }
	   }
	   static long doneTime2(int maxQps,String[] rtList,int requestNum,int threadNum) {
		   int qpsSum = 0;
		    for (String rtString : rtList) {
		    	int singleMaxQps = threadNum * 1000 / Integer.valueOf(rtString);
		    		if (singleMaxQps > maxQps) {
		    				qpsSum += maxQps;
		    			}else	{
		    				qpsSum += singleMaxQps;
		   				}
		  		}
		  		return	requestNum / qpsSum * 1000;
	   }
}
