package ruahkim.com.test_coding_springboot.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class
ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){

        Item addItem = new Item();
        addItem.setTitle(title);
        addItem.setPrice(price);
        itemRepository.save(addItem);
    }

    public void showDetail(Long id, Model model){

        Optional<Item> result = itemRepository.findById(id);
//                Optional: 데이터가 있을 수도 없을 수도 있음.
            Item item = result.get();
            model.addAttribute("item", item);
            System.out.println("item : " + item);
    }

    public void showList(Model model){
        List<Item> result = itemRepository.findAll();

        model.addAttribute("items", result);

    }

    public void update(Long id, Item updateItem){

      Optional<Item> result = itemRepository.findById(id);
        System.out.println("result : "+result);

        if(result.isPresent()){
            Item changeItem = result.get();

            if(100 < updateItem.getTitle().length() ){
             throw new IllegalArgumentException("제목이 너무 깁니다.");
            }
            if(0> updateItem.getPrice() ){
                throw new IllegalArgumentException("가격이 음수일 경우 저장불가능합니다.");
            }
            changeItem.setTitle(updateItem.getTitle());
            changeItem.setPrice(updateItem.getPrice());
            itemRepository.save(changeItem);
            System.out.println("change Item : "+changeItem);


        } else {
            throw new RuntimeException("아이템을 찾을 수 없습니다.");
        }
    }


    public void deleteProduct(Long id){
        Optional<Item> delete = itemRepository.findById(id);
        if (delete.isPresent()){
            Item item = delete.get();
            itemRepository.delete(item);
        } else {
            throw new RuntimeException("cannot found item");
        }
    }
}
