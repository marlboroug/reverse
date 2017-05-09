package suffix;
import java.util.*;
import java.lang.*;
import java.io.*;
public class GFG {
		public static void main (String[] args) {
			 Calendar calendar = Calendar.getInstance();  
			 synchronized(GFG.class){
				 
			 }
			//code
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
			    int m = sc.nextInt();
			    int[] nums = new int[m];
			    for (int j = 0; j < m; j++) {
			        nums[j] = sc.nextInt();
			    }
			    System.out.println(reseversepairs(nums));
			    System.out.println(Arrays.toString(nums));
			}
		}
		public static int reseversepairs(int nums[]) {
		    int[] res = new int[nums.length];
		    return mergeSort(nums, res, 0, nums.length - 1);
		}
		public static  int mergeSort(int[] nums,int[] res, int left, int right) {
			if (left >= right) {
				return 0;
			}	
			int mid = left + ((right - left) >> 1);
			int numl = mergeSort(nums, res, left, mid);
			int numr = mergeSort(nums, res, mid + 1, right);
			int merm = merge(nums, res, left , mid, right);
			return numl + numr + merm;
		}
		public static int merge(int[] nums, int[] res, int left, int mid, int right) {
		   int le = left, ri = mid + 1, idx = left;
		   int cnt = 0;
		   while (le <= mid && ri <= right) {
			   if (nums[le] > nums[ri]) {
				   res[idx++] = nums[ri++];
				   cnt += mid - le + 1;
			   } else {
				   res[idx++] = nums[le++];
			   }
		   }
		   while (le <= mid) {
			   res[idx++] = nums[le++];
		   }
		   while (ri <= right) {
			   res[idx++] = nums[ri++];
		   }
		   for (int k = left; k <= right; k++) {
			   nums[k] = res[k];
		   }
		   return cnt;
		}
	}
