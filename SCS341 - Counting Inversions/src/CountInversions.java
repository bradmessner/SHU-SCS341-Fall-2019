//******************************************************************************
// * Application: Counting Inversions
// * Author: Emily Grove
// * Date Created: 09/25/19
// * Description: This is an in class group project to successfully code a count
// * inversion alogrithm. 
// * Supplements: none 
//******************************************************************************


/**
 *
 * @author e.grove
 */
import java.util.Scanner;

public class CountInversions {

    static int[] getCount(int[] array) {
        int inversion = 0;
        int placeholder = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    inversion++;
                    for (int p = j; p > i; p--) {
                        placeholder = array[p];
                        array[p] = array[p - 1];
                        array[p - 1] = placeholder;
                    }
                }
            }
        }
        System.out.println("\nThe number of inversions is " + inversion);
        return array;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int arr[] = new int[5];
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter 5 numbers, separated by spaces ");

        for (int m = 0; m < 5; m++) {
            arr[m] = keyboard.nextInt();
        }

        System.out.print("The original list was ");

        for (int n = 0; n < arr.length; n++) {
            System.out.print(arr[n] + " ");
        }

        getCount(arr);

        System.out.print("The new list is ");

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }

    }

}
