import java.util.Scanner; 
public class IntegerEvenOddCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String userInput = ""; 
		int userNum = 0; 
		String name = ""; 
		char continueToken = 'y'; 
		boolean validEntry = false; 
		
		System.out.println("Hi there, what is your name?"); 
		name = scan.nextLine(); 
		
		while (continueToken == 'y') {
		
		
			validEntry = false; //  needed to reset subsequent loops otherwise parseInt will run an error with non-numeric inputs. 
			System.out.println("Hello " + name + "! Please enter your number: "); 
			userInput = scan.next(); 
	
		while (validEntry == false)	{
			
			validEntry = true; // so that normally loop will exit unless something is wrong
			
			for (int i = 0; i < userInput.length(); i++) { // for loop over entire String is used so that if the first character is a number but subsequent numbers are not, there will be no issue
				if (Character.isDigit(userInput.charAt(i)) == false) {
					validEntry = false; 
				}
			}
			
			if (validEntry == false) {
				System.out.println("Error, this is not an integer, please try again:"); 
				userInput = scan.next(); 
			}
		}	
			userNum = Integer.parseInt(userInput); 
			
			while (userNum < 1 || userNum > 100) {  //non-numeric cases have already been handled so this just makes sure it is within range. 
				System.out.println("Error, this calculator cannot operate on a number outside of the range 1 to 100. Please try again: "); 
				userInput = scan.next(); 
				userNum = Integer.parseInt(userInput); 
			}
			  
			
			System.out.print(userNum + ",");
			
			if (userNum % 2 == 1) {
				if (userNum > 60) {
					System.out.println(" Odd and over 60."); 
				} else {
				System.out.print(" Odd.");
				}
			} else if (userNum % 2 == 0) {
				if (userNum >= 2 && userNum <=25) {
					System.out.print(" Even and less than 25");
				}  else if (userNum >= 26) {  //  there is no need for two separate cases for over input being over 60 and input being between 26 and 60, since both of these options require the same output according to the Lab's build specifications. 
					System.out.print(" Even.");
				}  // second condition of >60 is ignored because both condition result in the same desired output of "Even."
			}
			
			System.out.println(""); 
			System.out.println("Continue? (y/n)"); 
			//Unfortunately there is no character input method in the scanner class, so the next three lines are necessary
			String continueString = scan.next(); 
			continueToken = continueString.charAt(0); 
			continueToken = Character.toLowerCase(continueToken);  //allows user to enter uppercase Y or N. 
			scan.nextLine(); // garbage line to clear out scanner. 
			
			
			if (continueToken == 'n') {
				System.out.println("Thank you for playing!");
				scan.close();
			}
			
		
		}
	
	
	

	}
}
