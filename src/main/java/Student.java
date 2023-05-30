/*
 * Do the previous OOP task.
 * Create the class to represent a student, student has a name, last name and age.
 * Create getter and setters, in setter method for the name create a logic to check if the lenght of name is less
 * than 3, than throw an exception with some message.
 * Create a test class with static main() method, create a new object of class Student, call the setter() method
 * with name less than 3, catch the exception and print a message, that exception did happen."
 */
public class Student {

    public String firstName;
    public String lastName;
    public int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.length() < 3) {
            throw new IndexOutOfBoundsException("The name can`t be less than 3 letters");
        } else {
            try {
                this.firstName = firstName;
            } catch (Exception IndexOutOfBoundsException) {

            }
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
