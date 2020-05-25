package musculation.ex002_brexit;

import java.lang.reflect.InvocationTargetException;

public class Test002 {

    static Ex002 solver;

    private static Integer test(Integer t, String result) {
        if (result.equals(solver.makeFlag(t))){
            System.out.println("["+t+"] :Ok");
            return 0;
        }else{
            System.out.println("["+t+"] : devrait retourner \n"+ result);
            return 1;
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // en paramètre, le nom de la classe à tester.
        if (args.length != 1) {
            System.out.println("Vous devez fournir le nom d'une classe à tester en argument.");
            return;
        }
        String className = "musculation.ex002_brexit.solutions." + args[0];
        System.out.println("Test de la classe " + className);
        try {
            solver = (Ex002) Class.forName(className).getDeclaredConstructor(new Class[] {})
                    .newInstance(new Object[] {});
        } catch (ClassNotFoundException e) {
            System.out.println("On a pas trouvé la classe (compilée) " + className);
            return;
        }
        Integer nbErrors = 0;
        nbErrors += test(0,"| |\n");
        String flag1 = "|   |\n"+
                       "|   |\n"+
                       "|   |\n";
        nbErrors += test(1, flag1);
        String flag2 = "| X X |\n"+
                       "|X   X|\n"+
                       "|     |\n"+
                       "|X   X|\n"+
                       "| X X |\n";
        nbErrors += test(2,flag2);
        String flag4 = 
        "| XXX XXX |\n"+
        "|X XX XX X|\n"+
        "|XX X X XX|\n"+
        "|XXX   XXX|\n"+
        "|         |\n"+
        "|XXX   XXX|\n"+
        "|XX X X XX|\n"+
        "|X XX XX X|\n"+
        "| XXX XXX |\n";
        
        nbErrors += test(4, flag4);

        System.out.println(nbErrors + " Erreurs!");
    }
}