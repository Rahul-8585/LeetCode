class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();

        for(int a : asteroids){

            boolean dest = false;

            while(!st.isEmpty() && st.peek() > 0 && a < 0){
                if(st.peek() < -a){
                    st.pop();
                    continue;
                }
                else if(st.peek() == -a){
                    st.pop();
                    dest = true;
                    break;
                }
                else{
                    dest = true;
                    break;
                }
            }
            if(!dest){
                st.push(a);
            }
        }
        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}