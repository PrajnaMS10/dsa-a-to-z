import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class majorityElement {
    public static void bruteforce(int n, int a[]){
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if(count>n/2){
                System.out.println(a[i] + " + " + count);
                return;
            }
        }
    }

    public static void better(int n, int a[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(a[i]))
                map.put(a[i], 1);
            else
                map.put(a[i], map.get(a[i]) + 1);
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int element = entry.getKey();
            int count = entry.getValue();
            if(count > n/2){
                System.out.println(element + " + " + count);
                return;
            }
        }
    }

    //uses Moore's Voting Algo
    //
    public static void optimal(int n, int a[]){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        better(n, a);
    }
}
