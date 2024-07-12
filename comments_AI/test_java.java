import java.util.Scanner;

public class ComplexCalculator {
    /**
     * This method allows the user to perform arithmetic operations on complex numbers. 
     * The user is prompted to enter the real and imaginary parts of two complex numbers. 
     * The method then creates ComplexNumber objects using the input values. 
     * The user is then presented with a menu of operations to choose from (addition, subtraction, multiplication, division). 
     * After the user selects an operation, the method performs the corresponding operation on the complex numbers using the ComplexNumber class methods. 
     * The result is then printed to the console.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the real part of the first complex number: ");
        double real1 = scanner.nextDouble();
        System.out.print("Enter the imaginary part of the first complex number: ");
        double imag1 = scanner.nextDouble();
    
        System.out.print("Enter the real part of the second complex number: ");
        double real2 = scanner.nextDouble();
        System.out.print("Enter the imaginary part of the second complex number: ");
        double imag2 = scanner.nextDouble();
    
        ComplexNumber complex1 = new ComplexNumber(real1, imag1);
        ComplexNumber complex2 = new ComplexNumber(real2, imag2);
    
        System.out.println("\nPerforming operations on complex numbers:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
    
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
    
        ComplexNumber result;
        switch (choice) {
            case 1:
                result = ComplexNumber.add(complex1, complex2);
                System.out.println("Result of addition: " + result);
                break;
            case 2:
                result = ComplexNumber.subtract(complex1, complex2);
                System.out.println("Result of subtraction: " + result);
                break;
            case 3:
                result = ComplexNumber.multiply(complex1, complex2);
                System.out.println("Result of multiplication: " + result);
                break;
            case 4:
                result = ComplexNumber.divide(complex1, complex2);
                System.out.println("Result of division: " + result);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    /**
     * Adds two complex numbers.
     * 
     * @param num1 the first complex number
     * @param num2 the second complex number
     * @return the result of adding num1 and num2
     */
    public static ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        // Add the real parts of the two complex numbers
        double realPart = num1.real + num2.real;
        
        // Add the imaginary parts of the two complex numbers
        double imaginaryPart = num1.imaginary + num2.imaginary;
        
        // Create a new complex number using the sum of the real and imaginary parts
        return new ComplexNumber(realPart, imaginaryPart);
    }
    /**
     * This method subtracts two complex numbers.
     *
     * @param num1 the first complex number
     * @param num2 the second complex number
     * @return a new ComplexNumber object representing the result of the subtraction
     */
    public static ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2) {
        // Subtract the real parts and imaginary parts separately
        double realResult = num1.real - num2.real;
        double imaginaryResult = num1.imaginary - num2.imaginary;
        
        // Create a new ComplexNumber object with the subtracted values
        return new ComplexNumber(realResult, imaginaryResult);
    }
    /**
     * Multiplies two complex numbers.
     *
     * @param num1 the first complex number
     * @param num2 the second complex number
     * @return the product of the two complex numbers
     */
    public static ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        // calculate the real part of the product
        double real = num1.real * num2.real - num1.imaginary * num2.imaginary;
        
        // calculate the imaginary part of the product
        double imaginary = num1.real * num2.imaginary + num1.imaginary * num2.real;
        
        // create a new complex number with the calculated real and imaginary parts
        return new ComplexNumber(real, imaginary);
    }
    /**
     * Divides two complex numbers.
     *
     * @param num1 the first complex number
     * @param num2 the second complex number
     * @return a new complex number that is the result of dividing num1 by num2
     */
    public static ComplexNumber divide(ComplexNumber num1, ComplexNumber num2) {
        // Calculate the denominator
        double denominator = num2.real * num2.real + num2.imaginary * num2.imaginary;
        
        // Calculate the real part of the resulting complex number
        double real = (num1.real * num2.real + num1.imaginary * num2.imaginary) / denominator;
        
        // Calculate the imaginary part of the resulting complex number
        double imaginary = (num1.imaginary * num2.real - num1.real * num2.imaginary) / denominator;
        
        // Return the resulting complex number
        return new ComplexNumber(real, imaginary);
    }
    /**
     * Returns a string representation of the complex number in the form of (real + imaginary i).
     *
     * @return the string representation of the complex number
     */
    @Override
    public String toString() {
        // Concatenates the real and imaginary parts of the complex number with the appropriate formatting
        return "(" + real + " + " + imaginary + "i)";
    }
}
