package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // exit 문자열을 입력하기 전까지 무한으로 진행함
        while (true) {
            try {
                int num1;               // 첫 번째 숫자
                int num2;               // 두 번째 숫자
                char operator;          // 사칙 연산 기호

                // 양의 정수 (0 포함) 입력 받기
                while (true) {
                    // 정수가 아닌 경우 try-catch로 NumberFormatException 처리
                    try {
                        System.out.print("첫 번째 숫자를 입력하세요: ");
                        num1 = Integer.parseInt(scanner.nextLine());
                        System.out.print("두 번째 숫자를 입력하세요: ");
                        num2 = Integer.parseInt(scanner.nextLine());

                        if ((num1 < 0 || num2 < 0)) {
                            System.out.println("양의 숫자(0 포함)를 입력해주세요.");
                        } else {
                            break;
                        }

                    } catch (NumberFormatException ex) {
                        System.out.println("양의 숫자(0 포함)를 입력해주세요. " + ex);
                    }
                }

                // 사칙 연산 기호 (+, -, *, /) 입력 받기
                while (true) {
                    System.out.print("사칙 연산 기호를 입력하세요: ");
                    operator = scanner.nextLine().charAt(0);

                    // isNotOperator 함수를 사용하여 사칙 연산 기호인지 판별
                    if (calculator.isNotOperator(operator)) {
                        System.out.println("올바른 사칙 연산 기호를 입력하세요. (+, -, *, /)");
                    } else {
                        break;
                    }
                }

                // 연산
                int result = calculator.calculate(num1, num2, operator);

                // setter 활용 예시 (원래는 클래스 내부에서 처리해야함)
                calculator.setCalculateList(result);

                // 출력
                System.out.println("결과 : " + result);

                // 반복 여부 확인
                System.out.println(("더 계산하시겠습니까? (exit 입력 시 종료)"));
                String command = scanner.nextLine();

                // getter 활용 예시
                System.out.println("연산 결과 내역");
                for (var list : calculator.getCalculateList()) {
                    System.out.println(list);
                }

                // exit 문자열과 동일하면 while문 빠져나오면서 종료
                if (command.equals("exit")) {
                    break;
                }
            } catch (ArithmeticException ex) {
                System.out.println(ex);
            }
        }
    }
}
