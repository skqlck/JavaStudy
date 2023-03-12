/* 단일 책임 원칙 (Single Responsibility Principle)
    하나의 클래스는 하나의 책임만 (책임의 기준을 변경으로)
    SW는 변화에 대응을 잘해야하는데, 하나의 변화로 연쇄작용이 일어나면 안된다.
    유지보수 >> 성능
 */
public class SingleResponsibilityPrinciple {
    class Cat{
        private int age;
        private String name;

        Cat(int age, String name){
        }
        protected void setAge(int age){
            this.age = age;
        }
        protected int getAge() { return this.age; }
        protected void setName(String name){
            this.name = name;
        }
        protected String getName() { return this.name; }
        protected void eat(String food){}
        protected void walk(){}

        protected void speak(){}

//        protected void print(){
//            System.out.printf("name : %s, age : %d\n",getName(),getAge());
        }

    public void main(String[] args){
        Cat 나비 = new Cat(3,"나비");
        System.out.println("name : "+나비.getName()+" age: "+나비.getAge());
        }
    }
