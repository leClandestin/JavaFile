package projects;

import java.util.Random;

/**
 * Handles transmission, parity checking, error introduction, and detection.
 */
public class ParityCheck {
	private String transmissionData;
	private String receivedData;
	private String parity;

	/**
	 * Generating random binary String
	 * 
	 * @return a generated binary String
	 */
	public String generateRandomBinary(int length) {
		Random rand = new Random();
		StringBuilder binary = new StringBuilder();
		for (int i = 0; i < length; i++) {
			binary.append(rand.nextInt(2));
		}
		transmissionData = binary.toString();
		return transmissionData;
	}

	/**
	 * Introduce error to binary string depending on the probability
	 */
	public String introduceError(String binary, double probability) {
		Random rand = new Random();
		StringBuilder newBinary = new StringBuilder();

		for (int i = 0; i < binary.length(); i++) {
			if (rand.nextDouble() < probability) {
				char bit = binary.charAt(i);
				if (bit == '0') {
					newBinary.append('1');
				} else {
					newBinary.append('0');
				}
				newBinary.append(binary.substring(i + 1));
				break;
			} else {
				newBinary.append(binary.charAt(i));
			}
		}

		if (newBinary.length() < binary.length()) {
			newBinary.append(binary.substring(newBinary.length()));
		}

		receivedData = newBinary.toString();
		return receivedData;
	}

	/**
	 * Count the number of 1 in binary string
	 */
	public int hammingWeight(String binaryString) {
		int count = 0;
		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	/**
	 * check binary string even or odd
	 */
	public String checkParity(String binaryString) {
		int one = hammingWeight(binaryString);
		if (one % 2 == 0) {
			parity = "Even";
		} else {
			parity = "Odd";
		}
		return parity;
	}

	/**
	 * detect error between transmitted and received string
	 */
	public boolean detectError(String transmitted, String received) {
		int incorrect = 0;
		for (int i = 0; i < transmitted.length(); i++) {
			if (transmitted.charAt(i) != received.charAt(i)) {
				incorrect++;
			}
		}
		if (incorrect % 2 != 0) {
			return true;
		} else {
			return false;

		}
	}

	/**
	 * return toString transmission results
	 */
	public String toString() {
		return "\nTransmitted Data: " + transmissionData + "\nParity of Transmitted Data: " + parity
				+ " parity\n\nReceived Data: " + receivedData;
	}
}
