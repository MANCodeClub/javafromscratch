/*
Ce programme doit deviner le nombre auquel vous pensez.

Vous choisissez un nombre en 1 et 100.
Vous lancer le programme.
Il vous propose des nombres et vous lui répondez si votre nombre est plus grand (+), plus petit (-) ou s'il a gagné (=).

Votre programme doit trouver la solution le plus rapidement possible par dichotomie.
C'est à dire qu'il propose toujours un nombre a peu près au milieu de l'intervalle possible.

exemple:
50? (milieu de l'intervalle 1-100)
-
25? (milieu de l'intervalle 1-49)
- 
12? +
18? -
15? -
13? +
14? =
Super! J'ai gagné!
*/
import java.util.Scanner;


public class Exo008_V0 {

    public static void main(String[] args) {
        int min = 0;
        int max = 100; // ou 101 pour arriver à 100
        String consigne_reponse = "";
        int nbreCherche = 50;
        System.out.println("Choisissez un nombre en 1 et 99");
        while (!consigne_reponse.equals("="))
        {
            nbreCherche = (min + max)/2;
            Scanner consigne = new Scanner(System.in);
            System.out.println("Alors, le nombre cherché est " + nbreCherche + " ? ou + grand, - grand, = exact ");
            consigne_reponse = consigne.nextLine();                

            if (consigne_reponse.equals("+"))
            {
                min = nbreCherche;
            }
            else if (consigne_reponse.equals("-"))
            {
                max = nbreCherche;
            }
        }
        System.out.println("Alors, le nombre cherché est donc " + nbreCherche + "\n" + "Super! J'ai gagné!");
    }
}
