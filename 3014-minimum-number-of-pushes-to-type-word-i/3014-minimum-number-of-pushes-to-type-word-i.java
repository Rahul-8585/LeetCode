class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int extra = 0;
        int c = 0;
        int x = 0;
        char[] arr = word.toCharArray();

        for(int i = 0;i<n;i++){
            if(x >= 8){
                extra = extra+1;
                x = 0;
            }
            c = c+extra+1;
            x++;
            System.out.println(x);
        }
        return c;
    }
}