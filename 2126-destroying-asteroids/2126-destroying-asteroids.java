class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currmass = mass;
        for(int a : asteroids){

            if(a<=currmass){
                currmass = currmass+a;
            }
            else{
                return false;
            }
        }
        return true;
    }
}