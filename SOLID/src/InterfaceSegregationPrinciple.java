/* 인터페이스 분리 원칙 (Interface Segregation Principle)
    범용 인터페이스 하나 보다는 특정 클라이언트를 위한 여러 개의 인터페이스가 좋다.
    코드가 매우 늘어나기 때문에, 인터페이스가 변경되는 것을 최소화 or 불가능하게 해야한다.
                                더 정확히 인터페이스의 변경이 클라이언트를 변화시켜서는 안된다. (인터페이스 == 정책)
 */
public class InterfaceSegregationPrinciple {
    public interface vehicles{
        void drive();
        void turnLeft();
        void turnRight();
        void openDoor();
        void openTrunk();
        void openSunRoof();
        void putAnchor();
    }

    class Car implements vehicles{
        @Override
        public void drive() {}
        @Override
        public void turnLeft() {}
        @Override
        public void turnRight() {}
        @Override
        public void openDoor() {}
        @Override
        public void openTrunk() {}
        @Override
        public void openSunRoof() {}
        @Override
        public void putAnchor() {}
    }
    class Boat implements vehicles{
        @Override
        public void drive() {}
        @Override
        public void turnLeft() {}
        @Override
        public void turnRight() {}
        @Override
        public void openDoor() {}
        @Override
        public void openTrunk() {}
        @Override
        public void openSunRoof() {}
        @Override
        public void putAnchor() {}
    }
    class MotorCycle implements vehicles{
        @Override
        public void drive() {}
        @Override
        public void turnLeft() {}
        @Override
        public void turnRight() {}
        @Override
        public void openDoor() {}
        @Override
        public void openTrunk() {}
        @Override
        public void openSunRoof() {}
        @Override
        public void putAnchor() {}
    }

    Car car = new Car();
    Boat boat = new Boat();
    MotorCycle motorcycle = new MotorCycle();
}
