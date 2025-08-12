package org.Der3;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String x = s.nextLine();

        System.out.println(StringUtils.capitalize(x));
    }
}