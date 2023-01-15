package p1recursion;

import java.util.HashMap;
import java.util.Map;

public class T2Fibonacci {

    // 爬楼梯有多少种方法
    // f(0) == 0
    // f(1) == 1
    // f(n) = f(n - 1) + f(n - 2)
    public static void main(String[] args) {
        for (int i = 2; i <= 45; i++) {
            System.out.println(i +"->" + method2(i) + ":"+ method3(i));
        }
    }


    // 解法1：暴力递归
    public static int method1(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return method1(n - 1) + method1(n -2);

    }

    // 解法2：使用map记录计算的结果，避免重复计算
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int method2(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int res = 0;
        if(map.get(n) != null){
            return map.get(n);
        }else{
            res = method2(n - 1) + method2(n - 2);
            map.put(n, res);
        }
        return res;

    }

    // 解法3：非递归实现，自底向上累加
    public static int method3(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        int res = 0;
        int n_1 = 0;
        int n_2 = 1;

        for(int i = 2; i <=n; i++){
            res = n_1 + n_2;
            n_1 = n_2;
            n_2 = res;
        }

        return res;
    }

    // 解法4：矩阵幂
    
}
