package fraction;

//import stack.Stack;
import java.util.Stack;

public class CalculateFraction {

	public static Fraction calculate(String s) {
		Fraction f1 = null, f2;
		if (s.contains("+")) {
			int index = s.indexOf("+");
			if (index == -1)
				f1 = new Fraction(s);
			else {
				f1 = new Fraction(s.substring(0, index));
				f2 = new Fraction(s.substring(index + 1, s.length()));
				f1.add(f2);
			}
		}
		if (s.contains("-")) {
			int index = s.indexOf("-");
			if (index == -1)
				f1 = new Fraction(s);
			else {
				f1 = new Fraction(s.substring(0, index));
				f2 = new Fraction(s.substring(index + 1, s.length()));
				f1.subtract(f2);
			}
		}
		if (s.contains("*")) {
			int index = s.indexOf("*");
			if (index == -1)
				f1 = new Fraction(s);
			else {
				f1 = new Fraction(s.substring(0, index));
				f2 = new Fraction(s.substring(index + 1, s.length()));
				f1.mult(f2);
			}
		}
		if (s.contains(":")) {
			int index = s.indexOf(":");
			if (index == -1)
				f1 = new Fraction(s);
			else {
				f1 = new Fraction(s.substring(0, index));
				f2 = new Fraction(s.substring(index + 1, s.length()));
				f1.div(f2);
			}
		}
		//f1.printFraction();
		return f1;
	}

	
//	Fraction r(String s) {
//		String new_s = "";
//		String[] chars = s.split("");
//		for (int i = 0; i < s.length(); i++) {
//			new_s += chars[i];
//		}
//		new_s += "+";
//		Fraction f2 = new Fraction(0,1);
//		int index = 0;
//		for (int i = 0; i < new_s.length(); i+) {
//			index = new_s.indexOf("+", i);
//			Fraction f1 = new Fraction(s.substring(i,index));
//			f1.printFraction();
//			f2.add(f1);
//		}
//		f2.printFraction();
//		return f2;
//	}

	private static String plus = new String("+");
	private static String minus = new String("-");
	private static String zvezd = new String("*");
	private static String tochki = new String(":");
	private static String left = new String("(");
	private static String right = new String(")");

	private static String toPoland(String input) {
		String output = "";
		Stack<Object> stack = new Stack<>();
		String[] inputSymbols = input.split(" ");

		for (int i = 0; i < inputSymbols.length; i++) {
			if (isFraction(inputSymbols[i])) {
				output += inputSymbols[i];
				output += " ";
			}
			if (!isFraction(inputSymbols[i])) {
				if (inputSymbols[i].equals(left))
					stack.push(inputSymbols[i]);
				else if (inputSymbols[i].equals(right)) {
					String s = (String) stack.pop();

					while (!s.equals(left)) {
						output += s + ' ';
						s = (String) stack.pop();
					}
				} else {
					if (stack.empty() == false)
						if (priority(inputSymbols[i]) <= priority((String) stack.peek()))
							output += stack.pop() + " ";
					stack.push(inputSymbols[i]);
				}
			}
	}

		while (stack.empty() == false)
			output += stack.pop() + " ";

		return output;
	}

	private static int priority(String s) {
		if (s.equals(left))
			return 0;
		if (s.equals(right))
			return 1;
		if (s.equals(plus))
			return 2;
		if (s.equals(minus))
			return 3;
		if (s.equals(zvezd))
			return 4;
		if (s.equals(tochki))
			return 4;
		else
			return 5;
	}

	public static Fraction poland(String s) {
		s = toPoland(s);
		Fraction f1 = null;
		Fraction f2 = null;
		String [] fractions = s.split(" ");
		Stack<String> temp = new Stack<>();
		for (int i = 0; i < fractions.length; i++) {
			if (isFraction(fractions[i])) {
				String a = "";
				a += fractions[i];
				temp.push(a);
			}
			else if(IsOperator(fractions[i])) {
				Fraction a = new Fraction(temp.pop());
				Fraction b = new Fraction(temp.pop());
				if(fractions[i].equals(plus)) 
					b.add(a);
				if (fractions[i].equals(minus)) 
					b.subtract(a);
				if(fractions[i].equals(zvezd))
					b.mult(a);
				if(fractions[i].equals(tochki))
					b.div(a);
				temp.push(b.toString());
			}
		}
		Fraction result = new Fraction(temp.peek());
		return result;

	}
	

	
	private static boolean IsOperator(String ñ) {
		if (("+-:*()".indexOf(ñ) != -1))
			return true; 
		return false;
	}

	private static boolean isFraction(String s) {
		if (s.matches("[1-9]+/*[0-9]*"))
				return true;
		return false;
	}

}