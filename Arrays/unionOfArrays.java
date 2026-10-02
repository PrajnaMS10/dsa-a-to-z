import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class unionOfArrays {
    public static void brute(int n1, int arr1[], int n2, int arr2[]) {
        //TC = O
        Set<Integer> union = new TreeSet<>();
        for (int x : arr1) {
            union.add(x);
        }
        for (int x : arr2) {
            union.add(x);
        }
        int[] arr = new int[union.size()];
        int index = 0;
        for (int x : union) {
            arr[index++] = x;
        }
        for (int i = 0; i < union.size(); i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void optimal(int n1, int arr1[], int n2, int arr2[]) {
        int i = 0, j = 0, index = 0;
        int[] arr = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (index == 0 || arr[index - 1] != arr1[i]) {
                    arr[index++] = arr1[i];
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (index == 0 || arr[index - 1] != arr2[j]) {
                    arr[index++] = arr2[j];
                }
                j++;
            } else {
                if(index == 0 || arr[index-1] != arr1[i]){
                    arr[index++] = arr1[i];
                }
                i++;
                j++;
            }
        }
        while (i < n1) {
            if (index == 0 || arr[index - 1] != arr1[i]) {
                arr[index++] = arr1[i];
            }
            i++;
        }
        while (j < n2) {
            if (index == 0 || arr[index - 1] != arr2[j]) {
                arr[index++] = arr2[j];
            }
            j++;
        }
        for (int k = 0; k < index; k++) {
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
        brute(n1, arr1, n2, arr2);
        System.out.println();
        optimal(n1, arr1, n2, arr2);
    }
}
