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
 File Filewrite = new File("TestVFINAL.txt");
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
        //ArrayList<String> com = new ArrayList<String>();
        //System.out.println(com);
        String [][] com = new String[4][16];
        int k = 0;
        //System.out.println(liste);
        while ((lineCom = inCom.readLine()) != null)
        {
        lineCom = lineCom.toUpperCase();
        lineCom = lineCom.strip();
        //com.add(((lineCom.split(";"))[0]));
        com[0][k]=(lineCom.split(";"))[0];
        com[1][k]=(lineCom.split(";"))[1];
        //Clé
        if (com[0][k].substring(0,2).equals("97"))
        {
            com[2][k] = com[0][k].substring(0,3);
        }
        else
        {
            com[2][k] = com[0][k].substring(0,2);
        }
        com[3][k] = dep.get((com[2][k]));

        System.out.println(com[0][k]);
        System.out.println(com[1][k]);
        System.out.println(com[2][k]);
        System.out.println(com[3][k]);
        k = k + 1;
        }
        inCom.close();



if (!Filewrite.exists())
     {
        Filewrite.createNewFile();
     }
     

     FileWriter fw = new FileWriter(Filewrite.getAbsoluteFile());
     BufferedWriter bw = new BufferedWriter(fw);

     for (int m = 0 ; m < 16 ; m=m+1) { 
     bw.write(com [0][m]);
     bw.write(";");
     bw.write(com [1][m]);
     bw.write(";");
     bw.write(com [2][m]);
     bw.write(";");
     bw.write(com [3][m]);
     bw.write("\n");
     }
     bw.close();
  
     System.out.println("Modification terminée!");

}
}
