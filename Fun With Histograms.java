// Stan Shabanov 
// 12.07.2022
import java.io.*;
import java.util.*;
public class FunWithHistograms {
    //Main method is used to print the start messages and used to return/call methods used
    //in this programming assignment
    //parameters : none
    //return : none 
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("The program will analyze data from a dataset of");
        System.out.println("non-negative integer values. It will produce a");
        System.out.println("histogram of the data and output some statistics.");
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("input file name? ");
        String fileName = scan.next();
        System.out.println();
        int[] array = scanz(new Scanner(new File(fileName)));
        int[] arrayz = eachVal(array); //made new array for histogram 
        histogram(arrayz);
        summary(array, arrayz);
    }
    //method takes the values from given file and translates it into a array
    //parameters : 
    //  - scanner, it takes in correct scanner based on the input of the user
    //    when prompted to tell which file to scan
    //return :
    //  - data, it returns the data from the file and we used a int array to 
    //    be allowed to return a array
    public static int[] scanz (Scanner scan){
        int numVals = scan.nextInt();
        int[] data = new int[numVals];
        for (int i = 0; i < numVals; i++) {
            data[i] = scan.nextInt();
        }
        return data;
    }
    //method takes takes the array from last method and used it the information to 
    //find the index where the max integer appears
    //parameters : 
    //  - array, the array we returned from last method is used as a paramter to find
    //    which index has the max value
    //return :
    //  - index, returns the index where the max is found
    public static int arrayMax (int[] array){
        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        } 
        return index;
    }
    //method takes the same array used for scanner to find the occurance of each
    //value in the array and make a array with itq1
    //parameters : 
    //  - array, the array we returned from last method is used as a paramter to find
    //    the amount of times a value has been 
    //return :
    //  - arrayz, returns the array we just made into the main method to be used for the next methods
   public static int[] eachVal (int [] array){
        int[] arrayz = new int[array[arrayMax(array)] + 1]; //makes return array of size max val + 1 to store all possible values
        for(int i = 0; i <= array[arrayMax(array)]; i++){ //loops through the indexes of array we will return
            int count = 0;
            for(int j = 0; j < array.length; j++){ //loops through the parameter array
                if(i == array[j]){ //checks each value in parameter array to see if it is = to the index
                    count++; //adds to count bc the value occurred in the parameter array
                }
            }
            arrayz[i] = count; //sets the value at index i with how many occurrences there were of that index in parameter array
        }
        
        return arrayz;
    }
    //method makes a for loop that reads through the array to find the mean of the values
    //parameters : 
    //  - array, the array we returned from last method is used as a paramter to find
    //    the mean/average value in the given array
    //return :
    //  - mean, returns a measn to be used as a integer for the summary stats
    public static double mean (int[] array){
        double total = 0.0;
        for(int i=0; i < array.length; i++){
        	total = total + array[i];
        }
        double mean = total / array.length;
        return mean;
    }
    //method finds the mode using a array of integers using a int for index and
    // a int called mode to be used in a for loop
    //parameters : 
    //  - array, the array we returned from last method is used as a paramter to find
    //    the mode using the values of the array
    //return :
    //  - index, returns a integer that will be used for the summary stats
    public static int mode (int[] array){
        int mode = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > mode) {
                mode = array[i];
                index = i;
            }
        } return index;
    }
    //method builds and prints a histogram and we use a nested for loop to make it happen
    //parameters : 
    //  - array, we used the array that has occurance of each value and used its informatiom
    //    to be printed into a histogram
    //return : None 
    public static void histogram (int[] array){
        for (int i = 0; i < array.length; i ++){
            System.out.print(i + "| ");
            for (int j = 0; j< array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }   
    }
    //method prints the summary stats found from the mean and mode method and prints it here
    //parameters : 
    //  - data,  this is the first array we made from taking in all the values from the file
    //  - counts, this array was taken from the occurance of values in the file
    //return : None
    public static void summary (int[] data, int[] counts){
        System.out.println();
        System.out.println("Num. Values: " + data.length);
        System.out.println("Mean: " + mean(data));
        System.out.println("Mode: " + mode(counts));
    }
}
