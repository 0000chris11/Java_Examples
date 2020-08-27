package Basic;

import java.util.Scanner;
public class DatosP_I {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//declaracion
		//int i;
		//asignarle
		//i = 3;
		
		//Datos primitivos
		boolean valor = 0==2; // V/F 1 bit
		byte numero1 = 127; //8 bits
		short numero2 = (short) 32767; // 16 bits
		int numero3 = 2147483647; // 32 bits
		long numero4 = 2147483647; // 64 bits
		float numero5 = (float) 45.5; // decimales 32 bits
		double numero6 = 89.56; //decimales 64 bits
		double pi = Math.PI;
		System.out.println(pi);
		char caracter = 'a'; // Unicode 16 bits
		
		
		//Datos no primitivos
		String nom = "Jose";
		String otra = nom.concat(" perez");
		System.out.println(otra);
		
		Integer numero10 = 10;
		
	}
	
}
