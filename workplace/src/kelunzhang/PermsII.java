public class PermsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length == 0) return res;
        helper(nums, new ArrayList<Integer>(), new boolean[nums.length], res);
        return res;
    }
    private void helper(int[] nums, ArrayList<Integer> list, boolean[] used, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                helper(nums, list, used, res);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}