//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmailFinder {
//
//    public static void main(String[] args) {
//        // Read the list of names from a file
//        List<String> names = readNamesFromFile("Assignment.txt");
//
//        // Set the email address format
//        String emailFormat = "{first}.{last}@domain.com";
//
//        // Search for the email address for "Jane Doe"
//        String targetName = "Cheng Thao";
//        String targetEmail = findEmail(names, emailFormat, targetName);
//
//        // Print the email address
//        System.out.println("Email address for " + targetName + ": " + targetEmail);
//    }
//
//    public static List<String> readNamesFromFile(String fileName) {
//        List<String> names = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                names.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return names;
//    }
//
//    public static String findEmail(List<String> names, String emailFormat, String targetName) {
//        // Split the email format into its components
//        String[] emailParts = emailFormat.split("\\.");
//        String firstPart = emailParts[0];
//        String lastPart = emailParts[1];
//
//        // Loop through the names and generate the email addresses
//        for (String name : names) {
//            // Split the name into first and last name
//            String[] nameParts = name.split(" ");
//            String firstName = nameParts[0];
//            String lastName = nameParts[1];
//
//            // Generate the email address
//            String email = firstPart.replace("{first}", firstName) + "." + lastPart.replace("{last}", lastName);
//
//            // If this is the target name, return the email address
//            if (name.equals(targetName)) {
//                return email;
//            }
//        }
//
//        // If the target name was not found, return null
//        return null;
//    }
//}

//





import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class EmailFinder {

    public static void main(String[] args) {
        // define the first and last name of the person we want to search for
        String firstName = "andualem";
        String lastName = "teshome";

        // create a BufferedReader to read the list of email addresses from a file
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Assignment.txt"));
            String email = null;
            // read each line (email address) from the file
            while ((email = reader.readLine()) != null) {
                // extract the first and last name from the email address
                String emailFirstName = email.split("\\.")[0];
                String emailLastName = email.split("\\.")[0].split("@")[0];

                // convert the names to lowercase for case-insensitive matching
                emailFirstName = emailFirstName.toLowerCase();
                emailLastName = emailLastName.toLowerCase();
                firstName = firstName.toLowerCase();
                lastName = lastName.toLowerCase();
                // check if the first and last names match
                if (emailFirstName.equals(firstName) && emailLastName.equals(lastName)) {
                    // if the names match, print the email address and break out of the loop
                    System.out.println(email);
                    break;
                } else {
                    System.out.println("The email is not there");
                }
            }
        } catch (IOException e) {
            // handle exception
        } finally {
            // close the reader
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // handle exception
                e.printStackTrace();
            }
        }
    }
}

//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class EmailFinder {
//    public static void main(String[] args) {
//        // Read the name of the file to search from the command line
//        //String fileName = args[0];
//
//        // Read the first and last name to search for from the command line
//        String firstName = args[1];
//        String lastName = args[2];
//
//        // Initialize a variable to store the email address we find
//        String emailAddress = "";
//
//        // Try to open the file and read through it line by line
//        try (BufferedReader reader = new BufferedReader(new FileReader("Assignment.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // Split the line into an array of words
//                String[] words = line.split(" ");
//
//                // Check if the first and last name are contained in the line
//                if (words[0].equals(firstName) && words[1].equals(lastName)) {
//                    // If they are, store the email address (assumed to be the third word)
//                    emailAddress = words[2];
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred while reading the file: " + e.getMessage());
//        }
//
//        // Print the email address we found, or an error message if we didn't find one
//        if (emailAddress.length() > 0) {
//            System.out.println("Email address: " + emailAddress);
//        } else {
//            System.out.println("Email address not found for " + firstName + " " + lastName);
//        }
//    }
//}
//
