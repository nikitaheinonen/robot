import java.util.*;     // Scanner, Locale

class Temperaturer{

	public static void main(String[] args){


		System.out.println ("TEMPERATURER\n");

		// inmatningsverktyg
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);

		// mata in uppgifter om antalet veckor och antaletmätningar
		System.out.print ("antalet veckor: ");
		int antalVeckor = in.nextInt();
	
		System.out.print ("antalet mätningar per vecka: ");
		int antalMatningarPerVecka = in.nextInt();

		

		// plats att lagra temperaturer
		double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

		// mata in temperaturerna
		for(int vecka = 1; vecka <= antalVeckor; vecka++){
			System.out.println("temperaturer -vecka " + vecka+ ":");
			for(int matning = 1; matning <= antalMatningarPerVecka; matning++)
				t[vecka][matning] = in.nextDouble();
		}
		System.out.println();

		// visa temperaturerna
		System.out.println("temperaturerna:");
		for(int vecka = 1; vecka <= antalVeckor; vecka++){
			for(int matning = 1; matning <= antalMatningarPerVecka; matning++)
				System.out.print(t[vecka][matning] + " ");
			System.out.println();
		}
		System.out.println();

		// den minsta,den största och medeltemperaturen–veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];

		
		// koden ska skrivas här
		//visa den minsta, största och medeltemperaturen för varje vecka
		for(int vecka = 1; vecka <= antalVeckor; vecka++){
			minT[vecka] = t[vecka][1];
			maxT[vecka] = t[vecka][1];
			for(int matning = 1; matning <= antalMatningarPerVecka; matning++){
				if(minT[vecka] > t[vecka][matning]){
					minT[vecka] = t[vecka][matning];
				}
				if(maxT[vecka] < t[vecka][matning]){
					maxT[vecka] = t[vecka][matning];
				}
				sumT[vecka] += t[vecka][matning];
			}
			medelT[vecka] = sumT[vecka]/antalMatningarPerVecka;
			System.out.print("minT | maxT | medelT ");
			System.out.print("vecka " + vecka + ":\n");
			System.out.print(minT[vecka] + "    ");
			System.out.print(maxT[vecka] + "    ");
			System.out.print(medelT[vecka] + "\n");
		}

		// den minsta, den största och medeltemperaturen -helamätperioden
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double medelTemp = 0;

		// koden ska skrivas här
		// visa den minsta, den största och medeltemperaturen i hela mätperioden
		//koden ska skrivas här
		for(int vecka = 1; vecka <= antalVeckor; vecka++){
			if(minTemp > minT[vecka]){
				minTemp = minT[vecka];
			}
			if(maxTemp < maxT[vecka]){
				maxTemp = maxT[vecka];
			}
			sumTemp += medelT[vecka];			
		}
		sumTemp = sumTemp - sumT[1];
		medelTemp = sumTemp/antalVeckor;
		System.out.println("minTemp | maxTemp | medelTemp för hela mätperioden:");
		System.out.println(minTemp + "       " + maxTemp + "       " + medelTemp);

	}




}




