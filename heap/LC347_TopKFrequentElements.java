        //maxheaP WE NEED as we r asked minimum lengths
        // approach:-
        // calc distance for ALL
        // put in a maxheap, if size>k poll the heap:>
     class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] p : points) {
            maxHeap.offer(p);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}