import java.util.Scanner;

public class numAppearsOnceOthersTwice {
    public static int bruteforce(int n, int arr[]){
        for(int i=0; i<n; i++){
            int num = arr[i];
            int count = 0;
            for(int j=0; j<n; i++){
                if(num == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                return num;
            }
        }
        return -1;
    }
    public static int better(int n, int arr[]){
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int hash[] = new int[max+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        for(int i=0; i<max; i++){
            if(hash[i] == 1){
                return i;
            }
        }
        return -1;
    }
    public static int optimal(int n, int arr[]){
        int xor = 0;
        for(int i=0; i<n; i++){
            xor ^= arr[i];
        }
        return xor;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int num = optimal(n, arr);
        System.out.println(num);
    }
}
