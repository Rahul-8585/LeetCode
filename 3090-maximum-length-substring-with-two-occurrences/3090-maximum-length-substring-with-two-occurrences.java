class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int r = 0;
        int l = 0;
        int max = 0;
        int n = s.length();

        while(r<n){

            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);

            if(map.get(c) > 2){
                while(map.get(c) > 2 && l<=r){
                    char cl = s.charAt(l);
                    map.put(cl,map.get(cl)-1);
                    l++;
                }
            }

            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}