import java.util.Scanner;
import java.util.HashMap;

public class longestSubarraySum {
    public static int bruteforce(int n, int arr[], int k){
        int len = 0;
        for(int i=0; i<n; i++){
            int sum = arr[i];
            for(int j=i+1; j<n; j++){
                sum += arr[j];
                if(sum == k){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    public static int better(int n, int[] arr, int k) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            // If the entire array from 0 to i has sum k
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            long rem = sum - k;
            // Check if a previous prefix sum = sum - k exists
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            // Store only the FIRST occurrence
            // because it gives the longest subarray
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }

    public static int optimal(int n, int arr[], int k){
        int left = 0, right = 0;
        int max = 0;
        int sum = 0;
        while(right < n){
            sum += arr[right];
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        return max;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int length = optimal(n, arr, k);
        System.out.println(length);
    }
}
