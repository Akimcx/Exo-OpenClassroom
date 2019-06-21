
public class MemTest {

	public static void main(String[] args) {
		//String  alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		System.out.println(chiffre(42%16));
		System.out.println(nombre('C'));
		System.out.println(lire_repr("101010",2));
		System.out.println(repr_nombre(42,2));
	}
	
	//Prend en entrez un nombre et retourne le charact�re associ�
	static char chiffre(int n) {
		String  alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return alphaNumeric.charAt(n);
	}
	//Prend en entrez un charact�re et retourne le nombre associ�
	static int nombre(char ch) {
		String  alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return alphaNumeric.indexOf(ch);
	}
	//Prend en entrez une chaine de charact�re et sa base est retourne l'entier associ�
	static int lire_repr(String chaine, int base) {
		int entier = 0;
		int exp = chaine.length() - 1;
		for(int i = 0; i < chaine.length(); i++) {
			entier += nombre(chaine.charAt(i)) * Math.pow(base, exp);
			exp--;
		}
		return entier;
	}

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