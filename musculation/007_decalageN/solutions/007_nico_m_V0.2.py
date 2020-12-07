/*
Dans l'exercice 001 il fallait déterminer si une chaine était décalé d'un caractère par rapport à une autre.
Ici on va chercher si deux chaines sont décalées l'une par rapport à l'autre et retourner le nombre de caractère de décalage.

exemples:
"AZERTY" "YAZERT" => décalage 1
"AZERTY" "TYAZER" => décalage 2
"AZERTY" "ZERTYA" => décalage 5

Le décalage est déplacement de la seconde chaine par rapport à la première vers la droite.

S'il n'est pas possible d'obtenir la nouvelle chaine par décalage de la première on retourne -1.

exemple:
"AZERTY" "UIOP" => décalage -1 

décale de N jusqu'a que ça marche!


*/
import java.util.Scanner;


public class EXO_007 {
 public static void main(String[] args) {

    String mot_1;
    String mot_2;
    Scanner scmot = new Scanner(System.in);
    System.out.println("Quel est ton premier mot?");
    mot_1 = scmot.nextLine();
    System.out.println("Quel est ton second mot?");
    mot_2 = scmot.nextLine();                
    //System.out.println("Ton premier mot, c'est : " + mot_1 + "\n" + "Ton second mot, c'est : " + mot_2);
    Decal (mot_1,mot_2);
    }

    public static boolean Decal(String s1, String s2) {
        boolean resultat = false ;
        int decalage = 0;
        int tailleMot = s1.length();
        for (int i = 0 ; i < tailleMot ; i++)
            {       
            if (s2.equals(s1.substring(i, tailleMot) + s1.substring(0, i))) // décalage
    
                {
                    resultat = true;
                    decalage = i;
                    break;
                }
            else
                {
                    continue;
                }
            }
        if (resultat == true)
        {
            System.out.println("le mot "+ s1 +" est décalé de " + s2 + " avec un décalage de " + decalage + " caractère(s)");

        }
        else
        {
            System.out.println("le mot "+ s1 +" ne peut être décalé pour obtenir " + s2);

        }
        return resultat;
    }
 }
