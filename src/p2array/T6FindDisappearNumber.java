package p2array;

import java.util.ArrayList;
import java.util.List;

public class T6FindDisappearNumber {
    public static void main(String[] args) {
        method2(new int[]{4,3,2,7,8,2,3,1});
    }

    // 解法1：使用辅助数组记录出现的数字
    public static List<Integer> method1(int[] nums){
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            hash[nums[i]] = 1;
        }

        for(int i = 1; i <= nums.length; i++){
            if(hash[i] == 0){
                res.add(i);
            }
        }

        return res;
    }

    // 解法2：利用数组本身当hash表，不额外借助空间
    public static List<Integer> method2(int[] nums){
        List<Integer> res = new ArrayList<>();


        for(int i = 0; i < nums.length; i++){
            int value = nums[i] - 1;
            // 这块取余，是避免因为这个位置之前加个n，而导致index越界
            value = value % nums.length;
            nums[value ] = nums[ value] + nums.length;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= nums.length){
                res.add(i + 1);
            }
        }

        return res;
    }
}
