1. Basic Try-Catch Scenario
Scenario: Exception occurs and is caught successfully.
Example:

java
Copy
Edit
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int a = 10 / 0; // Causes ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
Output:

csharp
Copy
Edit
Cannot divide by zero!
✅ Exception handled properly, so the program does not crash.

2. Try-Catch with Finally Block
Scenario: finally block executes regardless of exception occurrence.
Example:

java
Copy
Edit
public class FinallyExample {
    public static void main(String[] args) {
        try {
            int a = 10 / 0; // Exception occurs
        } catch (ArithmeticException e) {
            System.out.println("Exception caught!");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
Output:

php
Copy
Edit
Exception caught!
Finally block executed.
✅ finally block executes even after exception handling.

3. Scenario Without Exception (Finally Still Executes)
Scenario: No exception occurs, but the finally block still executes.
Example:

java
Copy
Edit
public class NoExceptionExample {
    public static void main(String[] args) {
        try {
            int a = 10 / 2; // No exception
            System.out.println("Inside try block.");
        } catch (ArithmeticException e) {
            System.out.println("Exception caught!");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
Output:

scss
Copy
Edit
Inside try block.
Finally block executed.
✅ finally executes even when no exception occurs.

4. Try Block Without Catch but With Finally
Scenario: The program will still execute the finally block.
Example:

java
Copy
Edit
public class TryFinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Try block executed.");
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
Output:

scss
Copy
Edit
Try block executed.
Finally block executed.
✅ A finally block is valid even without a catch block.

5. Multiple Catch Blocks (Child Exception First)
Scenario: A single try block can have multiple catch blocks, but child exceptions should come first.
Example:

java
Copy
Edit
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int arr[] = new int[5];
            System.out.println(arr[10]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds!");
        } catch (Exception e) {  // Parent exception
            System.out.println("Some other exception occurred.");
        }
    }
}
Output:

pgsql
Copy
Edit
Array index is out of bounds!
✅ The child exception (ArrayIndexOutOfBoundsException) is caught first, preventing the parent from handling it.

6. Multiple Exceptions in One Catch (Java 1.8 Feature)
Scenario: Using | to handle multiple exceptions in one catch.
Example:

java
Copy
Edit
public class MultiCatchExample {
    public static void main(String[] args) {
        try {
            int arr[] = null;
            System.out.println(arr.length); // Causes NullPointerException
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
Output:

php
Copy
Edit
Exception caught: java.lang.NullPointerException
✅ Multiple exceptions handled in a single catch block using |.

7. Finally Block Not Executing (System.exit(0))
Scenario: finally does not execute when System.exit(0) is used in try.
Example:

java
Copy
Edit
public class ExitExample {
    public static void main(String[] args) {
        try {
            System.out.println("Try block executed.");
            System.exit(0); // Terminates JVM
        } finally {
            System.out.println("Finally block executed."); // Will not execute
        }
    }
}
Output:

scss
Copy
Edit
Try block executed.
🚨 finally block is skipped because JVM exits before reaching it.

8. Throw vs Throws (User-Defined Exception)
Scenario: Using throw to create and throw a custom exception.
Example:

java
Copy
Edit
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ThrowExample {
    static void validate(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validate(16);
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
Output:

yaml
Copy
Edit
Caught exception: Age must be 18 or above.
✅ Custom exceptions help in meaningful error handling.

9. Catching Parent Exception (Generic Handling)
Scenario: If you are unsure of the exact exception type, use Exception as a parent.
Example:

java
Copy
Edit
public class ParentCatchExample {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("XYZ"); // NumberFormatException
        } catch (Exception e) {  // Parent exception
            System.out.println("Exception caught: " + e);
        }
    }
}
Output:

php
Copy
Edit
Exception caught: java.lang.NumberFormatException
✅ Using the parent exception class (Exception) as a fallback.

10. Using Finally Block to Close Resources
Scenario: Database connections, file operations, or network streams should be closed in finally.
Example:

java
Copy
Edit
import java.io.*;

public class FinallyResourceExample {
    public static void main(String[] args) {
        FileReader file = null;
        try {
            file = new FileReader("test.txt");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("File not found.");
        } finally {
            try {
                if (file != null) file.close(); // Ensuring the file is closed
                System.out.println("File closed.");
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}
Output:

arduino
Copy
Edit
File not found.
File closed.
✅ finally ensures that the file is always closed, preventing resource leaks.

Conclusion & Summary
Scenario	Expected Behavior
Try-Catch	Catches exceptions and prevents crashes
Finally Block	Always executes except in System.exit(0) case
Multiple Catch	Child exceptions must be caught first
Single Catch for Multiple Exceptions	Possible using `
Throw vs Throws	throw creates an exception, throws declares it
Custom Exception	Helps in meaningful error handling
Closing Resources in Finally	Prevents resource leaks
