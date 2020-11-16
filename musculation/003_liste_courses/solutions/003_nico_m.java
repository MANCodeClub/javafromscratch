import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadTextFile
{
	public static void main (String[] args) throws IOException
		{
			BufferedReader in = new BufferedReader(new FileReader("C:/Mes_Auto_Formations/java/musculation/ex003/liste_avec_doublons.txt"));
			String line;
            //String liste [] = new String[10];
            List<String> liste = new ArrayList<String>();
            System.out.println(liste);
			while ((line = in.readLine()) != null)
			{
		      // Afficher le contenu du fichier
                line = line.toUpperCase();
                line = line.strip();
                //System.out.println (line);
                //String tab[]= {line};
                //System.out.println (tab[0]);
                if (liste.contains(line))
                {
                    break;
                }
                else
                {
                    liste.add(line);
                }


            }
            System.out.println(liste);
			in.close();
        }
}
