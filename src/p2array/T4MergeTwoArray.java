package p2array;

import java.util.Arrays;

public class T4MergeTwoArray {
    public static void main(String[] args) {
        method1(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        method3(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

    }

    // 解法1：二路归并
    public static void method1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int k = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] >= nums2[j]) {
                temp[k++] = nums2[j++];
            } else {
                temp[k++] = nums1[i++];
            }
        }

        while (i < m) {

            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }

        for (int x = 0; x < m + n; x++) {
            nums1[x] = temp[x];
        }


    }

    // 解法2：数组合并，再排序
    public static void method2(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    // 解法3：逆向双指针，去掉临时数组
    // 从两个数组最后一个元素开始比较，得出最大值，放入第一个数组的后面
    public static void method3(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
