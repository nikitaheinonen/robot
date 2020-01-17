import java.util.*;

class Triangel{

	public static double area(double hojd, double bredd){
		double area = (hojd * bredd)/2;
		return area;
	}

	public static double omkrets(double a, double b, double c){
		double omkrets = a + b + c;
		return omkrets;
	}

	public static double pythagoras(double a, double b){
		double aa = Math.pow(a, 2);
		double bb = Math.pow(b, 2);
		double hyp = Math.sqrt(aa + bb);
		return hyp;
	}

	public static double bisektris(double b, double c, double alfa){
		double p = 2 * b * c * Math.cos(alfa/2);
		double bis = p/(b + c);
		return bis;
	}

	public static double semiperimeter(double a, double b, double c){
		double s = (a + b + c)/2;
		return s;
	}

	public static double omCirkel(double a, double b, double c){
		double sa = semiperimeter(a, b, c) - a;
		double sb = semiperimeter(a, b, c) - b;
		double sc = semiperimeter(a, b, c) - c;
		double omskrivenCirkel = (a*b*c)/(4*Math.sqrt(semiperimeter(a, b,
		c)*sa*sb*sc));
		return omskrivenCirkel;
	}

	public static double inCirkel(double a, double b , double c){
		double sa = semiperimeter(a, b, c) - a;
		double sb = semiperimeter(a, b, c) - b;
		double sc = semiperimeter(a, b, c) - c;
		double inskrivenCirkel = Math.sqrt((sa*sb*sc)/semiperimeter(a, b, c));
		return inskrivenCirkel;
	}


	




}


public class OU2{

	public static void main(String[] args){
		System.out.println("Ange triangelns sidor:");
		System.out.println("a:");
		Scanner sc = new Scanner(System.in);
		double a = sc.nextInt();
		System.out.println("b:");
		double b = sc.nextInt();
		System.out.println("c:");
		double c = sc.nextInt();
		System.out.println("Radie r för omskriven cirkel:" 
			+ Triangel.omCirkel(a, b, c));
		System.out.println("Radie r för inskriven cirkel:" 
			+ Triangel.inCirkel(a, b, c));

	}
	


}



