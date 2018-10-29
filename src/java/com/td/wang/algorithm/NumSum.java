package com.td.wang.algorithm;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by @shigen.wang 2018/10/18
 *
 * @author shigen.wang
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class NumSum {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        UUID.randomUUID().node();
        System.out.println(gson.toJson(test1(nums,target)));
    }

    public static int[] test1(int[] nums,int target){
        for (int i = 0;i<nums.length;i++){
            for (int j = i;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
                    int[] a = {i,j};
                    return a;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] test2(int[] nums,int target){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static int[] test3(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
