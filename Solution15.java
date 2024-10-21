import java.util.*;

/*
 * 修改内容总结：
 *修复循环语法：原代码中的 for 循环格式不正确，已更改为标准的 for (int i = 0; i < maxLength; ++i) 形式。
 *修正长度判断：增加了 maxLength 变量，它是两个修订号数组中长度的较大值，以确保比较时能够覆盖两者的所有修订号。
 *修复索引访问：修复了数组的访问逻辑，确保在访问修订号时不越界。
 *移除多余的圆括号：将原代码中使用的花括号替换为标准的编程语法
 */



/*
 * @Description
 * 
 * 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 *  如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * 
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLength = Math.max(v1.length, v2.length); // 计算两个版本号中修订号数量的最大值

        for (int i = 0; i < maxLength; ++i) { // 循环遍历最大修订号数量
            int x = 0, y = 0; // 初始化当前修订号的值

            // 对于版本1，检查当前修订号是否存在
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }

            // 对于版本2，检查当前修订号是否存在
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }

            // 比较当前修订号的值
            if (x > y) {
                return 1; // version1大于version2
            }
            if (x < y) {
                return -1; // version1小于version2
            }
        }
        return 0; // 如果所有修订号相等，返回0
    }
}
