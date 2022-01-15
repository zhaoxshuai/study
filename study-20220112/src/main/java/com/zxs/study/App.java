package com.zxs.study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        List<Integer> list = Arrays.asList(3, 6, 2, 1);
        List<Integer> collect = list.stream().filter(x -> x>2).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println( "Hello World!" );
    }
}
