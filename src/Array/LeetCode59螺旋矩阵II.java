package Array;

public class LeetCode59螺旋矩阵II {
    //    给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//    示例 1：
//    输入：n = 3
//    输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//    示例 2：
//    输入：n = 1
//    输出：[[1]]
//
//
//    提示：
//
//            1 <= n <= 20
    public static void main(String[] args) {
        int n = 3;

        int[][] nums = generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 循环填充
     * 时间复杂度O(n2) 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        //以顺时针一圈为一循环，螺旋赋值
        for (int loop = 0; loop <= n / 2; loop++) {
            System.out.println("第" + (loop + 1) + "轮循环开始");
            //1.从左到右
            for (int i = loop; i < n - loop - 1; i++) {
                System.out.print("现在是第" + loop + "行" + i + "列" + "    ");
                matrix[loop][i] = num++;
            }
            System.out.println();

            //2.从上到下
            for (int i = loop; i < n - loop - 1; i++) {
                System.out.print("现在是第" + i + "行" + (n - loop - 1) + "列" + "    ");
                matrix[i][n - loop - 1] = num++;
            }
            System.out.println();

            //3.从右到左
            for (int i = n - loop - 1; i > loop; i--) {
                System.out.print("现在是第" + (n - loop - 1) + "行" + i + "列" + "    ");
                matrix[n - loop - 1][i] = num++;
            }
            System.out.println();

            //4.从下到上
            for (int i = n - loop - 1; i > loop; i--) {
                System.out.print("现在是第" + i + "行" + loop + "列" + "    ");
                matrix[i][loop] = num++;
            }
            System.out.println();
            System.out.println("第" + (loop + 1) + "轮循环结束");
        }

        if (n % 2 == 1) {
            matrix[n / 2][n / 2] = num;
        }

        return matrix;
    }
}
