public class NextPerm {
	//1. From n to 0 find the if there is an element that nums[i] < nums[i+1]
    //2. If there is not, reverse the whole array.
    //3. If there is, set the position to k. From k to n find the smallest element that bigger than nums[k], swap the two element and reverse from k+1 to n;
    public void nextPermutation(int[] nums) {
		if (nums.length <= 1)
			return;
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int r = i + 1;
			while (r < nums.length && nums[r] > nums[i]) {
				r++;
			}
			r--;

			swap(nums, i, r);
			reverse(nums, i + 1, nums.length - 1);
			return;

		} else {
			reverse(nums, 0, nums.length - 1);
			return;
		}
	}

	private void swap(int[] A, int l, int r) {
		int tmp = A[r];
		A[r] = A[l];
		A[l] = tmp;
	}

	private void reverse(int[] A, int l, int r) {
		while (l < r) {
			swap(A, l++, r--);
		}
	}
}