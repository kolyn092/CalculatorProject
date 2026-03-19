package com.example.calculator;

import java.util.Scanner;

public class Calculator {

    // 사칙 연산 기호가 아니면 true 반환하는 함수
    public static boolean isNotOperator(char operator) {
        return !(operator == '+' || operator == '-' || operator == '*' || operator == '/');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // exit 문자열을 입력하기 전까지 무한으로 진행함
        while (true) {
            // do-while 조건 처리를 하기 위해 num1과 num2의 초기값을 -1로 설정
            int num1 = -1;          // 첫 번째 숫자
            int num2 = -1;          // 두 번째 숫자
            char operator;          // 사칙 연산 기호
            int result = 0;         // 연산 결과 값

            // 양의 정수 (0 포함) 입력 받기
            do {
                // 정수가 아닌 경우 try-catch로 NumberFormatException 처리
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException ex) {
                    System.out.println("양의 숫자(0 포함)를 입력해주세요. " + ex);
                }
                // 0보다 작은 경우 입력을 다시 받음
            } while (num1 < 0 || num2 < 0);

            // 사칙 연산 기호 (+, -, *, /) 입력 받기
            do {
                System.out.print("사칙 연산 기호를 입력하세요: ");
                operator = scanner.nextLine().charAt(0);

                // isNotOperator 함수를 사용하여 사칙 연산 기호인지 판별
                if (isNotOperator(operator)) {
                    System.out.println("올바른 사칙 연산 기호를 입력하세요. (+, -, *, /)");
                }
                // 사칙 연산 기호가 아니라면 재입력
            } while (isNotOperator(operator));

            // 입력 받은 정수 2개와 사칙 연산 기호를 사용하여 연산 진행 후 출력
            try {
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("연산 오류");
                        break;
                }

                // 출력
                System.out.println("결과 : " + result);

                // 0으로 나눈 경우 ArithmeticException 처리
            } catch (ArithmeticException ex) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. " + ex);
            }

            // 반복 여부 확인
            System.out.println(("더 계산하시겠습니까? (exit 입력 시 종료)"));
            String command = scanner.nextLine();

            // exit 문자열과 동일하면 while문 빠져나오면서 종료
            if (command.equals("exit")) {
                break;
            }
        }
    }
}