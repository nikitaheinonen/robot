import java.util.*;    // Scanner
import static java.lang.System.out;




class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar{

	public static void main (String[] args){

		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
		// mata in två naturliga heltal
		Scanner in = new Scanner (System.in);

		out.println ("två naturliga heltal:");

		String tal1 = in.next ();
		String tal2 = in.next ();
		out.println ();// addera heltalenoch visa resultatet
		String summa = addera (tal1, tal2);
		visa(tal1, tal2, summa, '+');
		// subtrahera heltalen och visa resultatet
		String subbb = subtrahera(tal1, tal2);
		visa(tal1, tal2, subbb, '-');
		}
	// addera tar emot två naturliga heltal givna somteckensträngar, och returnerar deras
	// summa somen teckensträng.
	public static String addera (String tal1, String tal2){
		int c = 0;
		String add = "";
		//gör strängarna lika långa
		if(tal1.length() < tal2.length()){
			tal1 = sattLen(tal1, tal2.length() - tal1.length());
		}
		if(tal1.length() > tal2.length()){
			tal2 = sattLen(tal2, tal1.length() - tal2.length());
		}
		int[] value1 = new int[tal1.length()];
		int[] value2 = new int[tal2.length()];
		//lägg varje siffra separat
		for(int i = 0; i < tal1.length(); i++){
			if(tal1.charAt(i) == ' '){
				value1[i] = 0;
			}else{
				value1[i] = Character.getNumericValue(tal1.charAt(i));
			}
			if(tal2.charAt(i) == ' '){
				value2[i] = 0;
			}else{
				value2[i] = Character.getNumericValue(tal2.charAt(i));
			}
		}
		
		//addera elementen i vektorerna
		for(int i = tal1.length() - 1; i > -1; i--){
			if(value1[i] + value2[i] + c >= 10){
				add = (value1[i] + value2[i] + c - 10) + add;
				c = (value1[i] + value2[i] + c) / 10;
			}else{
				add = (value1[i] + value2[i] + c) + add;
				c = 0;
			}
			
			
		}
		//se om det finns en rest kvar efter sista additionen
		if(c != 0){
			add = c + add;
		}

		return add;

		}

	// subtrahera tar emot två naturliga heltal givna somteckensträngar, och returnerar
	// deras differens somen teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.
	public static String subtrahera (String tal1, String tal2){
		String sub = "";

		//samma som i addera
		if(tal1.length() < tal2.length()){
			tal1 = sattLen(tal1, tal2.length() - tal1.length());
		}
		if(tal1.length() > tal2.length()){
			tal2 = sattLen(tal2, tal1.length() - tal2.length());
		}
		int[] value1 = new int[tal1.length()];
		int[] value2 = new int[tal2.length()];
		//lägg varje siffra separat
		for(int i = 0; i < tal1.length(); i++){
			if(tal1.charAt(i) == ' '){
				value1[i] = 0;
			}else{
				value1[i] = Character.getNumericValue(tal1.charAt(i));
			}
			if(tal2.charAt(i) == ' '){
				value2[i] = 0;
			}else{
				value2[i] = Character.getNumericValue(tal2.charAt(i));
			}
		}
		
		for(int i = tal1.length() - 1; i > -1; i--){
			if(value1[i] - value2[i] < 0){
				//om nuvarande subtraktion blir negativ
				//låna från nästa tal och minska det med 1 
				value1[i - 1] = value1[i - 1] - 1;
				sub = (10 + (value1[i] - value2[i])) + sub;
			}else{
				sub = (value1[i] - value2[i]) + sub;
			}
		}

		return sub;



	}

	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
	// utförd i samband med hetalen
	public static void visa (String tal1, String tal2, String resultat, char operator){
	// sätt en lämplig längd på heltalen och resultatet
		int len1 = tal1.length ();
		int len2 = tal2.length ();
		int len  = resultat.length ();
		int maxLen = Math.max (Math.max (len1, len2), len);
		tal1 = sattLen (tal1, maxLen -len1);
		tal2 = sattLen (tal2, maxLen -len2);
		resultat = sattLen (resultat, maxLen -len);
		// visa heltalen och resultatet
		out.println ("  " + tal1);
		out.println ("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print ("-");

		out.println ();
		out.println ("  " + resultat + "\n");

	}

	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen (String s, int antal){

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < antal; i++)
			sb.insert (0, " ");
		return sb.toString();
	}
}




















