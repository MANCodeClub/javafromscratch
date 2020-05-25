import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/* 
Cette application trop super permet de réviser les tables de multiplication.
Bon, il y a encore du boulot mais c'est déjà un début.
TODO: javadoc
TODO: on fait quoi avec les packages?
*/

public class Calculmental{

    static int NB_QUESTIONS = 3;

    public static void main(final String[] args) {
        System.out.println("Et c'est parti pour la grande révision des tables de multiplications!");
        Scores scores = new Scores();
        Scanner stdinSc = new Scanner(System.in);
        System.out.println("Quel est ton nom?");
        String userName = "JOHN DOE";
        userName = stdinSc.nextLine().toUpperCase();            

        Float userBestScore = scores.getScore(userName);

        boolean play_again = true;
        while(play_again){
            long startTime = System.currentTimeMillis();
            for ( int i = 1; i <= NB_QUESTIONS; i++ ){
                int a = ThreadLocalRandom.current().nextInt(2, 9 + 1);
                int b = ThreadLocalRandom.current().nextInt(2, 9 + 1);
                boolean is_resp_ok = false;
                while( ! is_resp_ok ){
                    System.out.print(a + " x " + b + " = ");
                    int resp;
                    try{
                        resp = stdinSc.nextInt();
                    }catch (Exception e){  // TODO: intercepter plus précisément l'exception.
                        stdinSc.next(); // il faut quand même manger la mauvaise 
                                        //valeur sinon on retombe toujours dessus
                        System.out.println("Vous devez saisir un nombre entier.");
                        continue;
                    }
                    if (resp != a * b){
                        System.out.println("INCORRECT! :-(");
                        continue;
                    }//if 
                    is_resp_ok = true;
                }// while ! is_resp_ok
            }// for NB_QUESTIONS

            long endTime = System.currentTimeMillis();
            float playDuration = (endTime - startTime) / 1000.0f;
            System.out.println("Durée: "+ playDuration);

            if (playDuration < userBestScore){
                System.out.println("Bravo tu as amélioré ton record précdent (" + userBestScore + "s).");
                userBestScore = playDuration;
                scores.update(userName, userBestScore);
            }
            scores.affiche_classement();
            System.out.println("Jouer encore? (oO/nN)");
            String continueAnser = stdinSc.next().toUpperCase();
            if ("N".equals(continueAnser)){
                play_again = false;
            }
        }//while play_again
        stdinSc.close();
    }//main
}//class
