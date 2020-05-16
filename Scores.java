import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Scores {
    List<UserInfo> usersList;
    Map<String, UserInfo> usersDict;
    String scoreFilePath;
    
    public Scores() {
        usersList = new ArrayList<UserInfo>();
        usersDict = new HashMap<String, UserInfo>();
        scoreFilePath = "scores.txt";
        load();
    }
    
    private void load(){
        usersDict.clear();
        try(Scanner scoreSc = new Scanner(new File(scoreFilePath))){
            // définir les séparateurs : et \n au scanner
            scoreSc.useDelimiter("[:\\n]");
            while(scoreSc.hasNext()){
                String[] lineItems = scoreSc.nextLine().split(":");
                String name = lineItems[0];
                Float score = Float.valueOf(lineItems[1]);
                usersDict.put(name, new UserInfo(name, score));
            }
        } catch (Exception e) {
            System.out.println("Le fichier des records n'a pas pu être lu correctement");
        }
    }
    public void affiche_classement() {
        List<UserInfo> userList = new ArrayList<>(usersDict.values());
        userList.sort(Comparator.comparing(UserInfo::getScore));

        int i = 1;
        for (UserInfo userInfo : userList){
            System.out.println((i+1) + ". " + userInfo.getName() + "\t" + userInfo.getScore());
            i++;
        }
    }

    public void update(String name, Float score){
        usersDict.put(name, new UserInfo(name,score));
        this.save();
    }

    private void save(){
        try(FileWriter scoreFileW = new FileWriter(new File(scoreFilePath))){
            for (Map.Entry<String, UserInfo> entry : usersDict.entrySet()){
                scoreFileW.write(entry.getKey()+":"+entry.getValue()+"\n");
            }
        } catch (Exception e) {
            System.out.println("Le fichier des records n'a pas pu être écrit correctement");
        }
    }

    public Float getScore(String name){
        if (usersDict.keySet().contains(name)){
            return usersDict.get(name).getScore();
        }else{
            return 999.99f;
        }
    }
}