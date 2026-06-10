// import java.util.*;

// class Solution {
//     public String frequencySort(String s) {

//         // Step 1: Count frequency
//         HashMap<Character, Integer> map = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         // Step 2: Convert to List
//         List<Map.Entry<Character, Integer>> list =
//                 new ArrayList<>(map.entrySet());

//         // Step 3: Sort by frequency (Descending)
//         Collections.sort(list,
//                 (a, b) -> b.getValue().compareTo(a.getValue()));

//         // Step 4: Build result string
//         StringBuilder sb = new StringBuilder();

//         for (Map.Entry<Character, Integer> entry : list) {
//             char ch = entry.getKey();
//             int freq = entry.getValue();

//             for (int i = 0; i < freq; i++) {
//                 sb.append(ch);
//             }
//         }

//         return sb.toString();
//     }
// }
//heap approach
 class Solution{
    public String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            maxHeap.offer(new int[]{
                entry.getKey(),
                entry.getValue()
            });
        }

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            char ch =  (char) curr[0];
            int freq = curr[1];

            for(int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
