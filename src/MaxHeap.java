// Aiden Wells 
// axw1@stmarys-ca.edu
// 415-301-1273
// CS-222-01
// Professor Das
// Assignment 3: Binary Max Heap
// 05-11-2024

// MaxHeap class
public class MaxHeap {
    
    // Three properties: heaparray, size, and maxsize.
    private int[] heaparray;
    private int size;
    private int maxsize;

    // Constructor method: Create new array of size arraysize.
    public MaxHeap(int arraysize){
        maxsize = arraysize;
        size = 0;
        heaparray = new int[maxsize];
    }

    // Method for inserting value into heap.
    public void insertintoarray(int x){
        heaparray[size] = x;
        int temp = 0;
        if(size > 0){
            int indexval = size;
            int parentindex = (indexval - 1)/2;
            // If value is greater than parent value, swap with parent.
            while(x > heaparray[parentindex]){
                temp = heaparray[parentindex];
                heaparray[parentindex] = heaparray[indexval];
                heaparray[indexval] = temp;
                indexval = parentindex;
                parentindex = (indexval - 1)/2;
            }
        }
        // Increment size
        size++;
    }

    // extractmax method is used to extract the maximum value at index 0 from the
    // array. When maxvalue is extracted, it is replaced with the last value in the
    // array. Heapify is then called to restructure the array. 
    public int extractmax(){
        int maxvalue = 0;
        if(size>0){
            maxvalue = heaparray[0];
            // Move last value from array to index 0.
            heaparray[0] = heaparray[size];
            // Call heapify to restructure array.
            heapify(0);
            // Decrement size.
            size--;
        }
        return maxvalue;
    }

    // heapify restructures the array after extracting the max value. 
    private void heapify(int x){
        int temp = 0;
        int largest = x;
        int left_index = (2*x)+1;
        int right_index = (2*x)+2;
        
        // Check left child to see if it is larger than parent.
        if(left_index<size){
            if(heaparray[left_index]>heaparray[largest]){
                largest = left_index;
            }
        }
        // Check right child to see if it is larger than parent and left child.
        if(right_index<size){
            if(heaparray[right_index]>heaparray[largest]){
                largest = right_index;
            }
        }
        // If largest is left child or right child, swap with parent and call
        // heapify recursively.
        if(largest!=x){
            temp = heaparray[largest];
            heaparray[largest] = heaparray[x];
            heaparray[x] = temp;
            heapify(largest);
        }
    }

    // display_vertical is a method based on the display method in the UBST class
    // for printing a binary tree vertically.
    public void display_vertical(){
        display_recursive(0, 0);
    }

    // Display recursive helper
    private void display_recursive(int root_pos, int level){
        if(root_pos < size){
            display_recursive((root_pos*2)+2, level+1);
            for(int i=0; i < level; i++){
                System.out.print("    ");
            }
            System.out.println(heaparray[root_pos]);
            display_recursive((root_pos*2)+1, level+1);
        }
    }

    // visualize is a method that will display the binary tree horizontally.
    public void visualize() {

        // maxdepth is the lowest level of the tree.
        int maxdepth = (int) (Math.log(size) / Math.log(2));

        int y = 0;
        for(int i = 0; i <= maxdepth; i++){

            // Use a for loop for printing spaces.
            for(int r = 0; r<((int) (Math.pow(2,(maxdepth-i)))-1); r++){
                System.out.print("     ");
            }
            for(int x = ((int) Math.pow(2,i) - 1); x < ((int) Math.pow(2,i+1)-1); x++ ) {

                if(y<size){

                    // This code will display integers up to 99999 centered in a 5
                    // character space.
                    if(Math.abs(heaparray[y])<10){
                        System.out.print("  " + heaparray[y] + "  ");
                    }else{
                        if(Math.abs(heaparray[y])<100){
                            System.out.print("  " + heaparray[y] + " ");
                        }else{
                            if(Math.abs(heaparray[y])<1000){
                                System.out.print("  " + heaparray[y]);
                            }else{
                                if(Math.abs(heaparray[y])<10000){
                                    System.out.print(" " + heaparray[y]);
                                }else{
                                    System.out.print(heaparray[y]);
                                }
                            }
                        }
                    }
                    // Print spaces at the end of the row.
                    for(int r = 0; r<((int) (Math.pow(2,((maxdepth+1)-i)))-1); r++){
                        System.out.print("     ");
                    }
        
                }
                y++;
            }            
            System.out.println("");
        }
    }
}
