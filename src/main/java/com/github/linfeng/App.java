package com.github.linfeng;

import com.github.linfeng.hash.MD5;

/**
 * Hello world!
 *
 * @author 黄麟峰
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String sign = MD5.sign("abc", "def", "UTF-8");
        System.out.println(sign);
    }
}
