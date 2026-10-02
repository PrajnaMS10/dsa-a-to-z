import java.util.Scanner;

public class missingNumber {
    //TC = O(n^2)
    public static int bruteforce(int n, int arr[]){
        for(int i = 1; i<=n; i++){
            int flag = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }
    public static int better(int n, int arr[]) {
        int[] hash = new int[n + 1];

        for(int i = 0; i < n; i++) {
            hash[arr[i]] = 1;
        }

        for(int i = 1; i <= n; i++) {
            if(hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }
    public static int optimal_sum(int n, int arr[]){
        int sum = (n * (n + 1)) / 2;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += arr[i];
        }
        int num = sum - total;
        return num;
    }

    public static int optimal_xor(int n, int arr[]){
        int xor1 = 0;
        int xor2 = 0;
//        for(int i=1; i<=n; i++){
//            xor1 ^= i;
//        }
//        for(int i=0; i<n; i++){
//            xor2 ^= arr[i];
//        }
//        int num = xor1 ^ xor2;
//        return num;
        for(int i=0; i<n; i++){
            xor2 ^= arr[i];
            xor1 ^= (i+1);
        }
        xor1 ^= n;
        int num = xor1 ^ xor2;
        return num;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n-1; i++){
            arr[i] = sc.nextInt();
        }
        int num = optimal_xor(n, arr);
        System.out.println(num);
    }
}
