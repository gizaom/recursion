package arrayrecursion;
import java.util.Random;
/**
 Author: Kevin De Jesus
 File: ArrayRecursion.java
 I affirm that this program is entirely my own work and none of it is the work 
 of any other person.
	__________Kevin De Jesus_________
	(your signature)
 */
public class ArrayRecursion {
    //instance variables
    private int[] list; //array of ints
    private int count = 0; //number of elements used
    
    /**
     * Create an ArrayRecursion object. Create an array with between 10 and 15
     * elements, and fill it with random positive 2-digit ints
     */
    public ArrayRecursion(){
        Random r = new Random();
        count = r.nextInt(6) + 10;
        list = new int[count];
        
        for(int i = 0; i < count; i++){
            list[i] = r.nextInt(90) + 10;
        }
    }
    
    /**
     * Return the list as a string
     * @return a string containing all ints stored in list
     */
    @Override
    public String toString(){
        String out = "";
        for(int i = 0; i < count; i++){
            out += list[i] + " ";
        }
        return out += "\n";
    }
    
    /**
     * Reverse the order of the values stored in the list. (called by client to
     * reverse list using first algorithm)
     */
    public void reverse(){
        reverseRecurse(list, 0, count);
    }
    
    /**
     * Reverses the order of integers in an array.
     * @param list the array of integers
     * @param start beginning of the list
     * @param count amount of elements in the list
     */
    //recursive "helper" method to reverse the values stored in the list
    //(called by public method reverse1())
    private void reverseRecurse(int[] list, int start, int count){
        if(start < count){
            int temp = list[start]; //start of list temporarily stored
            list[start] = list[count - 1]; //last element stored in the start 
                                           //index
            list[count - 1] = temp;//last index replaced with the value that was
                                   //originally first and stored in temp
                                   
            /**
             * the method is called again but with the start index moving up by
             * one spot and count index moving down by one. This method will
             * call itself until the list is reversed.
             */                       
            reverseRecurse(list, start + 1, count - 1);
        }
    }
    
    /**
     * Returns the index of the largest value in the array.
     * @return the index of the largest value in the array
     */
    public int getIndexOfLargest(){
        return recursiveGetIndexOfLargest(list, count);
    }
    
    /**
     * Returns the index of the largest value in the array.
     * @param list the array of integers
     * @param count amount of elements in the list
     * @return index of largest value
     */
    //recursive "helper" method to return index of largest value
    //(called by public method getLargest())
    private int recursiveGetIndexOfLargest(int[] list, int count){
        if(count == 1){
            return count - 1;//returns the first index if the list only has one
                             //element
        }
        
        int index = recursiveGetIndexOfLargest(list, count - 1);
        /**
         * index will first store the last element in the list, and the method 
         * will call itself with the index moving to the left until largest 
         * value is found
         */
        if(list[index] < list[count - 1]){
            return count - 1;
        }
        return index;
    }
    
    /**
     * Sort the array in ascending order using the selection sort
     */
    public void sort(){
        recursiveSort(list, count);
    }
    
    /**
     * Sorts the array of integers.
     * @param list the array of integers
     * @param count number of elements in the list
     */
    //recursive "helper" method to sort the array
    //(called by public method sort())
    private void recursiveSort(int[] list, int count){
        if(count > 1){
            int temp = list[count - 1];//starts with last element
            /**
             * finds the index containing the largest value
             */
            int index = recursiveGetIndexOfLargest(list, count);
            list[count - 1] = list[index];//makes the largest value the last 
                                          //element
            list[index] = temp;//index where the current largest value was 
                               //located switches with the last value in list
            recursiveSort(list, count - 1);//calls itself until list is fully 
                                           //sorted
        }
    }
    
    public static void main(String[] args){
        ArrayRecursion list = new ArrayRecursion();
        
        System.out.println("\nOriginal: " + list);
        list.reverse();
        System.out.println("\nReversed: " + list);
        System.out.println("\nLargest value is at index: " 
                + list.getIndexOfLargest());
        list.sort();
        System.out.println("\nSorted: " + list);
    }
}
