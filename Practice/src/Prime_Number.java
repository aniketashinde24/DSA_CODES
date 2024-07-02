import java.util.Scanner;

public class Prime_Number {
	public static boolean isPrime(int number) {
		
		int count = 0;
		for(int i=2; i < number/2 ;i++) {
			if(number % i == 0) {
				count++;
			}
		}
		
		return (count >= 1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
			System.out.println("Enter number to check is prime or not !!");
		int number = sc.nextInt();

		if (isPrime(number)) {
			System.out.println(number + "  " + "is not prime");
		}else {
			System.out.println(number +"  " + "is  prime");
		}
	}

}
