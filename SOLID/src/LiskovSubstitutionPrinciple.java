/* 리스코프 치환 원칙 (Liskov Substitution Principle)
T라는 클래스의 서브 클래스로 s1,s2,s3가 있다면
T를 s1,s2,s3로 바꾸더라도 문제가 없어야한다.(==치환되어야 한다.)
 */
public class LiskovSubstitutionPrinciple {
    static class Cat{
        public void speak(){
            System.out.println("meow");
        }
    }
    static class BlackCat extends Cat{
        @Override
        public void speak() {
            System.out.println("Black meow");
        }
    }
    static class fish extends Cat{
        @Override
        public void speak() {
            System.out.println("Cannot Speak!!!");
        }
    }
    public static void main(String[] args){
        Cat cat = new Cat();
        cat.speak();
        cat = new BlackCat();
        cat.speak();
        cat = new fish();
        cat.speak();
    }
}

