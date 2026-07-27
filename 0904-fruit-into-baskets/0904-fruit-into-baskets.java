class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = fruits.length;
        int r = 0;
        int l = 0;
        int len = 0;
        int max = 0;

        while(r<n){
            int x = fruits[r];
            map.put(x,map.getOrDefault(x,0)+1);

            if(map.size() > 2){
                int y = fruits[l];
                map.put(y,map.get(y)-1);
                if(map.get(y) == 0) map.remove(y);
                l++;
            }
            len = r-l+1;
            max = Math.max(max,len);
            r++;
        }
        return max;
    }
}