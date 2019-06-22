import java.util.Scanner;
public class MemTest {
	
	private static Scanner keyb = new Scanner(System.in);
	public static void main(String[] args) {
		int nombre;
		byte baseNombre;
		byte baseConversion;
		boolean verification = false; // Vérifie si la base est bien 2,8,10 ou 16
       
        do {
        	System.out.print("Entrez le nombre a convertir: ");
        	nombre = keyb.nextInt();
        	System.out.print("Entrez la base du nombre a convertir: ");
        	baseNombre = keyb.nextByte();
        }while(nombre < 0);
        
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
        	System.out.println(conversionEnBaseDix(nombre, baseNombre));
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
	/*static int lire_repr(String chaine, int base) {
	        int entier = 0;
	        int exp = chaine.length() - 1;
	        for(int i = 0; i < chaine.length(); i++) {
	                entier += nombre(chaine.charAt(i)) * Math.pow(base, exp);
	                exp--;
	        }
	        return entier;
	}*/
	
	static int conversionEnBaseDix(int nombre, int base) {
		int entier = 0;
		String sx = ""+nombre;  // convertit mon int en String
		int exp = sx.length() - 1;
		for(int i = 0; i < sx.length(); i++) {
            entier += nombre(sx.charAt(i)) * Math.pow(base, exp);
            exp--;
		}
		return entier;
	}
	//Pour les conversoins en base 2,8,16
	static StringBuffer repr_nombre(int nombre, int base) {
	        String chaine = "";
	        while(nombre != 0){
	                chaine += chiffre(nombre % base);
	                nombre = nombre / base;
	        }
	         StringBuffer sb = new StringBuffer(chaine).reverse();
	        return sb;
	}
}