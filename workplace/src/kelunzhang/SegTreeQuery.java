public class SegTreeQuery{
	public int query(SegmentTreeNode root, int start, int end) {
		if (root == null)
			return 0;
		if (start > root.end || end < root.start)
			return Integer.MIN_VALUE;
		if (start <= root.start && end >= root.end)
			return root.max;

		int mid = root.start + (root.end - root.start) / 2;
		int leftMax = query(root.left, start, Math.min(mid, end));
		int rightMax = query(root.right, Math.max(start, mid), end);
		return Math.max(leftMax, rightMax);
	}
}