package p2array;

import java.util.HashMap;
import java.util.Map;

public class T3TwoNumber {
    public static void main(String[] args) {

    }


    // 解法1：穷举所有情况
    public static int[] method1(int[] nums, int target){
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1;j < nums.length; j++ ){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    // 解法2：使用哈希表
    public static int[] method2(int[] nums, int target){
        int[] res = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            if(map.containsKey(target- nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }else{
                map.put(nums[i], i);
            }

        }

        return res;

    }
}
