// Aiden Wells 
// axw1@stmarys-ca.edu
// 415-301-1273
// CS-222-01
// Professor Das
// Assignment 3: Binary Max Heap
// 05-11-2024

public class Driver {

    public static void main(String[] arg){
        MaxHeap heap1 = new MaxHeap(100);
        heap1.insertintoarray(11);
        heap1.insertintoarray(22);
        heap1.insertintoarray(33);
        heap1.insertintoarray(44);
        heap1.insertintoarray(55);
        heap1.insertintoarray(66);
        heap1.insertintoarray(77);
        heap1.insertintoarray(88);
        heap1.insertintoarray(89);
        heap1.insertintoarray(90);
        heap1.insertintoarray(91);
        heap1.insertintoarray(92);
        heap1.insertintoarray(93);
        heap1.insertintoarray(94);
        heap1.insertintoarray(95);
        System.out.println("Max Value: " + heap1.extractmax());
        System.out.println("Max Value: " + heap1.extractmax());
        System.out.println("Max Value: " + heap1.extractmax());
        System.out.println("Remaining Heap:");
        heap1.display_vertical();
        heap1.visualize();
    }
}
