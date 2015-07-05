class SegmentTreeNode {
	public int start, end, count;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int count) {
		this.start = start;
		this.end = end;
		this.count = count;
		this.left = this.right = null;
	}
}

public class SegTreeQueryII {
	public int query(SegmentTreeNode root, int start, int end) {
		if (root == null)
			return 0;
		if (start > root.end || end < root.start)
			return 0;
		if (start <= root.start && end >= root.end)
			return root.count;
		int mid = root.start + (root.end - root.start) / 2;
		int leftCount = query(root.left, start, Math.min(mid, end));
		int rightCount = query(root.right, Math.max(mid, start), end);
		return leftCount + rightCount;
	}
}