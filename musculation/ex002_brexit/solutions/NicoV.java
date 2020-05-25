package musculation.ex002_brexit.solutions;

import musculation.ex002_brexit.Ex002;

public class NicoV implements Ex002{

    @Override
    public String makeFlag(Integer t){
        String baseLine = "|"+ "X".repeat(t)+" "+"X".repeat(t)+"|";
        String[] strips = new String[2*t+1];
        for (int i=0; i<t; i++){
            char[] line = baseLine.toCharArray();
            line[1+i] = ' ';
            line[1+2*t-i] = ' ';
            strips[i] = String.valueOf(line);
            strips[2*t-i] = String.valueOf(line);
        }
        strips[t] = "|" + " ".repeat(2*t+1) + "|";
        String result = String.join("\n", strips) + "\n";
        //System.out.println(result);
        return result;

    }
    
}