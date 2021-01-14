import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class EXO_009_V2 {
 public static void main(String[] args) throws IOException {
 File Filewrite = new File("TestVFINAL_00.txt");
 String fileNewLireMantis = "C:/Mes_Auto_Formations/java/musculation/ex009/mantis.csv";
BufferedReader inMantis = new BufferedReader(new FileReader(fileNewLireMantis));
String lineMantis;
List<String> lines = Files.readAllLines(Paths.get("C:\\Mes_Auto_Formations\\java\\musculation\\ex009\\mantis.csv"));
int size = lines.size();
String [][] uniteMulti = new String[size][];
        for (int i = 0; i < size; i++)
        {

            lineMantis = inMantis.readLine();
            uniteMulti[i] = (lineMantis.split(",",-1));
        }
        inMantis.close();
    
        if (!Filewrite.exists())
        {
           Filewrite.createNewFile();
        }
        
   
        FileWriter fw = new FileWriter(Filewrite.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
   
        for (int i = 0 ; i < size ; i++) { 
        bw.write(uniteMulti [i][0]);
        bw.write(";");
        bw.write(uniteMulti [i][2]);
        bw.write(";");
        bw.write(uniteMulti [i][3]);
        bw.write(";");
        bw.write(uniteMulti [i][1]);
        bw.write("\n");
        }
        bw.close();
     
        System.out.println("Modification terminée!");

    }
}
