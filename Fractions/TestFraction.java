
public class TestFraction {
	public static void main(String[] args) {
		Fraction1 f1, f2, f3;
		f1 = new Fraction1(-1,2);
		f2 = new Fraction1(1,2);
		f3 = new Fraction1(1,1);
		f3 = f1.add(f2, f3);
		System.out.print("Сумма = ");
		f3.printFraction();
		f3 = f1.subtract(f2, f3);
		System.out.print("Разность = ");
		f3.printFraction();
		f3 = f1.mult(f2, f3);
		System.out.print("Произведение = ");
		f3.printFraction();
		f3 = f1.div(f2, f3);
		System.out.print("Частное = ");
		f3.printFraction();
	}
}
