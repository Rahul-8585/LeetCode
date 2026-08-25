class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        Set<Integer> set = new HashSet<>();

        for(int a : nums){
            set.add(a);
        }

        int x = 1;
        while(set.contains(k*x)){
            x++;
        }
        System.out.println(k*x);
        return k*x;
    }
}