package main;


import java.io.IOException;
import java.util.Scanner;

import ceaser.CifradoCesar;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String texto;
        int codigo;
        char opcion;
        //Introducir un texto
        do {
            System.out.print("Introduce un texto: ");
            texto = sc.nextLine();
        } while (texto.isEmpty());
        //Introducir el valor del desplazamiento
        do {
            System.out.print("Introduce el c�digo: ");
            codigo = sc.nextInt();
        } while (codigo < 1);
        //Introducir la operaci�n a realizar: cifrar o descifrar
        do {
            sc.nextLine();
            System.out.print("(C) cifrar o (D) descifrar?: ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + CifradoCesar.cifradoCesar(texto, codigo));
        } else {
            System.out.println("Texto descifrado: " + CifradoCesar.descifradoCesar(texto, codigo));
        }
    }
	
}
