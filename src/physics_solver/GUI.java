package physics_solver;

import java.io.IOException;
import java.util.Scanner;

public class GUI {

	public static Scanner scan = new Scanner(System.in);
	public static final String[] values = { "D", "Vi", "T", "A", "Vf" };

	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.println("Pick a Kinematic Equation:");
			System.out.println("1. D = (Vi)(T) + (1/2)(A)(T^2)");
			System.out.println("2. Vf = Vi + (A)(T)");
			System.out.println("3. Vf^2 = Vi^2 + 2(A)(D)");
			System.out.println("4. D = (T)(Vi + Vf)/2");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			}
		}
	}

	private static void anotherOne() {
		System.out.println("Would you like to solve another problem? (y/n)");
		String yesOrNo = scan.next();
		if (yesOrNo.equals("n")) {
			System.exit(0);
		}
		System.out.println("-------------------------");
	}

	private static void one() {
		System.out.println("-------------------------");
		String s = "You have picked the equation : D = (Vi)(T) + (1/2)(A)(T^2)";
		System.out.println(s);
		System.out.println("Which variable are you solving for?");

		int count = 1;
		for (int i = 0; i < values.length; i++) {
			if (s.contains(values[i])) {
				System.out.println(count + ". " + values[i]);
				count++;
			}
		}
		System.out.println("5. Quit");

		int choice = scan.nextInt();
		System.out.println("-------------------------");

		if (choice == 5) {
			return;
		} else {
			switch (choice) {
			case 1:
				System.out.println("D = " + oneD());
				break;
			case 2:
				System.out.println("Vi = " + oneVi());
				break;
			case 3:
				System.out.println("T = " + oneT());
				break;
			case 4:
				System.out.println("A = " + oneA());
				break;
			}
		}
		System.out.println("-------------------------");
		anotherOne();
	}

	private static double oneD() {
		// Vi, T, A
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "D" && values[i] != "Vf") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double Vi = vals[0];
		double T = vals[1];
		double A = vals[2];

		return (Vi * T) + (0.5) * A * Math.pow(T, 2);
	}

	private static double oneVi() {
		// D, T, A
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vi" && values[i] != "Vf") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double T = vals[1];
		double A = vals[2];

		return (D - (0.5 * A * Math.pow(T, 2))) / T;
	}

	private static Point oneT() {
		// D, Vi, A
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "T" && values[i] != "Vf") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double Vi = vals[1];
		double A = vals[2];

		double desc = Math.sqrt(Math.pow((2 * Vi), 2) - 4 * (A) * (-D));

		return new Point((-2 * Vi - desc) / 2 * A, (-2 * Vi + desc) / 2 * A);
	}

	private static double oneA() {
		// D, Vi, T
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "A" && values[i] != "Vf") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double Vi = vals[1];
		double T = vals[2];

		return 2 * (D - (Vi * T)) / Math.pow(T, 2);
	}

	private static void two() {
		System.out.println("-------------------------");
		String s = "You have picked the equation : Vf = Vi + (A)(T)";
		System.out.println(s);
		System.out.println("Which variable are you solving for?");

		int count = 1;
		for (int i = 0; i < values.length; i++) {
			if (s.contains(values[i])) {
				System.out.println(count + ". " + values[i]);
				count++;
			}
		}
		System.out.println("5. Quit");

		int choice = scan.nextInt();
		System.out.println("-------------------------");

		if (choice == 5) {
			return;
		} else {
			switch (choice) {
			case 1:
				System.out.println("Vf = " + twoVf());
				break;
			case 2:
				System.out.println("Vi = " + twoVi());
				break;
			case 3:
				System.out.println("A = " + twoA());
				break;
			case 4:
				System.out.println("T = " + twoT());
				break;
			}
		}
		System.out.println("-------------------------");
		anotherOne();
	}

	private static double twoVf() {
		// Vi, A, T
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vf" && values[i] != "D") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double Vi = vals[0];
		double T = vals[1];
		double A = vals[2];

		return Vi + A * T;
	}

	private static double twoVi() {
		// Vf, A, T
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vi" && values[i] != "D") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double T = vals[0];
		double A = vals[1];
		double Vf = vals[2];

		return Vf - A * T;
	}

	private static double twoA() {
		// Vf, Vi, T
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "A" && values[i] != "D") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double Vi = vals[0];
		double T = vals[1];
		double Vf = vals[2];

		return (Vf - Vi) / T;
	}

	private static double twoT() {
		// Vf, Vi, A
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "T" && values[i] != "D") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double Vi = vals[0];
		double A = vals[1];
		double Vf = vals[2];

		return (Vf - Vi) / A;
	}

	private static void three() {
		System.out.println("-------------------------");
		String s = "You have picked the equation : Vf^2 = Vi^2 + 2(A)(D)";
		System.out.println(s);
		System.out.println("Which variable are you solving for?");

		int count = 1;
		for (int i = 0; i < values.length; i++) {
			if (s.contains(values[i])) {
				System.out.println(count + ". " + values[i]);
				count++;
			}
		}
		System.out.println("5. Quit");

		int choice = scan.nextInt();
		System.out.println("-------------------------");

		if (choice == 5) {
			return;
		} else {
			switch (choice) {
			case 1:
				System.out.println("Vf = " + threeVf());
				break;
			case 2:
				System.out.println("Vi = " + threeVi());
				break;
			case 3:
				System.out.println("A = " + threeA());
				break;
			case 4:
				System.out.println("D = " + threeD());
				break;
			}
		}
		System.out.println("-------------------------");
		anotherOne();
	}

	private static Point threeVf() {
		// Vi, A, D
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vf" && values[i] != "T") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double Vi = vals[1];
		double A = vals[2];

		double mag = Math.sqrt(Math.pow(Vi, 2) + 2 * A * D);

		return new Point(-mag, mag);
	}

	private static Point threeVi() {
		// Vf, A, D
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vi" && values[i] != "T") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double A = vals[1];
		double Vf = vals[2];

		double mag = Math.sqrt(Math.pow(Vf, 2) - 2 * A * D);

		return new Point(-mag, mag);
	}

	private static double threeA() {
		// Vf, Vi, D
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "A" && values[i] != "T") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double Vi = vals[1];
		double Vf = vals[2];

		return (Math.pow(Vf, 2) - Math.pow(Vi, 2)) / (2 * D);
	}

	private static double threeD() {
		// Vf, Vi, A
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "D" && values[i] != "T") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double Vi = vals[0];
		double A = vals[1];
		double Vf = vals[2];

		return (Math.pow(Vf, 2) - Math.pow(Vi, 2)) / (2 * A);
	}

	private static void four() {
		System.out.println("-------------------------");
		String s = "You have picked the equation : D = (T)(Vi + Vf)/2";
		System.out.println(s);
		System.out.println("Which variable are you solving for?");

		int count = 1;
		for (int i = 0; i < values.length; i++) {
			if (s.contains(values[i])) {
				System.out.println(count + ". " + values[i]);
				count++;
			}
		}
		System.out.println("5. Quit");

		int choice = scan.nextInt();
		System.out.println("-------------------------");

		if (choice == 5) {
			return;
		} else {
			switch (choice) {
			case 1:
				System.out.println("D = " + fourD());
				break;
			case 2:
				System.out.println("T = " + fourT());
				break;
			case 3:
				System.out.println("Vi = " + fourVi());
				break;
			case 4:
				System.out.println("Vf = " + fourVf());
				break;
			}
		}
		System.out.println("-------------------------");
		anotherOne();
	}

	private static double fourD() {
		// T, Vi, Vf
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "D" && values[i] != "A") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double Vi = vals[0];
		double T = vals[1];
		double Vf = vals[2];

		return T * (Vi + Vf) / 2;
	}

	private static double fourT() {
		// D, Vi, Vf
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "T" && values[i] != "A") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double Vi = vals[1];
		double Vf = vals[2];

		return 2 * D / (Vi + Vf);
	}

	private static double fourVi() {
		// D, T, Vf
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vi" && values[i] != "A") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double T = vals[1];
		double Vf = vals[2];

		return (2 * D / T) - Vf;
	}

	private static double fourVf() {
		// D, T, Vi
		double[] vals = new double[3];

		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != "Vf" && values[i] != "A") {
				System.out.print(values[i] + " = ");
				vals[count] = scan.nextDouble();
				System.out.println();
				count++;
			}
		}

		double D = vals[0];
		double T = vals[1];
		double Vi = vals[2];

		return (2 * D / T) - Vi;
	}
}
