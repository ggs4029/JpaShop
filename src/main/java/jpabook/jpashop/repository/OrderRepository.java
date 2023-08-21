package jpabook.jpashop.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

	private final EntityManager em;

	// 저장
	public void save(Order order) {
		em.persist(order);
	}
	// 단건 조회
	public Order findOne(Long id) {
		return em.find(Order.class, id);
	}
	// 리스트 조회
	//public List<Order> findAll(OrderSearch orderSearch) {}
}
