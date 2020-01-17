


public class Polylinje{

	private Punkt[]    horn;
	private String     farg = "svart";
	private int        bredd = 1;

	public Polylinje (){

		this.horn = new Punkt[0];
	}

	public Polylinje (Punkt[] horn){

		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}

	
	public String toString () {
		String linje = "";
		linje = linje + "{[";
		for(int i = 0; i < horn.length; i++){
			linje += horn[i].toString();
			linje += ", ";
		}
		linje += "] " + getFarg() + ", " + getBredd() + "}";
		return linje;
	}

	public Punkt[] getHorn () {
		//return horn;
		Punkt[] chorn = new Punkt[horn.length];
		for(int i = 0; i < horn.length; i++){
			chorn[i] = new Punkt(horn[i]);
		}
		return chorn;
	}

	//returnerar färgen på polylinje
	public String getFarg () {
		return this.farg;
	}

	//returnerar bredd på polylinje
	public int getBredd () {
		return this.bredd;
	}

	//sätter färg på linje
	public void setFarg(String farg) {
		//String farg1 = farg;
		this.farg = farg;
	}

	//sätter bredd
	public void setBredd (int bredd) {
		//int bredd1 = bredd;
		this.bredd = bredd;
	}

	//returnerar längden av linjen
	public double langd () {
		double langd = 0;
		for(int i = 0; i < horn.length - 1; i++){
			//hämtar avstånd mellan varje punkt, lagrar total
			langd += horn[i].avstand(horn[i + 1]);
			//i + 1 pga avståndet till NÄSTA hörn
		}
		return langd;

	}

	public void laggTill (Punkt horn){

		Punkt[]    h = new Punkt[this.horn.length + 1];
		int    i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];

		h[i] = new Punkt (horn);
		this.horn = h;
	}

	public void laggTillFramfor (Punkt horn, String hornNamn) {
		Punkt[] temp = new Punkt[this.horn.length + 1];
		//kopierar parameterreferensen
		Punkt copyHorn = horn;
		int j = 0;
		Boolean bool = false;
		for(int i = 0; i < this.horn.length; i++){
			j++;
			if(bool){
				//Om vi hittat en match, förskjuter index med 1
				//så att vi inte tappar bort punkten som vi en annan punkt framför sig
				temp[j] = this.horn[i];
			}
			if(hornNamn == this.horn[i].getNamn()){
				temp[i] = copyHorn;
				temp[j] = this.horn[i];
				bool = true;
			}
			if(!bool){
				temp[i] = this.horn[i];
			}
		}
		this.horn = temp;

	}

	public void taBort (String hornNamn) {
		//gör en ny temporär vektor som är kortare
		Punkt[] temp = new Punkt[this.horn.length - 1];
		int count = 0;
		for(int i = 0; i < this.horn.length; i++){
			//sparar alla hörn som inte matchar i den temporära
			if(horn[i].getNamn() != hornNamn){
				temp[count] = horn[i];
				count++;
			}
		}
		//flyttar över den nya vektorn med uppdaterade hörnen
		this.horn = temp;

	}

	public class PolylinjeIterator{
		private int    aktuell = -1;
		public PolylinjeIterator (){
			if (Polylinje.this.horn.length >0)
				aktuell = 0;
		}
		public boolean finnsHorn (){
			return aktuell != -1;
		}
		public Punkt horn ()throws java.util.NoSuchElementException{
			if (!this.finnsHorn ()){
				throw new java.util.NoSuchElementException("slut av iterationen");
			}
			Punkt    horn = Polylinje.this.horn[aktuell];
			return horn;
		}
		public void gaFram (){
			if (aktuell >= 0  && aktuell < Polylinje.this.horn.length -1)
				aktuell++;
			else
				aktuell = -1;
		}
	}











}