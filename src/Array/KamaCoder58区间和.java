package Array;

import java.util.Scanner;

public class KamaCoder58区间和 {
    //    题目描述
//    给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
//    输入描述
//    第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。
//    输出描述
//    输出每个指定区间内元素的总和。
//
//    输入示例
//        5
//        1
//        2
//        3
//        4
//        5
//        0 1
//        1 3
//
//    输出示例
//        3
//        9
//
//    提示信息
//    数据范围：
//            0 < n <= 100000
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (i != 0) {
                count[i] = count[i - 1] + arr[i];
            } else {
                count[0] = arr[0];
            }
        }

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum;

            if (a != 0) {
                sum = count[b] - count[a - 1];
            } else {
                sum = count[b];
            }

            System.out.println(sum);
        }

        sc.close();
    }
}
