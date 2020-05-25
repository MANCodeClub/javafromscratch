package musculation.ex001_decalage;

public interface Ex001 {
    /** Cette fonction retourne true si la chaine s2 est égale à la chaine s1 décalé d'un caractère vers la droite
    Elle retourne false sinon.
    Ex: s1 = "azerty", s2="zertya" => true
        s1 = "azerty", s2="azert" => false """
    */
    public boolean isShifted(String a, String b);
}