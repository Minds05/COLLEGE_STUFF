class Q5_Strings {
    // 1. Compare full string
    static int usrstrcmp(String s1, String s2) { 
        return s1.compareTo(s2); 
    }
    // 2. Compare only n characters
    static int usrstrcmp(String s1, String s2, int n) {
        String sub1 = s1.substring(0, Math.min(s1.length(), n));
        String sub2 = s2.substring(0, Math.min(s2.length(), n));
        return sub1.compareTo(sub2);
    }

    public static void main(String[] args) {
        String s1 = "Apollo", s2 = "Apple";
    
        System.out.println("Full Compare: " + (usrstrcmp(s1, s2) == 0 ? "Equal" : "Diff"));
        System.out.println("Partial (2 chars): " + (usrstrcmp(s1, s2, 5) == 0 ? "Equal" : "Diff"));
    }
}