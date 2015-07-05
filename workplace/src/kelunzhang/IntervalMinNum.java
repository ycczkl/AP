/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class SegmentTreeNode {
    int start, end, min;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class IntervalMinNum {
	/**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A.length == 0 || queries == null || queries.size() == 0)
            return res;
        //First build tree
        SegmentTreeNode root = build(new SegmentTreeNode(0, A.length-1) , A);
        //query each interval
        for (Interval obj : queries) {
            res.add(query(root, obj.start, obj.end));
        }
        return res;
    }
    
    private SegmentTreeNode build(SegmentTreeNode root ,int[] A) {
        if (root == null) return root;
        if (root.start == root.end){
            root.min = A[root.start];
            return root;
        }
        int mid = root.start + (root.end- root.start)/2;
        root.left = new SegmentTreeNode(root.start, mid);
        root.right = new SegmentTreeNode(mid+1, root.end);
        build(root.left, A);
        build(root.right, A);
        root.min = Math.min(root.left.min, root.right.min);
        return root;
    }
    
    private int query(SegmentTreeNode root, int start, int end) {
        if (start > root.end || end < root.start) return Integer.MAX_VALUE;
        if (start <= root.start && end >= root.end) return root.min;
        int mid = root.start + (root.end - root.start)/2;
        int leftMin = query(root.left, start, Math.min(mid, end));
        int rightMin = query(root.right, Math.max(mid, start), end);
        return Math.min(leftMin, rightMin);
    }
}