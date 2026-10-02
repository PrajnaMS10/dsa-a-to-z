import java.util.Scanner;

public class maxConsecutiveOnes {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int max = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                count++;
                if(max<count)
                    max=count;
            }
            else{
                count=0;
            }
        }
        System.out.println(max);
    }
}
