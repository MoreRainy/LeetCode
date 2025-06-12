package Array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54螺旋矩阵 {
    //    给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
//    示例 1：
//
//
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[1,2,3,6,9,8,7,4,5]
//    示例 2：
//
//
//    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//    输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//    提示：
//
//    m == matrix.length
//    n == matrix[i].length
//    1 <= m, n <= 10
//    -100 <= matrix[i][j] <= 100
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix3 = {{6, 9, 7}};
        final List<Integer> list = spiralOrder(matrix3);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    /**
     * 时间复杂度O(nm) 空间复杂度O(1)
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // 处理空矩阵的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;    // 矩阵的行数
        int cols = matrix[0].length; // 矩阵的列数

        // 定义四个边界
        int top = 0;     // 上边界
        int bottom = rows - 1; // 下边界
        int left = 0;    // 左边界
        int right = cols - 1; // 右边界

        System.out.println("这是一个" + rows + "行 " + cols + "列的矩阵");

        while (top <= bottom && left <= right) {
            // 1. 从左到右遍历上边界
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // 上边界下移

            // 2. 从上到下遍历右边界
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // 右边界左移

            // 3. 如果还有未遍历的行，从右到左遍历下边界
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // 下边界上移
            }

            // 4. 如果还有未遍历的列，从下到上遍历左边界
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // 左边界右移
            }
        }

        return result;
    }
}
