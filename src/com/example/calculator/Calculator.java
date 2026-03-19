package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // do-while 조건 처리를 하기 위해 초기값을 -1로 설정
        int num1 = -1;  // 첫 번째 숫자
        int num2 = -1;  // 두 번째 숫자
        int result = 0; // 연산 결과 값

        // 0보다 작은 경우 do-while로 입력을 다시 받을 수 있게 구현
        // 정수가 아닌 경우 try-catch로 예외 처리
        do {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = Integer.parseInt(scanner.nextLine());
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = Integer.parseInt(scanner.nextLine());


            } catch (NumberFormatException ex) {
                System.out.println("양의 숫자(0 포함)를 입력해주세요.");
            }
        } while (num1 < 0 || num2 < 0);

    }
}