import java.util.ArrayList;

/* 의존관계 역전 원칙 (Dependency Inversion Principle)
    구체화가 아니라 추상화에 의존
    -> 구현 클래스(구현체)가 아니라 인터페이스(역할)에 의존
                   |                      |
                  배우                    배역
    왜 역전인가?
    첫번째 코드에선 Zoo는 Cat과 Dog에 의존되어 있다. 새로운 동물이 생겼을 때, 모두 수정해야한다.
    하지만,
    두번째 코드에선 Zoo는 interface인 Animal에 의존하고 있어 새로운 동물이 생겨도, 기존
 */
public class DependencyInversionPrinciple {
//    class Cat{
//        void speak(){
//            System.out.println("meow");
//        }
//    }
//    class Dog{
//        void speak(){
//            System.out.println("mung");
//        }
//    }
//    class Zoo{
//        private Cat cat = new Cat();
//        private Dog dog = new Dog();
//
//        void speakAll(){
//            this.cat.speak();
//            this.dog.speak();
//        }
//    }
//  // 만약 Zoo에 Cow, Monkey 등이 추가 된다면?
    public interface Animal{
        void speak();
    }

    class Cat implements Animal{
        @Override
        public void speak() {
            System.out.println("meow");
        }
    }
    class Dog implements Animal{
        @Override
        public void speak() {
            System.out.println("mung");
        }
    }

    class Zoo{
        ArrayList<Animal> animals = new ArrayList<>();

        void addAnimal(Animal animal){
            animals.add(animal);
        }

        void speakAll(){
            for (int i = 0; i < animals.size(); i++){
                animals.get(i).speak();
            }
        }
    }
}
