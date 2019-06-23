import java.util.Scanner;
public class MemTest {
	
	private static Scanner keyb = new Scanner(System.in);
	public static void main(String[] args) {
		String nombre;
		byte baseNombre;
		byte baseConversion;
		boolean verification = false; // Vérifie si la base est bien 2,8,10 ou 16
       
    	System.out.print("Entrez le nombre a convertir: ");
    	nombre = keyb.nextLine().toUpperCase();
    	System.out.print("Entrez la base du nombre a convertir: ");
    	baseNombre = keyb.nextByte();
  
        do {
	        System.out.print("Entrez la base dans laquelle il doit être convertit: ");
	        baseConversion = keyb.nextByte();
	        switch (baseConversion) {
	        	case 2:
	        		verification = true;
	        		break;
	        	case 8:
	        		verification = true;
	        		break;
	        	case 10:
	        		verification = true;
	        		break;
	        	case 16:
	        		verification = true;
	        		break;
	        	default:
	        		System.out.println("Base inconnue, veuillez choisir parmi les bases suivantes [2,8,10,16] !");
	        			
	        }
        }while (!verification);
        
        if(baseConversion == 10) {
        	System.out.println("La conversion de "+nombre+" de la base "+baseNombre+" vers la base "+baseConversion+" est égale à : "+conversionEnBaseDix(nombre, baseNombre));
        } else {
        	System.out.println("La conversion de "+nombre+" de la base "+baseNombre+" vers la base "+baseConversion+" est égale à : "+autreConversion(nombre, baseConversion, baseNombre));
        }
    }

	//Prend en entrer un nombre et retourne le charactère correspondant
	static char chiffre(int n) {
	        String  alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        return alphaNumeric.charAt(n);
	}
	//Prend en entrer un charactère et retourne le nombre correspondant
	static int nombre(char ch) {
	        String  alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        return alphaNumeric.indexOf(ch);
	}
	//Pour les conversions en base 10
	static int conversionEnBaseDix(String nombre, int base) {
		int entier = 0;
		int exp = nombre.length() - 1;
		for(int i = 0; i < nombre.length(); i++) {
            entier += nombre(nombre.charAt(i)) * Math.pow(base, exp);
            exp--;
		}
		return entier;
	}
	//Pour les conversoins en base 2,8,16
	static StringBuffer autreConversion(String nombre, int baseConvertion, int baseNombre) {
		int nombre2 = conversionEnBaseDix(nombre,baseNombre);
		String chaine = "";
		while(nombre2 != 0){
			chaine += chiffre(nombre2 % baseConvertion);
			nombre2 = nombre2 / baseConvertion;
		}
        StringBuffer sb = new StringBuffer(chaine).reverse();
        return sb;
	}
}























