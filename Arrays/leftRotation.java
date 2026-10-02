import java.util.Scanner;

public class leftRotation {
    public static void bruteforce(int arr[], int n, int d) {
        d = d % n;
        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < n - d; i++) {
            arr[i] = arr[i + d];
        }
        for (int i = n - d; i < n; i++) {
            arr[i] = temp[i - (n - d)];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void reversal(int arr[], int s, int e) {
        int j = e - 1;
        for(int i = s; i < j; i++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
    public static void optimal(int arr[], int n, int d){
        d = d % n;
        reversal(arr, 0, d);
        reversal(arr, d, n);
        reversal(arr, 0, n);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //bruteforce(arr, n, d);
        optimal(arr, n, d);
    }
}

