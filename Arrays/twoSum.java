import java.util.HashMap;
import java.util.Scanner;

public class twoSum {
    public static void bruteforce(int n, int a[], int sum){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(a[i] + a[j] == sum){
                    System.out.println(i + " + " + j);
                    break;
                }
            }
        }
    }

    public static void better(int n, int a[], int sum){
        HashMap<Integer, Integer> presumMap = new HashMap<>();
        for(int i=0; i<n ; i++){
            int rem = sum-a[i];
            if(presumMap.containsKey(rem)){
                System.out.println(i + " + " + presumMap.get(rem));
            }
            if(!presumMap.containsKey(rem)){
                presumMap.put(a[i], i);
            }
        }
    }

    public static void optimal(int n, int a[], int sum){
        int left = 0, right = n-1;
        while(left<right){
            int total = a[left] + a[right];
            if(total > sum){
                right--;
            }
            else if(total < sum){
                left++;
            }
            else{
                System.out.println(left + " + " + right);
                break;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        optimal(n, a, sum);
    }
}
