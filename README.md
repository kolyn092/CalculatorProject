# 🧮 Java Calculator

## 📌 프로젝트 소개

Java를 활용하여 사칙연산 계산기를 구현하고,
단순 기능 구현을 넘어 **제네릭(Generic)과 Enum을 활용한 설계 개선 과정**을 단계별로 학습한 프로젝트입니다.

---

## 🚀 개발 환경

* Language: Java
* IDE: IntelliJ

---

## 🧩 주요 기능

* 사칙연산 (+, -, *, /) 수행
* 잘못된 입력 처리 (예외 처리)
* 연산 결과 저장 및 조회
* 가장 오래된 연산 결과 삭제
* Enum을 활용한 연산 로직 분리
* Generic을 활용한 다양한 타입 지원 (Integer, Double)
* 입력 값보다 큰 연산 결과 출력

---

## 📂 브랜치 전략

각 단계별 기능을 분리하여 개발 후 `master` 브랜치에 병합

```
feature/step1 → feature/step2 → feature/step3 → master
```

### 🔹 feature/step1

- [x]  양의 정수(0 포함)를 입력
- [x]  사칙연산 기호(+, -, *, /)를 입력
- [x]  입력 받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값 출력
- [x]  "exit" 문자열을 입력하기 전까지 무한으로 계산 진행

### 🔹 feature/step2

- [x]  계산기 클래스 추가
- [x]  연산 결과 저장
- [x]  연산 결과 데이터 캡슐화
- [x]  가장 먼저 저장된 데이터 삭제

### 🔹 feature/step3

- [x]  Enum 타입으로 연산자 타입 관리하고 계산기에 적용
- [x]  제네릭 타입으로 연산 수행 가능하게 변경
- [x]  연산 결과들 중 입력 값보다 큰 결과값들 출력

---
## 🧾 실행 방법
git clone https://github.com/kolyn092/CalculatorProject.git
cd CalculatorProject
run App.java
