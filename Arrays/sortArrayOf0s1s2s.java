import java.util.Scanner;

public class sortArrayOf0s1s2s {
    //bruteforce - using any sorting algo
    public static void better(int n, int a[]) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0)
                count0++;
            else if (a[i] == 1)
                count1++;
            else if (a[i] == 2)
                count2++;
        }
        for (int i = 0; i < count0; i++)
            a[i] = 0;
        for (int i = count0; i < count0+count1; i++)
            a[i] = 1;
        for (int i = count1+count0; i < count2+count1+count0; i++)
            a[i] = 2;
        for(int i=0; i<n; i++){
            System.out.print(a[i] + " ");
        }
    }

    //using Dutch National Flag Algo
    // uses 3 pointers - low, mid, high
    // 3rules - sorted
    // 1. 0 -> low-1 = 0s => extreme left
    // 2. low -> mid-1 = 1s
    // 3. high+1 -> n-1 = 2s => extreme right
    // mid to high - unsorted array = 0/1/2
    public static void swap(int a, int b, int arr[]){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void optimal(int n, int a[]){
        int low=0, mid=0, high=n-1;
        while(mid<=high){
            if(a[mid] == 0){
                swap(low, mid, a);
                low++;
                mid++;
            }
            else if(a[mid] == 1){
                mid++;
            }
            else if(a[mid] == 2){
                swap(mid, high, a);
                high--;
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        optimal(n, a);
    }
}
