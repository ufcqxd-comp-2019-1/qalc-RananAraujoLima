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
	            System.out.println("A expres�o:" + expressao + " Est� na linguagem ---->");
	        } else {
	            System.out.println("A expres�o:\" + expressao + \"N�o est� na linguagem ---->");
	        }
	        
	        
	        
	        System.out.println("BExpr -> bTermoS");
	        System.out.println("BExper� -> 'ou'btermo | null");
	        System.out.println("BTermo -> BFatorBtermo� ");
	        System.out.println("Btermo� -> 'e'BFator | null ");
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
	                if (BExpr�(exper)) {
	                    return true;
	                }
	                else {
	                    return false;
	                }
	            }
	            return false;
	        }

	        public static boolean BExpr�(String[] exper) {
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
	                if(BTermo�(exper)) {
	                    return true;
	                }
	            }
	            return false;
	        }

	        public static boolean BTermo�(String[] exper) {
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
	            if(exper[value].equals("�") ) {
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
	
