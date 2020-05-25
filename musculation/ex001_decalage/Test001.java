package musculation.ex001_decalage;

import java.lang.reflect.InvocationTargetException;

public class Test001 {

    static Ex001 solver;

    private static Integer test(String a, String b, boolean result) {
        if (solver.isShifted(a, b) == result){
            System.out.println("["+a+"] ["+b+"] :Ok");
            return 0;
        }else{
            System.out.println("["+a+"] ["+b+"] : devrait retourner "+ result);
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
        String className = "musculation.ex001_decalage.solutions." + args[0];
        System.out.println("Test de la classe " + className);
        try {
            solver = (Ex001) Class.forName(className).getDeclaredConstructor(new Class[] {})
                    .newInstance(new Object[] {});
        } catch (ClassNotFoundException e) {
            System.out.println("On a pas trouvé la classe (compilée) " + className);
            return;
        }
        Integer nbErrors = 0;
        nbErrors += test("","",false);
        nbErrors += test("","a", false);
        nbErrors += test("a","a", true);
        nbErrors += test("ab", "ba", true);
        nbErrors += test("abcde", "eabcd", true);
        nbErrors += test("abcde", "abcde", false);
        nbErrors += test("abcde", "eabcde", false);

        System.out.println(nbErrors + " Erreurs!");
    
    }
}