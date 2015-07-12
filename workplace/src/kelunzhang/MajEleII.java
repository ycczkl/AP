public class MajEleII {
	//Use two counter method
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums.length == 0) return res;
        int v1 = 0;
        int v2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (count1 == 0) {
                v1 = n;
                count1++;
            } else if (count2 == 0 && n != v1) {
                v2 = n;
                count2++;
            } else if (n == v1) {
                count1++;
            } else if (n == v2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        if (v1 == v2) {
            res.add(v1);
            return res;
        }
        for (int n : nums) {
            if (n == v1)
                count1++;
            if (n == v2)
                count2++;
        }
        if (count1 > nums.length/3)
            res.add(v1);
        if (count2 > nums.length/3)
            res.add(v2);
        return res;
    }
}