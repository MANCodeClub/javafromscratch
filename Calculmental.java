import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/* 
Cette application trop super permet de réviser les tables de multiplicatio.
Bon, il y a encore du boulot mais c'est déjà un début.
TODO: javadoc
TODO: on fait quoi avec les packages?
*/

public class Calculmental{

    static int NB_QUESTIONS = 3;

    private static void affiche_classement(final Map<String, Integer> scores) {
        int classement = 1;
        TreeMap<String, Integer> scoresTries = new TreeMap<String, Integer>(scores);
        for (Map.Entry<String, Integer> entry : scoresTries.entrySet()){
            System.out.println(classement + " : " + entry.getKey() + " : " + entry.getValue());
            classement ++;
        }
    }
    public static void main(final String[] args) {
        System.out.println("Hello world");
/*
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Nicolas", 10);
        scores.put("Charlotte", 50);
        scores.put("Ben", 5);

        affiche_classement(scores);
*/
        boolean play_again = true;
        Scanner keyboard = new Scanner(System.in);
        while(play_again){
            for ( int i = 1; i <= NB_QUESTIONS; i++ ){
                int a = ThreadLocalRandom.current().nextInt(2, 9 + 1);
                int b = ThreadLocalRandom.current().nextInt(2, 9 + 1);
                boolean is_resp_ok = false;
                while( ! is_resp_ok ){
                    System.out.print(a + " x " + b + " = ");
                    int resp = keyboard.nextInt();
                    if (resp != a * b){
                        System.out.println("ERREUR! :-(");
                    }else{
                        is_resp_ok = true;
                    }//if 
                }// while ! is_resp_ok
            }// for NB_QUESTIONS
            System.out.println("Play again?");
            
        }//while play_again
        keyboard.close();
    }
}
/*
import java.util.*;
public class utilitaireMap{
    public static > Map sortByValue( Map map ) {
        //On crée la liste à partir des entrées de la map
        List> liste =
        new LinkedList>( map.entrySet() );
        Collections.sort( liste, new Comparator>()
    {
 //Fonction de comparaison qui compare entres elles les valeurs de chaque entrée
 @Override
 public int compare( Map.Entry entree1, Map.Entry entree2 )
 {
 //Le tri se fait dans l'ordre ascendant. Il faut modifier cette ligne
 //si vous souhaitez changer l'ordre de tri
 return (entree1.getValue()).compareTo(entree2.getValue());
 }
 } );
 //Une fois le tri terminé, on crée une map dans laquelle on insère les entrées triées,
 //puis on la retourne
 Map resultat = new LinkedHashMap();
 for (Map.Entry entree : liste)
 {
 resultat.put(entree.getKey(), entree.getValue());
 }
 return resultat;
 }
}
*/
