package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){ return itemRepository.findById(itemId).get(); }
    /* itemId를 이용해서 Item을 찾는데,
       없어도 무슨 방버이 없으니,
       itemRepository.findById(itemId).isPresent를 안쓰는건가?

       if (itemRepository.findById(itemId).isPresent()){
           return itemRepository.findById(itemId).get();
       }
       else { do something; }

     */

    public void updateItem(Long id, String name, int price, int stockQuantity){

        Item item = itemRepository.findById(id).get();
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }
}
