
import java.util.*;
public class MaxHeap<E extends Comparable<E>> extends ArrayList<E> {
    private int size;
    //private ArrayList<E> heap;
    private int[] heap;

    // construct an empty Heap using ArrayList
    // with root at index 0.
    // don't use binary tree for implementing the heap.
    public MaxHeap(int size1) {
        size = 0;
        heap = new int[size1];
    }



    // returns max value
    public int findMax() {

        return heap[0];
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }


    private int leftChild(int pos) {
        if (pos == 0) {
            return 1;
        }
        return (2 * pos) + 1;
    }


    private int rightChild(int pos) {
        if (pos == 0) {
            return 2;
        }
        return (2 * pos) + 2;
    }


    // adds a new value to the heap at the end of the Heap and 
    // adjusts values up to the root to ensure Max heap property is satisfied.
    // parent of node at i is given by the formula (i-1)/2
    // throw appropriate exception
    public void addHeap(E val) {

        heap[size] = (Integer) val;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            //System.out.println("i: " + i);//consider putting i <= size /2
            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i + 1]
                            + " RIGHT CHILD :" + heap[2 * i + 2]);
            System.out.println();
        }
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {

            return;

        }
       // System.out.println("Pos: " + heap[pos]);
       // System.out.println("Pos Left: " + heap[leftChild(pos)]);
       // System.out.println("Pos Right: " + heap[rightChild(pos)]);

        if (heap[pos] < heap[leftChild(pos)]
                || heap[pos] < heap[rightChild(pos)]) {

            if (heap[leftChild(pos)]
                    > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    //returns the max value at the root of the heap by swapping the last value 
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public int removeHeap() {

        int popped = heap[0];
        if(size == 1)
        {
            heap[0] = 0;
            size -=1;
            return popped;
        }

        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size -= 1;
        //size -= 1;
      //  System.out.println("Last size: " + heap[size - 1]);
        maxHeapify(0);
        return popped;
    }

    // takes a list of items E and builds the heap and then prints 
    // decreasing values of E with calls to removeHeap().  
    public void heapSort(List<E> list){
        this.buildHeap(list);

        while(true)
        {
            if(size >= 1)
            {
                System.out.println(removeHeap());
            }
            else
            {
                //System.out.println(removeHeap());
                break;
            }
        }
     }

    // merges the other maxheap with this maxheap to produce a new maxHeap.  
      public MaxHeap heapMerge(MaxHeap<E> other){
        int size1 = size + other.size;
        MaxHeap newHeap = new MaxHeap(size1);
        int count = 0 ;
        for(int i = 0; i < size; i++)
        {

            newHeap.addHeap(this.heap[i]);
            count++;
        }
        for(int i = 0; count < size1;i++ )
        {
            newHeap.addHeap(other.heap[i]);
            count++;
        }
        newHeap.maxHeapify(0);
        return newHeap;
     }

    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            this.addHeap(list.get(i));
        }

    }


    public static void main(String[] args) {
        MaxHeap MaxHeap = new MaxHeap(15);

        ArrayList list1 = new ArrayList();
        list1.add(13);
        list1.add(8);
        list1.add(20);
        list1.add(23);
        list1.add(14);
        list1.add(15);
        list1.add(25);

        MaxHeap.buildHeap(list1);
        //MaxHeap.removeHeap();
        MaxHeap.print();
        //MaxHeap.print();
        System.out.println("\nMaximum: " + MaxHeap.findMax());
        System.out.println();

        MaxHeap m1 = new MaxHeap(10);
        m1.addHeap(10);
        m1.addHeap(12);
        m1.addHeap(21);
        m1.addHeap(40);
        m1.print();
        System.out.println("\nMaximum: " + m1.findMax());
        System.out.println();

        MaxHeap m3 = new MaxHeap(20);
        m3= MaxHeap.heapMerge(m1);
        m3.print();
        System.out.println("\nMaximum: " + m3.findMax());
        System.out.println();

        MaxHeap m4 = new MaxHeap(10);
        m4.heapSort(list1);//builds then deletes by descending through from max to min calling remove heap


    }

}
