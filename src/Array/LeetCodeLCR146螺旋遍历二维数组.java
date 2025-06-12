package Array;

import java.util.List;

public class LeetCodeLCR146螺旋遍历二维数组 {
    //    给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
//
//    螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
//
//
//
//    示例 1：
//    输入：array = [[1,2,3],[8,9,4],[7,6,5]]
//    输出：[1,2,3,4,5,6,7,8,9]
//
//    示例 2：
//    输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
//    输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
//
//
//    限制：
//
//            0 <= array.length <= 100
//            0 <= array[i].length <= 100
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix3 = {{6, 9, 7}};
        int[] list = spiralOrder(matrix1);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    public static int[] spiralOrder(int[][] array) {
        //处理空数组
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }

        //获取行列数
        int rows = array.length;
        int cols = array[0].length;

        int[] list = new int[rows * cols];

        // 定义四个边界
        int top = 0;     // 上边界
        int bottom = rows - 1; // 下边界
        int left = 0;    // 左边界
        int right = cols - 1; // 右边界

        int count = 0;

        while (top <= bottom && left <= right) {
            //1.从左到右遍历上边界
            for (int i = left; i <= right; i++) {
                list[count++] = array[top][i];
            }
            top++;

            //2.从上到下遍历右边界
            for (int i = top; i <= bottom; i++) {
                list[count++] = array[i][right];
            }
            right--;

            //3.从右到左遍历下边界
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list[count++] = array[bottom][i];
                }
                bottom--;
            }

            //4.从下到上遍历左边界
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list[count++] = array[i][left];
                }
                left++;
            }
        }

        return list;
    }
}
