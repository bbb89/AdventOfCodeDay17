package com.lukasz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter input:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Solution solution = new Solution(input);
        System.out.println("Value after 2017 is " + solution.getPartISolution());
        System.out.println("Value after 0 is " + solution.getPartIISolution());
    }
}
