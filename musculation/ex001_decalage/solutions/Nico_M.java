package musculation.ex001_decalage.solutions;
public class NicoM_V0 {
    public static void main(String[] args) { 
    String word1 = "abc";
    String word2 = "bca";
    isShifted(word1, word2);
    System.out.println(isShifted(word1, word2));
    }
    public static boolean isShifted(String s1, String s2){
        String s2_shifted = s1.substring(1,s1.length()) + s1.substring(0,1);
        return (s2.equals(s2_shifted));
    }
}
