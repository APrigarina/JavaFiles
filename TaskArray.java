import java.util.Arrays;
import java.util.Scanner;

public class TaskArray {

	int size;
	int[] array;
	int[] newArray;

	TaskArray(int a) {
		size = a;
		array = new int[size];
		newArray = new int[size];
	}

	public static void main(String[] args) {

		System.out.println("Enter your numbers through the space");

		Scanner in = new Scanner(System.in);
		String enter = in.nextLine();

		String[] numbers = enter.split(" ");
		int[] intNumbers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++)
			intNumbers[i] = Integer.parseInt(numbers[i]);

		TaskArray result = new TaskArray(5);

		result.create(intNumbers);
		result.delete(7);
		result.print();
	}

	private void create(int[] arr) {

		int i = 0;
		while (i < arr.length) {
			int element = arr[i];
			array[i] = element;
			i++;
			if (i == array.length - 1) {
				for (int j = 0; j < array.length; j++) {
					newArray[j] = array[j];
				}
				array = new int[array.length * 2];
				for (int j = 0; j < newArray.length; j++) {
					array[j] = newArray[j];
				}
				newArray = new int[array.length];
				continue;
			}
		}

	}

	private void delete(int k) {

		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == k)
				array[i] = 0;
		}

	}

	private void print() {
		
		System.out.println("Array: " + Arrays.toString(array));
		
	}
}
