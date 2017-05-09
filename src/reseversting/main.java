package reseversting;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
	public static void main(String[] args) {
		int[] nums = new int[]{-5, 1, 3, 4, -2, -3};
		// min 3
		getmin(nums, 0, 5, 1);
		System.out.println(Arrays.toString(nums));
	}
	public static void getmin(int[] nums,int left,int right, int tar) {
		if (left >= right) return;
		int pa = getpartation(nums, left, right); 
		if (pa == tar - 1) return;
		else  if(pa >  tar - 1) getmin(nums, left, pa - 1 , tar);
		else getmin(nums, pa + 1, right, tar);
	} 
	public static int getpartation(int[]  nums, int left, int right) {
		int pivot = nums[left];
		int temp = left;
		while (left < right) {
			while (nums[right] > pivot && left < right) right--;
			while (nums[left] <= pivot && left < right) left++;
			swap(nums, left, right);
			left++;
			right--;
		}
		left--;
		swap(nums, temp, left);
		return left;
	}
	public static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
