class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);

         HashMap<Integer,Integer> map = new HashMap<>();
         int rk = 1;
         for(int num: clone) {
            if(!map.containsKey(num)) {
                map.put(num,rk++);
            }
         } 
         for(int i= 0;i<arr.length;i++) {
            arr[i] = map.get(arr[i]);
         }

         return arr;
    }
}