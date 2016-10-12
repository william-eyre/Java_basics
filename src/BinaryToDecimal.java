import java.util.Scanner;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class BinaryToDecimal {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter a binary number");
        String Binary = input.nextLine();

        convertToDecimal(Binary);

    }

    static void convertToDecimal(String binary) {


        int decimal = 0, mult = 1;
        int length = binary.length();


        for (int i = binary.length() - 1; i >= 0; i--) //this loop is looking at the binary length and starting at the end and counting down
        {
            if (binary.charAt(i) == '1') {
                decimal += mult;
            }
            mult = mult * 2;
        }
        System.out.println(decimal);

    }
}
