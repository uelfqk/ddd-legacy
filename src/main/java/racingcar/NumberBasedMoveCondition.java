package racingcar;

public class NumberBasedMoveCondition implements MoveCondition {

    private static final int FORWARD_MOVE_CONDITION = 4;

    private final int condition;

    NumberBasedMoveCondition(int condition) {
        this.condition = condition;
    }

    @Override
    public boolean movable() {
        return condition >= FORWARD_MOVE_CONDITION;
    }
}
