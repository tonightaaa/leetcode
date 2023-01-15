package p4stackandqueue;

import java.util.Stack;

public class T17DecodeString_LC394 {
    public static void main(String[] args) {

        System.out.println(decodeString("10[a]"));
    }



    public static String decodeString(String s) {

        int i = 0;


        Stack<String> stack = new Stack<>();

        while(i < s.length()){
            char t = s.charAt(i++);
            // 如果是数字，则获取数字，此处数字可能是多个
            if(Character.isDigit(t)){
                String num = "";
                num += t;
                t = s.charAt(i);
                while(Character.isDigit(t)){
                    num += t;
                    i++;
                    t = s.charAt(i);
                }
                stack.add(num);
            }else if(Character.isLetter(t) || t == '['){
                stack.add(String.valueOf(t));
            }else if(t == ']'){
                String temp = "";
                while(!stack.peek().equals("[")){
                    temp = stack.pop() + temp;
                }
                // 弹出左括号
                stack.pop();
                // 弹出数字
                String tempNum = stack.pop();
                int numSToI = Integer.parseInt(tempNum);
                String temp2 = "";
                // 按照数字大小赋值字符串
                for(int x = 0; x < numSToI; x++){
                    temp2 += temp;
                }
                stack.add(temp2);
            }
        }
        String res = "";

        while(!stack.empty()){
            res = stack.pop() + res;
        }
        return res;

    }


}
