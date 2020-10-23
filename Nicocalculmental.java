import java.util.Scanner;
public class Nicocalculmental {
    public static void main(String[] args) {
        System.out.println("Quel est ton prénom ?");
        Scanner sc = new Scanner(System.in);
        String prenom = sc.nextLine();
        System.out.println("Bonjour "+ prenom +" ,Révisons les tables de multiplication!");

        char rejouer ='O';

        while (rejouer == 'O')
            {
            int reussite = 0;
            int echec = 0;
            for (int i = 1; i<= 3; i++)
                {
                int multiA = (int)(java.lang.Math.random() * 10);
                int multiB = (int)(java.lang.Math.random() * 10);
                System.out.println("combien font " + multiA + " X " + multiB + "?" );
                int reponse = sc.nextInt();
                int resutat = multiA * multiB;
                
                if (reponse == resutat)
                    {
                        System.out.println("Bravo");
                        reussite = reussite + 1;

                    }
                else
                    {
                        System.out.println("Mauvais Resultat");
                        echec = echec + 1;
                    }
                }
            int essai = echec + reussite;
            System.out.println("Votre score : " + reussite + "/" + essai);
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Rejouer (O/N) ?"); // j'ai été containt de créer sc1 ; en reprenant sc, je n'avais pas la main pour répondre à la question
            rejouer = sc1.nextLine().charAt(0);
            }
        System.out.println("Au revoir "+ prenom);
    }
}