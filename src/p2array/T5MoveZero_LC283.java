package p2array;

public class T5MoveZero_LC283 {
    public static void main(String[] args) {

    }

    // 解法1：先将所有非零数放入前面，之后补零
    public static void method1(int[] nums){
        if(nums.length == 0){
            return;
        }
        int k = 0;
        // 将所有非零数字放到前面
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }

        // 补零
        for(int i = k; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
