/* 개방 폐쇄의 원칙 (Open Closed Principle)
* 확장엔 Open, 변경엔 Close
* 높은 응집도, 낮은 결합도
* 추상화와 다형성
* 전역변수의 사용을 최소화
    예를 들어, 전역변수 global이란 것을 함수 A,B,C가 참조하고 사용한다면 global이 바뀌었을 때 원인 찾기가 힘들어진다.
 */
public class OpenClosedPrinciple {
    class wrongAnimal{
        private String animalType;

        protected void setAnimalType(String type){
            this.animalType = type;
        }
        protected void walk(wrongAnimal animal){
            if (animal.getAnimalType() == "cat"){
                System.out.println("cat is walking");
            }
            else if (animal.getAnimalType() == "dog"){
                System.out.println("Dog is walking");
            }
        }
        protected String getAnimalType(){ return this.animalType; }

        protected void hey(wrongAnimal animal){
            if (animal.getAnimalType() == "cat"){
                System.out.println("meow");
            }
            else if (animal.getAnimalType() == "dog"){
                System.out.println("mung");
            }
        }
    }
    // 만약 Cow, sheep, eagle 등이 추가(확장)된다면?
    class Animal{
        private String animalType;

        protected void hey(){};
    }
    class Cat extends Animal{
        @Override
        public void hey() {
            System.out.println("meow");
        }
    }
    class Dog extends Animal{
        @Override
        public void hey(){
            System.out.println("mung");
        }
    }
}