import java.util.*;

class DenKortasteVagen{

	public static int[] mellanstationer(double[] a, double[][] b, double[] c){
		double lang = 100000000; //stort tal
		int[] mellanstationer = new int[3];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < c.length; j++){
				if(lang > (a[i] + b[i][j] + c[j])){
					//Här får vi samma svar som i metoden langd()
					// så vi gör egentligen samma beräkning två gånger
					lang = (a[i] + b[i][j] + c[j]);
					mellanstationer[1] = (i + 1);//stationen börjar på u1, u2 osv
					mellanstationer[2] = (j + 1);//därför +1 då i och j börjar på 0
				}
			}
		}
		return mellanstationer;
		
	}

	public static double langd(double[] a, double[][] b, double[] c){
		double langd = 100000000; //stort tal
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < c.length; j++){
				if(langd > (a[i] + b[i][j] + c[j])){
					langd = (a[i] + b[i][j] + c[j]);
				}
			}
		}
		return langd;
		
	}
}


public class BestamDenKortasteVagen{
	
	public static void main(String[] args){
		System.out.println("Bestäm m:");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		System.out.println("Bestäm n;");
		int n = sc.nextInt();


		double[] ai = new double[m];
		double[][] bij = new double[m][n];
		double[] cj = new double[n];

		System.out.println("Bestäm distans ai:");
        for (int i = 0; i < m; i++) {
            System.out.print("Mellan X och U" + (i + 1) + ": "); 
            ai[i] = sc.nextDouble();
        }

        System.out.println("Bestäm distans bij:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Mellan U" + (i + 1) + " och V" + (j + 1) + ": "); // U och V index 1
                bij[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Bestäm distans cj:");
        for (int i = 0; i < n; i++) {
            System.out.print("Mellan V" + (i + 1) + " och Y: "); 
            cj[i] = sc.nextDouble();

        }

        int[] mellanstationer = DenKortasteVagen.mellanstationer(ai, bij, cj);
        System.out.println("Mellanstationerna för den kortaste vägen är: U" 
        	+ mellanstationer[1] + " och V" + mellanstationer[2]);

        double langd = DenKortasteVagen.langd(ai, bij ,cj);
        System.out.println("Längden av den kortaste vägen är: " + langd);










	
	}
	
}