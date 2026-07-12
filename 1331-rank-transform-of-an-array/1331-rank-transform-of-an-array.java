class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return arr;
        Map<Integer,Integer> map = new HashMap<>();
        int[] temp = arr.clone();
        Arrays.sort(temp);
        map.put(temp[0],1);
        int rank = 2;
        for(int i = 1;i<arr.length;i++){
            if(temp[i] == temp[i-1]){
               continue;
            }else{
                map.put(temp[i],rank++);
            }
        }
        for(int i = 0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}