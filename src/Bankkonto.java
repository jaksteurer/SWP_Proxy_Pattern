
public class Bankkonto {
	public String name = "";
	public String kontonr;
	public double kontostand;

	public Bankkonto(String name, String kontonr, double kontostand) {
		this.name = name;
		this.kontonr = kontonr;
		this.kontostand = kontostand;
	}
	public void showData() {
		System.out.println("Name:\t\t"+name);
		System.out.println("Kontonummer:\t"+kontonr);
		System.out.printf("Kontostand:\t%,.2f €\n",kontostand);
	}
	public double getKontostand() {
		return kontostand;
	}
	public void setKontostand(double kontostand) {
		this.kontostand = kontostand;
	}



}
