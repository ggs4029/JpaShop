package jpabook.jpashop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

	private final EntityManager em;

	//상품 저장
	public void save(Item item) {
		if(item.getId() == null) { // 새로 등록
			em.persist(item);
		}
		else { // 이미 존재하는 상품 업데이트
			em.merge(item);
		}
	}
	// 단건 조회
	public Item findOne(Long id) {
		return em.find(Item.class, id);
	}
	// 리스트 조회
	public List<Item> findAll() {
		return em.createQuery("select i from Item i", Item.class)
				.getResultList();
	}
}
