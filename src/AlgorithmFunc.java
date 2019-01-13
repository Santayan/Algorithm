/**
 *
 */
package main;

/**
 * @author pauls
 *
 */
public class AlgorithmFunc {

    private int[] theARRAY = new int[50];
    private int arraySize = 10;

    public void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            theARRAY[i] = (int) (Math.random() * 20) + 1;
        }
    }

    public void printArray(){
        System.out.println("---------");
        for(int j=0;j<arraySize;j++){
            System.out.print("|" + j + "|  ");
            System.out.println(theARRAY[j] + "  |");
            System.out.println("---------");
        }
    }

    public int getValueAtIndex(int index){
        if(index<arraySize) return theARRAY[index];
        return 0;
    }

    public boolean doesArrayContainValue(int searchValue){
        boolean valueInArray = false;
        for(int b=0;b<arraySize;b++){
            if(theARRAY[b] == searchValue){
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    public void deleteIndex(int index){
        if(index < arraySize){
            for(int i = index;i<(arraySize-1);i++) {
                theARRAY[i] = theARRAY[i + 1];
            }
            arraySize--;
        }
    }

    public void insertValue(int value){
        if(arraySize<theARRAY.length){
            theARRAY[arraySize] = value;
            arraySize++;
        }
    }

    /*  ---------------------------------------------------------------     */
    /*                      LINEAR SEARCH                                  */
    /*  ---------------------------------------------------------------   */
    public String linearSearchForValue(int value){
        boolean valueInArray = false;
        String indexsWithValue = "";
        System.out.println("The Value Was Found At Index : ");
        for(int i=0 ; i<arraySize;i++){
            if(theARRAY[i] == value){
                valueInArray = true;
                System.out.print(i + "  ");
                indexsWithValue+= i + "  ";
            }
        }
        if(!valueInArray){
            indexsWithValue = "NONE";
            System.out.print(indexsWithValue);
        }
        System.out.println();
        return indexsWithValue;
    }
    /*  ---------------------------------------------------------------     */
    /*                      LINEAR SEARCH                                  */
    /*  ---------------------------------------------------------------   */


    /*  ---------------------------------------------------------------     */
    /*                      BINARY SEARCH                                  */
    /*  ---------------------------------------------------------------   */
    public void binarySearchForValue(int value){
        int lowIndex = 0;
        int highIndex = arraySize-1;
        while(lowIndex<=highIndex) {
            int middleIndex = (highIndex + lowIndex)/2;
            if(theARRAY[middleIndex] < value ) lowIndex = middleIndex +1;
            else if (theARRAY[middleIndex] > value) highIndex = middleIndex - 1 ;
            else {
                System.out.println("\n Found A Match For " + value + " at Index " + middleIndex);
                lowIndex = highIndex +1;
            }
            //printHorzArray(middleIndex,-1);
        }
    }
    /*  ---------------------------------------------------------------     */
    /*                      BINARY SEARCH                                  */
    /*  ---------------------------------------------------------------   */


    /*  ---------------------------------------------------------------     */
    /*                      BUBBLE SORT                                    */
    /*  ---------------------------------------------------------------   */
    public void bubbleSort() {
        for(int x = arraySize ; x>0 ; x--) {
            for(int j=0;j<x;j++) {
                if(theARRAY[j] > theARRAY[j + 1]){
                    swapValues(j,j+1);
                    printHorzArray(x,j);
                }
            }
        }
    }

    public void swapValues(int indexOne , int indexTwo) {
        int temp = theARRAY[indexOne];
        theARRAY[indexOne] = theARRAY[indexTwo];
        theARRAY[indexTwo] = temp;
    }
    /*  ---------------------------------------------------------------     */
    /*                      BUBBLE SORT                                    */
    /*  ---------------------------------------------------------------   */


    /*  ---------------------------------------------------------------     */
    /*                      SELECTION SORT                                 */
    /*  ---------------------------------------------------------------   */
    public void selectionSort() {
        for(int ss=0;ss<arraySize;ss++) {
            int minimum = ss;
            for(int y=ss;y<arraySize;y++) {
                if(theARRAY[minimum]>theARRAY[y]) {
                    minimum=y;
                }
            }
            swapValues(ss,minimum);
            printHorzArray(ss,-1);
        }
    }
    /*  ---------------------------------------------------------------     */
    /*                      SELECTION SORT                                 */
    /*  ---------------------------------------------------------------   */


    /*  ---------------------------------------------------------------     */
    /*                      INSERTION SORT                                 */
    /*  ---------------------------------------------------------------   */
    public void insertionSort() {
        for (int i = 1; i < arraySize; i++){
            int j = i;
            int toInsert = theARRAY[i];
            while ((j > 0) && (theARRAY[j-1] > toInsert)){
                theARRAY[j] = theARRAY[j-1];
                j--;
                printHorzArray(i, j);
            }
            theARRAY[j] = toInsert;
            printHorzArray(i, j);
            System.out.println("\nArray[i] = " + theARRAY[i] + " Array[j] = " + theARRAY[j] + " toInsert = " + toInsert + "\n");
        }
    }
    /*  ---------------------------------------------------------------     */
    /*                      INSERTION SORT                                 */
    /*  ---------------------------------------------------------------   */


    public void printHorzArray(int i, int j){
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < arraySize; n++){
            System.out.print("| " + n + "  ");
        }
        System.out.println("|");
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        for(int n = 0; n < arraySize; n++){
            System.out.print("| " + theARRAY[n] + " ");
        }
        System.out.println("|");
        for(int n = 0; n < 51; n++)System.out.print("-");
        System.out.println();
        if(j != -1){
            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
            System.out.print(j);  }
        if(i != -1){
            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
            System.out.print(i);
        }
        System.out.println();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        AlgorithmFunc algo = new AlgorithmFunc();
        algo.generateRandomArray();
        algo.printArray();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Value At Index 7 is: " + algo.getValueAtIndex(7));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(algo.doesArrayContainValue(3));
        algo.deleteIndex(5);
        System.out.println("------------------------------------------------------------------------------");
        algo.printArray();
        algo.insertValue(9999);
        System.out.println("------------------------------------------------------------------------------");
        algo.printArray();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("----------------------  LINEAR SEARCH  ---------------------------------------");
        algo.linearSearchForValue(4);
        System.out.println("----------------------  LINEAR SEARCH  ---------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------  BUBBLE SORT  ----------------------------------------");
        algo.bubbleSort();
        System.out.println("------------------------  BUBBLE SORT  ----------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("----------------------  BINARY SEARCH  ---------------------------------------");
        algo.binarySearchForValue(13);
        System.out.println("----------------------  BINARY SEARCH  ---------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("----------------------  SELECTION SORT  --------------------------------------");
        algo.selectionSort();
        System.out.println("----------------------  SELECTION SORT  --------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("----------------------  BINARY SEARCH  ---------------------------------------");
        algo.binarySearchForValue(13);
        System.out.println("----------------------  BINARY SEARCH  ---------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("----------------------  INSERTION SORT  --------------------------------------");
        algo.insertionSort();
        System.out.println("----------------------  INSERTION SORT  --------------------------------------");

    }

}
