# java-racingcar-precourse

## 구현 기능 목록

### 1. 입력 (InputHandler)
    - 경주할 자동차의 이름과 시도할 횟수를 Console을 통해서 입력받는다.
    - InputHandler에서 InputVerifier를 통해 입력값의 기본적인 형식을 검사한다. (빈문자인지, 숫자로 변환할 수 있는지)
    - 사용자의 요청을 GameRequestDto로 변환해서 Converter에게 건낸다.

### 2. 경주게임에 대한 요청을 서비스 계층에 매핑 (Controller)
    - GameRequestDto를 Controller에서 받고 Service 계층으로 건낸다.

### 3. 사용자의 경주 게임에 대한 비즈니스 로직을 수행 (Service)
    - GameRequestDto의 List<String> carNames를 List<Car>로 변환한다.
    - List<Car>로 변환하는 과정에서 자동차이름이 빈 값, 중복이거나 1~5자가 아니라면 예외를 던진다.
    - 경주 차수별 실행 결과와 최종 결과(GameResponseDto)를 Controller에 반환한다.

### 4. 출력 (OutputHandler)
    - Controller로부터 반환된 경주 차수별 실행 결과와 최종 결과를 String 형태로 반환한다.
