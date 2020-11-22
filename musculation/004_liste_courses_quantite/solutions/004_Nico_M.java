import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;//pour un dictionnaire!
import java.util.*; 


public class ReadTextFile
{
	public static void main (String[] args) throws IOException
		{
			BufferedReader in = new BufferedReader(new FileReader("C:/Mes_Auto_Formations/java/musculation/ex004/liste_avec_doublons.txt"));
			String line;
            Map<String, Integer> dictionnaire = new TreeMap<String, Integer>();
            while ((line = in.readLine()) != null)

			{
		      // Afficher le contenu du fichier
                line = line.toUpperCase();
                line = line.trim();
                line = line.replace("  "," ");
                line = line.replace(" :",":");
                line = line.replace(": ",":");
                line = line.replace(" : ",":");
                String listeSplit[] ;
                if (line.contains(":"))
                {
                    listeSplit = line.split(":");
                }
                else 
                {
                    continue;
                }
                if (dictionnaire.containsKey(listeSplit[0]))
                {
                    dictionnaire.replace(listeSplit[0], dictionnaire.get(listeSplit[0])+Integer.valueOf((listeSplit[1])));
                }
                else
                {
                    dictionnaire.put(listeSplit[0], Integer.valueOf((listeSplit[1])));
                }
            }
        System.out.println(dictionnaire);
        }

}
