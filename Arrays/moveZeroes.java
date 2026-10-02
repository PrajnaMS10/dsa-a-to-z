import java.util.Scanner;

public class moveZeroes {
    public static void bruteforce(int arr[], int n){
        int index = 0;
        for(int i=0; i<n;i++){
            if(arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        for(int i = index; i<n;i++){
            arr[i] = 0;
        }
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void optimal(int arr[], int n){
        int j=-1;
        for(int i=0; i<n; i++) {
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for(int i=j+1; i<n; i++){
            if(arr[i] != 0){
                swap(arr, i, j);
                j++;
            }
        }
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //bruteforce(arr, n);
        optimal (arr, n);
    }
}
