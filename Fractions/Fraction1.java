
public class Fraction1 {
	private int nom;
	private int denom;
	
	Fraction1(int a, int b){
		nom = a;
		denom = b;
		//error();
		adjust();
	}
//	Fraction1 (String a) { 
//		String c=a.substring(0,2); 
//		String d=a.substring(2,3); 
//		nom=Integer.parseInt(c); 
//		denom=Integer.parseInt(d); 
////		System.out.println(c); 
////		System.out.println(d); 
//		error();
//		adjust();
//		}
	Fraction1 add(Fraction1 f, Fraction1 g) {
		g.nom = nom*f.denom + f.nom*denom;
		g.denom = denom*f.denom;
		return g;
	}
	Fraction1 subtract(Fraction1 f, Fraction1 g) {
		g.nom = nom*f.denom - f.nom*denom;
		g.denom = denom*f.denom;
		return g;
	}
	Fraction1 mult(Fraction1 f, Fraction1 g) {
		g.nom = nom*f.nom;
		g.denom = denom*f.denom;
		return g;
	}
	Fraction1 div(Fraction1 f, Fraction1 g) {
		g.nom = nom*f.denom;
		g.denom = denom*f.nom;
		return g;
	}
	void printFraction() {
		adjust();
		if (nom == 0)
			System.out.println(nom);
		else if (denom == 1)
			System.out.println(nom);
		else
			System.out.println(nom + "/" + denom);
	}
	private void error(){
		if (nom == 0 && denom == 0 || denom == 0) {
			System.out.println("Ошибка ввода");
			System.exit(0);
		}
	}
	private void adjust() {
		for(int i = denom; i > 1; i-- ){
		 while (nom%i == 0 && denom%i == 0){
				nom = nom/i;
				denom = denom/i;
			}
		}
		if (denom < 0 && nom < 0 || denom < 0) {
			denom = -1*denom;
			nom = -1*nom;
		}
	}
	
}
