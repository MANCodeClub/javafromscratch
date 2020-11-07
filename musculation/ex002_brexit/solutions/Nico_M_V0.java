import java.util.Scanner;
public class NicoM_V0 {
    public static void main(String[] args)
    {
        System.out.println("Taille du drapeau ?");
        Scanner sc = new Scanner(System.in);
        int taille = sc.nextInt();
        drapeau(taille);
    }


    public static void drapeau(int T)
    {

    String X = "X";
    String space = " ";

    for (int i = 0; i<= T; i++)
        {
        String XrepeatedHaut = "|" + X.repeat(i) + space.repeat(1) + X.repeat(T-i) + space.repeat(1) + X.repeat(T-i) + space.repeat(1) + X.repeat(i) + "|";
        System.out.println(XrepeatedHaut);
        }
    System.out.println("|" + space.repeat(T*2+3) + "|");
    for (int i = T; i>= 0; i--)
        {
        String XrepeatedBas =  "|" + X.repeat(i) + space.repeat(1) + X.repeat(T-i) + space.repeat(1) + X.repeat(T-i) + space.repeat(1) + X.repeat(i) + "|";
        System.out.println(XrepeatedBas);
        }
    }
}
