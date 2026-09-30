import java.util.*;
public class EqualStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = 0; i < n1; i++) {
            int x = sc.nextInt();
            s1.push(x);
            sum1 += x;
        }
        for (int i = 0; i < n2; i++) {
            int x = sc.nextInt();
            s2.push(x);
            sum2 += x;
        }
        for (int i = 0; i < n3; i++) {
            int x = sc.nextInt();
            s3.push(x);
            sum3 += x;
        }
        while (!(sum1 == sum2 && sum2 == sum3)) {

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.pop();

            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.pop();

            } else {
                sum3 -= s3.pop();
            }
        }

        System.out.println(sum1);
    }
}