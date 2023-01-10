import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class EmailFinder {

	public static void main(String[] args) {
		// define the first and last name of the person we want to search for
		Scanner inputFirstName = new Scanner(System.in);  // Create a Scanner object
	    System.out.print("Enter First Name : ");
	    String firstName = inputFirstName.nextLine();
	    Scanner inputLastName = new Scanner(System.in);
	    System.out.print("Enter Last Name : ");
	      // Read user input
	    String lastName = inputLastName.nextLine();
	    boolean emailFound = false;
	    //System.out.println("Username is: " + userName);  // Output user input
	    
		/*
		 * String firstName = "Joe"; String lastName = "Peter";
		 */
		//andualemteshome
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Assignment.txt"));
			
			  int lines = 0; 
			  while (reader.readLine() != null) lines++; 
			  reader.close();
			 

			reader = new BufferedReader(new FileReader("Assignment.txt"));
			String email = null;
			// read each line (email address) from the file
			List lines1 = new ArrayList();
			for(int i=1; i<=lines; i++)
			{
				 lines1.add(reader.readLine());
				 
			}
			
			for (int i=0; i<=lines1.size() - 1; i++)
			{
				String email1 = lines1.get(i).toString();
				String emailLastName = email1.split("@")[0];
				
				String firtAndLastName = firstName + lastName;
				//if (emailFirstName.equals(firstName) && emailLastName.equals(lastName)) {
				//This is for people that have their first and last name as their email address
				if (emailLastName.equalsIgnoreCase(firtAndLastName)) {
					// if the names match, print the email address and break out of the loop
					System.out.println(lines1.get(i).toString());
					System.out.println("Customer "+firstName+" "+lastName+ " email address is "+ lines1.get(i).toString());
					emailFound = true;
					break;
				}
				//This is for customers/clients that have their names and email listed together. 
				if(email1.contains(":"))
				{
					String[] customerNameAndEmail =  email1.split(":");
					String customerFullName = customerNameAndEmail[0].toString();
					
					if(firtAndLastName.equalsIgnoreCase(customerFullName.replace(" ", ""))){
						System.out.println(lines1.get(i).toString());
						System.out.println("Customer "+firstName+" "+lastName+ " email address is "+ customerNameAndEmail[1]);
						emailFound = true;
						break;
					}
				}
				
			}
			if(emailFound == false) { 
				System.out.println("Customer "+firstName+" "+lastName+" email not found in the provided data");
			}
			
		} catch (IOException e) {
			// handle exception
			e.printStackTrace();
			//System.setOut(out);
		} 
		
	}
}
