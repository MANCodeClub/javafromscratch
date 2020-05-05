import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Cette application trop super permet de réviser les tables de multiplicatio.
Bon, il y a encore du boulot mais c'est déjà un début.
TODO: javadoc
TODO: on fait quoi avec les packages?
*/

public class Calculmental{

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

        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Nicolas", 10);
        scores.put("Charlotte", 50);
        scores.put("Ben", 5);

        affiche_classement(scores);
    }
}

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

