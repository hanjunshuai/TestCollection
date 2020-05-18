import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        radixSort();
        hasMap();
    }

    /**
     * hasmap V remove(Object key);
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
