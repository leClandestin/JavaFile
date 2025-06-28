package projects;

import java.util.Scanner;

/**
 * ParityCheckTest check by generating binary data, provide and detects error
 * 
 * @author tran ly
 * 
 */
public class ParityCheckTest {
	/**
	 * Main method to call parityCheck and run the program
	 * 
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ParityCheck check = new ParityCheck();
		System.out.print("Enter binary string length number between 5 to 64: ");
		int length = scan.nextInt();
		if (length < 5 || length > 64) {
			System.out.println("Invalid");
		}

		System.out.print("Enter error number between 0 to 1: ");
		int error = scan.nextInt();
		if (error < 0 || error > 1) {
			System.out.println("Invalid");
		}
		String transmissions = check.generateRandomBinary(length);
		String parity = check.checkParity(transmissions);
		String received = check.introduceError(transmissions, error);
		boolean errorDetected = check.detectError(transmissions, received);
		System.out.println(check);
		if (errorDetected) {
			System.out.println("Error Detected: Yes");
		} else {
			System.out.println("Error Detected: No");
		}
	}
}
