package com.example.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArithmeticCalculator<T extends Number> {

    public enum OperatorType {
        ADD('+') {
            @Override
            public <T extends Number> double calculate(T num1, T num2) {
                return num1.doubleValue() + num2.doubleValue();
            }
        },
        SUB('-') {
            @Override
            public <T extends Number> double calculate(T num1, T num2) {
                return num1.doubleValue() - num2.doubleValue();
            }
        },
        MUL('*') {
            @Override
            public <T extends Number> double calculate(T num1, T num2) {
                return num1.doubleValue() * num2.doubleValue();
            }
        },
        DIV('/') {
            @Override
            public <T extends Number> double calculate(T num1, T num2) {
                return num1.doubleValue() / num2.doubleValue();
            }
        };

        private final char operator;

        OperatorType(char operator) {
            this.operator = operator;
        }

        public char toChar() {
            return operator;
        }

        public abstract <T extends Number> double calculate(T num1, T num2);
    }

    // 연산 결과를 저장하는 컬렉션
    private final List<T> calculateList = new ArrayList<>();

    public List<T> getCalculateList() {
        return Collections.unmodifiableList(calculateList); // 읽기 전용
    }

    public void setCalculateList(T data) {
        /// 현재 상태에서 setter를 사용하는게 좋은 방법은 아니지만 과제를 하기 위한 생성
        calculateList.add(data);
    }

    // 가장 먼저 저장된 데이터를 삭제하는 함수
    public void removeResult() {
        if (calculateList.isEmpty()) {
            System.out.println("데이터가 없습니다.");
        } else {
            calculateList.remove(0);
            System.out.println("가장 먼저 저장된 데이터를 삭제했습니다.");
        }
    }

    // 사칙 연산 기호가 아니면 true 반환하는 함수
    public boolean isNotOperator(char operator) {
        return !(operator == '+' || operator == '-' || operator == '*' || operator == '/');
    }

    public T calculate(T num1, T num2, char operator) {
        double result = 0.0;         // 연산 결과 값

        // 나눗셈 연산일 때 분모가 0인 경우 예외처리
        if (num2.intValue() == 0 && operator == '/') {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return null;
        }
        // 입력 받은 정수 2개와 사칙 연산 기호를 사용하여 연산 진행 후 출력
        // 종류 순회하면서 같으면 연산 후 빠져나감
        for (var op : OperatorType.values()) {
            if (op.toChar() == operator) {
                result = op.calculate(num1, num2);
                break;
            }
        }

        // 연산 결과 반환
        return (T) Double.valueOf(result);
    }

    public Stream<T> printBiggerNumber(T num) {
        return calculateList.stream()
                .filter(list -> list.doubleValue() > num.doubleValue());
    }
}