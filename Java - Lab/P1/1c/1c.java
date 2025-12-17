import java.util.Arrays; // Added import to fix "cannot find symbol"

class Q1C_Sort {         // Removed 'public' so it works in '1c.java'
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1};
        
        // Bubble Sort Logic
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) { 
                    int t = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}