import java.util.Arrays;

public class MinHeap {

    /*
    Time Complexity:
        1. getMin : 0(1)
        2. extractMin: 0(log n)
        3. insert : 0(log n)

    Space Complexity: 0(n) -- setup minHeap of size n
     */

    private int[] minHeap;
    private int count;

    public MinHeap(int maxSize){
        this.minHeap = new int[maxSize]; // assume minHeap of maxSize
        this.count = 0;
    }

    public int getMin(){
        if(this.minHeap.length == 0){
            return -1; // minHeap is empty
        }
        return this.minHeap[0];
    }

    public void extractMin(){

        // base case, count is zero
        if (this.count == 0){
            System.out.println("Min heap is empty !!");
            return;
        }

        // set the currentSize of the minHeap
        int lastIdx = this.count-1;

        // base case, lastIdx value is 0

        // logic case
        // swap values

        int tmp = this.minHeap[0];
        this.minHeap[0] = this.minHeap[lastIdx];
        this.minHeap[lastIdx] = tmp;
        tmp = 0; // reset tmp value

        // set the lastIdx value to zero
        this.minHeap[lastIdx] = 0;

        // update the count as the last element is removed
        this.count = lastIdx;
        lastIdx -= 1;

        // perform stabilization recursively
        int currIdx = 0;

        int currValue;
        int lftValue;
        int rtValue;

        while(true){
            currValue = this.minHeap[currIdx];

            // set lftValue
            if(currIdx*2+1 < this.count){
                lftValue = this.minHeap[currIdx*2 + 1];
            }else{
                break;
            }

            // set rtValue
            if(currIdx*2+2 < this.count){
                rtValue = this.minHeap[currIdx*2 + 2];
            }else{
                break;
            }

            // update values
            if (lftValue <= rtValue && lftValue < currValue){
                // go lft
                this.minHeap[currIdx*2 + 1] = currValue;
                this.minHeap[currIdx] = lftValue;
                currIdx = currIdx*2 + 1;

            }else{
                // go rt
                this.minHeap[currIdx*2 + 2] = currValue;
                this.minHeap[currIdx] = rtValue;
                currIdx = currIdx*2 + 2;
            }

            // break condition
            if(currIdx >= this.count){
                break;
            }
        }

        return;
    }

    public String insert(int num){

        // base-case
        if (this.count == this.minHeap.length){
            // heap is full
            return "Heap is full";
        }

        this.minHeap[this.count] = num;

        // perform stablization
        if(this.count == 0){
            // first element added, just return from here
            this.count += 1;
            return null;
        }

        // perform stablization recursively
        int currIdx = this.count;
        int parentIdx;

        // set parentValue and currValue
        int currValue;
        int parentValue;

        while(true){

            if(currIdx%2 != 0){
                // odd index
                parentIdx = currIdx/2;
            }else{
                // even index
                parentIdx = (currIdx/2) - 1;
            }

            // compare parent & currIdx value
            currValue = this.minHeap[currIdx];
            parentValue = this.minHeap[parentIdx];

            if(parentValue < currValue){
                // do nothing, break, everything is fine..
                break;
            }

            // swap the values
            this.minHeap[parentIdx] = currValue;
            this.minHeap[currIdx] = parentValue;

            // update the ptr
            currIdx = parentIdx;

            // break condition i.e. currIdx is 0
            if(currIdx == 0){
                break;
            }

        }

        // update the count
        this.count += 1;

        return null;
    }

    public void printMinHeap(){
        System.out.println("Min Heap is:\t" + Arrays.toString(this.minHeap));
        System.out.println("this.count is:\t" + this.count);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15); //int maxSize = 15

        // insert element to minHeap
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.printMinHeap();

        // return min element from minHeap
        System.out.println("min element is : "+ minHeap.getMin());

        // extract min from minHeap
        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();

        minHeap.extractMin();
        minHeap.printMinHeap();
    }
}
