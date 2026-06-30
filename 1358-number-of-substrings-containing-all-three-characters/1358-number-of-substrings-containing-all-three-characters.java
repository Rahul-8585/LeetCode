class Solution {
    public int numberOfSubstrings(String s) {
        
        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int n = s.length();
        int count = 0;

        while(r<n){
            char cr = s.charAt(r);
            map.put(cr,map.getOrDefault(cr,0)+1);

            while(map.getOrDefault('a', 0) > 0 && map.getOrDefault('b', 0) > 0 && map.getOrDefault('c', 0) > 0){
                count = count+(n-r);
                char cl = s.charAt(l);
                map.put(cl,map.get(cl)-1);
                if(map.get(cl)==0){
                    map.remove(cl);
                }
                l++;
            }
            r++;
        }
        return count;
    }
}