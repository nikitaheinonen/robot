

public class Test{
	public static void main(String[] args){
		System.out.println("Linje test");
		//gör en ny polylinje med 3 punkter
		Polylinje p = new Polylinje(new Punkt[]{new Punkt("A", 2, 4), new Punkt("B", 4, 6),
			new Punkt("C", 3, 6)});
		System.out.println(p.toString());

		//läggtillframför
		System.out.println("Lägger till D framför A");
		p.laggTillFramfor(new Punkt("D", 0, 7), "A");
		System.out.println(p.toString());

		//tabort
		System.out.println("Ta bort C");
		p.taBort("C");
		System.out.println(p.toString());

		//skriv ut längden
		System.out.println("längd");
		System.out.println(p.langd());

		//ändra färg/bredd
		System.out.println("ändra färg + bredd --- vit, 3");
		p.setBredd(3);
		p.setFarg("vit");
		System.out.println(p.toString());

		//uppgift d iterator
		System.out.println("Itererar över punkterna:");
		//en ny instans inne i p klassen
		Polylinje.PolylinjeIterator pi = p.new PolylinjeIterator();
		while(pi.finnsHorn()){
			System.out.println(pi.horn());
			pi.gaFram();
		}


	}
}