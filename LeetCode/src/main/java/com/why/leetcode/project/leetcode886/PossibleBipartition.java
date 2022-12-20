package com.leetcode.project.leetcode886;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一组n人（编号为1, 2, ..., n），我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n和数组 dislikes，其中dislikes[i] = [ai, bi]，表示不允许将编号为 ai和bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * 示例 1：
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 */
public class PossibleBipartition {

    public static void main(String[] args) {
        int[][] res = {{1,2},{1,3},{2,3}};
        System.err.println(possibleBipartition(3, res));
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {

        Map<Integer , Set<Integer>> map = new HashMap<>();
        int[] colors = new int[n + 1];

        for(int i = 0 ; i < dislikes.length ; i++){
            if(!map.containsKey(dislikes[i][0]))
                map.put(dislikes[i][0] , new HashSet<>());
            if(!map.containsKey(dislikes[i][1]))
                map.put(dislikes[i][1] , new HashSet<>());
            map.get(dislikes[i][0]).add(dislikes[i][1]);
            map.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        for(int i = 1 ; i <= n ; i++){
            //先判断i是否被染色，如果没有染色就对i进行染色;如果已经染色就跳过。
//            等价于:
//            if(colors[i] == 0){
//                if(!dfs(colors , i , 1 , map)){
//                    return false;
//                }
//            }
            if(colors[i] == 0 && !dfs(colors , i , 1 , map))
                return false;
        }
        return true;
    }

    public static boolean dfs(int[] colors , int node , int color , Map<Integer , Set<Integer>> map){
        if(colors[node] != 0){
            return colors[node] == color;
        }
        colors[node] = color;
        if(map.get(node) == null) return true;
        for(int num : map.get(node)){
            if(!dfs(colors , num , -color , map))
                return false;
        }
        return true;
    }
}
