public class MyHashMap {
    private int[] map;

    public MyHashMap() {
        map =new int[1000001];
        for(int i = 0; i< map.Length; i++){
            map[i]=-1;
        }    
    }
    
    public void Put(int key, int value) {
         map[key] = value;
    }
    
    public int Get(int key) {
       return map[key]; 
    }
    
    public void Remove(int key) {
        map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.Put(key,value);
 * int param_2 = obj.Get(key);
 * obj.Remove(key);
 */