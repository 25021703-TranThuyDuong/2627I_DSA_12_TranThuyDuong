import java.util.Scanner;

public class W4_CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Nhap " + n + " so nguyen (0 - 99):");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] count = new int[100];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        System.out.println("So lan xuat hien cua cac so tu 0 den 99:");

        for (int i = 0; i < 100; i++) {
            System.out.print(count[i] + " ");
        }

        sc.close();
    }
}