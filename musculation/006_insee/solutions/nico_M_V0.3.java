import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Map;//pour un dictionnaire!
import java.util.*;


public class EXO_006_VFIN {
 public static void main(String[] args) throws IOException {
 File Filewrite = new File("TestVFINAL6.txt");
 String fileNewLireDep = "C:/Mes_Auto_Formations/java/musculation/ex006/departement.txt";
 String fileNewLireCom = "C:/Mes_Auto_Formations/java/musculation/ex006/communes.csv";
        BufferedReader inDep = new BufferedReader(new FileReader(fileNewLireDep));
        String lineDep;
        Map<String, String> dep = new TreeMap<String, String>();
        String [][] depTx = new String[3][101];
        while ((lineDep = inDep.readLine()) != null)
        {
            // Afficher le contenu du fichier
            lineDep = lineDep.toUpperCase();
            lineDep = lineDep.strip();
            dep.put((lineDep.split(" - "))[0],((lineDep.split(" - "))[1]));
        }
        inDep.close();
        System.out.println(dep);
        BufferedReader inCom = new BufferedReader(new FileReader(fileNewLireCom));
        String lineCom;
        Map<String, String> com = new TreeMap<String, String>();
        //String liste [] = new String[10];
        //ArrayList com = new ArrayList();
        System.out.println(com);
        String [][] comTx = new String[4][16];
        int l = 0;
        //System.out.println(liste);
        while ((lineCom = inCom.readLine()) != null)
        {
            // Afficher le contenu du fichier
            lineCom = lineCom.toUpperCase();
            lineCom = lineCom.strip();
            //System.out.println(lineCom.split(";"));
            com.put((lineCom.split(";"))[0],((lineCom.split(";"))[1]));
            //Arrays.sort(com);
        }
        System.out.println(com);
        String comTxMap [][] = new String [4][16];
        int i = 0;
        Set<String> keys = com.keySet();
        for(String key: keys)
        {
            comTxMap[0][i] = key;
            comTxMap[1][i] = com.get(key);
            //Clé
            if (key.substring(0,2).equals("97"))
            {
                comTxMap[2][i] = key.substring(0,3);
            }
            else
            {
                comTxMap[2][i] = key.substring(0,2);
            }
            comTxMap[3][i] = dep.get((comTxMap[2][i]));
            System.out.println(comTxMap[0][i]);
            System.out.println(comTxMap[1][i]);
            System.out.println(comTxMap[2][i]);
            System.out.println(comTxMap[3][i]);
            i = i + 1;

        }

if (!Filewrite.exists())
     {
        Filewrite.createNewFile();
     }
     

     FileWriter fw = new FileWriter(Filewrite.getAbsoluteFile());
     BufferedWriter bw = new BufferedWriter(fw);

     for (int j = 0 ; j < 16 ; j=j+1) { 
     bw.write(comTxMap [0][j]);
     bw.write(";");
     bw.write(comTxMap [1][j]);
     bw.write(";");
     bw.write(comTxMap [2][j]);
     bw.write(";");
     bw.write(comTxMap [3][j]);
     bw.write("\n");
     }
     bw.close();
  
     System.out.println("Modification terminée!");

}
}
