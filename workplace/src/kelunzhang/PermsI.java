public class PermsI {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return res;
		List<Integer> list = new LinkedList<Integer>();
		list.add(num[0]);
		res.add(list);
		for (int i = 1; i < num.length; i++) {
			int size = res.size();
			List<List<Integer>> newRes = new ArrayList<List<Integer>>();
			for (List<Integer> line : res) {
			    int lineSize = line.size();
				for (int j = 0; j <= lineSize; j++) {
					List<Integer> tmp = new LinkedList<Integer>(line);
					tmp.add(j, num[i]);
					newRes.add(tmp);
				}
			}
			res = newRes;
		}
		return res;
	}
}