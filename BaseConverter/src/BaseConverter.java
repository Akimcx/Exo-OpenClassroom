import java.util.Scanner;

public class BaseConverter {

	private static Scanner keyb = new Scanner( System.in );

	public static void main( String[] args ) {

		System.out.println( "please inter a number" );
		int number = Integer.parseInt( keyb.nextLine().replaceAll( "[\\s,.]", "" ) );
		if ( number == 0 ) {
			System.out.println( "0" );
			return;
		}
		byte base = 16;
		System.out.println( toDecimal( "34d", base ) );
		System.out.println( decimal2Binary( number ) );
		System.out.println( decimal2Octal( number ) );
		System.out.println( decimal2Hexadecimal( number ) );

	}

	// Convert from base 10 to base B
	static String decimal2Binary( int decimalNumber ) {
		byte base = 2;
		if ( decimalNumber == 0 ) return "0";
		/*
		 * To convert a base 10 number into a base B number The first step is to find
		 * the first base B place value That is greater than or equal to the decimal
		 * number we are converting
		 */
		String result = "";
		int exponent = 0;
		int startValue = 0;

		while ( startValue < decimalNumber ) {
			startValue = (int) Math.pow( base, exponent );
			exponent++;
		}
		/*
		 * Next, if startValue is greater than Number we put "0" in result and
		 * startValue equal Math.pow(B, (exponent - 1)). Otherwise, if startValue is
		 * less than number, put "1" in result and enter the remainder of (number -
		 * startValue) in number and startValue equal Math.pow(B, (exponent - 1)) . Then
		 * simply repeat this process till startValue == 1
		 */
		do {
			if ( startValue > decimalNumber ) {
				result += "0";
			} else {
				result += "1";
				decimalNumber = decimalNumber - startValue;
			}
			startValue = (int) Math.pow( base, exponent - 1 );
			exponent--;
		} while ( startValue >= 1 );

		return result.replaceAll( "^0*", "" );
	}

	static String decimal2Octal( int decimalNumber ) {
		// TODO Auto-generated method stub
		byte base = 8;
//		int remainder = 0;
		String result = "";

		while ( decimalNumber > 0 ) {
			result = decimalNumber % base + result;
			decimalNumber /= base;
		}

		return result;
	}

	static String decimal2Hexadecimal( int decimalNumber ) {
		byte base = 16;

		String result = "";

		while ( decimalNumber > 0 ) {
			switch ( decimalNumber % base ) {
				case 10:
					result = "A" + result;
					break;
				case 11:
					result = "B" + result;
					break;
				case 12:
					result = "C" + result;
					break;
				case 13:
					result = "D" + result;
					break;
				case 14:
					result = "E" + result;
					break;
				case 15:
					result = "F" + result;
					break;
				default:
					result = decimalNumber % base + result;
					break;
			}
			decimalNumber /= base;
		}
		return result;
	}

	static int toDecimal( String toConvert, byte base ) {

		String alphabet = "0123456789ABCDEF";
		int result = 0;
		int exponent = toConvert.length() - 1;
		toConvert = toConvert.toUpperCase();

		for ( int i = 0; i < toConvert.length(); i++ ) {
			int charac = alphabet.indexOf( toConvert.charAt( i ) );
			result += charac * Math.pow( base, exponent );
			exponent--;
		}
		return result;
	}
}
