package HashTable;

import java.util.*;

public class LeetCode49字母异位词分组 {
    //    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//    字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//    示例 1:
//    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//    示例 2:
//    输入: strs = [""]
//    输出: [[""]]
//
//    示例 3:
//    输入: strs = ["a"]
//    输出: [["a"]]
//
//
//    提示：
//            1 <= strs.length <= 104
//            0 <= strs[i].length <= 100
//            strs[i] 仅包含小写字母

    /**
     * 排序
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

//            if(!map.containsKey(key)){
//                map.put(key,new LinkedList<>());
//            }
//            map.get(key).add(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {

        // 测试用例1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = groupAnagrams(strs1);
        printResult(result1);

        // 测试用例2
        String[] strs2 = {""};
        List<List<String>> result2 = groupAnagrams(strs2);
        printResult(result2);

        // 测试用例3
        String[] strs3 = {"a"};
        List<List<String>> result3 = groupAnagrams(strs3);
        printResult(result3);

        // 额外测试用例4: 所有字符串都是字母异位词
        String[] strs4 = {"abc", "bca", "cab"};
        List<List<String>> result4 = groupAnagrams(strs4);
        printResult(result4);

        // 额外测试用例5: 没有字母异位词
        String[] strs5 = {"abc", "def", "ghi"};
        List<List<String>> result5 = groupAnagrams(strs5);
        printResult(result5);
    }

    private static void printResult(List<List<String>> result) {
        System.out.println("[");
        for (List<String> group : result) {
            System.out.print("  [");
            for (int i = 0; i < group.size(); i++) {
                System.out.print("\"" + group.get(i) + "\"");
                if (i < group.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
        System.out.println();
    }
}
