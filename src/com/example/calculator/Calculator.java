package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 연산 결과를 저장하는 컬렉션
    private List<Integer> calculateList = new ArrayList<>();

    // 사칙 연산 기호가 아니면 true 반환하는 함수
    public boolean isNotOperator(char operator) {
        return !(operator == '+' || operator == '-' || operator == '*' || operator == '/');
    }

    public int calculate(int num1, int num2, char operator) {
        int result = 0;         // 연산 결과 값

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
            // 연산 결과 저장
            calculateList.add(result);

            // 연산 결과 반환
            return result;

            // 0으로 나눈 경우 ArithmeticException 처리
        } catch (ArithmeticException ex) {
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. " + ex);
        }
    }
}