import java.util.Scanner;

public class ProxyBankkonto implements InterfaceBankkonto {

	public Bankkonto konto;
	public String password;
	public String kntnr;
	double kntstand;
	String name;
	String fehler = "Falsche Eingabe!";

	public ProxyBankkonto(String n, String kntnr, double kntstand, String psw) {
		this.name=n;
		this.kntstand = kntstand;
		this.kntnr = kntnr;
		konto = new Bankkonto(n,kntnr,kntstand);
		password = psw;
	}
	public boolean verifyPassword() {
		/*
		 * Diese Methode erzeugt einen Fehler in der Methode
		 * functions() wenn sc.close() eingeklammert ist
		 * sonst funktioniert alles.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Passwort: ");
		String psw = sc.next();
		if(password.equals(psw)) {
			//sc.close();
			return true;
		}
		System.out.println("Falsches Passwort!");
		//sc.close();
		return false;
	}
	public void functions() {
		if(verifyPassword()) {
			double amount;
			Scanner sc1 = new Scanner(System.in);
			System.out.println("1\tAbheben");
			System.out.println("2\tEinzahlen");
			System.out.println("3\tKontostand");
			System.out.print("Ihre Wahl: ");
			int function = sc1.nextInt();	
			switch (function) {
			case 1:
				//Abheben
				System.out.printf("Kontostand:\t\t%,.2f €\n",kntstand);
				System.out.print("Menge eingeben:");
				amount = sc1.nextInt();
				kntstand-=amount;
				System.out.printf("Abgehoben:\t\t%,.2f €\n",amount);
				if(kntstand<0) {
					System.out.printf("Neuer Kontostand:\t%,.2f €\t(Achtung Sie sind im Minus)\n",kntstand);
				}
				else System.out.printf("Neuer Kontostand:\t%,.2f €\n",kntstand);
				break;
			case 2:
				//Einzahlen
				System.out.printf("Kontostand:\t\t%,.2f €\n",kntstand);
				System.out.print("Menge eingeben: ");
				amount = sc1.nextInt();
				kntstand+=amount;
				System.out.printf("Eingezahlt:\t\t%,.2f €\n",amount);
				System.out.printf("Neuer Kontostand:\t%,.2f €\n",kntstand);
				break;
			case 3:
				//Kontostand ansehen
				//System.out.println("Name:\t\t"+name);
				//System.out.println("Kontonummer:\t"+kntnr);
				//System.out.println("Kontostand:\t"+kntstand);
				konto.showData();
				break;
			default: System.out.println(fehler); 
			}
			sc1.close();
		}
	}
	public double getKontostand() {
		if(verifyPassword()) return konto.getKontostand();
		else return 0;
	}
	public void setKontostand(double kontostand) {
		if(verifyPassword()) konto.setKontostand(kontostand);
		else System.out.println(fehler);
	}

}
