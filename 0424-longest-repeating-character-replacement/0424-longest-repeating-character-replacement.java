class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int l = 0;
        int r = 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int maxf = 0;
        while(r<n){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxf = Math.max(maxf,map.get(ch));

            while((r-l+1)-maxf > k){
                char chl = s.charAt(l);
                map.put(chl,map.get(chl)-1);
                if(map.get(chl) == 0) map.remove(chl);
                l++;
            }
            max = Math.max(r-l+1,max);
            r++;
        }
        return max;
    }
}