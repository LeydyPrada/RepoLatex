package monoalfabetico;

public class CifradoMonoalfabetico {
	
	static String alfa ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String cifrarMonoalfabetico(String texto, String palabra) {
		
		String cadenaFinal = calcularAlfabeto(palabra);
		String mensaje = "";
		texto = texto.toUpperCase();
		
		char[] alfabetoCalculado = cadenaFinal.toCharArray();
		char[] entrada = texto.toCharArray();
		
		for(int i=0; i<entrada.length; i++) {
			String n = String.valueOf(entrada[i]);
			if(!n.equals(" ")) {
				int j = alfa.indexOf(n);
				mensaje+=alfabetoCalculado[j];
			}else {
				mensaje+=n;
			}
		}
		
		return mensaje;
	}
	
	public static String descifrarMonoalfabetico(String texto, String palabra) {
		
		String cadenaFinal = calcularAlfabeto(palabra);
		String mensaje = "";
		texto = texto.toUpperCase();
		
		char[] alfabetoCalculado = alfa.toCharArray();
		char[] entrada = texto.toCharArray();
		
		for(int i=0; i<entrada.length; i++) {
			String n = String.valueOf(entrada[i]);
			if(!n.equals(" ")) {
				int j = cadenaFinal.indexOf(n);
				mensaje+=alfabetoCalculado[j];
			}else {
				mensaje+=n;
			}
		}
		
		return mensaje;
	}

	private static String calcularAlfabeto(String palabra) {
		//Tomar palabra clave y quitar repetidos
		char[] cadena = palabra.toCharArray();
		String cadenaF = "";
        
		for(int i =0; i <cadena.length; i++) {
			if(i==0)
				cadenaF+=cadena[i];
			
			if(!cadenaF.contains(String.valueOf(cadena[i])))
				cadenaF+=cadena[i];
		}
		
		//generar matriz segun tamaño palabra clave sin repetidos (Sin ñ)
		cadenaF = cadenaF.toUpperCase();
		cadena = cadenaF.toCharArray();
		char[] alfabeto = alfa.toCharArray();
		
		for(int j = 0; j <alfabeto.length; j++) {
			if(!cadenaF.contains(String.valueOf(alfabeto[j])))
				cadenaF+=alfabeto[j];
		}
		char[] total = cadenaF.toCharArray();
		int div = total.length/cadena.length;
		
		int cont = 0;
		char[][] matriz = new char[div+1][cadena.length];
		
		for(int k=0;k<div+1;k++) {
			for(int l=0;l<cadena.length;l++) {
				if(cont<total.length) {
					if(!String.valueOf(total[cont]).equals(" ")) {
						matriz[k][l]=total[cont];
						cont++;
					}
				}else {
					break;
				}
			}
		}
		String cadenaFinal="";
		
		for (int x=0; x < cadena.length; x++) {
			 for (int y=0; y < div+1; y++) {
				 String m = String.valueOf(matriz[y][x]);
				 if(alfa.contains(m))
				 	cadenaFinal+=m;
			 }
		}
		return cadenaFinal;
	}

}
