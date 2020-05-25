import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.sort;

public class Main {
    private static String hexStr = "0123456789ABCDEF";
    private static String[] binaryArray =
            {"0000", "0001", "0010", "0011",
                    "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011",
                    "1100", "1101", "1110", "1111"};

    public static void main(String[] args) {
//        radixSort();
//        hasMap();


        int i = 2;
        System.out.println(i + " 的二进制是:" + Integer.toBinaryString(Byte.toUnsignedInt((byte) i)));
//        System.out.println(i + " 的八进制是:" + Integer.toOctalString(Byte.toUnsignedInt((byte) i)));
//        System.out.println(i + " 的十六进制是:" + Integer.toHexString(Byte.toUnsignedInt((byte) i)));
//        System.out.println(i + " 的三进制是:" + Integer.toString(Byte.toUnsignedInt((byte) i), 3));

//        String str = "2";
//        System.out.println(bytes2BinaryStr(str.getBytes()));
//
//        System.out.println(MAXIMUM_CAPACITY);
//        System.out.println(tableSizeFor(10));

        displacement();
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 返回一个大于输入参数且最近的2的整数次幂的数
     * <p>
     * <p>
     * |=：两个二进制对应位都为0时，结果等于0，否则结果等于1；
     * &=：两个二进制的对应位都为1时，结果为1，否则结果等于0；
     * ^=：两个二进制的对应位相同，结果为0，否则结果为1。
     *
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        System.out.println("cap: " + cap);
        int n = cap - 1;
        System.out.println("n: " + n);
        System.out.println(n + "    " + Integer.toBinaryString(n));
        System.out.println((n >>> 1) + "    " + Integer.toBinaryString(n >>> 1));
        System.out.println(Integer.valueOf("1101", 2).toString());
        n |= n >>> 1;
        System.out.println("n>>>1: " + n);
        n |= n >>> 2;
        System.out.println("n>>>2: " + n);
        n |= n >>> 4;
        System.out.println("n>>>4: " + n);
        n |= n >>> 8;
        System.out.println("n>>>8: " + n);
        n |= n >>> 16;
        System.out.println("n>>>16: " + n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 位移
     * >> 与 >>> 的区别
     * 1、 >> 带符号右移。(正数右移高位补 0 ,负数右移高位补 1)
     * 2、>>> 无符号右移，无论是正负数，高位都补 0
     */
    public static void displacement() {
        int i = -4;
        System.out.println(i + "的十进制：" + i);
        System.out.println(i + "的二进制：" + Integer.toBinaryString(i));
        i = i >> 1;
        System.out.println(i + "右移一位：" + Integer.toBinaryString(i));
    }


    /**
     * 转换为二进制
     *
     * @param bArray
     * @return
     */
    public static String bytes2BinaryStr(byte[] bArray) {
        String outStr = "";
        int pos = 0;
        for (byte b : bArray) {
            //高四位
            pos = (b & 0xF0) >> 4;
            outStr += binaryArray[pos];
            //低四位
            pos = b & 0x0F;
            outStr += binaryArray[pos];
        }
        return outStr;

    }

    /**
     * hasMap
     */
    private static void hasMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "a");
        hashMap.put("b", "b");
//        String a = hashMap.remove("a");
//        System.out.println(a + hashMap.toString());
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        System.out.println(entries);
        hashMap.keySet();
        System.out.println(hashMap.keySet().toString());
        System.out.println(hashMap.size());

    }

    /**
     * 基数排序（桶排序）
     */
    private static void radixSort() {
        int[] arrays = {6, 4322, 432, 344, 55, 1, 6, 88, 99, 6666, 444, 2, 4, 6, 5, 4, 4};
        int max = findMax(arrays, 0, arrays.length - 1);
        // 需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] buckets = new int[arrays.length][10];
            // 获取每一个数字（个、十、百、千位....分配到桶子里）
            for (int j = 0; j < arrays.length; j++) {
                int num = (arrays[j] / i) % 10;
                // 将其放入桶子里
                buckets[j][num] = arrays[j];
            }
            // 回收桶子里的元素
            int k = 0;
            // 有10个桶子
            for (int j = 0; j < 10; j++) {
                // 对每个桶子里的元素进行回收
                for (int l = 0; l < arrays.length; l++) {
                    // 如果桶子里面有元素就回收（数据初始化会为0）
                    if (buckets[l][j] != 0) {
                        arrays[k++] = buckets[l][j];
                    }
                }
            }
        }


        sort(arrays);
        System.out.println(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    /**
     * 递归，找出数组最大的值
     *
     * @param arrays 数组
     * @param L      左边界，第一个数
     * @param R      右边界，数组的长度
     * @return
     */
    private static int findMax(int[] arrays, int L, int R) {
        // 若数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R) {
            return arrays[L];
        } else {
            int a = arrays[L];
            // 找出整体的最大值
            int b = findMax(arrays, L + 1, R);
            if (a > b) {
                return a;
            } else {
                return b;
            }
        }
    }
}
