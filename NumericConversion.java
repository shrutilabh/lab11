import java.util.Scanner;

//I am currently doing lab11 and learning how to use github. This program is being used for these purposes
public class NumericConversion {

    public static long hexStringDecode(String hex){
        //Deal with the ox as the first two letters
        if(hex.substring(0,2).equals("0x")) {
            hex = hex.substring(2);
        }

        hex = hex.toLowerCase();
        long hexDecode = 0;
        int base = 0;
        for( int i = hex.length()-1; i >= 0; i--){
            char numIndex = hex.charAt(i);
            if (Character.isDigit(numIndex)) {
                hexDecode += (numIndex - 48) * (Math.pow(16, base));
                base++;
            }
            if (Character.isLetter(numIndex)){
                hexDecode += hexCharDecode(numIndex) * (Math.pow(16, base));
                base++;

            }



        }
        return hexDecode;
    }

    public static short hexCharDecode (char digit){
        // this is the hex 'range' or number
        String range = "0123456789abcdef";
        digit = Character.toLowerCase(digit);
        //this getting the value for the character
        short charDecode = (short) range.indexOf(digit);
        return charDecode;
    }

    public static short binaryStringDecode(String binary){
        if(binary.substring(0,2).equals("0b")) {
            binary = binary.substring(2);
        }

        short total = 0;
        int base = 0;
        for( int i = binary.length()-1; i >= 0; i--) {
            char bin = binary.charAt(i);
            if (bin - 48 == 1) {
                total += Math.pow(2, base);
                base++;

            }
            if (bin - 48 == 0)
                base++;
        }

        return total;
    }

    public static String binaryToHex(String binary){

        return binary;
    }

    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);
        boolean game = true;


        do {

            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");

            int choice;

            System.out.print("Please enter an option: ");
            choice = scnr.nextInt();

            if (choice >= 4) {
                System.out.println("Goodbye !");
                game = false;
                break;

            } else if (choice == 1) {
                // decode hexadecimal
                String hexString;
                System.out.print("Please enter the numeric string to convert: ");
                hexString = scnr.next();
                System.out.print("Result: ");
                System.out.println(hexStringDecode(hexString));

            } else if (choice == 2){
                // decode binary
                String biString;
                System.out.print("Please enter the numeric string to convert: ");
                biString = scnr.next();
                System.out.print("Result: ");
                System.out.println(binaryStringDecode(biString));

            } else if ( choice == 3){
                // convert binary t0 hex
                String bibiString;
                System.out.print("Please enter the numeric string to convert: ");
                bibiString = scnr.next();
                System.out.print("Result: ");
                System.out.println(binaryToHex(bibiString));

            }

        } while(game);
    }
}

