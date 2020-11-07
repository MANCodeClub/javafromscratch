public class NicoM_V1 {
    public static void main(String[] args) {
            System.out.println("word_1?");
            Scanner sc = new Scanner(System.in);
            String word1 = sc.nextLine();
            System.out.println("word_2?");
            Scanner sc1 = new Scanner(System.in);
            String word2 = sc1.nextLine();
            isShifted(word1, word2);
            System.out.println(isShifted(word1, word2));
    }

        public static boolean isShifted(String s1, String s2)
        {
            String s2_shifted = s1.substring(1,s1.length()) + s1.substring(0,1);
            return (s2.equals(s2_shifted));
        }
}
