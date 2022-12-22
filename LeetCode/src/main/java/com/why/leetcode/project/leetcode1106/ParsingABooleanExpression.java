package com.why.leetcode.project.leetcode1106;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个以字符串形式表述的布尔表达式（boolean） expression，返回该式的运算结果。
 * 有效的表达式需遵循以下约定：
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 * 示例 1：
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 */
public class ParsingABooleanExpression {

    public static void main(String[] args) {
        String expression = "|(&(t,f,t),!(t))";
        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {
        Deque<Character> deque = new ArrayDeque<>();
        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if(c == ','){
                continue;
            } else if (c != ')') {
                deque.push(c);
            }else{
                int t = 0 , f = 0;
                while(deque.peek() != '('){
                    char val = deque.pop();
                    if(val == 't'){
                        t++;
                    }else{
                        f++;
                    }
                }
                deque.pop();
                Character op = deque.pop();
                switch (op){
                    case '!':
                        deque.push(t > 0 ? 'f' : 't');
                        break;
                    case '&':
                        deque.push(f > 0 ? 't' : 'f');
                        break;
                    case '|':
                        deque.push(t > 0 ? 't' : 'f');
                        break;
                    default:
                }
            }
        }
        return deque.pop() == 't';
    }
}
