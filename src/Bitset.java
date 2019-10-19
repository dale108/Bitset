// Dale Berg
// CPSC 2600 - 02
// Homework 2, Programming portion
// 10/19/19

import java.util.Scanner;
public class Bitset {

    final static int[] UNIVERSAL_SET = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        int setA = 0;
        int setB = 0;

        Scanner console = new Scanner(System.in);
        int entry = 0;
        while( true ) {
            System.out.println("Input a value to be added to set A, or input -1 to move on to entry for set B: ");
            entry = console.nextInt();
            if (entry == -1) {
                break;
            }
            setA |= (1 << entry);
        }
        // reset entry value
        entry = 0;
        while( true ) {
            System.out.println("please input a value to be added to set B, or input -1 to finish: ");
            entry = console.nextInt();
            if (entry == -1) {
                break;
            }
            setB |= (1 << entry);
        }
        printSet("Set A ", Integer.parseInt(Integer.toBinaryString(setA)));
        printSet("Set B ", Integer.parseInt(Integer.toBinaryString(setB)));
        printSet("Union", Integer.parseInt(Integer.toBinaryString(setA | setB)));
        printSet("Intersection", Integer.parseInt(Integer.toBinaryString(setA & setB)));
        printSet("Difference", Long.parseLong(Long.toBinaryString(setA & ~setB)));
    }

    public static void printSet( String type, long binaryValue) {
        int index = 0;
        System.out.print( type + " = {");
        while(binaryValue != 0) {
            if ( binaryValue % 10 == 1 ) {
                System.out.print(" " + UNIVERSAL_SET[index] + " ");
            }
            binaryValue /= 10;
            index++;
        }
        System.out.print("}");
        System.out.println();
    }
}