package com.Jsons;
import java.util.Scanner;

public class MainMenu {
	private static void sc(String cadena) {
        System.out.println(cadena);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        JsonEjemplo obj = new JsonEjemplo(); 
        sc("Seleccione una operación a realizar");
        sc("1. Leer archivo JSON.");
        sc("2. Escribir al archivo JSON.");
        int op = sc.nextInt();
        sc.nextLine(); 

        switch(op){
            case 1:
                obj.lecturaJSON();
                break;
            case 2:
                obj.escribirJSON(sc); 
                break;
            default:
            	sc("Operación no válida.");
        }

        sc.close();

	}

}
