package Array;

import java.util.Scanner;

public class KamaCoder44开发商购买土地 {
    //    题目描述
//    在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
//
//    现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
//
//    然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。 为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
//
//    注意：区块不可再分。
//
//    输入描述
//    第一行输入两个正整数，代表 n 和 m。
//
//    接下来的 n 行，每行输出 m 个正整数。
//
//    输出描述
//    请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
//
//    输入示例
//        3 3
//        1 2 3
//        2 1 3
//        1 2 3
//    输出示例
//        0
//
//    提示信息
//    如果将区域按照如下方式划分：
//
//            1 2 | 3
//            2 1 | 3
//            1 2 | 3
//
//    两个子区域内土地总价值之间的最小差距可以达到 0。
//
//    数据范围：
//
//            1 <= n, m <= 100；
//            n 和 m 不同时为 1。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] val = new int[rows][cols];
        int[] rowsVal = new int[rows];
        int[] colsVal = new int[cols];

        //输入并计算行和列和
        for (int i = 0; i < rows; i++) {
            int rowCount = 0;
            for (int j = 0; j < cols; j++) {
                val[i][j] = sc.nextInt();

                rowCount += val[i][j];

                if (i == 0) {
                    colsVal[j] = val[0][j];
                } else {
                    colsVal[j] += val[i][j];
                }
            }
            rowsVal[i] = rowCount;
        }

        //更新行和列和为累加值
        for (int i = 1; i < rows; i++) {
            rowsVal[i] = rowsVal[i - 1] + rowsVal[i];
        }
        for (int i = 1; i < cols; i++) {
            colsVal[i] = colsVal[i - 1] + colsVal[i];
        }

        //找最小差
        int dif;
        int minDif = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                dif = rowsVal[rows - 1];
            } else {
                dif = (rowsVal[rows - 1] - rowsVal[i - 1]) -rowsVal[i - 1];
            }

            minDif = Math.min(Math.abs(dif), minDif);
        }

        for (int i = 0; i < cols; i++) {
            if (i == 0) {
                dif = colsVal[cols - 1];
            } else {
                dif = (colsVal[cols - 1] - colsVal[i - 1]) -colsVal[i - 1];
            }

            minDif = Math.min(Math.abs(dif), minDif);
        }

        System.out.println(minDif);
    }
}
