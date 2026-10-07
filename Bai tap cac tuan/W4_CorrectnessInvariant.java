import java.util.Scanner;

public class W4_CorrectnessInvariant {

    public static void insertionSort(int[] A) {

        for (int i = 1; i < A.length; i++) {

            int key = A[i];

            int j = i - 1;

            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }

            A[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();

        int[] A = new int[n];

        System.out.println("Nhap cac phan tu:");

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        insertionSort(A);

        System.out.println("Mang sau khi sap xep:");

        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
        }

        sc.close();
    }
}