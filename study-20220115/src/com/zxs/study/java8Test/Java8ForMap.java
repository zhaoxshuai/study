package com.zxs.study.java8Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zxs
 * @date 2022/1/15 下午3:04
 */
public class Java8ForMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 3, 7);
        List<Boolean> collect = list.stream().map(x -> x > 2).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("HaHa");
    }
}
