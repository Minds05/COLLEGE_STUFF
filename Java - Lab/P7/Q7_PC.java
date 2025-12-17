class Item {
    boolean valueSet = false;
    synchronized void put(int k) {
        while(valueSet) try { wait(); } catch(Exception e){}
        System.out.println("Producer:"+ k);
        valueSet = true; notify();
    }
    synchronized void get(int k) {
        while(!valueSet) try { wait(); } catch(Exception e){}
        System.out.println("Consumer:" + k);
        valueSet = false; notify();
    }
}
class Q7_PC {
    public static void main(String[] args) {
        Item i = new Item();
        // Producer Thread
        new Thread(() -> { 
            for(int k=0; k<5; k++) i.put(k); 
        }).start();
        // Consumer Thread
        new Thread(() -> { 
            for(int k=0; k<5; k++) i.get(k); 
        }).start();
    }
}