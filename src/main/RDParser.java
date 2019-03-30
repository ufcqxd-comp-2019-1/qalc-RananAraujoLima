package ufc.qxd.analisadorl1;

import java.util.Scanner;

public class RDParser {

	public static Scanner scanner;

	public static int value = 0;
	public static String expressao;

	public static void main(String[] args) {
		

	        
	        expressao = "( ( T | T ) | ( F | F ) )";
	        expressao = expressao + " $";
	        String[] exper = expressao.split(" ");
	

	        if (Inicio(exper)) {
	            System.out.println("A expresão:" + expressao + " Está na linguagem ---->");
	        } else {
	            System.out.println("A expresão:\" + expressao + \"Não está na linguagem ---->");
	        }
	        
	        
	        
	        System.out.println("BExpr -> bTermoS");
	        System.out.println("BExperº -> 'ou'btermo | null");
	        System.out.println("BTermo -> BFatorBtermoº ");
	        System.out.println("Btermoº -> 'e'BFator | null ");
	        System.out.println("BFator -> 'not' BFator| (BExpr)|'V' | 'F'");

	        System.out.println("");

	    }

	        public static boolean Inicio(String[] exper){
	            if(BExpr(exper)) {
	                if(exper[value].equals("$")) {
	                    return true;
	                }
	            }
	            return false;
	        }

	        public  static  boolean BExpr(String[] exper) {
	            if(BTermo(exper)) {
	                if (BExprº(exper)) {
	                    return true;
	                }
	                else {
	                    return false;
	                }
	            }
	            return false;
	        }

	        public static boolean BExprº(String[] exper) {
	            if(exper[value].equals("|")){
	                value++;
	                if (BTermo(exper)) {
	                    return true;
	                }
	                else {
	                    return false;
	                }
	            }
	            return true;
	        }

	        public static boolean BTermo(String[] exper) {
	            if(BFator(exper)) {
	                if(BTermoº(exper)) {
	                    return true;
	                }
	            }
	            return false;
	        }

	        public static boolean BTermoº(String[] exper) {
	            if(exper[value].equals("&")){
	                value++;
	                if (BFator(exper)) {
	                    return true;
	                }
	                else {
	                    return false;
	                }
	            }
	            return true;
	        }


	        public static boolean BFator(String[] exper) {
	            if(exper[value].equals("¬") ) {
	                value++;
	                if (BFator(exper)) {
	                    return true;
	                }
	            }
	            else if (exper[value].equals("(")) {
	                value++;
	                if (BExpr(exper)) {
	                    if(exper[value].equals(")")){
	                        value++;
	                        return true;
	                    }
	                }
	            }
	            else if (exper[value].equals("T")){
	                value++;
	                return true;
	            }

	            else if (exper[value].equals("F")){
	                value++;
	                return true;
	            }
	            return false;
	        }


	    }
	
