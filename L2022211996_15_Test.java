import org.junit.Test;
import static org.junit.Assert.*;

/*
 * 测试用例设计总体原则：
 * 本测试类通过等价类划分原则和边界值分析原则设计测试用例。
 * 1. 等价类划分：将版本号的不同组合分为几个范围，在每个范围内选取具有代表性的测试用例。
 * 2. 边界值分析：特别关注修订号数量的变化以及零的处理，选取临界边界值进行测试。
 */

public class L2022211996_15_Test {

    // 测试目的：测试相等版本号的比较
    @Test
    public void testEqualVersions() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "1.01";
        String version2 = "1.001";
        assertEquals(0, solution.compareVersion(version1, version2)); // 输出应为0
    }

    // 测试目的：测试相等版本号，包含不同修订号数量
    @Test
    public void testEqualVersionsDifferentLength() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "1.0";
        String version2 = "1.0.0";
        assertEquals(0, solution.compareVersion(version1, version2)); // 输出应为0
    }

    // 测试目的：测试版本1小于版本2的情况
    @Test
    public void testVersion1LessThanVersion2() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "0.1";
        String version2 = "1.1";
        assertEquals(-1, solution.compareVersion(version1, version2)); // 输出应为-1
    }

    // 测试目的：测试版本1大于版本2的情况
    @Test
    public void testVersion1GreaterThanVersion2() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "1.2";
        String version2 = "1.0";
        assertEquals(1, solution.compareVersion(version1, version2)); // 输出应为1
    }

    // 测试目的：测试版本号包含前导零的情况
    @Test
    public void testLeadingZeros() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "2.05";
        String version2 = "2.5";
        assertEquals(0, solution.compareVersion(version1, version2)); // 输出应为0
    }

    // 测试目的：测试版本号缺失修订号的情况
    @Test
    public void testMissingRevisionNumber() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "1";
        String version2 = "1.0.0";
        assertEquals(0, solution.compareVersion(version1, version2)); // 输出应为0
    }

    // 测试目的：测试空字符串（不应发生的情况）
    @Test(expected = NumberFormatException.class)
    public void testEmptyVersion() {
        Solution solution = new Solution();
        // 用到的测试用例
        String version1 = "";
        String version2 = "1.0";
        solution.compareVersion(version1, version2); // 应抛出异常
    }
}
