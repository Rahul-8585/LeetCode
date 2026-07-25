class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int r = 0;
        int l = 0;
        int n = s.length();
        int len = 0;
        int max = 0;
        if(n == 1){
            return 1;
        }
        Set<Character> set = new HashSet<>();
        while(r<n){
            char ch = s.charAt(r);
            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            len = r-l+1;
            max = Math.max(len,max);
            r++;
        }
        return max;
    }
}