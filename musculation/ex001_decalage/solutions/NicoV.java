package musculation.ex001_decalage.solutions;

import musculation.ex001_decalage.Ex001;

public class NicoV implements Ex001 {

    @Override
    public boolean isShifted(String a, String b){
        if (a.length() != b.length() || a.length() == 0){
            return false;
        }
        if (b.equals(a.substring(a.length()-1) + a.substring(0, a.length()-1))){
            return true;
        }
        return false;
    }

}