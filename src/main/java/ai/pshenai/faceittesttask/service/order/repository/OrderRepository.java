package ai.pshenai.faceittesttask.service.order.repository;

import ai.pshenai.faceittesttask.service.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
