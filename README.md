# java-racingcar-precourse
# java-racingcar-precourse

## 구현 기능 목록

### 1. 입력 (InputHandler)
    - 경주할 자동차의 이름과 시도할 횟수를 Console을 통해서 입력받는다.
    - 사용자의 요청을 GameRequestDto로 변환해서 Converter에게 건낸다.

### 2. 경주게임에 대한 요청을 서비스 계층에 매핑 (Controller)
    - List<Car>와 gameCount를 Service 계층에 넘긴다.

### 3. 사용자의 경주 게임에 대한 비즈니스 로직을 수행 (Service)
    - Serivce 계층에서는 경주 차수별 실행 결과와 최종 결과를 Controller에 반환한다.

### 4. 출력 (OutputHandler)
    - Controller로부터 반환된 경주 차수별 실행 결과와 최종 결과를 String 형태로 반환한다.
