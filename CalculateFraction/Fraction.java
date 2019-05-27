package fraction;

public class Fraction {
	int nom;
	int denom;
	Fraction f;

	Fraction(int a, int b) {
		nom = a;
		denom = b;
		error();
		adjust();
	}

	public Fraction() {
		this(1, 2);
	}

	public Fraction(String a)  {

		//try {
			int sign = a.indexOf("/");
			if (sign == -1) {
				nom = Integer.parseInt(a);
				denom = 1;
			} else {
				String c = a.substring(0, sign);
				String d = a.substring(sign + 1, a.length());
				nom = Integer.parseInt(c);
				denom = Integer.parseInt(d);
			}
			if (denom == 0)
				throw new RuntimeException("Divide by zero!");

//		} catch (ArithmeticException arithmeticException) {
//			System.out.println(arithmeticException);
//		}

		adjust();

	}

	public Fraction add(Fraction g) {
		Fraction f = this;
		nom = nom * g.denom + g.nom * denom;
		denom = denom * g.denom;
		return f;
	}

	public Fraction subtract(Fraction g) {
		Fraction f = this;
		nom = nom * g.denom - g.nom * denom;
		denom = denom * g.denom;
		return f;
	}

	public Fraction mult(Fraction g) {
		Fraction f = this;
		nom = nom * g.nom;
		denom = denom * g.denom;
		return f;
	}

	public Fraction div(Fraction g) {
		Fraction f = this;
		nom = nom * g.denom;
		denom = denom * g.nom;
		return f;
	}

	public void printFraction() {
		adjust();
		if (nom == 0)
			System.out.println(nom);
		else if (denom == 1)
			System.out.println(nom);
		else
			System.out.println(nom + "/" + denom);
	}

	private void error() {
		if (nom == 0 && denom == 0 || denom == 0) {
			System.out.println("Ошибка ввода");
			System.exit(0);
		}
	}

	private void adjust() {
		for (int i = denom; i > 1; i--) {
			while (nom % i == 0 && denom % i == 0) {
				nom = nom / i;
				denom = denom / i;
			}
		}
		if (denom < 0 && nom < 0 || denom < 0) {
			denom = -1 * denom;
			nom = -1 * nom;
		}
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Fraction))
			return false;
		Fraction f = (Fraction) o;

		if (this.nom == f.nom && this.denom == f.denom)
			return true;
		else
			return false;
	}

	public int hashCode() {
		return (int) Math.abs(nom * denom);
	}

	public String toString() {
		String n = String.valueOf(nom);
		if (denom == 1)
			return n;
		else
			return nom + "/" + denom;
	}

	public boolean less(Fraction f1, Fraction f2) {
		Fraction f3 = new Fraction();
		if ((f1.denom == f2.denom) && (f1.nom < f2.nom))
			return true;
		if (f1.denom != f2.denom) {
			f1.nom *= f2.denom;
			f2.nom *= f3.denom;
			f3.denom = f1.denom;
			f1.denom *= f2.denom;
			f2.denom *= f3.denom;

			if (f1.nom < f2.nom)
				return true;
		}
		return false;
	}
}
