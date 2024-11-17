package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가지고 있다.")
    void test1() {
        Car car = new Car("Jason");

        Assertions.assertThat(car.getName()).isEqualTo("Jason");
    }

    @Test
    @DisplayName("자동차의 이름이 다섯글자를 넘으면 예외가 발생한다.")
    void test2() {
        Assertions.assertThatThrownBy(() -> new Car("동해물과 백두산이"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 무작위 값이 3이하인 경우 정지한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void test3(int condition) {
        Car car = new Car("Jason");
        car.move(new NumberBasedMoveCondition(condition));

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 무작위 값이 4이상인 경우 전진한다.")
    void test4() {
        Car car = new Car("Jason");
        car.move(new NumberBasedMoveCondition(4));

        Assertions.assertThat(car.getPosition()).isNotEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 무조건 정지한다.")
    void test5() {
        Car car = new Car("Jason");
        car.move(new StopMoveCondition());

        Assertions.assertThat(car.getPosition()).isZero();
    }
}
