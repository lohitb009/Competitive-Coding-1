import java.util.Arrays;

public class FindMissingNumberInSortedArray {

    /*
    Time Complexity: 0(log n)
    Space Complexity: 0(n)
    Approach: There is a relationship b/w index & value. If index is (i), value is (i+1). So perform binary search
    to find the missing element
     */

    public int findMissingNumber(int arr[]){

        // potential missing number
        int missing = -1;

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(low <= high){
            mid = (high-low)/2 + low;

            if(mid == arr[mid]-1){
                // ok, update low
                low = mid + 1;
            }else{
                // update missing
                missing = mid+1;
                high = mid-1;
            }
        }


        return missing;
    }

    public static void main(String[] args) {

        FindMissingNumberInSortedArray obj = new FindMissingNumberInSortedArray();

        int result = obj.findMissingNumber(new int[]{1,2,3,4,5,6,8,9});
        System.out.println("missing number is = " + result);

        result = obj.findMissingNumber(new int[]{2,3,4,5,6,7,8,9});
        System.out.println("missing number is = " + result);
    }

}
