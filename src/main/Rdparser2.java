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
            System.out.println("A expresão:" + expressao + " Está na linguagem ---->");
        } else {
            System.out.println("A expresão:\" + expressao + \"Não está na linguagem ---->");
        }
        System.out.println("E -> TEº ");
        System.out.println("Eº -> +TEº | null");
        System.out.println("T -> FTº");
        System.out.println("Tº -> *FBº | null");
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
            if (Eº(exper)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Eº(String[] exper) {
        if(exper[value].equals("+")){
            value++;
            if (T(exper)) {
                if (Eº(exper)) {
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
            if(Tº(exper)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Tº(String[] exper) {
        if(exper[value].equals("*")){
            value++;
            if (F(exper)) {
                if (Tº(exper)) {
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