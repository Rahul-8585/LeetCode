class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
       
       StringBuilder[] sb = new StringBuilder[numRows];

       for(int i = 0;i<numRows;i++){
        sb[i] = new StringBuilder();
       }
       int cr = 0;
       int dir = 1; 
       for(char c : s.toCharArray()){
        sb[cr].append(c);

        if(cr == numRows-1) dir = -1;
        if(cr == 0) dir = 1;

        cr = cr+dir;
       }
       StringBuilder ans  = new StringBuilder();
       for(StringBuilder ssb : sb){
        ans.append(ssb);
       }
       return ans.toString();
    }
}