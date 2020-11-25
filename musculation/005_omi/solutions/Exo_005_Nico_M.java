import java.util.Scanner;
import java.util.regex.*;
public class Exo5_V0 {
    public static void main(String[] args)
    {
        System.out.println("omi ?");
        Scanner sc = new Scanner(System.in);
        String omi = sc.nextLine();
        checkIMONbr(omi);       
    }


    public static void checkIMONbr(String test)
    {

        String erreur = "";
        Boolean resultat;
        String premier = "0";
        if (test.length() != 7)
        {
            resultat = false;
            erreur = "mauvaise longueur";
        }
        else if (premier.equals((test.substring(0,1))))
        {
            resultat = false;
            erreur = "commence par 0";
        }
        else if (Pattern.matches("\\d+", test) == false)
        {
            resultat = false;
            erreur = "caractère non chiffre";
        }
        else if (
                    (
                    (Integer.valueOf(test.substring(0,1)).intValue())*(8-1)
                    +
                    (Integer.valueOf(test.substring(1,2)).intValue())*(8-2)
                    +
                    (Integer.valueOf(test.substring(2,3)).intValue())*(8-3)
                    +
                    (Integer.valueOf(test.substring(3,4)).intValue())*(8-4)
                    +
                    (Integer.valueOf(test.substring(4,5)).intValue())*(8-5)
                    +
                    (Integer.valueOf(test.substring(5,6)).intValue())*(8-6)
                    )%10
                    != Integer.valueOf(test.substring(6,7)).intValue()
        )         
        {
            resultat = false;
            erreur = "mauvaise clé";
        }
        else
        {
            resultat = true;
        }
        System.out.println(resultat + " : " + erreur);
        }
}
