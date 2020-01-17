import java.util.*;

class ValjPolylinje{

	public static final Random    rand = new Random ();
	public static final int    ANTAL_POLYLINJER = 10;

	public static void main (String[] args){
		// skapa ett antal slumpmässiga polylinjer
		Polylinje[]    polylinjer = new Polylinje[ANTAL_POLYLINJER];

		for (int i = 0; i < ANTAL_POLYLINJER; i++){
			polylinjer[i] = slumpPolylinje ();
		}
		boolean bool = false;
		Polylinje kortast = null;
		double distans = Double.MAX_VALUE;
			// visa polylinjerna
		System.out.println("Alla polylinjer:");
		for(int i = 0; i < polylinjer.length; i++){
			System.out.println(polylinjer[i]);
			//väljer ut en gul polylinje
			if(polylinjer[i].getFarg() == "gul"){
				bool = true;
				//den längsta blir sparad 
				if(polylinjer[i].langd() < distans){
					distans = polylinjer[i].langd();
					kortast = polylinjer[i];
				}
			}
		}
		if(bool){
			System.out.println("Den kortaste GULA polylinjen:");
			System.out.println(kortast);
			System.out.println("Längden:");
			System.out.println(distans);
		}else{
			System.out.println("Det finns ingen GUL polylinje.");
		}
		



			// bestäm den kortaste av de polylinjer som är gula


			//visa den valda polylinjen


	}

	// slumpPunkt returnerar en punkt med ett slumpmässigt namn,som är en stor bokstav i
	// det engelska alfabetet, ochslumpmässiga koordinater.
	public static Punkt slumpPunkt (){

		String    n = "" + (char) (65 + rand.nextInt (26));
		int    x = rand.nextInt (11);
		int    y = rand.nextInt (11);
		return new Punkt (n, x, y);
	}

	// slumpPolylinje returnerar en slumpmässig polylinje, varsfärg är antingen blå, eller röd
	//eller gul.Namn på polylinjens hörn är stora bokstäver i det engelskaalfabetet. Två hörn
	//kan inte ha samma namn.
	public static Polylinje slumpPolylinje (){

	// skapa en tom polylinje, och lägg till hörn till den
		Polylinje polylinje = new Polylinje ();
		int    antalHorn = 2 + rand.nextInt (7);
		int    antalValdaHorn = 0;
		boolean[]    valdaNamn = new boolean[26];
		// ett och samma namn kan inte förekomma flera gånger
		Punkt    valdPunkt = null;
		char    valtChar = 0;
		int z = 0;
		String[] valdaNamn1 = new String[26];
		String[] valdaNamn2 = new String[26];
		while (antalValdaHorn < antalHorn){
			valdPunkt = slumpPunkt();	
			while(true){
				//Tittar om vi har varit på detta index förut
				//charvärde för stora tal 65-90.
				//-65 för att få ett index mellan 0 - 25
				if(!valdaNamn[((valdPunkt.getNamn().toCharArray
					()[0]) - 65)]){
					valdaNamn[((valdPunkt.getNamn().toCharArray()[0]) 
					 - 65)] = true;
					break;
				}
				//går in i if om det är falskt, annar har vi varit där
				// och slumpar fram en ny punkt
				valdPunkt = slumpPunkt();
			}
		
			polylinje.laggTill(valdPunkt);
			antalValdaHorn++;
		}
			
		

		// sätt färg
		String[] farger = new String[]{"bla", "rod", "gul"};
		int fargVal = rand.nextInt(3);
		polylinje.setFarg(farger[fargVal]);
		return polylinje;
	}
	/*
	public static boolean contains(String[] arr, String match){
		for(int k = 0; k < arr.length; k++){
			if(arr[k] == match){
				return true;
			}
		}
		return false;
	}
	*/
}












