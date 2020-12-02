import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class EXO_006_VFIN {
 public static void main(String[] args) {
 File Filewrite = new File("TestVFIN.txt");
 String fileNewLireDep = "C:/Mes_Auto_Formations/java/musculation/ex006/departement.txt";
 String fileNewLireCom = "C:/Mes_Auto_Formations/java/musculation/ex006/communes.csv";

    try {
    BufferedReader inDep = new BufferedReader(new FileReader(fileNewLireDep));
    String lineDep;
    //String liste [] = new String[10];
    String [] dep = {};
    String [][] depTx = new String[3][101];
    int k = 0;
    //System.out.println(liste);
    while ((lineDep = inDep.readLine()) != null)
    {
        // Afficher le contenu du fichier
        lineDep = lineDep.toUpperCase();
        lineDep = lineDep.strip();
        dep = lineDep.split(" - ");
        depTx [0][k] = dep[0];
        depTx [1][k] = dep[1];
        depTx [2][k] = dep[2];

        System.out.println("clé dep : " + depTx[0][k]);
        System.out.println(depTx[1][k]);
        System.out.println(depTx[2][k]);
        k =  k + 1;
    }
    inDep.close();

        BufferedReader inCom = new BufferedReader(new FileReader(fileNewLireCom));
        String lineCom;
        //String liste [] = new String[10];
        String [] com = {};
        String [][] comTx = new String[4][16];
        int l = 0;
        //System.out.println(liste);
        while ((lineCom = inCom.readLine()) != null)
        {
            // Afficher le contenu du fichier
            lineCom = lineCom.toUpperCase();
            lineCom = lineCom.strip();
            com = lineCom.split(";");
            comTx [0][l] = com[0];
            comTx [1][l] = com[1];
            //Clé
            if (com[0].substring(0,2).equals("97"))
            {
                comTx [2][l] = com[0].substring(0,3);
            }
            else
            {
                comTx [2][l] = com[0].substring(0,2);
            }
            System.out.println(comTx[0][l]);
            System.out.println(comTx[1][l]);
            System.out.println("clé com : " + comTx[2][l]);
            l =  l + 1;
        }
        inCom.close();

    
        for (int i = 0 ; i < 16 ; i=i+1) {
            for (int j = 0 ; j < 101 ; j=j+1)
                if (depTx [0][j].equals(comTx [2][i]))
                {
                    comTx [3][i] = depTx [1][j];
                }
                else
                {
                    continue;
                }
        System.out.println(comTx [0][i]);
        System.out.println(comTx [1][i]);
        System.out.println(comTx [2][i]);
        System.out.println(comTx [3][i]);
        System.out.println("Fin");
        }
  
     //String content = "Ceci est le contenu ajouté au fichier";
  
  
     // créer le fichier s'il n'existe pas
     if (!Filewrite.exists())
     {
        Filewrite.createNewFile();
     }
  
     FileWriter fw = new FileWriter(Filewrite.getAbsoluteFile());
     BufferedWriter bw = new BufferedWriter(fw);
     for (int m = 0 ; m < 16 ; m=m+1) { 
     bw.write(comTx [0][m]);
     bw.write(";");
     bw.write(comTx [1][m]);
     bw.write(";");
     bw.write(comTx [2][m]);
     bw.write(";");
     bw.write(comTx [3][m]);
     bw.write("\n");
     }
     bw.close();
  
     System.out.println("Modification terminée!");
  
    } catch (IOException e) {
     e.printStackTrace();
    }
}
}
