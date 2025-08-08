package Aug06;

public class Lab1 {
 
    private String firstName;
    private String lastName;
    private char gender;


    public static class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    public Lab1() {}

    public Lab1(String firstName, String lastName, char gender) throws InvalidNameException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new InvalidNameException("First name cannot be blank.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new InvalidNameException("Last name cannot be blank.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public void setFirstName(String firstName) throws InvalidNameException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new InvalidNameException("First name cannot be blank.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws InvalidNameException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new InvalidNameException("Last name cannot be blank.");
        }
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static void main(String[] args) {
        try {
            Lab1 person = new Lab1("Richa", "", 'F');  
            System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
            System.out.println("Gender: " + person.getGender());
        } catch (InvalidNameException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
