import java.util.Scanner;

public class intersectionOfArrays {
    public static void intersection(int n1, int arr1[], int n2, int arr2[]){
        int i=0,j=0,index=0;
        int[] arr = new int[Math.min(n1, n2)];
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else{
                if(index == 0 || arr[index - 1] != arr1[i]){
                    arr[index++] = arr1[i];
                }
                i++;
                j++;
            }
        }
        for(int k=0; k<index; k++){
            System.out.print(arr[k] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        intersection(n1, arr1, n2, arr2);
    }
}
