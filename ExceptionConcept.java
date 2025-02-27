Exception Handling in Java
1. What is an Exception?
An exception is an abnormal condition that disrupts the normal flow of a program.
Exceptions occur due to various reasons like invalid input, resource unavailability, or logical errors.
When an exception occurs, the program execution is halted, and it does not proceed further unless handled properly.
2. Why Handle Exceptions?
To prevent program termination and allow smooth execution.
To debug and log errors properly for future reference.
To ensure resource management, such as closing database connections.
3. Exception Handling Mechanisms
Try-Catch Block
The try block contains the code that may cause an exception.
The catch block is used to handle the exception and prevent abnormal termination.
Example:

java
Copy
Edit
try {
    int a = 10 / 0;  // Causes ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
}
Finally Block
The finally block executes always, regardless of whether an exception occurs or not.
Typically used for resource cleanup like closing database connections.
Example:

java
Copy
Edit
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception caught!");
} finally {
    System.out.println("Finally block executed.");
}
Throw vs Throws
Feature	throw	throws
Purpose	Used to explicitly throw an exception	Used to declare exceptions a method can throw
Number of Exceptions	Handles only one exception	Can handle multiple exceptions (comma-separated)
Placement	Inside a method	In the method signature
Example	throw new ArithmeticException("Cannot divide by zero");	void myMethod() throws IOException, SQLException
4. Types of Exceptions
Checked Exceptions (Compile-time Exceptions)
Checked at compile time.
The program will not compile unless handled using try-catch or throws.
Examples:

IOException
SQLException
FileNotFoundException
Example Code:

java
Copy
Edit
import java.io.*;

public class CheckedExceptionExample {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("test.txt"); // This may cause an exception
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
    }
}
Unchecked Exceptions (Runtime Exceptions)
Occur during execution and are not checked at compile-time.
The program will compile successfully but crash at runtime if not handled.
Examples:

NullPointerException
ArrayIndexOutOfBoundsException
ArithmeticException
Example Code:

java
Copy
Edit
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[10]); // Causes ArrayIndexOutOfBoundsException
    }
}
5. Exception Class Hierarchy
java
Copy
Edit
Throwable  
│  
├── Exception (Handled using try-catch)  
│   ├── Checked Exceptions (IOException, SQLException)  
│   ├── Unchecked Exceptions (NullPointerException, ArithmeticException)  
│  
└── Error (System-level issues, cannot be recovered)  
    ├── StackOverflowError  
    ├── OutOfMemoryError  
Throwable is the parent class for both Exception and Error.
Errors represent serious system failures and should not be handled in code (e.g., StackOverflowError).
6. Difference Between Exception and Error
Feature	Exception	Error
Cause	Due to programming errors or invalid input	Due to system failure
Recoverable?	Yes, can be handled using try-catch	No, usually not recoverable
Examples	IOException, NullPointerException	StackOverflowError, OutOfMemoryError
7. Multiple Catch Blocks
A single try block can have multiple catch blocks to handle different exceptions.
Child exceptions must be caught first; otherwise, a compile-time error occurs.
Example:

java
Copy
Edit
try {
    int arr[] = new int[5];
    System.out.println(arr[10]);  // ArrayIndexOutOfBoundsException
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index is out of bounds!");
} catch (Exception e) {
    System.out.println("Some other exception occurred.");
}
8. Handling Multiple Exceptions with | Operator (Java 1.8 Feature)
Introduced in Java 8, allows handling multiple exceptions in a single catch block.
Example:

java
Copy
Edit
try {
    int a = 10 / 0;
} catch (ArithmeticException | NullPointerException e) {
    System.out.println("Exception caught: " + e);
}
9. When Does finally Block Not Execute?
The finally block always executes, except in the following scenario:
If System.exit(0); is called in the try block, terminating the JVM.
Example:

java
Copy
Edit
try {
    System.exit(0);
} finally {
    System.out.println("This will not be executed.");
}
10. printStackTrace() vs getMessage() vs System.out.println(e)
Method	Description
e.printStackTrace()	Prints the full stack trace (detailed debugging info)
e.getMessage()	Returns only the error message
System.out.println(e)	Calls toString(), prints exception type + message
Example:

java
Copy
Edit
try {
    int a = 10 / 0;
} catch (Exception e) {
    e.printStackTrace(); // Detailed error info
    System.out.println(e.getMessage()); // Only message
    System.out.println(e); // Exception type + message
}
11. Creating a Custom Exception
A custom exception extends the Exception class and is used for specific error handling.
Example:

java
Copy
Edit
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
12. Best Practices for Exception Handling
✅ Use specific exceptions instead of generic Exception class
✅ Close resources in the finally block
✅ Follow exception hierarchy while using multiple catch blocks
✅ Use throw for custom exceptions and throws for declaring exceptions
✅ Log exceptions properly using printStackTrace() or logging frameworks
