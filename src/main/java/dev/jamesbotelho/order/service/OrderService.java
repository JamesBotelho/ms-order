package dev.jamesbotelho.order.service;

import dev.jamesbotelho.order.model.dto.OrderDTO;
import reactor.core.publisher.Mono;

public interface OrderService {
  Mono<OrderDTO> insert(OrderDTO dto);
  Mono<OrderDTO> findOrderById(String id);
}
