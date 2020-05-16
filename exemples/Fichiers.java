package exemples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fichiers {

    public static String filePath = "./test.txt";

    public static void useFileReader(){
        // Write the content in file 
        // note NVI: le try avec ressource s'assure que le fichier sera bien refermé.
        try(FileWriter fileWriter = new FileWriter(filePath)) {
            String fileContent = "This is a sample text.";
            fileWriter.write(fileContent);
        } catch (IOException e) {
            // Cxception handling
        }
        
        // lit de contenu du fichier caractère par caractère
        try(FileReader fileReader = new FileReader(filePath)){
            ;
            int ch;
            do{
                ch = fileReader.read();
                System.out.print((char)ch);
            } while(ch != -1);
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
    }

    public static void useBufferReader(){
        // Write the content in file 
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            String fileContent = "This is a sample text.";
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
        }

        // Read the content from file
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }

    }


    public static void main(final String[] args){
        // ecrire sur stdout
        System.out.println("Tapez un entier:"); 

        // lire stdin
        Scanner stdin = new Scanner(System.in);
        int resp = stdin.nextInt(); /* voir la doc complete */
        stdin.close();

        // ecrire dans un fichier texte
        try(FileWriter fileWriter = new FileWriter("file_path.txt")){
            fileWriter.write(Integer.toString(resp));
        }catch (Exception e){
            //TODO: handle exception
        }

        String line = "";
        // lire dans un fichier texte
        try (Scanner fileReader = new Scanner(new File("file_path.txt"))){
            line = fileReader.nextLine();
        } catch (Exception e) {
            //TODO: handle exception
        }

        System.out.println("["+line+"]");
        // utilisation des fichiers non texte
        //useFileReader();
        //useBufferReader();
    }
}