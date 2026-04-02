package com.example.calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();

        while (true) {
            int selectMenu = 0;     // 선택한 메뉴 번호
            try {
                System.out.print("""
                메뉴 선택
                1.계산기
                2.연산 결과 내역 보기
                3.첫 번째 연산 결과 삭제
                4.입력 값보다 큰 결과값 출력
                0.종료
                """);
                selectMenu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("0~4까지의 정수만 입력하세요.");
                continue;
            }
            switch (selectMenu) {
                case 0:
                    scanner.close();
                    return;
                case 1: // 계산기
                    // exit 문자열을 입력하기 전까지 무한으로 진행함
                    while(true) {
                        Number num1;            // 첫 번째 숫자
                        Number num2;            // 두 번째 숫자
                        char operator;          // 사칙 연산 기호

                        // 양의 정수 (0 포함) 입력 받기
                        while (true) {
                            try {
                                System.out.print("첫 번째 숫자를 입력하세요: ");
                                num1 = Double.parseDouble(scanner.nextLine());
                                System.out.print("두 번째 숫자를 입력하세요: ");
                                num2 = Double.parseDouble(scanner.nextLine());

                                if ((num1.doubleValue() < 0.0 || num2.doubleValue() < 0.0)) {
                                    System.out.println("양의 숫자(0 포함)를 입력해주세요.");
                                } else {
                                    break;
                                }

                            } catch (NumberFormatException ex) {
                                System.out.println("계산기 예외) 양의 숫자(0 포함)를 입력해주세요. " + ex);
                            }
                        }

                        try {
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
                            Number result = calculator.calculate(num1, num2, operator);
                            // 잘못되 연산으로 null이 넘어올 경우 계산 결과를 저장하지 않음.
                            if (result == null) {
                                continue;
                            }

                            // 결과 출력
                            System.out.println("결과 : " + result);

                            // 반복 여부 확인
                            System.out.println(("더 계산하시겠습니까? (exit 입력 시 종료)"));
                            String command = scanner.nextLine();

                            // exit 문자열과 동일하면 while문 빠져나오면서 종료
                            if (command.equals("exit")) {
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException ex) {
                            System.out.println("공백/빈 문자열은 불가능합니다.");
                            break;
                        } catch (Exception ex) {
                            System.out.println("계산기 예외) " + ex);
                        }
                    }
                    break;
                case 2: // getter 활용 예시
                    System.out.println("연산 결과 내역");
                    var calculateList = calculator.getCalculateList();
                    // 결과 내역에 데이터가 없으면 없다고 출력하고 빠져나감.
                    if (calculateList.isEmpty()) {
                        System.out.println("연산 결과가 없습니다.");
                        break;
                    }
                    // 결과 내역 순회해서 출력
                    for (var list : calculateList) {
                        System.out.println(list);
                    }
                    break;
                case 3: // remove 활용 예시
                    calculator.removeResult();
                    break;
                case 4:
                    System.out.print("비교할 숫자를 입력하세요: ");
                    Number num = Double.parseDouble(scanner.nextLine());
                    calculator.printBiggerNumber(num).forEach(System.out::println);
                    break;
                default:
                    System.out.println("0~4까지의 정수만 입력하세요.");
                    break;
            }
        }
    }
}
