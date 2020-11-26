
public class Main {

	public static void main(String[] args) {
														
		ProxyBankkonto Konto = new ProxyBankkonto(
				"Hans Maier",				//Name
				"2365 2356 4568 5789 7892",	//Kontonummer
				175064,						//Kontostand
				"987");						//Passwort
		Konto.functions();
	}
	

}
