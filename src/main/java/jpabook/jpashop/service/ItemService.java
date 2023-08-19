package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	// 상품 저장
	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	// 상품 단건 조회
	public Item findOne(Long itemId) {
		return itemRepository.findOne(itemId);
	}
	// 상품 리스트 조회
	public List<Item> findItems() {
		return itemRepository.findAll();
	}

}
