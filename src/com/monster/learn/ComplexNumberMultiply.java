package com.monster.learn;

public class ComplexNumberMultiply {

    //93.25%
    public String complexNumberMultiply(String a, String b) {
        
        String[] splitA = split(a);
        String[] splitB = split(b);
        int a1 =Integer.parseInt(splitA[0]);
        int a2 =Integer.parseInt(splitA[1]);
        int b1 =Integer.parseInt(splitB[0]);
        int b2 =Integer.parseInt(splitB[1]);

        int c1 = a1 * b1 - a2 * b2 ;
        int c2 = a1 * b2 + a2 * b1;
        StringBuilder sb = new StringBuilder();
        sb.append(c1);
        sb.append("+");
        sb.append(c2).append("i");
        return  sb.toString();
        
    }


    public static String[] split(String expr){
        // endsWith
        if(expr.endsWith("i")){
            expr = expr.substring(0, expr.length()-1);
        }
        return expr.split("\\+");   
    }

}
