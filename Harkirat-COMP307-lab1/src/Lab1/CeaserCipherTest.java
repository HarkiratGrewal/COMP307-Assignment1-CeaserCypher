package Lab1;
import java.util.Scanner;

public class CeaserCipherTest {    
    public static void main(String[] args) {
    	String message = "";
    	int key;
        while(true) {
        	Scanner scan = new Scanner(System.in);
        	System.out.print("Enter a message: ");
            message = scan.nextLine();
            do {
                System.out.print("Please a key: ");
                while (!scan.hasNextInt()) {
                    String input = scan.next();
//                    System.out.printf("\"%s\" is not a valid key.\n", input);
                    System.out.println("Enter a valid key: ");
                }
                key = scan.nextInt();
            } while (key < 0);
            System.out.println("Original Message: " + message);
            System.out.println("Encrypted Message: " + encrypt(message, key));
            System.out.println("Encrypted Message: " + decrypt(encrypt(message, key), key) + "\n");
        }	//	loop infinite
    }	//	main End
    public static String encrypt(String message, int key) {
		char ch;
		String encryptedMessage = "";
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch + key);
	            if(ch > 'z'){
	                ch = (char)(ch - 'z' + 'a' - 1);
	            }	//	Looping over after 'z'
	            encryptedMessage += ch;
	        }	else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch + key);
	            if(ch > 'Z'){
	                ch = (char)(ch - 'Z' + 'A' - 1);
	            }	//	Looping over after 'Z'
	            encryptedMessage += ch;
	        }	else {
	        	encryptedMessage += ch;
	        }	//	ifElse (character shifting)
		}	//	forLoop
		return encryptedMessage;
	}	//	encrypt
	public static String decrypt(String message, int key) {
		char ch;
		String decryptedMessage = "";
		for(int i = 0; i < message.length(); ++i){
			ch = message.charAt(i);
			if(ch >= 'a' && ch <= 'z'){
	            ch = (char)(ch - key);
	            if(ch < 'a'){
	                ch = (char)(ch + 'z' - 'a' + 1);
	            }	//	Looping over after 'z'
	            decryptedMessage += ch;
	        }
	        else if(ch >= 'A' && ch <= 'Z'){
	            ch = (char)(ch - key);
	            if(ch < 'A'){
	                ch = (char)(ch + 'Z' - 'A' + 1);
	            }	//	Looping over after 'Z'
	            decryptedMessage += ch;
	        }
	        else {
	        	decryptedMessage += ch;
	        }	//	ifElse (character shifting)
		}	//	forLoop
		return decryptedMessage;
	}	//	encrypt
}	//	CaeserCipher Class End