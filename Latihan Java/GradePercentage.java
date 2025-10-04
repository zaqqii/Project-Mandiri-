import java.util.Scanner;

public class GradePercentage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user for input
        System.out.println("Masukkan huruf antara A dan F:");
        String input = scanner.nextLine().toUpperCase();
        
        // Validate the input
        if (input.length() != 1) {
            System.out.println("Input tidak valid. Harap masukkan satu huruf.");
            return;
        }
        
        // Get the grade from the input
        char grade = input.charAt(0);
        
        // Process the grade to get the percentage
        switch (grade) {
            case 'A':
                System.out.println("Persentase: 90 - 100");
                break;
            case 'B':
                System.out.println("Persentase: 80 - 89");
                break;
            case 'C':
                System.out.println("Persentase: 70 - 79");
                break;
            case 'D':
                System.out.println("Persentase: 60 - 69");
                break;
            case 'E':
            case 'F':
                System.out.println("Persentase: 0 - 59");
                break;
            default:
                System.out.println("Input tidak valid. Harap masukkan huruf antara A dan F.");
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }
}