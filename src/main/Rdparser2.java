package ufc.qxd.analisadorl2;


import java.util.Scanner;
import java.lang.String;

public class Rdparser2{

    public static Scanner scanner;

    public static int value = 0;
    public static String expressao;

    public static void main(String[] args) {

      

        expressao = "( NUML ) * ( NUML )";
        
        expressao = expressao + " $";
        String[] exper = expressao.split(" ");

        if (S(exper)) {
            System.out.println("A expres�o:" + expressao + " Est� na linguagem ---->");
        } else {
            System.out.println("A expres�o:\" + expressao + \"N�o est� na linguagem ---->");
        }
        System.out.println("E -> TE� ");
        System.out.println("E� -> +TE� | null");
        System.out.println("T -> FT�");
        System.out.println("T� -> *FB� | null");
        System.out.println("F -> (E)| NULM");
        System.out.println(" ");

    }

    public static boolean S(String[] exper) {
        if(E(exper)) {
            if(exper[value].equals("$")) {
                return true;
            }
        }
        return false;
    }

    public  static  boolean E(String[] exper) {
        if(T(exper)) {
            if (E�(exper)) {
                return true;
            }
        }
        return false;
    }

    public static boolean E�(String[] exper) {
        if(exper[value].equals("+")){
            value++;
            if (T(exper)) {
                if (E�(exper)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean T(String[] exper) {
        if(F(exper)) {
            if(T�(exper)) {
                return true;
            }
        }
        return false;
    }

    public static boolean T�(String[] exper) {
        if(exper[value].equals("*")){
            value++;
            if (F(exper)) {
                if (T�(exper)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static boolean F(String[] exper) {
        if (exper[value].equals("(")) {
            value++;
            if (E(exper)) {
                if(exper[value].equals(")")){
                    value++;
                    return true;
                }
            }
        }
        else if (exper[value].equals("NUML")){
            value++;
            return true;
        }
        return false;
    }


}