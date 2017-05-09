package reseversting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KuoZHan {
	public void prinDup(int [] nums){
		MyBitSet bit = new MyBitSet(32000);
		for (int num : nums){
			if (bit.get(num - 1)){
				System.out.print(" " + num);
			} else {
				bit.set(num - 1);
			}
		}
		
	}
	public class MyBitSet{
		private int[] bitset;
		public MyBitSet(int size){
			//int 类型数据包含4个字节变量
			bitset = new int[size >> 5];//32
		}
		public boolean get(int index){
			int wordNum = index >> 5;
			int bitNum = index & 0x1f;//对32 取余数
			return ((bitset[wordNum] >> bitNum) & 0x01) == 1;
		}
		public void set(int index){
			int wordNum = index >> 5;
			int bitNum = index & 0x1f;//对32 取余数
			bitset[wordNum] |= 0x01 << bitNum;
		}
	}
	
	public void quickSort(int nums[], int left, int right){
		int index = position(nums, left, right);
		if (left < index - 1){
			quickSort(nums, left, index - 1);
		}
		if (index < right){
			quickSort(nums, index, right);
		}
	}
	public int position(int nums[] , int left, int right){
		int mid = nums[left + ((right - left) >> 1)];
		while (left <= right){
			while (nums[left] < mid){
				left++;
			}
			while (nums[right] > mid){
				right--;
			}
			if (left <= right){
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left ++;//找到并交换后，要进行位置处理操作
				right--;
			}
		}
		return left;
	}
	public void mergeSort(int[] nums, int left, int right){
		if (left < right){
			int mid = left + ((right - left) >> 1);
			mergeSort(nums, left, mid);
			mergeSort(nums, mid + 1, right);
			merge(nums, left, mid, right);
		}
	}
	public void merge(int[] nums,int left,int mid,int right){
		int[] temp = new int[nums.length];
		for (int i = left; i <= right; i++){
			temp[i] = nums[i];
		}
		int c = left;
		int num = mid + 1;
		while(c <= right){
			if ((left <= mid) && ((temp[left] < temp[num]) || (num > right))){
				nums[c] = temp[left++];
			} else {
				nums[c] = temp[num++];
			}
			c++;
		}
	}

	public void RadixSort(String[] strs){
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		String key = null;
		for (String s : strs){
			key = changeSort(s.toCharArray());
			if (!map.containsKey(key)){
				map.put(key, new ArrayList<String>());
			}
			List<String> temp = map.get(key);
			temp.add(s);
		}
		int index = 0;
		for (String mapkey : map.keySet()){
			List<String> list = map.get(mapkey);
			for (String s : list){
				System.out.println(s);
				strs[index++] = s;
			}
		}
	}
	public String changeSort(char[] carray){
		Arrays.sort(carray);
		return new String(carray);
	}
	
/*	System.out.println(kuo.findIndex(nums, 7, 0, nums.length - 1));*/
	public int findIndex(int[] nums, int tar, int left, int right){
		if (left > right){
			return -1;
		}
		int mid = left + ((right - left) >> 1);
		if (nums[mid] == tar){
			return mid;
		}
		if (nums[left] < nums[mid]){//左
			if ((tar >= nums[left]) && (tar <= nums[mid])){
				return findIndex(nums, tar, left, mid -1);
			} else {
				return findIndex(nums, tar, mid + 1, right);
			}
		} else if (nums[mid] < nums[right]){//右
			if ((tar >= nums[mid]) && (tar <= nums[right])){
				return findIndex(nums, tar, mid + 1, right);
			} else {
				return findIndex(nums, tar, left, mid -1);
			}
		} else {
			if (nums[left] == nums[mid]){//左
				if (nums[mid] != right){
					return findIndex(nums, tar, mid + 1, right);
				} else {
					int result = findIndex(nums, tar, left, mid - 1);
					if (result == -1){
						result = findIndex(nums, tar, mid + 1, right);
					}
					return result;
				}
			}
		}
		return -1;
	}
	
	public int findIndex1(int[] nums, int tar, int left, int right){
		if (left > right){
			return -1;
		}
		int mid = left + ((right - left) >> 1);
		if (nums[mid] == tar){
			return mid;
		}
		if (nums[left] <= nums[mid]){//左
			if ((tar <= nums[mid])){
				return findIndex1(nums, tar, left, mid -1);
			} else {
				return findIndex1(nums, tar, mid + 1, right);
			}
		} else {//右
			if ((tar >= nums[mid])){
				return findIndex1(nums, tar, mid + 1, right);
			} else {
				return findIndex1(nums, tar, left, mid -1);
			}
		} 
	}
	
	
	public int getNum(Employ[] nums, Employ em, Map map){
		if (em != null && map.containsKey(em)){
			System.out.println("计算过 " + em.wei + " : " + map.get(em));
			return (int)map.get(em);
		}
		int max = 0;
		int value = 0;
		for (int i = 0; i < nums.length; i++){
			if ((nums[i].wei < em.wei) && (nums[i].hei < em.hei)){
				value = getNum(nums, nums[i], map);
			}
			if (value > max){
				max = value;
			}
		}
		max++;
		map.put(em, max);
		System.out.println("计算chu " + em.wei + " : " + max);
		return max;
	}
	public int getNum(Employ[] nums){
		Map map = new HashMap();
		int max = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++){
			temp = getNum(nums, nums[i], map);
			if (temp > max){
				max = temp;
			}
		}
		return max;
		
	}
}
