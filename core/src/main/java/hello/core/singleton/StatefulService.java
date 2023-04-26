package hello.core.singleton;

public class StatefulService {
    // 스프링 빈은 항상 무상태로 설계하자!!
    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!!! private 변수 재할당
    }

    public int getPrice() {
        return price;
    }
}
