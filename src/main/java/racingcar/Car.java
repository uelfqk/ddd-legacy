package racingcar;

public class Car {

    private String name;

    private int position;

    public Car(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 다섯글자 이하여야합니다.");
        }
    }

    public void move(MoveCondition condition) {
        if(!condition.movable()) {
            return;
        }

        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
