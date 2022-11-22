package hello.core.order;

public interface OrderService {
    //주문 완료된 주문 결과 객체 반환하는 부분
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
